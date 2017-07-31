package glm_.vec2

import glm_.BYTES
import glm_.getShort
import glm_.s
import glm_.vec2.operators.vec2s_operators
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import java.nio.*

/**
 * Created by GBarbieri on 06.10.2016.
 */

class Vec2s(x: Short, y: Short) : Vec2t<Short>(x, y) {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y)

    constructor(v: Vec2bool) : this(v.x.s, v.y.s)
    constructor(v: Vec3bool) : this(v.x.s, v.y.s)
    constructor(v: Vec4bool) : this(v.x.s, v.y.s)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneShort: Boolean = true, bigEndianess: Boolean = true) : this(
            if (oneByteOneShort) bytes[index].s else bytes.getShort(index, bigEndianess),
            if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Short.BYTES, bigEndianess))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].s, chars[index + 1].s)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].s, booleans[index + 1].s)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].s, chars[index + 1].s)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].s, booleans[index + 1].s)

    constructor(list: List<Any>, index: Int = 0) : this(list[index].s, list[index + 1].s)

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneShort: Boolean = true) : this(
            if (oneByteOneShort) bytes[index].s else bytes.getShort(index),
            if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Short.BYTES))

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].s, chars[index + 1].s)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1])

    constructor(s: Number) : this(s, s)
    constructor(x: Number, y: Number) : this(x.s, y.s)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneShort: Boolean = true, bigEndianess: Boolean = true) {
        x = if (oneByteOneShort) bytes[index].s else bytes.getShort(index, bigEndianess)
        y = if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Short.BYTES, bigEndianess)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneShort: Boolean = true) {
        x = if (oneByteOneShort) bytes[index].s else bytes.getShort(index)
        y = if (oneByteOneShort) bytes[index + 1].s else bytes.getShort(index + Short.BYTES)
    }


    fun put(x: Short, y: Short): Vec2s {
        this.x = x
        this.y = y
        return this
    }

    override fun put(x: Number, y: Number): Vec2s {
        this.x = x.s
        this.y = y.s
        return this
    }


    // -- Component accesses --

    override operator fun get(i: Int) = when (i) {
        0 -> x
        1 -> y
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Short) = when (i) {
        0 -> x = s.s
        1 -> y = s.s
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Number) = when (i) {
        0 -> x = s.s
        1 -> y = s.s
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec2s_operators {
        @JvmField val length = 2
        @JvmField val size = length * Short.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec2s(-x, -y)


    // -- Increment main.and decrement operators --

    operator fun inc() = plus(Vec2s(), this, 1, 1)
    infix fun inc(res: Vec2s) = plus(res, this, 1, 1)
    fun inc_() = plus(this, this, 1, 1)


    operator fun dec() = minus(Vec2s(), this, 1, 1)
    infix fun dec(res: Vec2s) = minus(res, this, 1, 1)
    fun dec_() = minus(this, this, 1, 1)


    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: Short) = plus(Vec2s(), this, b, b)
    infix operator fun plus(b: Int) = plus(Vec2s(), this, b, b)
    infix operator fun plus(b: Vec2s) = plus(Vec2s(), this, b.x, b.y)

    @JvmOverloads fun plus(bX: Short, bY: Short, res: Vec2s = Vec2s()) = plus(res, this, bX, bY)
    @JvmOverloads fun plus(bX: Int, bY: Int, res: Vec2s = Vec2s()) = plus(res, this, bX, bY)
    fun plus(b: Short, res: Vec2s) = plus(res, this, b, b)
    fun plus(b: Int, res: Vec2s) = plus(res, this, b, b)
    fun plus(b: Vec2s, res: Vec2s) = plus(res, this, b.x, b.y)

    fun plus_(bX: Short, bY: Short) = plus(this, this, bX, bY)
    fun plus_(bX: Int, bY: Int) = plus(this, this, bX, bY)
    infix fun plus_(b: Short) = plus(this, this, b, b)
    infix fun plus_(b: Int) = plus(this, this, b, b)
    infix fun plus_(b: Vec2s) = plus(this, this, b.x, b.y)


    infix operator fun minus(b: Short) = minus(Vec2s(), this, b, b)
    infix operator fun minus(b: Int) = minus(Vec2s(), this, b, b)
    infix operator fun minus(b: Vec2s) = minus(Vec2s(), this, b.x, b.y)

    @JvmOverloads fun minus(bX: Short, bY: Short, res: Vec2s = Vec2s()) = minus(res, this, bX, bY)
    @JvmOverloads fun minus(bX: Int, bY: Int, res: Vec2s = Vec2s()) = minus(res, this, bX, bY)
    fun minus(b: Short, res: Vec2s) = minus(res, this, b, b)
    fun minus(b: Int, res: Vec2s) = minus(res, this, b, b)
    fun minus(b: Vec2s, res: Vec2s) = minus(res, this, b.x, b.y)

    fun minus_(bX: Short, bY: Short) = minus(this, this, bX, bY)
    fun minus_(bX: Int, bY: Int) = minus(this, this, bX, bY)
    infix fun minus_(b: Short) = minus(this, this, b, b)
    infix fun minus_(b: Int) = minus(this, this, b, b)
    infix fun minus_(b: Vec2s) = minus(this, this, b.x, b.y)


    infix operator fun times(b: Short) = times(Vec2s(), this, b, b)
    infix operator fun times(b: Int) = times(Vec2s(), this, b, b)
    infix operator fun times(b: Vec2s) = times(Vec2s(), this, b.x, b.y)

    @JvmOverloads fun times(bX: Short, bY: Short, res: Vec2s = Vec2s()) = times(res, this, bX, bY)
    @JvmOverloads fun times(bX: Int, bY: Int, res: Vec2s = Vec2s()) = times(res, this, bX, bY)
    fun times(b: Short, res: Vec2s) = times(res, this, b, b)
    fun times(b: Int, res: Vec2s) = times(res, this, b, b)
    fun times(b: Vec2s, res: Vec2s) = times(res, this, b.x, b.y)

    fun times_(bX: Short, bY: Short) = times(this, this, bX, bY)
    fun times_(bX: Int, bY: Int) = times(this, this, bX, bY)
    infix fun times_(b: Short) = times(this, this, b, b)
    infix fun times_(b: Int) = times(this, this, b, b)
    infix fun times_(b: Vec2s) = times(this, this, b.x, b.y)


    infix operator fun div(b: Short) = div(Vec2s(), this, b, b)
    infix operator fun div(b: Int) = div(Vec2s(), this, b, b)
    infix operator fun div(b: Vec2s) = div(Vec2s(), this, b.x, b.y)

    @JvmOverloads fun div(bX: Short, bY: Short, res: Vec2s = Vec2s()) = div(res, this, bX, bY)
    @JvmOverloads fun div(bX: Int, bY: Int, res: Vec2s = Vec2s()) = div(res, this, bX, bY)
    fun div(b: Short, res: Vec2s) = div(res, this, b, b)
    fun div(b: Int, res: Vec2s) = div(res, this, b, b)
    fun div(b: Vec2s, res: Vec2s) = div(res, this, b.x, b.y)

    fun div_(bX: Short, bY: Short) = div(this, this, bX, bY)
    fun div_(bX: Int, bY: Int) = div(this, this, bX, bY)
    infix fun div_(b: Short) = div(this, this, b, b)
    infix fun div_(b: Int) = div(this, this, b, b)
    infix fun div_(b: Vec2s) = div(this, this, b.x, b.y)


    infix operator fun rem(b: Short) = rem(Vec2s(), this, b, b)
    infix operator fun rem(b: Int) = rem(Vec2s(), this, b, b)
    infix operator fun rem(b: Vec2s) = rem(Vec2s(), this, b.x, b.y)

    @JvmOverloads fun rem(bX: Short, bY: Short, res: Vec2s = Vec2s()) = rem(res, this, bX, bY)
    @JvmOverloads fun rem(bX: Int, bY: Int, res: Vec2s = Vec2s()) = rem(res, this, bX, bY)
    fun rem(b: Short, res: Vec2s) = rem(res, this, b, b)
    fun rem(b: Int, res: Vec2s) = rem(res, this, b, b)
    fun rem(b: Vec2s, res: Vec2s) = rem(res, this, b.x, b.y)

    fun rem_(bX: Short, bY: Short) = rem(this, this, bX, bY)
    fun rem_(bX: Int, bY: Int) = rem(this, this, bX, bY)
    infix fun rem_(b: Short) = rem(this, this, b, b)
    infix fun rem_(b: Int) = rem(this, this, b, b)
    infix fun rem_(b: Vec2s) = rem(this, this, b.x, b.y)


    // -- Generic binary arithmetic operators --

    infix operator fun plus(b: Number) = plus(Vec2s(), this, b.s, b.s)
    infix operator fun plus(b: Vec2t<out Number>) = plus(Vec2s(), this, b.x.s, b.y.s)

    @JvmOverloads fun plus(bX: Number, bY: Number, res: Vec2s = Vec2s()) = plus(res, this, bX.s, bY.s)
    fun plus(b: Number, res: Vec2s) = plus(res, this, b.s, b.s)
    fun plus(b: Vec2t<out Number>, res: Vec2s) = plus(res, this, b.x.s, b.y.s)

    fun plus_(bX: Number, bY: Number) = plus(this, this, bX.s, bY.s)
    infix fun plus_(b: Number) = plus(this, this, b.s, b.s)
    infix fun plus_(b: Vec2t<out Number>) = plus(this, this, b.x.s, b.y.s)


    infix operator fun minus(b: Number) = minus(Vec2s(), this, b.s, b.s)
    infix operator fun minus(b: Vec2t<out Number>) = minus(Vec2s(), this, b.x.s, b.y.s)

    @JvmOverloads fun minus(bX: Number, bY: Number, res: Vec2s = Vec2s()) = minus(res, this, bX.s, bY.s)
    fun minus(b: Number, res: Vec2s) = minus(res, this, b.s, b.s)
    fun minus(b: Vec2t<out Number>, res: Vec2s) = minus(res, this, b.x.s, b.y.s)

    fun minus_(bX: Number, bY: Number) = minus(this, this, bX.s, bY.s)
    infix fun minus_(b: Number) = minus(this, this, b.s, b.s)
    infix fun minus_(b: Vec2t<out Number>) = minus(this, this, b.x.s, b.y.s)


    infix operator fun times(b: Number) = times(Vec2s(), this, b.s, b.s)
    infix operator fun times(b: Vec2t<out Number>) = times(Vec2s(), this, b.x.s, b.y.s)

    @JvmOverloads fun times(bX: Number, bY: Number, res: Vec2s = Vec2s()) = times(res, this, bX.s, bY.s)
    fun times(b: Number, res: Vec2s) = times(res, this, b.s, b.s)
    fun times(b: Vec2t<out Number>, res: Vec2s) = times(res, this, b.x.s, b.y.s)

    fun times_(bX: Number, bY: Number) = times(this, this, bX.s, bY.s)
    infix fun times_(b: Number) = times(this, this, b.s, b.s)
    infix fun times_(b: Vec2t<out Number>) = times(this, this, b.x.s, b.y.s)


    infix operator fun div(b: Number) = div(Vec2s(), this, b.s, b.s)
    infix operator fun div(b: Vec2t<out Number>) = div(Vec2s(), this, b.x.s, b.y.s)

    @JvmOverloads fun div(bX: Number, bY: Number, res: Vec2s = Vec2s()) = div(res, this, bX.s, bY.s)
    fun div(b: Number, res: Vec2s) = div(res, this, b.s, b.s)
    fun div(b: Vec2t<out Number>, res: Vec2s) = div(res, this, b.x.s, b.y.s)

    fun div_(bX: Number, bY: Number) = div(this, this, bX.s, bY.s)
    infix fun div_(b: Number) = div(this, this, b.s, b.s)
    infix fun div_(b: Vec2t<out Number>) = div(this, this, b.x.s, b.y.s)


    infix operator fun rem(b: Number) = rem(Vec2s(), this, b.s, b.s)
    infix operator fun rem(b: Vec2t<out Number>) = rem(Vec2s(), this, b.x.s, b.y.s)

    @JvmOverloads fun rem(bX: Number, bY: Number, res: Vec2s = Vec2s()) = rem(res, this, bX.s, bY.s)
    fun rem(b: Number, res: Vec2s) = rem(res, this, b.s, b.s)
    fun rem(b: Vec2t<out Number>, res: Vec2s) = rem(res, this, b.x.s, b.y.s)

    fun rem_(bX: Number, bY: Number) = rem(this, this, bX.s, bY.s)
    infix fun rem_(b: Number) = rem(this, this, b.s, b.s)
    infix fun rem_(b: Vec2t<out Number>) = rem(this, this, b.x.s, b.y.s)


    // -- Specific bitwise operators --

    infix fun and(b: Short) = and(Vec2s(), this, b, b)
    infix fun and(b: Int) = and(Vec2s(), this, b, b)
    infix fun and(b: Vec2s) = and(Vec2s(), this, b.x, b.y)

    fun and(b: Short, res: Vec2s) = and(res, this, b, b)
    fun and(b: Int, res: Vec2s) = and(res, this, b, b)
    fun and(b: Vec2s, res: Vec2s) = and(res, this, b.x, b.y)
    @JvmOverloads fun and(bX: Short, bY: Short, res: Vec2s = Vec2s()) = and(res, this, bX, bY)
    @JvmOverloads fun and(bX: Int, bY: Int, res: Vec2s = Vec2s()) = and(res, this, bX, bY)

    infix fun and_(b: Short) = and(this, this, b, b)
    infix fun and_(b: Int) = and(this, this, b, b)
    infix fun and_(b: Vec2s) = and(this, this, b.x, b.y)
    fun and_(bX: Short, bY: Short) = and(this, this, bX, bY)
    fun and_(bX: Int, bY: Int) = and(this, this, bX, bY)


    infix fun or(b: Short) = or(Vec2s(), this, b, b)
    infix fun or(b: Int) = or(Vec2s(), this, b, b)
    infix fun or(b: Vec2s) = or(Vec2s(), this, b.x, b.y)

    fun or(b: Short, res: Vec2s) = or(res, this, b, b)
    fun or(b: Int, res: Vec2s) = or(res, this, b, b)
    fun or(b: Vec2s, res: Vec2s) = or(res, this, b.x, b.y)
    @JvmOverloads fun or(bX: Short, bY: Short, res: Vec2s = Vec2s()) = or(res, this, bX, bY)
    @JvmOverloads fun or(bX: Int, bY: Int, res: Vec2s = Vec2s()) = or(res, this, bX, bY)

    infix fun or_(b: Short) = or(this, this, b, b)
    infix fun or_(b: Int) = or(this, this, b, b)
    infix fun or_(b: Vec2s) = or(this, this, b.x, b.y)
    fun or_(bX: Short, bY: Short) = or(this, this, bX, bY)
    fun or_(bX: Int, bY: Int) = or(this, this, bX, bY)


    infix fun xor(b: Short) = xor(Vec2s(), this, b, b)
    infix fun xor(b: Int) = xor(Vec2s(), this, b, b)
    infix fun xor(b: Vec2s) = xor(Vec2s(), this, b.x, b.y)

    fun xor(b: Short, res: Vec2s) = xor(res, this, b, b)
    fun xor(b: Int, res: Vec2s) = xor(res, this, b, b)
    fun xor(b: Vec2s, res: Vec2s) = xor(res, this, b.x, b.y)
    @JvmOverloads fun xor(bX: Short, bY: Short, res: Vec2s = Vec2s()) = xor(res, this, bX, bY)
    @JvmOverloads fun xor(bX: Int, bY: Int, res: Vec2s = Vec2s()) = xor(res, this, bX, bY)

    infix fun xor_(b: Short) = xor(this, this, b, b)
    infix fun xor_(b: Int) = xor(this, this, b, b)
    infix fun xor_(b: Vec2s) = xor(this, this, b.x, b.y)
    fun xor_(bX: Short, bY: Short) = xor(this, this, bX, bY)
    fun xor_(bX: Int, bY: Int) = xor(this, this, bX, bY)


    infix fun shl(b: Short) = shl(Vec2s(), this, b, b)
    infix fun shl(b: Int) = shl(Vec2s(), this, b, b)
    infix fun shl(b: Vec2s) = shl(Vec2s(), this, b.x, b.y)

    fun shl(b: Short, res: Vec2s) = shl(res, this, b, b)
    fun shl(b: Int, res: Vec2s) = shl(res, this, b, b)
    fun shl(b: Vec2s, res: Vec2s) = shl(res, this, b.x, b.y)
    @JvmOverloads fun shl(bX: Short, bY: Short, res: Vec2s = Vec2s()) = shl(res, this, bX, bY)
    @JvmOverloads fun shl(bX: Int, bY: Int, res: Vec2s = Vec2s()) = shl(res, this, bX, bY)

    infix fun shl_(b: Short) = shl(this, this, b, b)
    infix fun shl_(b: Int) = shl(this, this, b, b)
    infix fun shl_(b: Vec2s) = shl(this, this, b.x, b.y)
    fun shl_(bX: Short, bY: Short) = shl(this, this, bX, bY)
    fun shl_(bX: Int, bY: Int) = shl(this, this, bX, bY)


    infix fun shr(b: Short) = shr(Vec2s(), this, b, b)
    infix fun shr(b: Int) = shr(Vec2s(), this, b, b)
    infix fun shr(b: Vec2s) = shr(Vec2s(), this, b.x, b.y)

    fun shr(b: Short, res: Vec2s) = shr(res, this, b, b)
    fun shr(b: Int, res: Vec2s) = shr(res, this, b, b)
    fun shr(b: Vec2s, res: Vec2s) = shr(res, this, b.x, b.y)
    @JvmOverloads fun shr(bX: Short, bY: Short, res: Vec2s = Vec2s()) = shr(res, this, bX, bY)
    @JvmOverloads fun shr(bX: Int, bY: Int, res: Vec2s = Vec2s()) = shr(res, this, bX, bY)

    infix fun shr_(b: Short) = shr(this, this, b, b)
    infix fun shr_(b: Int) = shr(this, this, b, b)
    infix fun shr_(b: Vec2s) = shr(this, this, b.x, b.y)
    fun shr_(bX: Short, bY: Short) = shr(this, this, bX, bY)
    fun shr_(bX: Int, bY: Int) = shr(this, this, bX, bY)


    @JvmOverloads fun inv(res: Vec2s = Vec2s()) = inv(res, this)
    fun inv_() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec2s(), this, b.s, b.s)
    infix fun and(b: Vec2t<out Number>) = and(Vec2s(), this, b.x.s, b.y.s)

    fun and(b: Number, res: Vec2s) = and(res, this, b.s, b.s)
    fun and(b: Vec2t<out Number>, res: Vec2s) = and(res, this, b.x.s, b.y.s)
    @JvmOverloads fun and(bX: Number, bY: Number, res: Vec2s = Vec2s()) = and(res, this, bX.s, bY.s)

    infix fun and_(b: Number) = and(this, this, b.s, b.s)
    infix fun and_(b: Vec2t<out Number>) = and(this, this, b.x.s, b.y.s)
    fun and_(bX: Number, bY: Number) = and(this, this, bX.s, bY.s)


    infix fun or(b: Number) = or(Vec2s(), this, b.s, b.s)
    infix fun or(b: Vec2t<out Number>) = or(Vec2s(), this, b.x.s, b.y.s)

    fun or(b: Number, res: Vec2s) = or(res, this, b.s, b.s)
    fun or(b: Vec2t<out Number>, res: Vec2s) = or(res, this, b.x.s, b.y.s)
    @JvmOverloads fun or(bX: Number, bY: Number, res: Vec2s = Vec2s()) = or(res, this, bX.s, bY.s)

    infix fun or_(b: Number) = or(this, this, b.s, b.s)
    infix fun or_(b: Vec2t<out Number>) = or(this, this, b.x.s, b.y.s)
    fun or_(bX: Number, bY: Number) = or(this, this, bX.s, bY.s)


    infix fun xor(b: Number) = xor(Vec2s(), this, b.s, b.s)
    infix fun xor(b: Vec2t<out Number>) = xor(Vec2s(), this, b.x.s, b.y.s)

    fun xor(b: Number, res: Vec2s) = xor(res, this, b.s, b.s)
    fun xor(b: Vec2t<out Number>, res: Vec2s) = xor(res, this, b.x.s, b.y.s)
    @JvmOverloads fun xor(bX: Number, bY: Number, res: Vec2s = Vec2s()) = xor(res, this, bX.s, bY.s)

    infix fun xor_(b: Number) = xor(this, this, b.s, b.s)
    infix fun xor_(b: Vec2t<out Number>) = xor(this, this, b.x.s, b.y.s)
    fun xor_(bX: Number, bY: Number) = xor(this, this, bX.s, bY.s)


    infix fun shl(b: Number) = shl(Vec2s(), this, b.s, b.s)
    infix fun shl(b: Vec2t<out Number>) = shl(Vec2s(), this, b.x.s, b.y.s)

    fun shl(b: Number, res: Vec2s) = shl(res, this, b.s, b.s)
    fun shl(b: Vec2t<out Number>, res: Vec2s) = shl(res, this, b.x.s, b.y.s)
    @JvmOverloads fun shl(bX: Number, bY: Number, res: Vec2s = Vec2s()) = shl(res, this, bX.s, bY.s)

    infix fun shl_(b: Number) = shl(this, this, b.s, b.s)
    infix fun shl_(b: Vec2t<out Number>) = shl(this, this, b.x.s, b.y.s)
    fun shl_(bX: Number, bY: Number) = shl(this, this, bX.s, bY.s)


    infix fun shr(b: Number) = shr(Vec2s(), this, b.s, b.s)
    infix fun shr(b: Vec2t<out Number>) = shr(Vec2s(), this, b.x.s, b.y.s)

    fun shr(b: Number, res: Vec2s) = shr(res, this, b.s, b.s)
    fun shr(b: Vec2t<out Number>, res: Vec2s) = shr(res, this, b.x.s, b.y.s)
    @JvmOverloads fun shr(bX: Number, bY: Number, res: Vec2s = Vec2s()) = shr(res, this, bX.s, bY.s)

    infix fun shr_(b: Number) = shr(this, this, b.s, b.s)
    infix fun shr_(b: Vec2t<out Number>) = shr(this, this, b.x.s, b.y.s)
    fun shr_(bX: Number, bY: Number) = shr(this, this, bX.s, bY.s)


    override fun equals(other: Any?) =
            if (other is Vec2s)
                this[0] == other[0] && this[1] == other[1]
            else false
}