package glm_.quat

import glm_.glm.dot
import glm_.quat.Quat.Companion.times
import glm_.vec3.Vec3
import glm_.vec4.Vec4

/**
 * Created by GBarbieri on 13.12.2016.
 */

interface quat_operators {

    fun plus(res: Quat, a: Quat, b: Quat): Quat {
        res.w = a.w + b.w
        res.x = a.x + b.x
        res.y = a.y + b.y
        res.z = a.z + b.z
        return res
    }


    fun minus(res: Quat, a: Quat, b: Quat): Quat {
        res.w = a.w - b.w
        res.x = a.x - b.x
        res.y = a.y - b.y
        res.z = a.z - b.z
        return res
    }


    fun times(res: Quat, a: Quat, b: Quat): Quat {
        val resW = a.w * b.w - a.x * b.x - a.y * b.y - a.z * b.z
        val resX = a.w * b.x + a.x * b.w + a.y * b.z - a.z * b.y
        val resY = a.w * b.y + a.y * b.w + a.z * b.x - a.x * b.z
        val resZ = a.w * b.z + a.z * b.w + a.x * b.y - a.y * b.x
        return res.put(resW, resX, resY, resZ)
    }

    fun times(res: Quat, a: Quat, b: Float): Quat {
        res.w = a.w * b
        res.x = a.x * b
        res.y = a.y * b
        res.z = a.z * b
        return res
    }

    fun times(res: Vec3, a: Quat, b: Vec3): Vec3 {
        val uvX = a.y * b.z - b.y * a.z
        val uvY = a.z * b.x - b.z * a.x
        val uvZ = a.x * b.y - b.x * a.y
        val uuvX = a.y * uvZ - uvY * a.z
        val uuvY = a.z * uvX - uvZ * a.x
        val uuvZ = a.x * uvY - uvX * a.y
        res.x = b.x + (uvX * a.w + uuvX) * 2f
        res.y = b.y + (uvY * a.w + uuvY) * 2f
        res.z = b.z + (uvZ * a.w + uuvZ) * 2f
        return res
    }

    fun times(res: Vec3, a: Vec3, b: Quat): Vec3 {
        val dot = dot(a, a)
        val iW = b.w / dot
        val iX = -b.x / dot
        val iY = -b.y / dot
        val iZ = -b.z / dot
        val uvX = iY * a.z - a.y * iZ
        val uvY = iZ * a.x - a.z * iX
        val uvZ = iX * a.y - a.x * iY
        val uuvX = iY * uvZ - uvY * iZ
        val uuvY = iZ * uvX - uvZ * iX
        val uuvZ = iX * uvY - uvX * iY
        res.x = a.x + (uvX * iW + uuvX) * 2f
        res.y = a.y + (uvY * iW + uuvY) * 2f
        res.z = a.z + (uvZ * iW + uuvZ) * 2f
        return res
    }

    fun times(res: Quat, a: Quat, b: Vec4): Quat {
        res.w = a.w
        res.x = a.x * b.x
        res.y = a.y * b.y
        res.z = a.z * b.z
        return res
    }

    fun div(res: Quat, a: Quat, b: Float): Quat {
        res.w = a.w / b
        res.x = a.x / b
        res.y = a.y / b
        res.z = a.z / b
        return res
    }
}


infix operator fun Float.times(b: Quat) = times(Quat(), b, this)
infix operator fun Vec3.times(b: Quat) = times(Vec3(), this, b)
infix operator fun Vec4.times(b: Quat) = times(Quat(), b, this)