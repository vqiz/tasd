package dev.teammlg.vqiz.bwsw.commads;

import dev.teammlg.vqiz.bwsw.BWSW;
import dev.teammlg.vqiz.bwsw.handler.TeamHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Debug implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender.hasPermission("adas")){
            Player player = ((Player) commandSender);
            TeamHandler.teams.forEach(team -> {
                player.sendMessage(team.name);
                team.member.forEach(player1 -> {
                    player.sendMessage(player1.getName());
                });
            });
            player.sendMessage(BWSW.getInstance().aktivmap.bronzespawner.size() +  "");
            player.sendMessage(
            BWSW.getInstance().aktivmap.iron.size() + "");

        }
        return false;
    }
}
