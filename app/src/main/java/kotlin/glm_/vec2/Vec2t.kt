@file:Suppress("UNCHECKED_CAST")

package glm_.vec2

import glm_.*
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import java.nio.*

/**
 * Created bY GBarbieri on 05.10.2016.
 */

abstract class Vec2t<T : Number>(_x: T, _y: T) {

    @JvmField var x = _x
    @JvmField var y = _y

    open operator fun get(i: Int) = when (i) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException()
    }

    // -- infix Generic Constructors --

    infix fun put(v: Vec2t<out Number>) = put(v.x, v.y)
    infix fun put(v: Vec3t<out Number>) = put(v.x, v.y)
    infix fun put(v: Vec4t<out Number>) = put(v.x, v.y)

    infix fun put(v: Vec2bool) = put(v.x.b, v.y.b)
    infix fun put(v: Vec3bool) = put(v.x.b, v.y.b)
    infix fun put(v: Vec4bool) = put(v.x.b, v.y.b)

    infix fun put(bytes: ByteArray) = put(bytes, 0)
    infix fun put(chars: CharArray) = put(chars, 0)
    infix fun put(shorts: ShortArray) = put(shorts, 0)
    infix fun put(ints: IntArray) = put(ints, 0)
    infix fun put(longs: LongArray) = put(longs, 0)
    infix fun put(floats: FloatArray) = put(floats, 0)
    infix fun put(doubles: DoubleArray) = put(doubles, 0)
    infix fun put(booleans: BooleanArray) = put(booleans, 0)

    infix fun put(numbers: Array<out Number>) = put(numbers, 0)
    infix fun put(chars: Array<Char>) = put(chars, 0)
    infix fun put(a: Array<Boolean>) = put(a, 0)

    infix fun put(list: List<Any>) = put(list, 0)

    infix fun put(bytes: ByteBuffer) = put(bytes, 0)
    infix fun put(chars: CharBuffer) = put(chars, 0)
    infix fun put(shorts: ShortBuffer) = put(shorts, 0)
    infix fun put(ints: IntBuffer) = put(ints, 0)
    infix fun put(longs: LongBuffer) = put(longs, 0)
    infix fun put(floats: FloatBuffer) = put(floats, 0)
    infix fun put(doubles: DoubleBuffer) = put(doubles, 0)

    infix fun put(s: Number) = put(s, s)
    abstract fun put(x: Number, y: Number): Vec2t<T>

    // -- indexed Generic Constructors --

    fun put(bytes: ByteArray, index: Int) = put(bytes[index], bytes[index + 1])
    fun put(chars: CharArray, index: Int) = put(chars[index].b, chars[index + 1].b)
    fun put(shorts: ShortArray, index: Int) = put(shorts[index], shorts[index + 1])
    fun put(ints: IntArray, index: Int) = put(ints[index], ints[index + 1])
    fun put(longs: LongArray, index: Int) = put(longs[index], longs[index + 1])
    fun put(floats: FloatArray, index: Int) = put(floats[index], floats[index + 1])
    fun put(doubles: DoubleArray, index: Int) = put(doubles[index], doubles[index + 1])
    fun put(booleans: BooleanArray, index: Int) = put(booleans[index].b, booleans[index + 1].b)

    fun put(a: Array<out Number>, index: Int) = put(a[index], a[index + 1])
    fun put(a: Array<Char>, index: Int) = put(a[index].b, a[index + 1].b)
    fun put(a: Array<Boolean>, index: Int) = put(a[index].b, a[index + 1].b)

    fun put(list: List<Any>, index: Int) {
        val a = list[index]
        val b = list[index + 1]
        when {
            a is Number && b is Number -> put(a, b)
            a is Char && b is Char -> put(a.b, b.b)
            a is Boolean && b is Boolean -> put(a.b, b.b)
            a is String && b is String ->
                when {
                    x is Byte && y is Byte -> put(a.b, b.b)
                    x is Short && y is Short -> put(a.s, b.s)
                    x is Int && y is Int -> put(a.i, b.i)
                    x is Long && y is Long -> put(a.L, b.L)
                    x is Float && y is Float -> put(a.f, b.f)
                    x is Double && y is Double -> put(a.d, b.d)
                    else -> throw ArithmeticException("incompatible type")
                }
            else -> throw ArithmeticException("incompatible type")
        }
    }

    fun put(bytes: ByteBuffer, index: Int) = put(bytes[index], bytes[index + 1])
    fun put(chars: CharBuffer, index: Int) = put(chars[index].b, chars[index + 1].b)
    fun put(shorts: ShortBuffer, index: Int) = put(shorts[index], shorts[index + 1])
    fun put(ints: IntBuffer, index: Int) = put(ints[index], ints[index + 1])
    fun put(longs: LongBuffer, index: Int) = put(longs[index], longs[index + 1])
    fun put(floats: FloatBuffer, index: Int) = put(floats[index], floats[index + 1])
    fun put(doubles: DoubleBuffer, index: Int) = put(doubles[index], doubles[index + 1])


    infix fun lessThan(b: Vec2t<out Number>) = glm.lessThan(this, b, Vec2bool())
    fun lessThan(b: Vec2t<out Number>, res: Vec2bool = Vec2bool()) = glm.lessThan(this, b, res)

    infix fun lessThanEqual(b: Vec2t<out Number>) = glm.lessThan(this, b, Vec2bool())
    fun lessThanEqual(b: Vec2t<out Number>, res: Vec2bool = Vec2bool()) = glm.lessThan(this, b, res)

    infix fun greaterThan(b: Vec2t<out Number>) = glm.greaterThan(this, b, Vec2bool())
    fun greaterThan(b: Vec2t<out Number>, res: Vec2bool = Vec2bool()) = glm.greaterThan(this, b, res)

    infix fun greaterThanEqual(b: Vec2t<out Number>) = glm.greaterThanEqual(this, b, Vec2bool())
    fun greaterThanEqual(b: Vec2t<out Number>, res: Vec2bool = Vec2bool()) = glm.greaterThanEqual(this, b, res)

    infix fun equal(b: Vec2t<out Number>) = glm.equal(this, b, Vec2bool())
    fun equal(b: Vec2t<out Number>, res: Vec2bool = Vec2bool()) = glm.equal(this, b, res)

    infix fun notEqual(b: Vec2t<out Number>) = glm.notEqual(this, b, Vec2bool())
    fun notEqual(b: Vec2t<out Number>, res: Vec2bool = Vec2bool()) = glm.notEqual(this, b, res)

    infix fun isEqual(b: Vec2t<out Number>) = glm.isEqual(this, b)


    companion object {
        @JvmField val length = 2
    }


    operator fun component1() = x
    operator fun component2() = y

    override fun toString() = "($x, $y)"

    // component alias
    var r
        @JvmName("r") get() = x
        @JvmName("r") set(value) {
            x = value
        }


    var g
        @JvmName("g") get() = y
        @JvmName("g") set(value) {
            y = value
        }
    var s
        @JvmName("s") get() = x
        @JvmName("s") set(value) {
            x = value
        }

    var t
        @JvmName("t") get() = y
        @JvmName("t") set(value) {
            y = value
        }

    // swizzling
    val xx @JvmName("xx") get() = when (this) {
        is Vec2 -> Vec2(x, x)
        is Vec2d -> Vec2d(x, x)
        is Vec2b -> Vec2b(x, x)
        is Vec2i -> Vec2i(x, x)
        is Vec2s -> Vec2s(x, x)
        is Vec2l -> Vec2l(x, x)
        is Vec2ub -> Vec2ub(x, x)
        is Vec2ui -> Vec2ui(x, x)
        is Vec2us -> Vec2us(x, x)
        is Vec2ul -> Vec2ul(x, x)
        else -> throw IllegalStateException()
    }
    var xy @JvmName("xy") get() = when (this) {
        is Vec2 -> Vec2(this)
        is Vec2d -> Vec2d(this)
        is Vec2b -> Vec2b(this)
        is Vec2i -> Vec2i(this)
        is Vec2s -> Vec2s(this)
        is Vec2l -> Vec2l(this)
        is Vec2ub -> Vec2ub(this)
        is Vec2ui -> Vec2ui(this)
        is Vec2us -> Vec2us(this)
        is Vec2ul -> Vec2ul(this)
        else -> throw IllegalStateException()
    }
        @JvmName("xy") set(value) {
            x = value.x as T
            y = value.y as T
        }
    var yx @JvmName("yx") get() = when (this) {
        is Vec2 -> Vec2(y, x)
        is Vec2d -> Vec2d(y, x)
        is Vec2b -> Vec2b(y, x)
        is Vec2i -> Vec2i(y, x)
        is Vec2s -> Vec2s(y, x)
        is Vec2l -> Vec2l(y, x)
        is Vec2ub -> Vec2ub(y, x)
        is Vec2ui -> Vec2ui(y, x)
        is Vec2us -> Vec2us(y, x)
        is Vec2ul -> Vec2ul(y, x)
        else -> throw IllegalStateException()
    }
        @JvmName("yx") set(value) {
            y = value.x as T
            x = value.y as T
        }
    val yy @JvmName("yy") get() = when (this) {
        is Vec2 -> Vec2(y, y)
        is Vec2d -> Vec2d(y, y)
        is Vec2b -> Vec2b(y, y)
        is Vec2i -> Vec2i(y, y)
        is Vec2s -> Vec2s(y, y)
        is Vec2l -> Vec2l(y, y)
        is Vec2ub -> Vec2ub(y, y)
        is Vec2ui -> Vec2ui(y, y)
        is Vec2us -> Vec2us(y, y)
        is Vec2ul -> Vec2ul(y, y)
        else -> throw IllegalStateException()
    }
}