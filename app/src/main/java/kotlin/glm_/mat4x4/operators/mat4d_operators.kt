package  glm_.mat4x4.operators

import glm_.mat2x4.Mat2x4d
import glm_.mat3x4.Mat3x4d
import glm_.mat4x4.Mat4d
import glm_.mat4x4.Mat4d.Companion.div
import glm_.mat4x4.Mat4d.Companion.minus
import glm_.mat4x4.Mat4d.Companion.plus
import glm_.mat4x4.Mat4d.Companion.times
import glm_.vec4.Vec4d
import glm_.vec4.Vec4d.Companion.div
import glm_.vec4.Vec4d.Companion.minus
import glm_.vec4.Vec4d.Companion.plus
import glm_.vec4.Vec4d.Companion.times

/**
 * Created by GBarbieri on 10.11.2016.
 */
interface mat4d_operators {


    fun plus(res: Mat4d, a: Mat4d, b: Double): Mat4d {
        plus(res[0], a[0], b, b, b, b)
        plus(res[1], a[1], b, b, b, b)
        plus(res[2], a[2], b, b, b, b)
        plus(res[3], a[3], b, b, b, b)
        return res
    }

    fun plus(res: Mat4d, a: Mat4d, b: Mat4d): Mat4d {
        plus(res[0], a[0], b[0][0], b[0][1], b[0][2], b[0][3])
        plus(res[1], a[1], b[1][0], b[1][1], b[1][2], b[1][3])
        plus(res[2], a[2], b[2][0], b[2][1], b[2][2], b[2][3])
        plus(res[3], a[3], b[3][0], b[3][1], b[3][2], b[3][3])
        return res
    }

    fun minus(res: Mat4d, a: Mat4d, b: Double): Mat4d {
        minus(res[0], a[0], b, b, b, b)
        minus(res[1], a[1], b, b, b, b)
        minus(res[2], a[2], b, b, b, b)
        minus(res[3], a[3], b, b, b, b)
        return res
    }

    fun minus(res: Mat4d, a: Double, b: Mat4d): Mat4d {
        minus(res[0], a, a, a, a, b[0])
        minus(res[1], a, a, a, a, b[1])
        minus(res[2], a, a, a, a, b[2])
        minus(res[3], a, a, a, a, b[3])
        return res
    }

    fun minus(res: Mat4d, a: Mat4d, b: Mat4d): Mat4d {
        minus(res[0], a[0], b[0][0], b[0][1], b[0][2], b[0][3])
        minus(res[1], a[1], b[1][0], b[1][1], b[1][2], b[1][3])
        minus(res[2], a[2], b[2][0], b[2][1], b[2][2], b[2][3])
        minus(res[3], a[3], b[3][0], b[3][1], b[3][2], b[3][3])
        return res
    }


    /**
     * [res] = [a] * [b]
     */
    fun times(res: Mat4d, a: Mat4d, b: Double): Mat4d {
        times(res[0], a[0], b, b, b, b)
        times(res[1], a[1], b, b, b, b)
        times(res[2], a[2], b, b, b, b)
        times(res[3], a[3], b, b, b, b)
        return res
    }

    fun times(res: Vec4d, a: Mat4d, b: Vec4d): Vec4d {
        res[0] = a[0][0] * b.x + a[1][0] * b.y + a[2][0] * b.z + a[3][0] * b.w
        res[1] = a[0][1] * b.x + a[1][1] * b.y + a[2][1] * b.z + a[3][1] * b.w
        res[2] = a[0][2] * b.x + a[1][2] * b.y + a[2][2] * b.z + a[3][2] * b.w
        res[3] = a[0][3] * b.x + a[1][3] * b.y + a[2][3] * b.z + a[3][3] * b.w
        return res
    }

    fun times(res: Vec4d, a: Vec4d, b: Mat4d): Vec4d {
        res[0] = a.x * b[0][0] + a.y * b[0][1] + a.z * b[0][2] + a.w * b[0][3]
        res[1] = a.x * b[1][0] + a.y * b[1][1] + a.z * b[1][2] + a.w * b[1][3]
        res[2] = a.x * b[2][0] + a.y * b[2][1] + a.z * b[2][2] + a.w * b[2][3]
        res[3] = a.x * b[3][0] + a.y * b[3][1] + a.z * b[3][2] + a.w * b[3][3]
        return res
    }

