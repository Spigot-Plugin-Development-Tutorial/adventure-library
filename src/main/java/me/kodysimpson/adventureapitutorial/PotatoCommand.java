package me.kodysimpson.adventureapitutorial;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PotatoCommand implements CommandExecutor {

    private final AdventureAPITutorial plugin;

    public PotatoCommand(AdventureAPITutorial plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player p){

            //Audience - Is a grouping of 0 or more viewers of some content
            //Content - Chat Components

            TextComponent message = Component.text("I enjoy eating potatoes")
                    .color(NamedTextColor.BLUE)
                    .append(Component.text(" and "))
                    .append(Component.text("I love potatoes")
                        .color(NamedTextColor.RED)
                        .decorate(TextDecoration.UNDERLINED))
                    .append(Component.text("!"));
            plugin.adventure().players().sendMessage(message);

            TextComponent textComponent = Component.text("You're a ")
                    .color(TextColor.color(0x443344))
                    .append(Component.text("Bunny", NamedTextColor.LIGHT_PURPLE))
                    .append(Component.text("! Press "))
                    .append(
                            Component.keybind("key.jump")
                                    .color(NamedTextColor.LIGHT_PURPLE)
                                    .decoration(TextDecoration.BOLD, true)
                                    .hoverEvent(HoverEvent.showText(Component.text("My favorite flavor is cheese.")))
                    )
                    .append(Component.text(" to jump!"));
            plugin.adventure().sender(sender).sendMessage(textComponent);

        }

        return true;
    }
}
