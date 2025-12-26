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
        // Plugin shutdown logic
    }

    @EventHandler
    public void onPlayerOpenGui(SignInGUIOpenEvent event){
        int month = event.getInventory().getPreviousPageMonth();

        int year = event.getInventory().getPreviousPageYear();

        Ext ext = new Ext(year,month);

        Player player = event.getPlayer();

        signInDays.put(player.getUniqueId(),ext);

        //getLogger().info(ext.toString());

        //getLogger().info(signInDays.toString());
    }

/**
 * 处理玩家关闭GUI界面的事件
 * 当玩家关闭签到GUI时，从签到天数记录中移除该玩家的记录
 *

    @EventHandler
    public void onPlayerCloseGui(SignInGUICloseEvent event){
    // 从签到天数记录中移除触发事件的玩家
    // 使用玩家的唯一标识符(UUID)作为键来移除对应的记录
        signInDays.remove(event.getPlayer().getUniqueId());
    }
 */
    public static Ext getExt(Player player){
        return signInDays.get(player.getUniqueId());
    }
}
