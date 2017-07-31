package glm_.vec1

import glm_.getInt
import glm_.i
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import java.nio.*

/**
 * Created by GBarbieri on 04.04.2017.
 */

class Vec1i(x: Int) : Vec1t<Int>(x) {

    // -- Explicit basic, conversion other main.and conversion vector constructors --

    constructor() : this(0)

    constructor(v: Vec1t<out Number>) : this(v.x)
    constructor(v: Vec2t<out Number>) : this(v.x)
    constructor(v: Vec3t<out Number>) : this(v.x)
    constructor(v: Vec4t<out Number>) : this(v.x)

    constructor(v: Vec1bool) : this(v.x.i)
    constructor(v: Vec2bool) : this(v.x.i)
    constructor(v: Vec3bool) : this(v.x.i)
    constructor(v: Vec4bool) : this(v.x.i)

    constructor(bytes: ByteArray, index: Int = 0, oneByteOneInt: Boolean = true, bigEndianess: Boolean = true)
            : this(if (oneByteOneInt) bytes[index].i else bytes.getInt(index, bigEndianess))

    constructor(chars: CharArray, index: Int = 0) : this(chars[index].i)
    constructor(shorts: ShortArray, index: Int = 0) : this(shorts[index])
    constructor(ints: IntArray, index: Int = 0) : this(ints[index])
    constructor(longs: LongArray, index: Int = 0) : this(longs[index])
    constructor(floats: FloatArray, index: Int = 0) : this(floats[index])
    constructor(doubles: DoubleArray, index: Int = 0) : this(doubles[index])
    constructor(booleans: BooleanArray, index: Int = 0) : this(booleans[index].i)

    constructor(numbers: Array<out Number>, index: Int = 0) : this(numbers[index])
    constructor(chars: Array<Char>, index: Int = 0) : this(chars[index].i)
    constructor(booleans: Array<Boolean>, index: Int = 0) : this(booleans[index].i)

    constructor(list: List<Any>, index: Int = 0) : this() {
        put(list, index)
    }

    constructor(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneInt: Boolean = true)
            : this(if (oneByteOneInt) bytes[index].i else bytes.getInt(index))

    constructor(chars: CharBuffer, index: Int = chars.position()) : this(chars[index].i)
    constructor(shorts: ShortBuffer, index: Int = shorts.position()) : this(shorts[index])
    constructor(ints: IntBuffer, index: Int = ints.position()) : this(ints[index])
    constructor(longs: LongBuffer, index: Int = longs.position()) : this(longs[index])
    constructor(floats: FloatBuffer, index: Int = floats.position()) : this(floats[index])
    constructor(doubles: DoubleBuffer, index: Int = doubles.position()) : this(doubles[index])

    constructor(s: Number) : this(s.i)


    fun set(bytes: ByteArray, index: Int = 0, oneByteOneInt: Boolean = true, bigEndianess: Boolean = true) {
        x = if (oneByteOneInt) bytes[index].i else bytes.getInt(index, bigEndianess)
    }

    fun set(bytes: ByteBuffer, index: Int = bytes.position(), oneByteOneInt: Boolean = true) {
        x = if (oneByteOneInt) bytes[index].i else bytes.getInt(index)
    }


    fun put(x: Int): Vec1i {
        this.x = x
        return this
    }

    override fun put(x: Number): Vec1i {
        this.x = x.i
        return this
    }


    // -- Component accesses --

    infix operator fun get(i: Int) = when (i) {
        0 -> x
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Int) = when (i) {
        0 -> x = s
        else -> throw ArrayIndexOutOfBoundsException()
    }

    operator fun set(i: Int, s: Number) = when (i) {
        0 -> x = s.i
        else -> throw ArrayIndexOutOfBoundsException()
    }
}