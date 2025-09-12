package creatures;

public class Lepegeto extends Leny {
    public Lepegeto(String nev, int kezdoViz) {
        super(nev, kezdoViz);
        this.maxViz=12;
        waterCheck();
    }

    @Override
    public void naposNap() {
        if (this.eletbenVan) {
            this.vizmennyiseg-=2;
            waterCheck();
            if (this.eletbenVan) {
                this.megtettTavolsag+=1;
            }
        }
    }

    @Override
    public void felhosNap() {
        if (this.eletbenVan) {
            this.vizmennyiseg+=3;
            waterCheck();
            if (this.eletbenVan) {
                this.megtettTavolsag+=2;
            }
        }
    }

    @Override
    public void esosNap() {
        if (this.eletbenVan) {
            this.vizmennyiseg+=3;
            waterCheck();
            if (this.eletbenVan) {
                this.megtettTavolsag+=1;
            }
        }
    }
}
