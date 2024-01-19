package org.firstinspires.ftc.teamcode.pp

import com.sun.tools.javac.comp.Check
import org.firstinspires.ftc.teamcode.pp.PP.Checkpoints
import org.firstinspires.ftc.teamcode.pp.PP.MAX_FRACTION
import org.firstinspires.ftc.teamcode.pp.PP.PeruEnd
import org.firstinspires.ftc.teamcode.pp.PP.PeruStart
import org.firstinspires.ftc.teamcode.utils.Pose
import org.firstinspires.ftc.teamcode.utils.Util.angDiff
import org.firstinspires.ftc.teamcode.utils.Vec2d
import java.util.Vector

class CubicBezierCurve(
        private val c0: Double,
        private val c1: Double,
        private val c2: Double,
        private val c3: Double) {

    operator fun get(t: Double) = t * (t * (t * (-c0 + 3 * c1 - 3 * c2 + c3) + 3 * c0 - 6 * c1 + 3 * c2) - 3 * c0 + 3 * c1) + c0
    // Desmos friendly version
    // x * (x * (x * (-a + 3 * b - 3 * c + d) + 3 * a - 6 * b + 3 * c) - 3 * a + 3 * b) + a

    fun deriv(t: Double) = t * (t * (-3 * c0 - 9 * c2 + 3 * c3) + 6 * c0 + 6 * c2) - 3 * c0 + c1 * (t * (9 * t - 12) + 3)

    fun dderiv(t: Double) = -6 * (c0 * (t - 1) - c1 * (3 * t - 2) + c2 * (3 * t - 1) - c3 * t)

    fun ddderiv(t: Double) = -6 * c0 + 18 * c1 - 18 * c2 + 6 * c3 + 0 * t
}

class Action(val checkNr: Int, val act: () -> Unit) {
    override fun toString() = "$checkNr -> $act"
}

class TrajCoef(@JvmField var sp: Pose, @JvmField var ep: Pose, @JvmField var v1: Vec2d, @JvmField var v2: Vec2d, @JvmField var h: Vec2d, @JvmField var mf: Double, @JvmField var peru: Vec2d) {
    constructor(sp: Pose, ep: Pose, v1: Vec2d, v2: Vec2d) : this(sp, ep, v1, v2, Vec2d(0.6, 0.95), MAX_FRACTION, Vec2d(PeruStart, PeruEnd))
    constructor(sp: Pose, ep: Pose) : this(sp, ep, Vec2d(), Vec2d())

    constructor(ep: Pose, v1: Vec2d, v2: Vec2d) : this(Pose(), ep, v1, v2)
    constructor(ep: Pose) : this(Pose(), ep)
}

class Trajectory(val start: Pose, val initVel: Double, val end: Pose, v1e: Vec2d, v2e: Vec2d, h1: Vec2d, val maxFraction: Double, val peruStart: Double, val peruEnd: Double) {
    constructor(tc: TrajCoef) : this(tc.sp, 0.0, tc.ep, tc.v1, tc.v2, tc.h, tc.mf, tc.peru.x, tc.peru.y)
    constructor(sp: Pose, initVel: Double, ep: Pose, v1e: Vec2d, v2e: Vec2d, h1: Vec2d, maxFraction: Double) : this(sp, initVel, ep, v1e, v2e, h1, maxFraction, PeruStart, PeruEnd)
    constructor(sp: Pose, initVel: Double, ep: Pose, v1e: Vec2d, v2e: Vec2d, h1: Vec2d) : this(sp, initVel, ep, v1e, v2e, h1, MAX_FRACTION)
    constructor(sp: Pose, initVel: Double, ep: Pose, v1x: Double, v1y: Double, v2x: Double, v2y: Double, h1x: Double, h1y: Double) : this(sp, initVel, ep, Vec2d(v1x, v1y), Vec2d(v2x, v2y), Vec2d(h1x, h1y))
    constructor(sp: Pose, initVel: Double, ep: Pose, v1x: Double, v1y: Double, v2x: Double, v2y: Double) : this(sp, initVel, ep, Vec2d(v1x, v1y), Vec2d(v2x, v2y), Vec2d(0.3333, 0.666))
    constructor(sp: Pose, initVel: Double, ep: Pose) : this(sp, initVel, ep, Vec2d(), Vec2d(), Vec2d(0.3333, 0.6666))
    constructor(sp: Pose, ep: Pose) : this(sp, 0.0, ep)
    constructor() : this(Pose(), Pose())

    private val v1 = v1e.polar()
    private val v2 = v2e.polar()
    val checkLen = 1.0 / Checkpoints.toDouble()

    private val cubX = CubicBezierCurve(start.x, start.x + v1.x, end.x + v2.x, end.x)
    private val cubY = CubicBezierCurve(start.y, start.y + v1.y, end.y + v2.y, end.y)
    private val cubH = CubicBezierCurve(0.0, h1.x, h1.y, 1.0) // Heading handled in get()

    var actions: Vector<Action> = Vector()
    var lastCompletedAction = 0

    fun addActionS(distFromEnd: Double, act: () -> Unit) {
        for (i in 0..Checkpoints) {
            if ((start - get(i)).dist() >= distFromEnd) {
                actions.add(Action(i, act))
                actions.sortBy { it.checkNr }
                return
            }
        }
        actions.add(Action(Checkpoints, act))
        actions.sortBy { it.checkNr }
    }

    fun addActionE(distFromEnd: Double, act: () -> Unit) {
        for (i in Checkpoints downTo 0) {
            if ((end - get(i)).dist() >= distFromEnd) {
                actions.add(Action(i, act))
                actions.sortBy { it.checkNr }
                return
            }
        }
        actions.add(Action(0, act))
        actions.sortBy { it.checkNr }
    }

    fun nextAction(): Action =
            if (lastCompletedAction >= actions.size) {
                Action(1000000000) {}
            } else {
                actions[lastCompletedAction]
            }

    operator fun get(i: Int) = if (i < 0) start else if (i > Checkpoints) end else Pose(cubX[i * checkLen], cubY[i * checkLen], start.h + angDiff(start.h, end.h) * cubH[i * checkLen])
    fun deriv(i: Int) = Pose(cubX.deriv(i * checkLen), cubY.deriv(i * checkLen), cubH.deriv(i * checkLen))


    override fun toString(): String = "$start:$end"
}