package glm_.vec2.operators

import glm_.*
import glm_.vec2.Vec2us
import glm_.vec2.Vec2us.Companion.div
import glm_.vec2.Vec2us.Companion.minus
import glm_.vec2.Vec2us.Companion.plus
import glm_.vec2.Vec2us.Companion.rem
import glm_.vec2.Vec2us.Companion.times
import unsigned.*
import kotlin.experimental.and
import kotlin.experimental.inv
import kotlin.experimental.or
import kotlin.experimental.xor

/**
 * Created by elect on 09/11/16.
 */

interface vec2us_operators {

    fun plus(res: Vec2us, a: Vec2us, bX: Ushort, bY: Ushort): Vec2us {
        res.x.v = (a.x.v + bX.v).s
        res.y.v = (a.y.v + bY.v).s
        return res
    }

    fun plus(res: Vec2us, a: Vec2us, bX: Short, bY: Short): Vec2us {
        res.x.v = (a.x.v + bX).s
        res.y.v = (a.y.v + bY).s
        return res
    }

    fun plus(res: Vec2us, a: Vec2us, bX: Int, bY: Int): Vec2us {
        res.x.v = (a.x.v + bX).s
        res.y.v = (a.y.v + bY).s
        return res
    }

    fun minus(res: Vec2us, a: Vec2us, bX: Ushort, bY: Ushort): Vec2us {
        res.x.v = (a.x.v - bX.v).s
        res.y.v = (a.y.v - bY.v).s
        return res
    }

    fun minus(res: Vec2us, a: Vec2us, bX: Short, bY: Short): Vec2us {
        res.x.v = (a.x.v - bX).s
        res.y.v = (a.y.v - bY).s
        return res
    }

    fun minus(res: Vec2us, a: Vec2us, bX: Int, bY: Int): Vec2us {
        res.x.v = (a.x.v - bX).s
        res.y.v = (a.y.v - bY).s
        return res
    }

    fun minus(res: Vec2us, aX: Ushort, aY: Ushort, b: Vec2us): Vec2us {
        res.x.v = (aX.v - b.x.v).s
        res.y.v = (aY.v - b.y.v).s
        return res
    }

    fun minus(res: Vec2us, aX: Short, aY: Short, b: Vec2us): Vec2us {
        res.x.v = (aX - b.x.v).s
        res.y.v = (aY - b.y.v).s
        return res
    }

    fun minus(res: Vec2us, aX: Int, aY: Int, b: Vec2us): Vec2us {
        res.x.v = (aX - b.x.v).s
        res.y.v = (aY - b.y.v).s
        return res
    }

    fun times(res: Vec2us, a: Vec2us, bX: Ushort, bY: Ushort): Vec2us {
        res.x.v = (a.x.v * bX.v).s
        res.y.v = (a.y.v * bY.v).s
        return res
    }

    fun times(res: Vec2us, a: Vec2us, bX: Short, bY: Short): Vec2us {
        res.x.v = (a.x.v * bX).s
        res.y.v = (a.y.v * bY).s
        return res
    }

    fun times(res: Vec2us, a: Vec2us, bX: Int, bY: Int): Vec2us {
        res.x.v = (a.x.v * bX).s
        res.y.v = (a.y.v * bY).s
        return res
    }

    fun div(res: Vec2us, a: Vec2us, bX: Ushort, bY: Ushort): Vec2us {
        res.x.v = a.x.v udiv bX.v
        res.y.v = a.y.v udiv bY.v
        return res
    }

    fun div(res: Vec2us, a: Vec2us, bX: Short, bY: Short): Vec2us {
        res.x.v = a.x.v udiv bX
        res.y.v = a.y.v udiv bY
        return res
    }

    fun div(res: Vec2us, a: Vec2us, bX: Int, bY: Int): Vec2us {
        res.x.v = a.x.v udiv bX
        res.y.v = a.y.v udiv bY
        return res
    }

    fun div(res: Vec2us, aX: Ushort, aY: Ushort, b: Vec2us): Vec2us {
        res.x.v = aX.v udiv b.x.v
        res.y.v = aY.v udiv b.y.v
        return res
    }

    fun div(res: Vec2us, aX: Short, aY: Short, b: Vec2us): Vec2us {
        res.x.v = aX udiv b.x.v
        res.y.v = aY udiv b.y.v
        return res
    }

    fun div(res: Vec2us, aX: Int, aY: Int, b: Vec2us): Vec2us {
        res.x.v = (aX udiv b.x.v).s
        res.y.v = (aY udiv b.y.v).s
        return res
    }

    fun rem(res: Vec2us, a: Vec2us, bX: Ushort, bY: Ushort): Vec2us {
        res.x.v = a.x.v urem bX.v
        res.y.v = a.y.v urem bY.v
        return res
    }

