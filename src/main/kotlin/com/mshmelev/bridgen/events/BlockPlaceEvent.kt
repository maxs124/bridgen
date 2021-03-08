package com.mshmelev.bridgen.events

import br.com.devsrsouza.kotlinbukkitapi.extensions.event.KListener
import br.com.devsrsouza.kotlinbukkitapi.extensions.event.event
import br.com.devsrsouza.kotlinbukkitapi.extensions.event.events
import com.mshmelev.bridgen.Main
import com.mshmelev.bridgen.Main.Companion.activated
import com.mshmelev.bridgen.Main.Companion.placedBlocks
import com.mshmelev.bridgen.Main.Companion.commandsender
import org.bukkit.event.block.BlockPlaceEvent

/**
 * Created by mshmelev on 3/8/21
 */
class BlockPlaceEvent(override val plugin: Main): KListener<Main> {
    init {
        events {
            event<BlockPlaceEvent> {
                val player = this.player

                if (commandsender == player && activated) {
                    placedBlocks.add(this.block)
                }
            }
        }
    }
}