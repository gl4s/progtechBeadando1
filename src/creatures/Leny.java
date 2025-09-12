package creatures;

public abstract class Leny {
    protected String nev;
    protected int vizmennyiseg;
    protected int maxViz;
    protected boolean eletbenVan;
    protected int megtettTavolsag;

    public Leny(String nev, int kezdoViz) {
        this.nev=nev;
        this.vizmennyiseg=kezdoViz;
        this.eletbenVan=true;
        this.megtettTavolsag=0;
    }

    public abstract void naposNap();
    public abstract void felhosNap();
    public abstract void esosNap();

    public boolean isAlive() {
        return eletbenVan;
    }

    public String getNev() {
        return nev;
    }

    public int getMegtettTavolsag() {
        return megtettTavolsag;
    }

    protected void waterCheck() {
        if (this.vizmennyiseg>this.maxViz) {
            this.vizmennyiseg=this.maxViz;
        }
        if (this.vizmennyiseg<=0) {
            this.vizmennyiseg=0;
            this.eletbenVan=false;
        }
    }
}
