package org.firstinspires.ftc.teamcode.auto

import com.acmerobotics.dashboard.config.Config
import org.firstinspires.ftc.teamcode.pp.PP.MAX_FRACTION
import org.firstinspires.ftc.teamcode.pp.TrajCoef
import org.firstinspires.ftc.teamcode.utils.Pose
import org.firstinspires.ftc.teamcode.utils.Vec2d
import org.firstinspires.ftc.teamcode.utils.Vec3
import org.firstinspires.ftc.teamcode.utils.Vec3T

@Config
object BlueLongP {
    @JvmField
    var bPPos = Vec3T( /// Pos 0 = under thruss, 1 = mid, 2 e odar
            TrajCoef(
                    Pose(-80.0, 4.0, 1.4),
                    Vec2d(), Vec2d(60.0, 1.5),
                    Vec2d(0.3, 0.9), 0.8,
                    Vec2d(34.0, 50.0)
            ),
            TrajCoef(
                    Pose(-100.0, 40.0, 1.8),
                    Vec2d(60.0, 1.8), Vec2d(0.0, 0.0),
                    Vec2d(0.0, 0.8), 0.8,
                    Vec2d(20.0, 80.0)
            ),
            TrajCoef(
                    Pose(-100.0, 54.0, 2.1),
                    Vec2d(40.0, 1.7), Vec2d(0.0, 0.0),
                    Vec2d(0.0, 0.6), 1.0,
                    Vec2d(34.0, 50.0)
            )
    )

    @JvmField
    var bPStack = Vec3T(
            TrajCoef(
                    Pose(-140.0, 66.0, 1.57),
                    Vec2d(30.0, 1.7), Vec2d(30.0, -1.0),
                    Vec2d(0.2, 0.7),
                    0.8
            ),

            TrajCoef(
                    Pose(-140.0, 73.0, 1.57),
                    Vec2d(50.0, 1.6), Vec2d(80.0, -0.9),
                    0.8
            ),

            TrajCoef(
                    Pose(-140.0, 66.0, 1.57),
                    Vec2d(00.0, 4.4), Vec2d(30.0, -1.0),
                    0.8, Vec2d(50.0, 120.0)
            )
    )

    @JvmField
    var bPAfterShave = TrajCoef(
            Pose(-120.0, 60.0, 1.50),
            1.0, Vec2d(999.0, 1000.0)
    )


    @JvmField
    var bPutPos = TrajCoef(
            Pose(), Pose(0.0, -225.0, 1.59),
            Vec2d(200.0, 4.5), Vec2d(80.0, 2.2),
            Vec2d(0.0, 0.1), 1.0, Vec2d(40.0, 100.0)
    )

    @JvmField
    var bPutXCase = Vec3(-46.0, -66.0, -86.0)

    @JvmField
    var bPutYOffsetCase = Vec3(0.0, 0.0, 0.0)

    @JvmField
    var bStackOffset = Pose(0.0, 0.0, 0.0)

    @JvmField
    var bPutOffset = Pose(0.0, 0.0, 0.0)

    @JvmField
    var bStackPos2 = TrajCoef(
            Pose(), Pose(-137.0, 73.0, 1.57),
            Vec2d(80.0, -3.6), Vec2d(100.0, -1.2),
            Vec2d(), 1.0, Vec2d(40.0, 70.0)
    )

    @JvmField
    var bPAfterAfterShave = TrajCoef(
            Pose(), Pose(-110.0, 60.0, 1.57),
            1.0, Vec2d(999.0, 1000.0)
    )

    @JvmField
    var bParkPos = TrajCoef(
            Pose(-123.0, -237.0, 1.57),
            Vec2d(60.0, 1.9), Vec2d(60.0, 1.9),
            0.7
    )
}

@Config
object BlueShortP {
    @JvmField
    var sbPPos = Vec3T( /// Pos 0 = under thruss, 1 = mid, 2 e odar
            TrajCoef(
                    Pose(-75.0, -10.0, -1.57),
                    Vec2d(), Vec2d(60.0, -1.5),
                    Vec2d(0.2, 0.7), 0.8
            ),
            TrajCoef(
                    Pose(-62.0, -10.0, -0.2),
                    Vec2d(), Vec2d(2.0, 0.0),
                    Vec2d(0.0, 0.8), 0.8,
                    Vec2d(34.0, 60.0)
            ),
            TrajCoef(
                   Pose(-75.0, 5.0, 1.57), 1.0
            )
    )

    @JvmField
    var sbPutFromPreloadPos = TrajCoef(
            Pose(0.0, -100.0, 1.57), Vec2d(), Vec2d(),
            Vec2d(0.0, 0.8), 0.9, Vec2d(30.0, 60.0)
    )

    @JvmField
    var sbPutXCase = Vec3(-51.0, -68.0, -90.0)

    @JvmField
    var sbPutYOffsetCase = Vec3(0.0, 0.0, 0.0)

    @JvmField
    var stackPPose = Vec3T(
            TrajCoef(
                    Pose(-16.0, -10.0, 1.57),
            ),
            TrajCoef(
                    Pose(-16.0, 110.0, 1.57),
                    Vec2d(5.0, 0.7), Vec2d(0.0, 0.0)
            ),
            TrajCoef(
                    Pose(-76.0, 160.0, 1.57),
                    Vec2d(60.0, 1.57), Vec2d(10.0, 4.0),
                    1.0, Vec2d(40.0, 90.0)
            )
    )

