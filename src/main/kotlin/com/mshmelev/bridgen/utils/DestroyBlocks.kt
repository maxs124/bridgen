package com.mshmelev.bridgen.utils

import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.block.Block

/**
 * Created by mshmelev on 3/8/21
 */
class DestroyBlocks {
    fun destroy(blks: MutableList<Block>) {
        blks.forEach { it.type = Material.AIR }
    }
}