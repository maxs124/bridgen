package com.mshmelev.bridgen.events

import br.com.devsrsouza.kotlinbukkitapi.extensions.event.KListener
import br.com.devsrsouza.kotlinbukkitapi.extensions.event.event
import com.mshmelev.bridgen.Main
import com.mshmelev.bridgen.Main.Companion.activated
import com.mshmelev.bridgen.Main.Companion.fail
import com.mshmelev.bridgen.Main.Companion.placedBlocks
import com.mshmelev.bridgen.Main.Companion.spawn
import com.mshmelev.bridgen.utils.DestroyBlocks
import org.bukkit.Material
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.inventory.ItemStack

/**
 * Created by mshmelev on 3/8/21
 */
class OnFallEvent(override val plugin: Main) : KListener<Main> {
    init {
        event<PlayerMoveEvent> {
            val player = this.player
            if (activated) {
                if (player.location.y < spawn!!.y.minus(fail)) {
                    val location = spawn!!.clone()
                    location.pitch = 0F
                    location.yaw = 0F
                    player.teleport(location)

                    //Destroy Placed Blocks
                    DestroyBlocks().destroy(placedBlocks)
                    placedBlocks = mutableListOf()

                    //Replenish Blocks
                    player.inventory.setItem(0, ItemStack(Material.SANDSTONE, 64))
                    player.inventory.setItem(1, ItemStack(Material.SANDSTONE, 64))
                }
            }
        }
    }
}