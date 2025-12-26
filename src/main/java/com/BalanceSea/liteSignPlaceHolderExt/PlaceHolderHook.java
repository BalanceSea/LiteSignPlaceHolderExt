package com.BalanceSea.liteSignPlaceHolderExt;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class PlaceHolderHook extends PlaceholderExpansion {
    @NotNull
    @Override
    public String getIdentifier() {
        return "litesignext";
    }

    @NotNull
    @Override
    public String getAuthor() {
        return "山海";
    }

    @NotNull
    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public boolean persist(){
        return true;
    }

    @Override
    public boolean canRegister(){
        return true;
    }

    @Override
    public String onPlaceholderRequest(Player player,@NotNull String params){

        if (params.equalsIgnoreCase("year")){
            Ext ext = LiteSignPlaceHolderExt.getExt(player);
            if (ext != null) {
                return String.valueOf(ext.getYear());
            }
            //Bukkit.getLogger().info("获取年时ext类为null");
            return "";
        }
        if (params.equalsIgnoreCase("month")) {
            Ext ext = LiteSignPlaceHolderExt.getExt(player);
            if (ext != null) {
                return String.valueOf(ext.getMonth());
            }
            //Bukkit.getLogger().info("获取月时ext类为null");
            return "";
        }
        if (params.equalsIgnoreCase("test")) {
            return "2025-12-26";
        }
        return "";
    }
}