    fun times(res: Mat2x4d, a: Mat4d, b: Mat2x4d): Mat2x4d {
        val v00 = a[0][0] * b[0][0] + a[1][0] * b[0][1] + a[2][0] * b[0][2] + a[3][0] * b[0][3]
        val v01 = a[0][1] * b[0][0] + a[1][1] * b[0][1] + a[2][1] * b[0][2] + a[3][1] * b[0][3]
        val v02 = a[0][2] * b[0][0] + a[1][2] * b[0][1] + a[2][2] * b[0][2] + a[3][2] * b[0][3]
        val v03 = a[0][3] * b[0][0] + a[1][3] * b[0][1] + a[2][3] * b[0][2] + a[3][3] * b[0][3]
        val v10 = a[0][0] * b[1][0] + a[1][0] * b[1][1] + a[2][0] * b[1][2] + a[3][0] * b[1][3]
        val v11 = a[0][1] * b[1][0] + a[1][1] * b[1][1] + a[2][1] * b[1][2] + a[3][1] * b[1][3]
        val v12 = a[0][2] * b[1][0] + a[1][2] * b[1][1] + a[2][2] * b[1][2] + a[3][2] * b[1][3]
        val v13 = a[0][3] * b[1][0] + a[1][3] * b[1][1] + a[2][3] * b[1][2] + a[3][3] * b[1][3]
        res[0][0] = v00
        res[0][1] = v01
        res[0][2] = v02
        res[0][3] = v03
        res[1][0] = v10
        res[1][1] = v11
        res[1][2] = v12
        res[1][3] = v13
        return res
    }

    fun times(res: Mat3x4d, a: Mat4d, b: Mat3x4d): Mat3x4d {
        val v00 = a[0][0] * b[0][0] + a[1][0] * b[0][1] + a[2][0] * b[0][2] + a[3][0] * b[0][3]
        val v01 = a[0][1] * b[0][0] + a[1][1] * b[0][1] + a[2][1] * b[0][2] + a[3][1] * b[0][3]
        val v02 = a[0][2] * b[0][0] + a[1][2] * b[0][1] + a[2][2] * b[0][2] + a[3][2] * b[0][3]
        val v03 = a[0][3] * b[0][0] + a[1][3] * b[0][1] + a[2][3] * b[0][2] + a[3][3] * b[0][3]
        val v10 = a[0][0] * b[1][0] + a[1][0] * b[1][1] + a[2][0] * b[1][2] + a[3][0] * b[1][3]
        val v11 = a[0][1] * b[1][0] + a[1][1] * b[1][1] + a[2][1] * b[1][2] + a[3][1] * b[1][3]
        val v12 = a[0][2] * b[1][0] + a[1][2] * b[1][1] + a[2][2] * b[1][2] + a[3][2] * b[1][3]
        val v13 = a[0][3] * b[1][0] + a[1][3] * b[1][1] + a[2][3] * b[1][2] + a[3][3] * b[1][3]
        val v20 = a[0][0] * b[2][0] + a[1][0] * b[2][1] + a[2][0] * b[2][2] + a[3][0] * b[2][3]
        val v21 = a[0][1] * b[2][0] + a[1][1] * b[2][1] + a[2][1] * b[2][2] + a[3][1] * b[2][3]
        val v22 = a[0][2] * b[2][0] + a[1][2] * b[2][1] + a[2][2] * b[2][2] + a[3][2] * b[2][3]
        val v23 = a[0][3] * b[2][0] + a[1][3] * b[2][1] + a[2][3] * b[2][2] + a[3][3] * b[2][3]
        res[0][0] = v00
        res[0][1] = v01
        res[0][2] = v02
        res[0][3] = v03
        res[1][0] = v10
        res[1][1] = v11
        res[1][2] = v12
        res[1][3] = v13
        res[2][0] = v20
        res[2][1] = v21
        res[2][2] = v22
        res[2][3] = v23
        return res
    }

