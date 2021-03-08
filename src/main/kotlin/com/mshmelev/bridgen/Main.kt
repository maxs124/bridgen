package com.mshmelev.bridgen

import br.com.devsrsouza.kotlinbukkitapi.architecture.KotlinPlugin
import com.mshmelev.bridgen.commands.BridgenCommand
import com.mshmelev.bridgen.events.BlockPlaceEvent
import com.mshmelev.bridgen.events.OnFallEvent
import org.bukkit.Location
import org.bukkit.block.Block
import org.bukkit.entity.Player

class Main : KotlinPlugin() {
    companion object {
        var activated: Boolean = false
        var spawn: Location? = null
        var commandsender: Player? = null
        var placedBlocks: MutableList<Block> = mutableListOf()
        var fail = 5.0
    }

    override fun onPluginEnable() {
        BridgenCommand(this).bridgen()
        OnFallEvent(this)
        BlockPlaceEvent(this)
    }

    override fun onPluginDisable() {

    }
}