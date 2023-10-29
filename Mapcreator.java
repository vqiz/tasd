package dev.teammlg.vqiz.bwsw.commads;

import dev.teammlg.vqiz.bwsw.BWSW;
import dev.teammlg.vqiz.bwsw.Utils.GameMap;
import dev.teammlg.vqiz.bwsw.Utils.LocationManager;
import dev.teammlg.vqiz.bwsw.Utils.Mode;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Mapcreator {








     static int i = 1;

    public static void execute(String name, Location specspawn, Location bluespawn, Location bluebed1, Location bluebed2, Location redspawn, Location redbed1, Location redbed2, Location greenspawn, Location greenbed1, Location greenbed2, Location yellowspawn, Location yellowbed1, Location yellowbed2, Location deathheight, ArrayList<Location> bronzespawns, ArrayList<Location> ironspawns, ArrayList<Location> gold) throws IOException {
        File file = new File("maps/" + name + ".yaml");
        file.getParentFile().mkdirs(); // Erstellt den Ordner maps, falls er nicht vorhanden ist
        file.createNewFile();
        FileConfiguration c = YamlConfiguration.loadConfiguration(file);
        GameMap gameMap = new GameMap();
        gameMap.name = name;
        gameMap.specspawn = specspawn;
        gameMap.bluespawn = bluespawn;
        gameMap.bluebed1 = bluebed1;
        gameMap.bluebed2 = bluebed2;
        gameMap.redspawn = redspawn;
        gameMap.redbed1 = redbed1;
        gameMap.redbed2 = redbed2;
        gameMap.greenspawn = greenspawn;
        gameMap.greenbed1 = greenbed1;
        gameMap.greenbed2 = greenbed2;
        gameMap.yellowspawn = yellowspawn;
        gameMap.yellowbed1 = yellowbed1;
        gameMap.yellowbed2 = yellowbed2;
        gameMap.gold = gold;
        gameMap.iron = ironspawns;
        gameMap.bronzespawner = bronzespawns;
        LocationManager.setcfg(c, file);

        c.set("name", name);
        LocationManager.setLocation("specspawn", specspawn);
        LocationManager.setLocation("bluespawn", bluespawn);
        LocationManager.setLocation("bluebed1", bluebed1);
        LocationManager.setLocation("bluebed2", bluebed2);
        LocationManager.setLocation("redspawn", redspawn);
        LocationManager.setLocation("redbed1", redbed1);
        LocationManager.setLocation("redbed2", redbed2);
        LocationManager.setLocation("greenspawn",greenspawn);
        LocationManager.setLocation("greenbed1", greenbed1);
        LocationManager.setLocation("greenbed2", greenbed2);
        LocationManager.setLocation("yellowspawn", yellowspawn);
        LocationManager.setLocation("yellowbed1", yellowbed1);
        LocationManager.setLocation("yellowbed2", yellowbed2);
        LocationManager.setLocation("deathheight", deathheight);
        c.set("goldspawns", gold.size());
        c.set("bronze", bronzespawns.size());
        c.set("ironspawns", ironspawns.size());
        gold.forEach(location ->
        {
            try {
                LocationManager.setLocation(i + ".gold", location);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            i++;
        });
        i = 1;
        bronzespawns.forEach(location ->
        {
            try {
                LocationManager.setLocation(i + ".bronze", location);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            i++;
        });
        i = 1;
        ironspawns.forEach(location ->
        {
            try {
                LocationManager.setLocation(i + ".ironspawns", location);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            i++;
        });
        c.save(file);
    }

}
