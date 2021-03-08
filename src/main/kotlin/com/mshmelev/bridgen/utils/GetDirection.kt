package com.mshmelev.bridgen.utils

import org.bukkit.Location

/**
 * Created by mshmelev on 3/8/21
 */
class GetDirection {
    fun getCardinalDirection(loc: Location): Float? {
        val north = 0F
        val south = 180F
        val west = 270F
        val east = 90F

        val directions = floatArrayOf(0F, 180F, 270F, 90F)

        var rotation = loc.yaw

        val closest = java.util.Arrays.binarySearch(directions, rotation)

        println(closest)


//        var rotation = (loc.yaw - 90.0) % 360.0
//
//        if (rotation < 0.0) {
//            rotation += 360.0
//        }
//        when {
//            ((0.0 <= rotation) && (rotation < 45.0)) -> return 270F
//            ((45.0 <= rotation) && (rotation < 135.0)) -> return 0F
//            ((135.0 <= rotation) && (rotation < 225.0)) -> return 90F
//            ((225.0 <= rotation) && (rotation < 315.0)) -> return 180F
//            ((315.0 <= rotation) && (rotation < 360.0)) -> return 270F
//        }

        return null
    }
}