    fun times(res: Mat4d, a: Mat4d, b: Mat4d): Mat4d {
        val v00 = a[0][0] * b[0][0] + a[1][0] * b[0][1] + a[2][0] * b[0][2] + a[3][0] * b[0][3]
        val v01 = a[0][1] * b[0][0] + a[1][1] * b[0][1] + a[2][1] * b[0][2] + a[3][1] * b[0][3]
        val v02 = a[0][2] * b[0][0] + a[1][2] * b[0][1] + a[2][2] * b[0][2] + a[3][2] * b[0][3]
        val v03 = a[0][3] * b[0][0] + a[1][3] * b[0][1] + a[2][3] * b[0][2] + a[3][3] * b[0][3]
        val v10 = a[0][0] * b[1][0] + a[1][0] * b[1][1] + a[2][0] * b[1][2] + a[3][0] * b[1][3]
        val v11 = a[0][1] * b[1][0] + a[1][1] * b[1][1] + a[2][1] * b[1][2] + a[3][1] * b[1][3]
        val v12 = a[0][2] * b[1][0] + a[1][2] * b[1][1] + a[2][2] * b[1][2] + a[3][2] * b[1][3]
        val v13 = a[0][3] * b[1][0] + a[1][3] * b[1][1] + a[2][3] * b[1][2] + a[3][3] * b[1][3]
        val v20 = a[0][0] * b[2][0] + a[1][0] * b[2][1] + a[2][0] * b[2][2] + a[3][0] * b[2][3]
        val v21 = a[0][1] * b[2][0] + a[1][1] * b[2][1] + a[2][1] * b[2][2] + a[3][1] * b[2][3]
        val v22 = a[0][2] * b[2][0] + a[1][2] * b[2][1] + a[2][2] * b[2][2] + a[3][2] * b[2][3]
        val v23 = a[0][3] * b[2][0] + a[1][3] * b[2][1] + a[2][3] * b[2][2] + a[3][3] * b[2][3]
        val v30 = a[0][0] * b[3][0] + a[1][0] * b[3][1] + a[2][0] * b[3][2] + a[3][0] * b[3][3]
        val v31 = a[0][1] * b[3][0] + a[1][1] * b[3][1] + a[2][1] * b[3][2] + a[3][1] * b[3][3]
        val v32 = a[0][2] * b[3][0] + a[1][2] * b[3][1] + a[2][2] * b[3][2] + a[3][2] * b[3][3]
        val v33 = a[0][3] * b[3][0] + a[1][3] * b[3][1] + a[2][3] * b[3][2] + a[3][3] * b[3][3]
        res[0][0] = v00
        res[0][1] = v01
        res[0][2] = v02
        res[0][3] = v03
        res[1][0] = v10
        res[1][1] = v11
        res[1][2] = v12
        res[1][3] = v13
        res[2][0] = v20
        res[2][1] = v21
        res[2][2] = v22
        res[2][3] = v23
        res[3][0] = v30
        res[3][1] = v31
        res[3][2] = v32
        res[3][3] = v33
        return res
    }


    fun div(res: Mat4d, a: Mat4d, b: Double): Mat4d {
        div(res[0], a[0], b, b, b, b)
        div(res[1], a[1], b, b, b, b)
        div(res[2], a[2], b, b, b, b)
        div(res[3], a[3], b, b, b, b)
        return res
    }

    fun div(res: Mat4d, a: Double, b: Mat4d): Mat4d {
        div(res[0], a, a, a, a, b[0])
        div(res[1], a, a, a, a, b[1])
        div(res[2], a, a, a, a, b[2])
        div(res[3], a, a, a, a, b[3])
        return res
    }

