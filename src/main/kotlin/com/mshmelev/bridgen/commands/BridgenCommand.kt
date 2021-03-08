package com.mshmelev.bridgen.commands

import br.com.devsrsouza.kotlinbukkitapi.dsl.command.arguments.double
import br.com.devsrsouza.kotlinbukkitapi.dsl.command.arguments.int
import br.com.devsrsouza.kotlinbukkitapi.dsl.command.arguments.string
import br.com.devsrsouza.kotlinbukkitapi.dsl.command.command
import br.com.devsrsouza.kotlinbukkitapi.dsl.command.simpleCommand
import br.com.devsrsouza.kotlinbukkitapi.extensions.text.color
import br.com.devsrsouza.kotlinbukkitapi.extensions.text.msg
import com.mshmelev.bridgen.Main
import com.mshmelev.bridgen.Main.Companion.activated
import com.mshmelev.bridgen.Main.Companion.commandsender
import com.mshmelev.bridgen.Main.Companion.fail
import com.mshmelev.bridgen.Main.Companion.spawn
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

/**
 * Created by mshmelev on 2/27/21
 */
class BridgenCommand(private val plugin: Main) {

    fun bridgen() = plugin.command("bridgen") {
        executor {
            val player = sender as Player
            if (!activated) {
                activated = true
                spawn = player.location
                commandsender = player
                player.inventory.setItem(0, ItemStack(Material.SANDSTONE, 64))
                player.inventory.setItem(1, ItemStack(Material.SANDSTONE, 64))
                sender.msg("Bridging mode has been activated.".color(ChatColor.BOLD).color(ChatColor.AQUA))
                sender.msg("You will be teleported back to your current location when you pass the fail level.")
                sender.msg("Use this command again to disable bridging mode.")
            } else {
                activated = false
                sender.msg("Bridging mode has been deactivated.".color(ChatColor.BOLD).color(ChatColor.AQUA))
            }
        }

    }
}