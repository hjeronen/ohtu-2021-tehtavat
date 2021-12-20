package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class KiviPaperiSakset {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static KiviPaperiSakset luoKaksinpeli() {
        return new KPSPelaajaVsPelaaja(scanner);
    }
    
    public static KiviPaperiSakset luoHelppoYksinpeli() {
        return new KPSTekoaly();
    }
    
    public static KiviPaperiSakset luoVaikeaYksinpeli() {
        return new KPSParempiTekoaly();
    }
    
    // t�m� on ns template metodi
    public void pelaa() {
        Tuomari tuomari = new Tuomari();
        
        String ekanSiirto = ensimmaisenSiirto();
        String tokanSiirto = toisenSiirto();
        
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();
            
            asetaSiirto(ekanSiirto);

            ekanSiirto = ensimmaisenSiirto();
            tokanSiirto = toisenSiirto();
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
    
    protected String ensimmaisenSiirto() {
        System.out.print("Ensimm�isen pelaajan siirto: ");
        return scanner.nextLine();
    }

    // t�m� on abstrakti metodi sill� sen toteutus vaihtelee eri pelityypeiss�
    abstract protected String toisenSiirto();
    
    abstract protected void asetaSiirto(String ekanSiirto);
    
    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}