    fun div(res: Vec4d, a: Mat4d, b: Vec4d): Vec4d {

        // invert a
        val c00 = a[2][2] * a[3][3] - a[3][2] * a[2][3]
        val c02 = a[1][2] * a[3][3] - a[3][2] * a[1][3]
        val c03 = a[1][2] * a[2][3] - a[2][2] * a[1][3]

        val c04 = a[2][1] * a[3][3] - a[3][1] * a[2][3]
        val c06 = a[1][1] * a[3][3] - a[3][1] * a[1][3]
        val c07 = a[1][1] * a[2][3] - a[2][1] * a[1][3]

        val c08 = a[2][1] * a[3][2] - a[3][1] * a[2][2]
        val c10 = a[1][1] * a[3][2] - a[3][1] * a[1][2]
        val c11 = a[1][1] * a[2][2] - a[2][1] * a[1][2]

        val c12 = a[2][0] * a[3][3] - a[3][0] * a[2][3]
        val c14 = a[1][0] * a[3][3] - a[3][0] * a[1][3]
        val c15 = a[1][0] * a[2][3] - a[2][0] * a[1][3]

        val c16 = a[2][0] * a[3][2] - a[3][0] * a[2][2]
        val c18 = a[1][0] * a[3][2] - a[3][0] * a[1][2]
        val c19 = a[1][0] * a[2][2] - a[2][0] * a[1][2]

        val c20 = a[2][0] * a[3][1] - a[3][0] * a[2][1]
        val c22 = a[1][0] * a[3][1] - a[3][0] * a[1][1]
        val c23 = a[1][0] * a[2][1] - a[2][0] * a[1][1]

        var i00 = +(a[1][1] * c00 - a[1][2] * c04 + a[1][3] * c08)
        var i01 = -(a[0][1] * c00 - a[0][2] * c04 + a[0][3] * c08)
        var i02 = +(a[0][1] * c02 - a[0][2] * c06 + a[0][3] * c10)
        var i03 = -(a[0][1] * c03 - a[0][2] * c07 + a[0][3] * c11)

        var i10 = -(a[1][0] * c00 - a[1][2] * c12 + a[1][3] * c16)
        var i11 = +(a[0][0] * c00 - a[0][2] * c12 + a[0][3] * c16)
        var i12 = -(a[0][0] * c02 - a[0][2] * c14 + a[0][3] * c18)
        var i13 = +(a[0][0] * c03 - a[0][2] * c15 + a[0][3] * c19)

        var i20 = +(a[1][0] * c04 - a[1][1] * c12 + a[1][3] * c20)
        var i21 = -(a[0][0] * c04 - a[0][1] * c12 + a[0][3] * c20)
        var i22 = +(a[0][0] * c06 - a[0][1] * c14 + a[0][3] * c22)
        var i23 = -(a[0][0] * c07 - a[0][1] * c15 + a[0][3] * c23)

        var i30 = -(a[1][0] * c08 - a[1][1] * c16 + a[1][2] * c20)
        var i31 = +(a[0][0] * c08 - a[0][1] * c16 + a[0][2] * c20)
        var i32 = -(a[0][0] * c10 - a[0][1] * c18 + a[0][2] * c22)
        var i33 = +(a[0][0] * c11 - a[0][1] * c19 + a[0][2] * c23)

        val oneOverDet = 1 / (a[0][0] * i00 + a[0][1] * i10 + a[0][2] * i20 + a[0][3] * i30)

        i00 *= oneOverDet
        i01 *= oneOverDet
        i02 *= oneOverDet
        i03 *= oneOverDet

        i10 *= oneOverDet
        i11 *= oneOverDet
        i12 *= oneOverDet
        i13 *= oneOverDet

        i20 *= oneOverDet
        i21 *= oneOverDet
        i22 *= oneOverDet
        i23 *= oneOverDet

        i30 *= oneOverDet
        i31 *= oneOverDet
        i32 *= oneOverDet
        i33 *= oneOverDet

        // a * main.getB
        res[0] = i00 * b.x + i10 * b.y + i20 * b.z + i30 * b.w
        res[1] = i01 * b.x + i11 * b.y + i21 * b.z + i31 * b.w
        res[2] = i02 * b.x + i12 * b.y + i22 * b.z + i32 * b.w
        res[3] = i03 * b.x + i13 * b.y + i23 * b.z + i33 * b.w

        return res
    }

