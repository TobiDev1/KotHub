package dev.qv7_.scoreboard;

import dev.qv7_.KotHub;
import dev.qv7_.scoreboard.assamble.AssembleAdapter;
import dev.qv7_.util.CC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 7qv_ on 7/2/2022.
 * @project KotHub
 */
public class ScoreBoardProvider implements AssembleAdapter {

    @Override
    public String getTitle(Player player) {
        return CC.translate("&d&lKotHub");
    }

    @Override
    public List<String> getLines(Player player) {
        final List<String> toReturn = new ArrayList<>();
        toReturn.add("&7&m--------------------");
        toReturn.add("&d&lPlayer&7: &f" + player.getName());
        toReturn.add("&d&lOnline&7: &f" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getServer().getMaxPlayers());
        toReturn.add("&d&lRank&7: None");
        toReturn.add("&7&m--------------------");

        return toReturn;
    }

}