package dev.teammlg.vqiz.bwsw.commads;

import dev.teammlg.vqiz.bwsw.BWSW;
import dev.teammlg.vqiz.bwsw.Utils.LocationManager;
import dev.teammlg.vqiz.bwsw.Utils.Mode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.checkerframework.checker.units.qual.A;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.ArrayList;

public class Setup implements CommandExecutor {
     String name;
     Location specspawn;
     Location bluespawn;
     Location bluebed1;
     Location bluebed2;

     Location redspawn;
     Location redbed1;
     Location redbed2;
     Location greenspawn;
     Location greenbed1;
     Location greenbed2;

     Location yellowspawn;
     Location yellowbed1;
     Location yellowbed2;
     Location deathheight;
     ArrayList<Location> gold = new ArrayList<>();
    ArrayList<Location> iron = new ArrayList<>();
    ArrayList<Location> bronze = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = ((Player) commandSender);
        if (player.hasPermission("do")){
            if (args.length == 2 && args[0].equalsIgnoreCase("add")){
                name = args[1];
                player.sendMessage("done");


            }
            if (args.length == 1){
                if (args[0].equalsIgnoreCase("lobby")){
                    LocationManager.setcfg(BWSW.getInstance().config, null);
                    try {
                        LocationManager.setLocation("lobbyspawn", player.getLocation());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                }
                if (args[0].equalsIgnoreCase("specspawn")){
                    specspawn = player.getLocation();
                    player.sendMessage("done");
                }
                if (args[0].equalsIgnoreCase("bluespawn")){
                    bluespawn = player.getLocation();
                    player.sendMessage("done");
                }
                if (args[0].equalsIgnoreCase("redspawn")){
                    redspawn = player.getLocation();
                    player.sendMessage("done");
                }
                if (args[0].equalsIgnoreCase("yellowspawn")){
                    yellowspawn = player.getLocation();
                    player.sendMessage("done");
                }
                if (args[0].equalsIgnoreCase("deathheight")){
                    deathheight = player.getLocation();
                    player.sendMessage("done");
                }
                if (args[0].equalsIgnoreCase("greenspawn")){
                    greenspawn = player.getLocation();
                    player.sendMessage("done");
                }
                if (args[0].equalsIgnoreCase("ironspawn")){
                    iron.add(player.getLocation());
                    player.sendMessage("done");
                }
                if (args[0].equalsIgnoreCase("bronze")){
                    bronze.add(player.getLocation());
                    player.sendMessage("done");
                }
                if (args[0].equalsIgnoreCase("gold")){
                    gold.add(player.getLocation());
                    player.sendMessage("done");
                }
                if (args[0].equalsIgnoreCase("execute")){
                    try {
                        Mapcreator.execute(name, specspawn,bluespawn, bluebed1, bluebed2, redspawn, redbed1,redbed2,greenspawn, greenbed1, greenbed2, yellowspawn, yellowbed1, yellowbed2, deathheight, bronze, iron, gold);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    player.sendMessage("done");
                }

            }
            if (args.length == 4){
                if (args[0].equalsIgnoreCase("bluebed1")){
                    bluebed1 = new Location(player.getWorld(), Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]));
                    player.sendMessage("done");

                }
                if (args[0].equalsIgnoreCase("bluebed2")){
                    bluebed2 = new Location(player.getWorld(), Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]));
                    player.sendMessage("done");

                }
                if (args[0].equalsIgnoreCase("redbed1")){
                    redbed1 = new Location(player.getWorld(), Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]));
                    player.sendMessage("done");

                }
                if (args[0].equalsIgnoreCase("redbed2")){
                    redbed2 = new Location(player.getWorld(), Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]));
                    player.sendMessage("done");

                }
                if (args[0].equalsIgnoreCase("greenbed1")){
                    greenbed1 = new Location(player.getWorld(), Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]));
                    player.sendMessage("done");

                }
                if (args[0].equalsIgnoreCase("greenbed2")){
                    greenbed2 = new Location(player.getWorld(), Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]));
                    player.sendMessage("done");

                }
                if (args[0].equalsIgnoreCase("yellowbed1")){
                    yellowbed1 = new Location(player.getWorld(), Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]));
                    player.sendMessage("done");

                }
                if (args[0].equalsIgnoreCase("yellowbed2")){
                    yellowbed2 = new Location(player.getWorld(), Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]));
                    player.sendMessage("done");

                }
            }



        }
        return false;
    }
}
