package creatures;

public class Homokjaro extends Leny
{
    public Homokjaro(String nev, int kezdoViz){
        super(nev, kezdoViz);
        this.maxViz=8;
        waterCheck();
    }

    @Override
    public void naposNap() {
        if (this.eletbenVan) {
            this.vizmennyiseg-=1;
            waterCheck();
            if (this.eletbenVan) {
                this.megtettTavolsag+=3;
            }
        }
    }

    @Override
    public void felhosNap() {
        if (this.eletbenVan) {
            this.vizmennyiseg+=0;
            waterCheck();
            if (this.eletbenVan) {
                this.megtettTavolsag+=1;
            }
        }
    }

    @Override
    public void esosNap() {
        if (this.eletbenVan) {
            this.vizmennyiseg+=1;
            waterCheck();
            if (this.eletbenVan) {
                this.megtettTavolsag+=1;
            }
        }
    }
}
