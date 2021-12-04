
package ohtu;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Nollaa extends Komento {
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private JButton nollaa;
    private JButton undo;
    private int edellinen;
    
    public Nollaa(JTextField tuloskentta, JTextField syotekentta, JButton nollaa, JButton undo, Sovelluslogiikka sovellus) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.edellinen = 0;
    }
    
    @Override
    public void suorita() {
        this.edellinen = this.sovellus.tulos();
        sovellus.nollaa();
        this.tuloskentta.setText("");
        nollaa.setEnabled(false);
    }
    
    @Override
    public void peru() {
        this.sovellus.plus(this.edellinen);
        this.tuloskentta.setText("" + this.sovellus.tulos());
    }
}
