package glm_.vec2

import glm_.BYTES
import glm_.b
import glm_.i
import glm_.vec2.operators.vec2b_operators
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import java.nio.*

/**
 * Created bY GBarbieri on 06.10.2016.
 */

class Vec2b(x: Byte, y: Byte) : Vec2t<Byte>(x, y) {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec2t<out Number>) : this(v.x, v.y)
    constructor(v: Vec3t<out Number>) : this(v.x, v.y)
    constructor(v: Vec4t<out Number>) : this(v.x, v.y)

    constructor(v: Vec2bool) : this(v.x.b, v.y.b)
    constructor(v: Vec3bool) : this(v.x.b, v.y.b)
    constructor(v: Vec4bool) : this(v.x.b, v.y.b)

    constructor(bytes: ByteArray, index: Int = 0) : this(bytes[index], bytes[index + 1])
    constructor(chars: CharArray, index: Int = 0) : this(chars[index].b, chars[index + 1].b)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index], ints[index + 1])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index], longs[index + 1])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index], doubles[index + 1])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].b, booleans[index + 1].b)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index], numbers[index + 1])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].b, chars[index + 1].b)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].b, booleans[index + 1].b)

    constructor(list: List<Any>, index: Int = 0) : this(list[index].b, list[index + 1].b)

    constructor(bytes: ByteBuffer, index: Int = bytes.position()) : this(bytes[index], bytes[index + 1])
    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].b, chars[index + 1].b)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index], shorts[index + 1])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index], ints[index + 1])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index], longs[index + 1])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index], floats[index + 1])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index], doubles[index + 1])

    constructor(s: Number) : this(s, s)
    constructor(x: Number, y: Number) : this(x.b, y.b)


    fun put(x: Byte, y: Byte): Vec2b {
        this.x = x
        this.y = y
        return this
    }

    override fun put(x: Number, y: Number): Vec2b {
        this.x = x.b
        this.y = y.b
        return this
    }


    // -- Component accesses --

    override operator fun get(i: Int) = when (i) {
        0 -> x
        1 -> y
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Byte) = when (i) {
        0 -> x = s
        1 -> y = s
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Number) = when (i) {
        0 -> x = s.b
        1 -> y = s.b
        else -> throw ArrayIndexOutOfBoundsException()
    }


    companion object : vec2b_operators {
        @JvmField val length = 2
        @JvmField val size = length * Byte.BYTES
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Vec2b(-x, -y)

    // -- Increment main.and decrement operators --

    operator fun inc() = plus(Vec2b(), this, 1, 1)
    infix fun inc(res: Vec2b) = plus(res, this, 1, 1)
    fun inc_() = plus(this, this, 1, 1)


    operator fun dec() = minus(Vec2b(), this, 1, 1)
    infix fun dec(res: Vec2b) = minus(res, this, 1, 1)
    fun dec_() = minus(this, this, 1, 1)


    // -- Specific binary arithmetic operators --

    infix operator fun plus(b: Byte) = plus(Vec2b(), this, b, b)
    infix operator fun plus(b: Int) = plus(Vec2b(), this, b, b)
    infix operator fun plus(b: Vec2b) = plus(Vec2b(), this, b.x, b.y)

    @JvmOverloads fun plus(bX: Byte, bY: Byte, res: Vec2b = Vec2b()) = plus(res, this, bX, bY)
    @JvmOverloads fun plus(bX: Int, bY: Int, res: Vec2b = Vec2b()) = plus(res, this, bX, bY)
    fun plus(b: Byte, res: Vec2b) = plus(res, this, b, b)
    fun plus(b: Int, res: Vec2b) = plus(res, this, b, b)
    fun plus(b: Vec2b, res: Vec2b) = plus(res, this, b.x, b.y)

    fun plus_(bX: Byte, bY: Byte) = plus(this, this, bX, bY)
    fun plus_(bX: Int, bY: Int) = plus(this, this, bX, bY)
    infix fun plus_(b: Byte) = plus(this, this, b, b)
    infix fun plus_(b: Int) = plus(this, this, b, b)
    infix fun plus_(b: Vec2b) = plus(this, this, b.x, b.y)


    infix operator fun minus(b: Byte) = minus(Vec2b(), this, b, b)
    infix operator fun minus(b: Int) = minus(Vec2b(), this, b, b)
    infix operator fun minus(b: Vec2b) = minus(Vec2b(), this, b.x, b.y)

    @JvmOverloads fun minus(bX: Byte, bY: Byte, res: Vec2b = Vec2b()) = minus(res, this, bX, bY)
    @JvmOverloads fun minus(bX: Int, bY: Int, res: Vec2b = Vec2b()) = minus(res, this, bX, bY)
    fun minus(b: Byte, res: Vec2b) = minus(res, this, b, b)
    fun minus(b: Int, res: Vec2b) = minus(res, this, b, b)
    fun minus(b: Vec2b, res: Vec2b) = minus(res, this, b.x, b.y)

    fun minus_(bX: Byte, bY: Byte) = minus(this, this, bX, bY)
    fun minus_(bX: Int, bY: Int) = minus(this, this, bX, bY)
    infix fun minus_(b: Byte) = minus(this, this, b, b)
    infix fun minus_(b: Int) = minus(this, this, b, b)
    infix fun minus_(b: Vec2b) = minus(this, this, b.x, b.y)


    infix operator fun times(b: Byte) = times(Vec2b(), this, b, b)
    infix operator fun times(b: Int) = times(Vec2b(), this, b, b)
    infix operator fun times(b: Vec2b) = times(Vec2b(), this, b.x, b.y)

    @JvmOverloads fun times(bX: Byte, bY: Byte, res: Vec2b = Vec2b()) = times(res, this, bX, bY)
    @JvmOverloads fun times(bX: Int, bY: Int, res: Vec2b = Vec2b()) = times(res, this, bX, bY)
    fun times(b: Byte, res: Vec2b) = times(res, this, b, b)
    fun times(b: Int, res: Vec2b) = times(res, this, b, b)
    fun times(b: Vec2b, res: Vec2b) = times(res, this, b.x, b.y)

    fun times_(bX: Byte, bY: Byte) = times(this, this, bX, bY)
    fun times_(bX: Int, bY: Int) = times(this, this, bX, bY)
    infix fun times_(b: Byte) = times(this, this, b, b)
    infix fun times_(b: Int) = times(this, this, b, b)
    infix fun times_(b: Vec2b) = times(this, this, b.x, b.y)


    infix operator fun div(b: Byte) = div(Vec2b(), this, b, b)
    infix operator fun div(b: Int) = div(Vec2b(), this, b, b)
    infix operator fun div(b: Vec2b) = div(Vec2b(), this, b.x, b.y)

    @JvmOverloads fun div(bX: Byte, bY: Byte, res: Vec2b = Vec2b()) = div(res, this, bX, bY)
    @JvmOverloads fun div(bX: Int, bY: Int, res: Vec2b = Vec2b()) = div(res, this, bX, bY)
    fun div(b: Byte, res: Vec2b) = div(res, this, b, b)
    fun div(b: Int, res: Vec2b) = div(res, this, b, b)
    fun div(b: Vec2b, res: Vec2b) = div(res, this, b.x, b.y)

    fun div_(bX: Byte, bY: Byte) = div(this, this, bX, bY)
    fun div_(bX: Int, bY: Int) = div(this, this, bX, bY)
    infix fun div_(b: Byte) = div(this, this, b, b)
    infix fun div_(b: Int) = div(this, this, b, b)
    infix fun div_(b: Vec2b) = div(this, this, b.x, b.y)


    infix operator fun rem(b: Byte) = rem(Vec2b(), this, b, b)
    infix operator fun rem(b: Int) = rem(Vec2b(), this, b, b)
    infix operator fun rem(b: Vec2b) = rem(Vec2b(), this, b.x, b.y)

    @JvmOverloads fun rem(bX: Byte, bY: Byte, res: Vec2b = Vec2b()) = rem(res, this, bX, bY)
    @JvmOverloads fun rem(bX: Int, bY: Int, res: Vec2b = Vec2b()) = rem(res, this, bX, bY)
    fun rem(b: Byte, res: Vec2b) = rem(res, this, b, b)
    fun rem(b: Int, res: Vec2b) = rem(res, this, b, b)
    fun rem(b: Vec2b, res: Vec2b) = rem(res, this, b.x, b.y)

    fun rem_(bX: Byte, bY: Byte) = rem(this, this, bX, bY)
    fun rem_(bX: Int, bY: Int) = rem(this, this, bX, bY)
    infix fun rem_(b: Byte) = rem(this, this, b, b)
    infix fun rem_(b: Int) = rem(this, this, b, b)
    infix fun rem_(b: Vec2b) = rem(this, this, b.x, b.y)


    // -- Generic binary arithmetic infix operators --

    infix operator fun plus(b: Number) = plus(Vec2b(), this, b.i, b.i)
    infix operator fun plus(b: Vec2t<out Number>) = plus(Vec2b(), this, b.x.i, b.y.i)

    @JvmOverloads fun plus(bX: Number, bY: Number, res: Vec2b = Vec2b()) = plus(res, this, bX.i, bY.i)
    fun plus(b: Number, res: Vec2b) = plus(res, this, b.i, b.i)
    fun plus(b: Vec2t<out Number>, res: Vec2b) = plus(res, this, b.x.i, b.y.i)

    fun plus_(bX: Number, bY: Number) = plus(this, this, bX.i, bY.i)
    infix fun plus_(b: Number) = plus(this, this, b.i, b.i)
    infix fun plus_(b: Vec2t<out Number>) = plus(this, this, b.x.i, b.y.i)


    infix operator fun minus(b: Number) = minus(Vec2b(), this, b.i, b.i)
    infix operator fun minus(b: Vec2t<out Number>) = minus(Vec2b(), this, b.x.i, b.y.i)

    @JvmOverloads fun minus(bX: Number, bY: Number, res: Vec2b = Vec2b()) = minus(res, this, bX.i, bY.i)
    fun minus(b: Number, res: Vec2b) = minus(res, this, b.i, b.i)
    fun minus(b: Vec2t<out Number>, res: Vec2b) = minus(res, this, b.x.i, b.y.i)

    fun minus_(bX: Number, bY: Number) = minus(this, this, bX.i, bY.i)
    infix fun minus_(b: Number) = minus(this, this, b.i, b.i)
    infix fun minus_(b: Vec2t<out Number>) = minus(this, this, b.x.i, b.y.i)


    infix operator fun times(b: Number) = times(Vec2b(), this, b.i, b.i)
    infix operator fun times(b: Vec2t<out Number>) = times(Vec2b(), this, b.x.i, b.y.i)

    @JvmOverloads fun times(bX: Number, bY: Number, res: Vec2b = Vec2b()) = times(res, this, bX.i, bY.i)
    fun times(b: Number, res: Vec2b) = times(res, this, b.i, b.i)
    fun times(b: Vec2t<out Number>, res: Vec2b) = times(res, this, b.x.i, b.y.i)

    fun times_(bX: Number, bY: Number) = times(this, this, bX.i, bY.i)
    infix fun times_(b: Number) = times(this, this, b.i, b.i)
    infix fun times_(b: Vec2t<out Number>) = times(this, this, b.x.i, b.y.i)


    infix operator fun div(b: Number) = div(Vec2b(), this, b.i, b.i)
    infix operator fun div(b: Vec2t<out Number>) = div(Vec2b(), this, b.x.i, b.y.i)

    @JvmOverloads fun div(bX: Number, bY: Number, res: Vec2b = Vec2b()) = div(res, this, bX.i, bY.i)
    fun div(b: Number, res: Vec2b) = div(res, this, b.i, b.i)
    fun div(b: Vec2t<out Number>, res: Vec2b) = div(res, this, b.x.i, b.y.i)

    fun div_(bX: Number, bY: Number) = div(this, this, bX.i, bY.i)
    infix fun div_(b: Number) = div(this, this, b.i, b.i)
    infix fun div_(b: Vec2t<out Number>) = div(this, this, b.x.i, b.y.i)


    infix operator fun rem(b: Number) = rem(Vec2b(), this, b.i, b.i)
    infix operator fun rem(b: Vec2t<out Number>) = rem(Vec2b(), this, b.x.i, b.y.i)

    @JvmOverloads fun rem(bX: Number, bY: Number, res: Vec2b = Vec2b()) = rem(res, this, bX.i, bY.i)
    fun rem(b: Number, res: Vec2b) = rem(res, this, b.i, b.i)
    fun rem(b: Vec2t<out Number>, res: Vec2b) = rem(res, this, b.x.i, b.y.i)

    fun rem_(bX: Number, bY: Number) = rem(this, this, bX.i, bY.i)
    infix fun rem_(b: Number) = rem(this, this, b.i, b.i)
    infix fun rem_(b: Vec2t<out Number>) = rem(this, this, b.x.i, b.y.i)


    // -- Specific bitwise operators --

    infix fun and(b: Byte) = and(Vec2b(), this, b, b)
    infix fun and(b: Int) = and(Vec2b(), this, b, b)
    infix fun and(b: Vec2b) = and(Vec2b(), this, b.x, b.y)

    fun and(b: Byte, res: Vec2b) = and(res, this, b, b)
    fun and(b: Int, res: Vec2b) = and(res, this, b, b)
    fun and(b: Vec2b, res: Vec2b) = and(res, this, b.x, b.y)
    @JvmOverloads fun and(bX: Byte, bY: Byte, res: Vec2b = Vec2b()) = and(res, this, bX, bY)
    @JvmOverloads fun and(bX: Int, bY: Int, res: Vec2b = Vec2b()) = and(res, this, bX, bY)

    infix fun and_(b: Byte) = and(this, this, b, b)
    infix fun and_(b: Int) = and(this, this, b, b)
    infix fun and_(b: Vec2b) = and(this, this, b.x, b.y)
    fun and_(bX: Byte, bY: Byte) = and(this, this, bX, bY)
    fun and_(bX: Int, bY: Int) = and(this, this, bX, bY)


    infix fun or(b: Byte) = or(Vec2b(), this, b, b)
    infix fun or(b: Int) = or(Vec2b(), this, b, b)
    infix fun or(b: Vec2b) = or(Vec2b(), this, b.x, b.y)

    fun or(b: Byte, res: Vec2b) = or(res, this, b, b)
    fun or(b: Int, res: Vec2b) = or(res, this, b, b)
    fun or(b: Vec2b, res: Vec2b) = or(res, this, b.x, b.y)
    @JvmOverloads fun or(bX: Byte, bY: Byte, res: Vec2b = Vec2b()) = or(res, this, bX, bY)
    @JvmOverloads fun or(bX: Int, bY: Int, res: Vec2b = Vec2b()) = or(res, this, bX, bY)

    infix fun or_(b: Byte) = or(this, this, b, b)
    infix fun or_(b: Int) = or(this, this, b, b)
    infix fun or_(b: Vec2b) = or(this, this, b.x, b.y)
    fun or_(bX: Byte, bY: Byte) = or(this, this, bX, bY)
    fun or_(bX: Int, bY: Int) = or(this, this, bX, bY)


    infix fun xor(b: Byte) = xor(Vec2b(), this, b, b)
    infix fun xor(b: Int) = xor(Vec2b(), this, b, b)
    infix fun xor(b: Vec2b) = xor(Vec2b(), this, b.x, b.y)

    fun xor(b: Byte, res: Vec2b) = xor(res, this, b, b)
    fun xor(b: Int, res: Vec2b) = xor(res, this, b, b)
    fun xor(b: Vec2b, res: Vec2b) = xor(res, this, b.x, b.y)
    @JvmOverloads fun xor(bX: Byte, bY: Byte, res: Vec2b = Vec2b()) = xor(res, this, bX, bY)
    @JvmOverloads fun xor(bX: Int, bY: Int, res: Vec2b = Vec2b()) = xor(res, this, bX, bY)

    infix fun xor_(b: Byte) = xor(this, this, b, b)
    infix fun xor_(b: Int) = xor(this, this, b, b)
    infix fun xor_(b: Vec2b) = xor(this, this, b.x, b.y)
    fun xor_(bX: Byte, bY: Byte) = xor(this, this, bX, bY)
    fun xor_(bX: Int, bY: Int) = xor(this, this, bX, bY)


    infix fun shl(b: Byte) = shl(Vec2b(), this, b, b)
    infix fun shl(b: Int) = shl(Vec2b(), this, b, b)
    infix fun shl(b: Vec2b) = shl(Vec2b(), this, b.x, b.y)

    fun shl(b: Byte, res: Vec2b) = shl(res, this, b, b)
    fun shl(b: Int, res: Vec2b) = shl(res, this, b, b)
    fun shl(b: Vec2b, res: Vec2b) = shl(res, this, b.x, b.y)
    @JvmOverloads fun shl(bX: Byte, bY: Byte, res: Vec2b = Vec2b()) = shl(res, this, bX, bY)
    @JvmOverloads fun shl(bX: Int, bY: Int, res: Vec2b = Vec2b()) = shl(res, this, bX, bY)

    infix fun shl_(b: Byte) = shl(this, this, b, b)
    infix fun shl_(b: Int) = shl(this, this, b, b)
    infix fun shl_(b: Vec2b) = shl(this, this, b.x, b.y)
    fun shl_(bX: Byte, bY: Byte) = shl(this, this, bX, bY)
    fun shl_(bX: Int, bY: Int) = shl(this, this, bX, bY)


    infix fun shr(b: Byte) = shr(Vec2b(), this, b, b)
    infix fun shr(b: Int) = shr(Vec2b(), this, b, b)
    infix fun shr(b: Vec2b) = shr(Vec2b(), this, b.x, b.y)

    fun shr(b: Byte, res: Vec2b) = shr(res, this, b, b)
    fun shr(b: Int, res: Vec2b) = shr(res, this, b, b)
    fun shr(b: Vec2b, res: Vec2b) = shr(res, this, b.x, b.y)
    @JvmOverloads fun shr(bX: Byte, bY: Byte, res: Vec2b = Vec2b()) = shr(res, this, bX, bY)
    @JvmOverloads fun shr(bX: Int, bY: Int, res: Vec2b = Vec2b()) = shr(res, this, bX, bY)

    infix fun shr_(b: Byte) = shr(this, this, b, b)
    infix fun shr_(b: Int) = shr(this, this, b, b)
    infix fun shr_(b: Vec2b) = shr(this, this, b.x, b.y)
    fun shr_(bX: Byte, bY: Byte) = shr(this, this, bX, bY)
    fun shr_(bX: Int, bY: Int) = shr(this, this, bX, bY)


    @JvmOverloads fun inv(res: Vec2b = Vec2b()) = inv(res, this)
    fun inv_() = inv(this, this)


    // -- Generic bitwise operators --

    infix fun and(b: Number) = and(Vec2b(), this, b.b, b.b)
    infix fun and(b: Vec2t<out Number>) = and(Vec2b(), this, b.x.b, b.y.b)

    fun and(b: Number, res: Vec2b) = and(res, this, b.b, b.b)
    fun and(b: Vec2t<out Number>, res: Vec2b) = and(res, this, b.x.b, b.y.b)
    @JvmOverloads fun and(bX: Number, bY: Number, res: Vec2b = Vec2b()) = and(res, this, bX.b, bY.b)

    infix fun and_(b: Number) = and(this, this, b.b, b.b)
    infix fun and_(b: Vec2t<out Number>) = and(this, this, b.x.b, b.y.b)
    fun and_(bX: Number, bY: Number) = and(this, this, bX.b, bY.b)


    infix fun or(b: Number) = or(Vec2b(), this, b.b, b.b)
    infix fun or(b: Vec2t<out Number>) = or(Vec2b(), this, b.x.b, b.y.b)

    fun or(b: Number, res: Vec2b) = or(res, this, b.b, b.b)
    fun or(b: Vec2t<out Number>, res: Vec2b) = or(res, this, b.x.b, b.y.b)
    @JvmOverloads fun or(bX: Number, bY: Number, res: Vec2b = Vec2b()) = or(res, this, bX.b, bY.b)

    infix fun or_(b: Number) = or(this, this, b.b, b.b)
    infix fun or_(b: Vec2t<out Number>) = or(this, this, b.x.b, b.y.b)
    fun or_(bX: Number, bY: Number) = or(this, this, bX.b, bY.b)


    infix fun xor(b: Number) = xor(Vec2b(), this, b.b, b.b)
    infix fun xor(b: Vec2t<out Number>) = xor(Vec2b(), this, b.x.b, b.y.b)

    fun xor(b: Number, res: Vec2b) = xor(res, this, b.b, b.b)
    fun xor(b: Vec2t<out Number>, res: Vec2b) = xor(res, this, b.x.b, b.y.b)
    @JvmOverloads fun xor(bX: Number, bY: Number, res: Vec2b = Vec2b()) = xor(res, this, bX.b, bY.b)

    infix fun xor_(b: Number) = xor(this, this, b.b, b.b)
    infix fun xor_(b: Vec2t<out Number>) = xor(this, this, b.x.b, b.y.b)
    fun xor_(bX: Number, bY: Number) = xor(this, this, bX.b, bY.b)


    infix fun shl(b: Number) = shl(Vec2b(), this, b.b, b.b)
    infix fun shl(b: Vec2t<out Number>) = shl(Vec2b(), this, b.x.b, b.y.b)

    fun shl(b: Number, res: Vec2b) = shl(res, this, b.b, b.b)
    fun shl(b: Vec2t<out Number>, res: Vec2b) = shl(res, this, b.x.b, b.y.b)
    @JvmOverloads fun shl(bX: Number, bY: Number, res: Vec2b = Vec2b()) = shl(res, this, bX.b, bY.b)

    infix fun shl_(b: Number) = shl(this, this, b.b, b.b)
    infix fun shl_(b: Vec2t<out Number>) = shl(this, this, b.x.b, b.y.b)
    fun shl_(bX: Number, bY: Number) = shl(this, this, bX.b, bY.b)


    infix fun shr(b: Number) = shr(Vec2b(), this, b.b, b.b)
    infix fun shr(b: Vec2t<out Number>) = shr(Vec2b(), this, b.x.b, b.y.b)

    fun shr(b: Number, res: Vec2b) = shr(res, this, b.b, b.b)
    fun shr(b: Vec2t<out Number>, res: Vec2b) = shr(res, this, b.x.b, b.y.b)
    @JvmOverloads fun shr(bX: Number, bY: Number, res: Vec2b = Vec2b()) = shr(res, this, bX.b, bY.b)

    infix fun shr_(b: Number) = shr(this, this, b.b, b.b)
    infix fun shr_(b: Vec2t<out Number>) = shr(this, this, b.x.b, b.y.b)
    fun shr_(bX: Number, bY: Number) = shr(this, this, bX.b, bY.b)


    override fun equals(other: Any?) =
            if (other is Vec2b)
                this[0] == other[0] && this[1] == other[1]
            else false
}