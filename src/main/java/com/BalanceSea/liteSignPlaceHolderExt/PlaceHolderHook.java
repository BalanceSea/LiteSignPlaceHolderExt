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

        Ext ext = LiteSignPlaceHolderExt.getExt(player);
        if (ext != null) {
            return switch (params.toLowerCase()) {
                case "lastyear" -> String.valueOf(ext.getLastYear());
                case "lastmonth" -> String.valueOf(ext.getLastMonth());
                case "nextyear" -> String.valueOf(ext.getNextYear());
                case "nextmonth" -> String.valueOf(ext.getNextMonth());
                default -> "";
            };
        }

        if (params.equalsIgnoreCase("test")) {
            return "2025-12-26";
        }
        return "";
    }
}
