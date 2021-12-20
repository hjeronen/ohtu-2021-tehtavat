package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KiviPaperiSakset {

    private Scanner scanner;
    
    public KPSPelaajaVsPelaaja(Scanner scanner) {
        this.scanner = scanner;
    }
    
    @Override
    protected void asetaSiirto(String ekanSiirto) {
        // ei tehda mitaan
    }

    @Override
    protected String toisenSiirto() {
        System.out.print("Toisen pelaajan siirto: ");
        String toisenSiirto = scanner.nextLine();
        return toisenSiirto;
    }
}