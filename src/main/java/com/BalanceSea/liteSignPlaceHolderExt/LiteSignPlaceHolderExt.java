package com.BalanceSea.liteSignPlaceHolderExt;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import studio.trc.bukkit.litesignin.event.custom.SignInGUIOpenEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class LiteSignPlaceHolderExt extends JavaPlugin implements Listener {
    private static final Map<UUID, Ext> signInDays = new HashMap<>();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this,this);
        new PlaceHolderHook().register();
    }

    @Override
    public void onDisable() {
        signInDays.clear();
    }

    @EventHandler
    public void onPlayerOpenGui(SignInGUIOpenEvent event){
        int LastMonth = event.getInventory().getPreviousPageMonth();

        int LastYear = event.getInventory().getPreviousPageYear();

        int NextMonth = event.getInventory().getNextPageMonth();

        int NextYear = event.getInventory().getNextPageYear();

        Ext ext = new Ext(LastYear,LastMonth,NextYear,NextMonth);

        Player player = event.getPlayer();

        signInDays.put(player.getUniqueId(),ext);

    }


    public static Ext getExt(Player player){
        return signInDays.get(player.getUniqueId());
    }
}
