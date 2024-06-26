package org.firstinspires.ftc.teamcode.utils

import org.firstinspires.ftc.teamcode.hardware.PIDFC
import org.firstinspires.ftc.teamcode.pp.TrajCoef
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

@Suppress("MemberVisibilityCanBePrivate")
class Pose(@JvmField var x: Double, @JvmField var y: Double, @JvmField var h: Double) {
    constructor(v: Vec2d, h: Double) : this(v.x, v.y, h)
    constructor() : this(0.0, 0.0, 0.0)

    fun dist2(): Double = x * x + y * y
    fun dist(): Double = sqrt(dist2())
    fun v2d(): Vec2d = Vec2d(x, y)
    fun rotated(a: Double): Pose {
        val ar = vec().rotated(a)
        return Pose(ar.x, ar.y, h + a)
    }

    fun duplicate(): Pose = Pose(x, y, h)

    fun vec() = Vec2d(x, y)
    fun headingVec() = Vec2d(cos(h), sin(h))

    operator fun get(id: Int) = when (id) {
        0 -> x
        1 -> y
        else -> h
    }

    operator fun unaryMinus() = Pose(-x, -y, -h)

    operator fun plus(pose: Pose) = Pose(x + pose.x, y + pose.y, h + pose.h)

    operator fun minus(pose: Pose) = Pose(x - pose.x, y - pose.y, h - pose.h)

    operator fun div(pose: Pose) = Pose(x / pose.x, y / pose.y, h / pose.h)

    operator fun times(pose: Pose) = Pose(x * pose.x, y * pose.y, h * pose.h)
    operator fun times(s: Double) = Pose(x * s, y * s, h * s)
    operator fun div(s: Double) = Pose(x / s, y / s, h / s)
    operator fun times(s: Int) = times(s.toDouble())
    operator fun divAssign(s: Double) { x /= s; y /= s; h /= s }
    operator fun divAssign(s: Int) = divAssign(s.toDouble())

    fun negX() = Pose(-x, y, h)
    override fun toString() = String.format("(%.3f, %.3f, %.3f)", x, y, h)
}

class Vec2d(@JvmField var x: Double, @JvmField var y: Double) {
    constructor() : this(0.0, 0.0)

    fun dist2(): Double = x * x + y * y
    fun dist(): Double = sqrt(dist2())
    fun pose(): Pose = Pose(x, y, 0.0)

    fun rotated(angle: Double): Vec2d {
        val newX = x * cos(angle) - y * sin(angle)
        val newY = x * sin(angle) + y * cos(angle)
        return Vec2d(newX, newY)
    }

    fun norm() = this / dist()

    fun duplicate() = Vec2d(x, y)

    operator fun unaryMinus() = Vec2d(-x, -y)

    operator fun plus(vec: Vec2d) = Vec2d(x + vec.x, y + vec.y)

    operator fun minus(vec: Vec2d) = Vec2d(x - vec.x, y - vec.y)

    operator fun div(vec: Vec2d) = Vec2d(x / vec.x, y / vec.y)
    operator fun div(s: Double) = Vec2d(x / s, y / s)
    operator fun divAssign(s: Int) { x /= s.toDouble(); y /= s.toDouble() }

    operator fun times(vec: Vec2d) = Vec2d(x * vec.x, y * vec.y)
    operator fun times(s: Double) = Vec2d(x * s, y * s)

    fun polar() = Vec2d(x * cos(y), x * sin(y))

    override fun toString() = String.format("(%.3f, %.3f)", x, y)
}

class Vec3(@JvmField var a: Double, @JvmField var b: Double, @JvmField var c: Double) {
    operator fun get(i: Int) = when (i) {
        0 -> a
        1 -> b
        else -> c
    }
}

class Vec4(@JvmField var a: Double, @JvmField var b: Double, @JvmField var c: Double, @JvmField var d: Double) {
    operator fun get(i: Int) = when (i) {
        0 -> a
        1 -> b
        2 -> c
        else -> d
    }
}

class Vec2T(@JvmField var a: TrajCoef, @JvmField var b: TrajCoef) {
    operator fun get(i: Int) = when (i) {
        0 -> a
        else -> b
    }
}

class Vec3T(@JvmField var a: TrajCoef, @JvmField var b: TrajCoef, @JvmField var c: TrajCoef) {
    operator fun get(i: Int) = when (i) {
        0 -> a
        1 -> b
        else -> c
    }
}

class Vec4T(@JvmField var a: TrajCoef, @JvmField var b: TrajCoef, @JvmField var c: TrajCoef, @JvmField var d: TrajCoef) {
    operator fun get(i: Int) = when (i) {
        0 -> a
        1 -> b
        2 -> c
        else -> d
    }
}

class Vec4P(@JvmField var a: PIDFC, @JvmField var b: PIDFC, @JvmField var c: PIDFC, @JvmField var d: PIDFC) {
    operator fun get(i: Int) = when (i) {
        0 -> a
        1 -> b
        2 -> c
        else -> d
    }
} /// These all have to exist only to make shit accessible in the dashboard :(

class Vec4PP(@JvmField var a: Pose, @JvmField var b: Pose, @JvmField var c: Pose, @JvmField var d: Pose) {
    operator fun get(i: Int) = when (i) {
        0 -> a
        1 -> b
        2 -> c
        else -> d
    }
} /// These all have to exist only to make shit accessible in the dashboard :(

class Vec4i(@JvmField var a: Int, @JvmField var b: Int, @JvmField var c: Int, @JvmField var d: Int) {
    operator fun get(i: Int) = when (i) {
        0 -> a
        1 -> b
        2 -> c
        else -> d
    }
}

class DDoubleV4i(@JvmField var left: Vec4i, @JvmField var right: Vec4i)

class Vec4vi(@JvmField var a: DDoubleV4i, @JvmField var b: DDoubleV4i, @JvmField var c: DDoubleV4i, @JvmField var d: DDoubleV4i) {
    operator fun get(i: Int) = when (i) {
        0 -> a
        1 -> b
        2 -> c
        else -> d
    }
}

class Vec4Gen<T>(@JvmField var a: T, @JvmField var b: T, @JvmField var c: T, @JvmField var d: T) {
    operator fun get(i: Int) = when (i) {
        0 -> a
        1 -> b
        2 -> c
        else -> d
    }
}


class Vec6Gen<T>(@JvmField var a: T, @JvmField var b: T, @JvmField var c: T, @JvmField var d: T, @JvmField var e: T, @JvmField var f: T) {
    operator fun get(i: Int) = when (i) {
        0 -> a
        1 -> b
        2 -> c
        3 -> d
        4 -> e
        else -> f
    }
    operator fun set(i: Int, v: T) = when (i) {
        0 -> a = v
        1 -> b = v
        2 -> c = v
        3 -> d = v
        4 -> e = v
        else -> f = v
    }
}
