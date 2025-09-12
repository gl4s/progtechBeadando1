package creatures;

public class Szivacs extends Leny {
    public Szivacs(String nev, int kezdoViz) {
        super(nev, kezdoViz);
        this.maxViz=20;
        waterCheck();
    }

    @Override
    public void naposNap() {
        if (this.eletbenVan) {
            this.vizmennyiseg-=4;
            waterCheck();
            if (this.eletbenVan) {
                this.megtettTavolsag+=0;
            }
        }
    }

    @Override
    public void felhosNap() {
        if (this.eletbenVan) {
            this.vizmennyiseg-=1;
            waterCheck();
            if (this.eletbenVan) {
                this.megtettTavolsag+=3;
            }
        }
    }

    @Override
    public void esosNap() {
        if (this.eletbenVan) {
            this.vizmennyiseg+=6;
            waterCheck();
            if (this.eletbenVan) {
                this.megtettTavolsag+=1;
            }
        }
    }
}
