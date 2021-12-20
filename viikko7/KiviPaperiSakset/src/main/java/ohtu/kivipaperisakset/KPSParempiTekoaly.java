package ohtu.kivipaperisakset;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KiviPaperiSakset {

    private TekoalyParannettu tekoaly;
    
    public KPSParempiTekoaly() {
        this.tekoaly = new TekoalyParannettu(20);
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