    fun rem(res: Vec2us, a: Vec2us, bX: Short, bY: Short): Vec2us {
        res.x.v = a.x.v urem bX
        res.y.v = a.y.v urem bY
        return res
    }

    fun rem(res: Vec2us, a: Vec2us, bX: Int, bY: Int): Vec2us {
        res.x.v = a.x.v urem bX
        res.y.v = a.y.v urem bY
        return res
    }

    fun rem(res: Vec2us, aX: Ushort, aY: Ushort, b: Vec2us): Vec2us {
        res.x.v = aX.v urem b.x.v
        res.y.v = aY.v urem b.y.v
        return res
    }

    fun rem(res: Vec2us, aX: Short, aY: Short, b: Vec2us): Vec2us {
        res.x.v = aX urem b.x.v
        res.y.v = aY urem b.y.v
        return res
    }

    fun rem(res: Vec2us, aX: Int, aY: Int, b: Vec2us): Vec2us {
        res.x.v = (aX urem b.x.v).s
        res.y.v = (aY urem b.y.v).s
        return res
    }

    fun and(res: Vec2us, a: Vec2us, bX: Ushort, bY: Ushort): Vec2us {
        res.x.v = a.x.v and bX.v
        res.y.v = a.y.v and bY.v
        return res
    }

    fun and(res: Vec2us, a: Vec2us, bX: Short, bY: Short): Vec2us {
        res.x.v = a.x.v and bX
        res.y.v = a.y.v and bY
        return res
    }

    fun and(res: Vec2us, a: Vec2us, bX: Int, bY: Int): Vec2us {
        res.x.v = a.x.v and bX
        res.y.v = a.y.v and bY
        return res
    }

    fun or(res: Vec2us, a: Vec2us, bX: Ushort, bY: Ushort): Vec2us {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        return res
    }

    fun or(res: Vec2us, a: Vec2us, bX: Short, bY: Short): Vec2us {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        return res
    }

    fun or(res: Vec2us, a: Vec2us, bX: Int, bY: Int): Vec2us {
        res.x.v = a.x.v or bX
        res.y.v = a.y.v or bY
        return res
    }

    fun xor(res: Vec2us, a: Vec2us, bX: Ushort, bY: Ushort): Vec2us {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        return res
    }

    fun xor(res: Vec2us, a: Vec2us, bX: Short, bY: Short): Vec2us {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        return res
    }

    fun xor(res: Vec2us, a: Vec2us, bX: Int, bY: Int): Vec2us {
        res.x.v = a.x.v xor bX
        res.y.v = a.y.v xor bY
        return res
    }

    fun shl(res: Vec2us, a: Vec2us, bX: Ushort, bY: Ushort): Vec2us {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        return res
    }

    fun shl(res: Vec2us, a: Vec2us, bX: Short, bY: Short): Vec2us {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        return res
    }

    fun shl(res: Vec2us, a: Vec2us, bX: Int, bY: Int): Vec2us {
        res.x.v = a.x.v shl bX
        res.y.v = a.y.v shl bY
        return res
    }

    fun shr(res: Vec2us, a: Vec2us, bX: Ushort, bY: Ushort): Vec2us {
        res.x.v = a.x.v ushr bX.v
        res.y.v = a.y.v ushr bY.v
        return res
    }

    fun shr(res: Vec2us, a: Vec2us, bX: Short, bY: Short): Vec2us {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        return res
    }

    fun shr(res: Vec2us, a: Vec2us, bX: Int, bY: Int): Vec2us {
        res.x.v = a.x.v ushr bX
        res.y.v = a.y.v ushr bY
        return res
    }

    fun inv(res: Vec2us, a: Vec2us): Vec2us {
        res.x.v = a.x.v.inv()
        res.y.v = a.y.v.inv()
        return res
    }
}


// -- Specific binary arithmetic operators --

infix operator fun Ushort.plus(b: Vec2us) = plus(Vec2us(), b, this, this)
fun Ushort.plus(b: Vec2us, res: Vec2us) = plus(res, b, this, this)
infix fun Ushort.plus_(b: Vec2us) = plus(b, b, this, this)

infix operator fun Ushort.minus(b: Vec2us) = minus(Vec2us(), this, this, b)
fun Ushort.minus(b: Vec2us, res: Vec2us) = minus(res, this, this, b)
infix fun Ushort.minus_(b: Vec2us) = minus(b, this, this, b)

infix operator fun Ushort.times(b: Vec2us) = times(Vec2us(), b, this, this)
fun Ushort.times(b: Vec2us, res: Vec2us) = times(res, b, this, this)
infix fun Ushort.times_(b: Vec2us) = times(b, b, this, this)

