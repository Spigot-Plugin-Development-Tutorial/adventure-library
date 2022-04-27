package me.kodysimpson.adventureapitutorial;

import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class AdventureAPITutorial extends JavaPlugin {

    private BukkitAudiences adventure;

    public @NonNull BukkitAudiences adventure() {
        if(this.adventure == null) {
            throw new IllegalStateException("Tried to access Adventure when the plugin was disabled!");
        }
        return this.adventure;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

        this.adventure = BukkitAudiences.create(this);

        getCommand("potato").setExecutor(new PotatoCommand(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
