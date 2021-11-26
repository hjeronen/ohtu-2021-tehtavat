package ohtu;

import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OstoskoriTest {

    Ostoskori kori;

    @Before
    public void setUp() {
        kori = new Ostoskori();
    }

    // step 1
    @Test
    public void ostoskorinHintaJaTavaroidenMaaraAlussa() { 
        assertEquals(0, kori.hinta());
 
        assertEquals(0, kori.tavaroitaKorissa());
    }
    
    @Test
    public void yhdenTuotteenLisaamisenJalkeenKorissaYksiTavara() {
        Tuote maito = new Tuote("maito", 3);
 
        kori.lisaaTuote(maito);
 
        assertEquals(1, kori.tavaroitaKorissa());
    }
    
    @Test
    public void yhdenTuotteenLisaamisenJalkeenKorinHintaOnSamaKuinTuotteenHinta() {
        Tuote maito = new Tuote("maito", 3);
 
        kori.lisaaTuote(maito);
 
        assertEquals(3, kori.hinta());
    }
    
    @Test
    public void kahdenEriTuotteenLisaamisenJalkeenKorissaKaksiTavaraa() {
        Tuote maito = new Tuote("maito", 3);
        Tuote mehu = new Tuote("mehu", 4);
 
        kori.lisaaTuote(maito);
        kori.lisaaTuote(mehu);
 
        assertEquals(2, kori.tavaroitaKorissa());
    }
    
    @Test
    public void kahdenEriTuotteenLisaamisenJalkeenKorinHintaOnTuotteidenHinta() {
        Tuote maito = new Tuote("maito", 3);
        Tuote mehu = new Tuote("mehu", 4);
 
        kori.lisaaTuote(maito);
        kori.lisaaTuote(mehu);
 
        assertEquals(7, kori.hinta());
    }
    
    @Test
    public void kahdenSamanTuotteenLisaamisenJalkeenKorissaOnKaksiTavaraa() {
        Tuote maito = new Tuote("maito", 3);
 
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);
 
        assertEquals(2, kori.tavaroitaKorissa());
    }
    
    @Test
    public void kahdenSamanTuotteenLisaamisenJalkeenKorinHintaOnKaksiKertaaTuotteenHinta() {
        Tuote maito = new Tuote("maito", 3);
 
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);
 
        assertEquals(6, kori.hinta());
    }
    
    @Test
    public void yhdenTuotteenLisaamisenJalkeenKorissaYksiOstosOlio() {
        kori.lisaaTuote(new Tuote("maito", 3));
 
        List<Ostos> ostokset = kori.ostokset();
        
        assertEquals(1, ostokset.size());
    }
    
    @Test
    public void yhdenTuotteenLisaamisenJalkeenKorissaYksiOstosOlioJollaOikeaTuotteenNimiJaMaara() {
        Tuote maito = new Tuote("maito", 3);
        kori.lisaaTuote(maito);
 
        Ostos ostos = kori.ostokset().get(0);
        
        assertEquals("maito", ostos.tuotteenNimi());
        assertEquals(1, ostos.lukumaara());
    }
    
    @Test
    public void kahdenEriTuotteenLisaamisenJalkeenKorissaKaksiOstosOliota() {
        kori.lisaaTuote(new Tuote("maito", 3));
        kori.lisaaTuote(new Tuote("mehu", 4));
 
        List<Ostos> ostokset = kori.ostokset();
        
        assertEquals(2, ostokset.size());
    }
    
    @Test
    public void kahdenSamanTuotteenLisaamisenJalkeenKorissaYksiOstosOlio() {
        Tuote maito = new Tuote("maito", 3);
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);
 
        List<Ostos> ostokset = kori.ostokset();
        
        assertEquals(1, ostokset.size());
    }
    
    @Test
    public void kahdenSamanTuotteenLisaamisenJalkeenKorissaYksiOstosOlioJollaOikeaTuotteenNimiJaMaara() {
        Tuote maito = new Tuote("maito", 3);
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);
 
        Ostos ostos = kori.ostokset().get(0);
        
        assertEquals("maito", ostos.tuotteenNimi());
        assertEquals(2, ostos.lukumaara());
    }

}
