package ohtu.kivipaperisakset;

public class KPSTekoaly extends KiviPaperiSakset {

    private Tekoaly tekoaly;
    
    public KPSTekoaly() {
        this.tekoaly = new Tekoaly();
    }
    
    @Override
    protected void asetaSiirto(String ekanSiirto) {
        this.tekoaly.asetaSiirto(ekanSiirto);
    }

    @Override
    protected String toisenSiirto() {
        String toisenSiirto = tekoaly.annaSiirto();
        System.out.println("Toinen pelaaja valitsi: " + toisenSiirto);
        return toisenSiirto; 
    }
}