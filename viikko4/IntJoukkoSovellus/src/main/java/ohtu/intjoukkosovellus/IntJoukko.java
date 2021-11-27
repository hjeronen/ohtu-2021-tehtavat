
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] joukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);

    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasiteetti ei voi olla negatiivinen");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasvatuskoko ei voi olla negatiivinen");
        }
        this.joukko = new int[kapasiteetti];
        for (int i = 0; i < joukko.length; i++) {
            this.joukko[i] = 0;
        }
        this.alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }
    

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            this.joukko[this.alkioidenLkm] = luku;
            this.alkioidenLkm++;
            if (this.alkioidenLkm == this.joukko.length) {
                int[] taulukkoOld = this.joukko;
                this.joukko = new int[this.alkioidenLkm + this.kasvatuskoko];
                kopioiTaulukko(taulukkoOld, this.joukko);
            }
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < this.alkioidenLkm; i++) {
            if (luku == this.joukko[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        if (!kuuluu(luku)) {
            return false;
        }
        boolean loytynyt = false;
        for (int i = 0; i < this.alkioidenLkm; i++) {
            if (luku == this.joukko[i]) {
                loytynyt = true;
            }
            if (loytynyt) {
                this.joukko[i] = this.joukko[i + 1];
            }
        }
        this.alkioidenLkm--;
        return true;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return this.alkioidenLkm;
    }


    @Override
    public String toString() {
        if (this.alkioidenLkm == 0) {
            return "{}";
        } else {
            String tulostus = "{" + this.joukko[0];
            for (int i = 1; i <= this.alkioidenLkm - 1; i++) {
                tulostus += ", ";
                tulostus += this.joukko[i];
            }
            tulostus += "}";
            return tulostus;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[this.alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = this.joukko[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(bTaulu[i]);
        }
 
        return z;
    }
        
}
