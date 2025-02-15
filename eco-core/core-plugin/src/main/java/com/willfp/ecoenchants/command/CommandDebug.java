package com.willfp.ecoenchants.command;

import com.willfp.eco.core.command.CommandHandler;
import com.willfp.eco.core.command.impl.Subcommand;
import com.willfp.ecoenchants.EcoEnchantsPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

@SuppressWarnings({"unchecked", "deprecation"})
public class CommandDebug extends Subcommand {
    /**
     * Instantiate a new /ecoenchants debug command handler.
     *
     * @param plugin The plugin for the commands to listen for.
     */
    public CommandDebug(@NotNull final EcoEnchantsPlugin plugin) {
        super(plugin, "debug", "ecoenchants.command.debug", true);
    }

    @Override
    public CommandHandler getHandler() {
        return (sender, args) -> {
            Player player = (Player) sender;
            player.sendMessage("Held Item: " + player.getInventory().getItemInMainHand());
            player.sendMessage("Lore: ");
            Bukkit.getLogger().info("");

            Bukkit.getLogger().info("Held Item: " + player.getInventory().getItemInMainHand());
            Bukkit.getLogger().info("Lore: ");
            ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
            if (meta != null) {
                for (String s : new ArrayList<>(meta.hasLore() ? meta.getLore() : new ArrayList<>())) {
                    Bukkit.getLogger().info(s);
                    player.sendMessage(s);
                }
            }
            Bukkit.getLogger().info("");
        };
    }
}