    fun div(res: Vec4d, a: Vec4d, b: Mat4d): Vec4d {

        // invert main.getB
        val c00 = b[2][2] * b[3][3] - b[3][2] * b[2][3]
        val c02 = b[1][2] * b[3][3] - b[3][2] * b[1][3]
        val c03 = b[1][2] * b[2][3] - b[2][2] * b[1][3]

        val c04 = b[2][1] * b[3][3] - b[3][1] * b[2][3]
        val c06 = b[1][1] * b[3][3] - b[3][1] * b[1][3]
        val c07 = b[1][1] * b[2][3] - b[2][1] * b[1][3]

        val c08 = b[2][1] * b[3][2] - b[3][1] * b[2][2]
        val c10 = b[1][1] * b[3][2] - b[3][1] * b[1][2]
        val c11 = b[1][1] * b[2][2] - b[2][1] * b[1][2]

        val c12 = b[2][0] * b[3][3] - b[3][0] * b[2][3]
        val c14 = b[1][0] * b[3][3] - b[3][0] * b[1][3]
        val c15 = b[1][0] * b[2][3] - b[2][0] * b[1][3]

        val c16 = b[2][0] * b[3][2] - b[3][0] * b[2][2]
        val c18 = b[1][0] * b[3][2] - b[3][0] * b[1][2]
        val c19 = b[1][0] * b[2][2] - b[2][0] * b[1][2]

        val c20 = b[2][0] * b[3][1] - b[3][0] * b[2][1]
        val c22 = b[1][0] * b[3][1] - b[3][0] * b[1][1]
        val c23 = b[1][0] * b[2][1] - b[2][0] * b[1][1]

        var i00 = +(b[1][1] * c00 - b[1][2] * c04 + b[1][3] * c08)
        var i01 = -(b[0][1] * c00 - b[0][2] * c04 + b[0][3] * c08)
        var i02 = +(b[0][1] * c02 - b[0][2] * c06 + b[0][3] * c10)
        var i03 = -(b[0][1] * c03 - b[0][2] * c07 + b[0][3] * c11)

        var i10 = -(b[1][0] * c00 - b[1][2] * c12 + b[1][3] * c16)
        var i11 = +(b[0][0] * c00 - b[0][2] * c12 + b[0][3] * c16)
        var i12 = -(b[0][0] * c02 - b[0][2] * c14 + b[0][3] * c18)
        var i13 = +(b[0][0] * c03 - b[0][2] * c15 + b[0][3] * c19)

        var i20 = +(b[1][0] * c04 - b[1][1] * c12 + b[1][3] * c20)
        var i21 = -(b[0][0] * c04 - b[0][1] * c12 + b[0][3] * c20)
        var i22 = +(b[0][0] * c06 - b[0][1] * c14 + b[0][3] * c22)
        var i23 = -(b[0][0] * c07 - b[0][1] * c15 + b[0][3] * c23)

        var i30 = -(b[1][0] * c08 - b[1][1] * c16 + b[1][2] * c20)
        var i31 = +(b[0][0] * c08 - b[0][1] * c16 + b[0][2] * c20)
        var i32 = -(b[0][0] * c10 - b[0][1] * c18 + b[0][2] * c22)
        var i33 = +(b[0][0] * c11 - b[0][1] * c19 + b[0][2] * c23)

        val oneOverDet = 1 / (b[0][0] * i00 + b[0][1] * i10 + b[0][2] * i20 + b[0][3] * i30)

        i00 *= oneOverDet
        i01 *= oneOverDet
        i02 *= oneOverDet
        i03 *= oneOverDet

        i10 *= oneOverDet
        i11 *= oneOverDet
        i12 *= oneOverDet
        i13 *= oneOverDet

        i20 *= oneOverDet
        i21 *= oneOverDet
        i22 *= oneOverDet
        i23 *= oneOverDet

        i30 *= oneOverDet
        i31 *= oneOverDet
        i32 *= oneOverDet
        i33 *= oneOverDet

        // a * main.getB
        res[0] = a.x * i00 + a.y * i01 + a.z * i02 + a.w * i03
        res[1] = a.x * i10 + a.y * i11 + a.z * i12 + a.w * i13
        res[2] = a.x * i20 + a.y * i21 + a.z * i22 + a.w * i23
        res[3] = a.x * i30 + a.y * i31 + a.z * i32 + a.w * i33

        return res
    }

    fun div(res: Mat4d, a: Mat4d, b: Mat4d) = b.inverse(res) times_ a
}


// -- Specific binary arithmetic operators --

operator fun Double.plus(b: Mat4d) = plus(Mat4d(), b, this)
fun Double.plus(b: Mat4d, res: Mat4d = Mat4d()) = plus(res, b, this)
infix fun Double.plus_(b: Mat4d) = plus(b, b, this)

operator fun Double.minus(b: Mat4d) = minus(Mat4d(), this, b)
fun Double.minus(b: Mat4d, res: Mat4d = Mat4d()) = minus(res, this, b)
infix fun Double.minus_(b: Mat4d) = minus(b, this, b)

operator fun Double.times(b: Mat4d) = times(Mat4d(), b, this)
fun Double.times(b: Mat4d, res: Mat4d = Mat4d()) = times(res, b, this)
infix fun Double.times_(b: Mat4d) = times(b, b, this)

operator fun Vec4d.times(b: Mat4d) = times(Vec4d(), this, b)
fun Vec4d.times(b: Mat4d, res: Vec4d = Vec4d()) = times(res, this, b)
infix fun Vec4d.times_(b: Mat4d) = times(this, this, b)

operator fun Double.div(b: Mat4d) = div(Mat4d(), this, b)
fun Double.div(b: Mat4d, res: Mat4d = Mat4d()) = div(res, this, b)
infix fun Double.div_(b: Mat4d) = div(b, this, b)