    @JvmField
    var stackPPut = Vec3T(
            TrajCoef(
                    Pose(-20.0, 130.0, 1.57),
                    Vec2d(10.0, 4.0), Vec2d(60.0, 1.57)
            ),
            TrajCoef(
                    Pose(-22.0, -10.0, 1.57),
                    Vec2d(5.0, -0.7), Vec2d(0.0, 0.0)
            ),
            TrajCoef(
                    Pose(-56.0, -100.0, 1.57),
                    Vec2d(10.0, -1.57), Vec2d(10.0, -4.0),
                    1.0, Vec2d(30.0, 60.0)
            )
    )

    @JvmField
    var sbStackOffset = Pose(0.0, 0.0, 0.0)

    @JvmField
    var sbPutOffset = Pose(0.0, 0.0, 0.0)

    @JvmField
    var sbParkPos = TrajCoef(
            Pose(-16.0, -100.0, 1.57),
            Vec2d(60.0, 0.5), Vec2d(60.0, 2.7)
    )
}


@Config
object RedLongP {
    @JvmField
    var rPos2 = TrajCoef(
            Pose(-92.0, 24.0, -0.5),
            0.4
    )

    @JvmField
    var rPos1 = TrajCoef(
            Pose(-115.0, -6.0, 0.0),
            Vec2d(0.0, 2.0), Vec2d(0.0, 3.0),
            0.4
    )

    @JvmField
    var rPos0 = TrajCoef(
            Pose(-85.0, -20.0, -1.57),
            Vec2d(80.0, 1.8), Vec2d(40.0, 1.4),
            0.4
    )

    @JvmField
    var rPos2Stack = TrajCoef(
            Pose(-125.0, 10.2, -1.57),
            Vec2d(60.0, 4.4), Vec2d(0.0, 4.0),
            0.5
    )

    @JvmField
    var rPos1Stack = TrajCoef(
            Pose(-125.0, 10.0, -1.57),
            Vec2d(30.0, 3.1), Vec2d(20.0, 4.0),
            0.4
    )

    @JvmField
    var rPos0Stack = TrajCoef(
            Pose(-125.0, 10.0, -1.57),
            Vec2d(60.0, 1.7), Vec2d(0.0, 0.0),
            Vec2d(0.2, 0.7),
            0.5
    )

    @JvmField
    var rPutPos = TrajCoef(
            Pose(), Pose(-65.0, 245.0, -1.57),
            Vec2d(200.0, -4.65), Vec2d(80.0, -1.9),
            Vec2d(0.0, 1.0), 0.5, Vec2d(40.0, 80.0)
    )

    @JvmField
    var rOffsets = Vec3(1.0, 0.0, 2.5)

    @JvmField
    var rStackOffset = Vec3(0.0, -0.0, 0.0)

    @JvmField
    var rStackPos2 = TrajCoef(
            rPutPos.ep,
            Pose(-130.0, 58.0, 1.57),
            Vec2d(100.0, -3.5), Vec2d(100.0, -1.35),
            Vec2d(), MAX_FRACTION, Vec2d(60.0, 100.0)
    )

    @JvmField
    var rPutPosCase = Vec3(-70.0, -90.0, -125.0)

    @JvmField
    var rparkPos = TrajCoef(
            Pose(-105.0, 237.0, 1.57),
            Vec2d(30.0, 1.7), Vec2d(30.0, 1.7)
    )
}

@Config
object RedShortP {
    @JvmField
    var srPos0 = TrajCoef(
            Pose(-80.0, 15.0, 0.5),
            Vec2d(50.0, -2.0), Vec2d(30.0, -1.6),
            0.45
    )

    @JvmField
    var srPos1 = TrajCoef(
            Pose(-113.0, -16.0, 0.0),
            Vec2d(40.0, -2.0), Vec2d(15.0, -3.0),
            0.4
    )

    @JvmField
    var srPos2 = TrajCoef(
            Pose(-75.0, -33.0, 1.57),
            0.5
    )

    @JvmField
    var srPos0Stack = TrajCoef(
            Pose(-60.0, -45.0, 1.57),
            Vec2d(60.0, -1.7), Vec2d(0.0, 0.0),
            Vec2d(0.2, 0.7),
            0.5
    )

    @JvmField
    var srPos1Stack = TrajCoef(
            Pose(-60.0, -45.0, 1.57),
            Vec2d(30.0, 3.1), Vec2d(40.0, 4.0),
            0.5
    )

    @JvmField
    var srPos2Stack = TrajCoef(
            Pose(-65.0, -60.0, 1.57),
            0.5
    )

    @JvmField
    var srPutPos = TrajCoef(
            Pose(), Pose(-65.0, -100.0, 1.57),
            Vec2d(0.0, 0.5), Vec2d(0.0, 1.9),
            Vec2d(0.0, 1.0), MAX_FRACTION, Vec2d(80.0, 140.0)
    )

    @JvmField
    var sbparkPos = TrajCoef(
            Pose(-105.0, -90.0, 1.57),
            Vec2d(30.0, 1.7), Vec2d(30.0, 1.7)
    )
}


@Config
object AutoVars {
    @JvmField
    var NumCycles = 3

    @JvmField
    var WaitIntake = 0.5

    @JvmField
    var WaitPut = 0.25

    @JvmField
    var WaitStack = 0.4

    val colours = arrayOf("#8EE3EF", "#AEF3E7", "#F6BD60", "#F7EDE2", "#37718E", "#F5CAC3", "#84A59D", "#F28482", "#19535F", "#0B7A75", "#D7C9AA", "#7B2D26", "#F0F3F5")
}
