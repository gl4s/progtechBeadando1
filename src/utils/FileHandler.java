package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import creatures.Leny;
import creatures.Homokjaro;
import creatures.Szivacs;
import creatures.Lepegeto;

public class FileHandler {
    public List<Leny> readCreaturesFromFile(String filePath) throws IOException {
        List<Leny> creatures = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){

            String firstLine = br.readLine();
            if(firstLine == null) {
                throw new IllegalArgumentException("ures file");
            }
            int lenyekSzama = Integer.parseInt(firstLine.trim());

            for (int i = 0; i < lenyekSzama; i++) {
                String line = br.readLine();
                if(line == null) {
                    throw new IllegalArgumentException("kevesebb leny van benne mint az elso sorban a szam");
                }
                String[] data = line.split(" ");

                if (data.length < 3) {
                    throw new IllegalArgumentException("rossz formatum a " + (i + 1) + "sorban");
                }

                String name = data[0];
                char type = data[1].charAt(0);
                int kezdoViz;

                try {
                    kezdoViz = Integer.parseInt(data[2]);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("rossz kezdo viz ertek");
                }

                switch (type) {
                    case 'h':
                        creatures.add(new Homokjaro(name, kezdoViz));
                        break;
                    case 's':
                        creatures.add(new Szivacs(name, kezdoViz));
                        break;
                    case 'l':
                        creatures.add(new Lepegeto(name, kezdoViz));
                        break;
                    default:
                        throw new IllegalArgumentException("ismeretlen leny tipus: " + type);
                }
            }

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Nem valid szam szerepel az elso sorban");
        } catch (IOException e) {
            throw new IOException("file beolvasasi hiba: " + e.getMessage(), e);
        }

        return creatures;
    }

    public String readDaySeriesFromFile(String filePath) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String firstLine = br.readLine();
            if(firstLine == null) {
                throw new IllegalArgumentException("ures file");
            }
            int lenyekSzama = Integer.parseInt(firstLine.trim());

            for (int i = 0; i < lenyekSzama; i++) {
                br.readLine();
            }

            String napSorozat = br.readLine();
            if (napSorozat == null) {
                throw new IllegalArgumentException("nincs megadott napsorozat");
            }
            return napSorozat;
        }
    }
}
