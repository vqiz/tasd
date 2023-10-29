package dev.teammlg.vqiz.bwsw.commads;

import dev.teammlg.vqiz.bwsw.BWSW;
import dev.teammlg.vqiz.bwsw.handler.StatsHandler;
import dev.teammlg.vqiz.bwsw.handler.User;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class stats implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = ((Player) commandSender);
        if (args.length == 0){
            User user = StatsHandler.getuser(player.getUniqueId());
            player.sendMessage(BWSW.prefix + "§8§m-----------------------");
            player.sendMessage("§6User §7: " + player.getName());
            player.sendMessage("§6Wins §7: " + user.wins);
            player.sendMessage("§6Looses §7: " + user.loos);
            player.sendMessage("§6Brokenbeds §7: " + user.brokenbeds);
            player.sendMessage("§6Kills §7: §7" + user.kills);
            player.sendMessage("§6Final Kills §7: " + user.finalkills);
            player.sendMessage("§6Final Deaths §7: " + user.finaldeaths);
            player.sendMessage("§6Rank §7: " + BWSW.getInstance().stats.getrankfromUUID("WINS", player.getUniqueId()));

        }
        return false;
    }
}
