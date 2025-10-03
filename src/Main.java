import java.io.IOException;
import java.util.List;
import creatures.Leny;
import utils.FileHandler;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args){
        String filepath;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Kerem adja meg a bemeneti fajl nevet (pl.: test/input.txt): ");
            filepath = br.readLine();
        } catch (java.io.IOException e) {
            System.err.println("Hiba a konzolrol valo beolvasaskor: " + e.getMessage());
            return;
        }

        if (filepath.isEmpty()) {
            System.err.println("Nem adott meg fajlnevet");
            return;
        }

        FileHandler fh = new FileHandler();

        try {

            List<Leny> lenyek = fh.readCreaturesFromFile(filepath);
            String napokSorozata = fh.readDaySeriesFromFile(filepath);

            for (char nap : napokSorozata.toCharArray()) {
                for (Leny leny : lenyek) {
                    if (leny.isAlive()) {
                        switch (nap) {
                            case 'n':
                                leny.naposNap();
                                break;
                            case 'f':
                                leny.felhosNap();
                                break;
                            case 'e':
                                leny.esosNap();
                                break;
                        }
                    }
                }
            }

            Leny nyertes = null;
            int maxTavolsag = -1;

            for (Leny leny : lenyek) {
                if (leny.isAlive() && leny.getMegtettTavolsag() > maxTavolsag) {
                    maxTavolsag = leny.getMegtettTavolsag();
                    nyertes = leny;
                }
            }

            // Eredmeny
            if (nyertes != null) {
                System.out.println("A gyoztes: " + nyertes.getNev());
            } else {
                System.out.println("Nincs gyoztes. Minden lény elpusztult");
            }

        } catch (Exception e){
            System.err.println("hiba tortent: " + e.getMessage());
        }
    }
}
