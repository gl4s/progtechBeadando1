import java.io.IOException;
import java.util.List;
import creatures.Leny;
import utils.FileHandler;

public class Main {
    public static void main(String[] args){
        String filepath = "src/input.txt";
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

            Leny gyoztes = null;
            int maxTavolsag = -1;

            for (Leny leny : lenyek) {
                if (leny.isAlive() && leny.getMegtettTavolsag() > maxTavolsag) {
                    maxTavolsag = leny.getMegtettTavolsag();
                    gyoztes = leny;
                }
            }

            // Eredmeny
            if (gyoztes != null) {
                System.out.println("A győztes: " + gyoztes.getNev());
            } else {
                System.out.println("Nincs győztes. Minden lény elpusztult.");
            }

        } catch (Exception e){
            System.err.println("hiba történt: " + e.getMessage());
        }
    }
}
