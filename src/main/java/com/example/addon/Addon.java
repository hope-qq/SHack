package com.example.addon;

import com.example.addon.commands.CommandExample;
import com.example.addon.hud.HudExample;
import com.example.addon.modules.Prefix;
import com.example.addon.modules.SpammerPlus;
import com.mojang.logging.LogUtils;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.commands.Commands;
import meteordevelopment.meteorclient.systems.hud.Hud;
import meteordevelopment.meteorclient.systems.hud.HudGroup;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import org.slf4j.Logger;

public class Addon extends MeteorAddon {
    public static final Logger LOG = LogUtils.getLogger();
    public static final Category CATEGORY = new Category("Semeen Hack");
    public static final HudGroup HUD_GROUP = new HudGroup("Semeen Hack");

    @Override
    public void onInitialize() {
        LOG.info("[SemeenHack] Downloading rat...");
        LOG.info("[SemeenHack] Installing rat...");

        // Modules
        LOG.info("[SemeenHack] Initializing modules");

        Modules.get().add(new SpammerPlus());
        Modules.get().add(new Prefix());
        LOG.info("[SemeenHack] Initializing mudules is dome!");

        // Commands
        LOG.info("[SemeenHack] Initializing commands");
        Commands.add(new CommandExample());

        LOG.info("[SemeenHack] Initializing commands is done!");
        // HUD
        LOG.info("[SemeenHack] Initializing hud");

        Hud.get().register(HudExample.INFO);

        LOG.info("[SemeenHack] Initializing hud is done!");
        LOG.info("[SemeenHack] Initializing is OK! UoU");
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
    }

    @Override
    public String getPackage() {
        return "com.example.addon";
    }

}