infix operator fun Ushort.div(b: Vec2us) = div(Vec2us(), this, this, b)
fun Ushort.div(b: Vec2us, res: Vec2us) = div(res, this, this, b)
infix fun Ushort.div_(b: Vec2us) = div(b, this, this, b)

infix operator fun Ushort.rem(b: Vec2us) = rem(Vec2us(), this, this, b)
fun Ushort.rem(b: Vec2us, res: Vec2us) = rem(res, this, this, b)
infix fun Ushort.rem_(b: Vec2us) = rem(b, this, this, b)


infix operator fun Short.plus(b: Vec2us) = plus(Vec2us(), b, this, this)
fun Short.plus(b: Vec2us, res: Vec2us) = plus(res, b, this, this)
infix fun Short.plus_(b: Vec2us) = plus(b, b, this, this)

infix operator fun Short.minus(b: Vec2us) = minus(Vec2us(), this, this, b)
fun Short.minus(b: Vec2us, res: Vec2us) = minus(res, this, this, b)
infix fun Short.minus_(b: Vec2us) = minus(b, this, this, b)

infix operator fun Short.times(b: Vec2us) = times(Vec2us(), b, this, this)
fun Short.times(b: Vec2us, res: Vec2us) = times(res, b, this, this)
infix fun Short.times_(b: Vec2us) = times(b, b, this, this)

infix operator fun Short.div(b: Vec2us) = div(Vec2us(), this, this, b)
fun Short.div(b: Vec2us, res: Vec2us) = div(res, this, this, b)
infix fun Short.div_(b: Vec2us) = div(b, this, this, b)

infix operator fun Short.rem(b: Vec2us) = rem(Vec2us(), this, this, b)
fun Short.rem(b: Vec2us, res: Vec2us) = rem(res, this, this, b)
infix fun Short.rem_(b: Vec2us) = rem(b, this, this, b)


infix operator fun Int.plus(b: Vec2us) = plus(Vec2us(), b, this, this)
fun Int.plus(b: Vec2us, res: Vec2us) = plus(res, b, this, this)
infix fun Int.plus_(b: Vec2us) = plus(b, b, this, this)

infix operator fun Int.minus(b: Vec2us) = minus(Vec2us(), this, this, b)
fun Int.minus(b: Vec2us, res: Vec2us) = minus(res, this, this, b)
infix fun Int.minus_(b: Vec2us) = minus(b, this, this, b)

infix operator fun Int.times(b: Vec2us) = times(Vec2us(), b, this, this)
fun Int.times(b: Vec2us, res: Vec2us) = times(res, b, this, this)
infix fun Int.times_(b: Vec2us) = times(b, b, this, this)

infix operator fun Int.div(b: Vec2us) = div(Vec2us(), this, this, b)
fun Int.div(b: Vec2us, res: Vec2us) = div(res, this, this, b)
infix fun Int.div_(b: Vec2us) = div(b, this, this, b)

infix operator fun Int.rem(b: Vec2us) = rem(Vec2us(), this, this, b)
fun Int.rem(b: Vec2us, res: Vec2us) = rem(res, this, this, b)
infix fun Int.rem_(b: Vec2us) = rem(b, this, this, b)


// -- Generic binary arithmetic operators --

infix operator fun Number.plus(b: Vec2us) = plus(Vec2us(), b, this.i, this.i)
fun Number.plus(b: Vec2us, res: Vec2us) = plus(res, b, this.i, this.i)
infix fun Number.plus_(b: Vec2us) = plus(b, b, this.i, this.i)

infix operator fun Number.minus(b: Vec2us) = minus(Vec2us(), this.i, this.i, b)
fun Number.minus(b: Vec2us, res: Vec2us) = minus(res, this.i, this.i, b)
infix fun Number.minus_(b: Vec2us) = minus(b, this.i, this.i, b)

infix operator fun Number.times(b: Vec2us) = times(Vec2us(), b, this.i, this.i)
fun Number.times(b: Vec2us, res: Vec2us) = times(res, b, this.i, this.i)
infix fun Number.times_(b: Vec2us) = times(b, b, this.i, this.i)

infix operator fun Number.div(b: Vec2us) = div(Vec2us(), this.i, this.i, b)
fun Number.div(b: Vec2us, res: Vec2us) = div(res, this.i, this.i, b)
infix fun Number.div_(b: Vec2us) = div(b, this.i, this.i, b)

infix operator fun Number.rem(b: Vec2us) = rem(Vec2us(), this.i, this.i, b)
fun Number.rem(b: Vec2us, res: Vec2us) = rem(res, this.i, this.i, b)
infix fun Number.rem_(b: Vec2us) = rem(b, this.i, this.i, b)