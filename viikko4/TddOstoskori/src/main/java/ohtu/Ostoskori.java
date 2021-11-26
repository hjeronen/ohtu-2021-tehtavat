package ohtu;

import java.util.ArrayList;
import java.util.List;

public class Ostoskori {
    private ArrayList<Ostos> ostokset;
    
    public Ostoskori() {
        this.ostokset = new ArrayList<Ostos>();
    }
    
    public int tavaroitaKorissa() {
        // kertoo korissa olevien tavaroiden lukumäärän
        // eli jos koriin lisätty 2 kpl tuotetta "maito", 
        //   tulee metodin palauttaa 2 
        // jos korissa on 1 kpl tuotetta "maito" ja 1 kpl tuotetta "juusto", 
        //   tulee metodin palauttaa 2   
        if (this.ostokset.isEmpty()) {
            return 0;
        }
        int maara = 0;
        for (Ostos o : this.ostokset) {
            maara += o.lukumaara();
        }
        return maara;
    }
 
    public int hinta() {
        // kertoo korissa olevien tuotteiden yhteenlasketun hinnan
        if (this.ostokset.isEmpty()) {
            return 0;
        }
        return -1;
    }
 
    public void lisaaTuote(Tuote lisattava) {
        // lisää tuotteen
        this.ostokset.add(new Ostos(lisattava));
    }
 
    public void poista(Tuote poistettava) {
        // poistaa tuotteen
    }
 
    public List<Ostos> ostokset() {
        // palauttaa listan jossa on korissa olevat ostokset
 
        return null;
    }
 
    public void tyhjenna() {
        // tyhjentää korin
    }
}
