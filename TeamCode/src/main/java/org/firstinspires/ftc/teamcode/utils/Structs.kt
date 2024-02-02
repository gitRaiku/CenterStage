package org.firstinspires.ftc.teamcode.utils

import org.firstinspires.ftc.teamcode.hardware.PIDFC
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

    operator fun times(vec: Vec2d) = Vec2d(x * vec.x, y * vec.y)
    operator fun times(s: Double) = Vec2d(x * s, y * s)

    fun polar() = Vec2d(x * cos(y), x * sin(y))

    override fun toString() = String.format("(%.3f, %.3f)", x, y)
}

class Vec4(@JvmField var a: Double, @JvmField var b: Double, @JvmField var c: Double, @JvmField var d: Double) {
    var x: Double = a
        get() = a
        set(v) { a = v; field = v }
    var y: Double = b
        get() = b
        set(v) { b = v; field = v }
    var z: Double = c
        get() = c
        set(v) { c = v; field = v }
    var w: Double = d
        get() = d
        set(v) { d = v; field = v }

    operator fun get(i: Int) = when (i) {
        0 -> a
        1 -> b
        2 -> c
        else -> d
    }
}

class Vec4P(@JvmField var a: PIDFC, @JvmField var b: PIDFC, @JvmField var c: PIDFC, @JvmField var d: PIDFC) {
    var x: PIDFC = a
        get() = a
        set(v) { a = v; field = v }
    var y: PIDFC = b
        get() = b
        set(v) { b = v; field = v }
    var z: PIDFC = c
        get() = c
        set(v) { c = v; field = v }
    var w: PIDFC = d
        get() = d
        set(v) { d = v; field = v }

    operator fun get(i: Int) = when (i) {
        0 -> a
        1 -> b
        2 -> c
        else -> d
    }
}
