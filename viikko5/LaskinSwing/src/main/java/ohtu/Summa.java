
package ohtu;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Summa extends Komento {
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private JButton nollaa;
    private JButton undo;
    private int edellinen;
    
    public Summa(JTextField tuloskentta, JTextField syotekentta, JButton nollaa, JButton undo, Sovelluslogiikka sovellus) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.edellinen = 0;
    }
    
    @Override
    public void suorita() {
        String syote = this.syotekentta.getText();
        int luku = 0;
        if (!syote.isEmpty()) {
            luku = Integer.parseInt(syote);
            this.edellinen = luku;
        }
        this.sovellus.plus(luku);
        
        int tulos = this.sovellus.tulos();
        this.syotekentta.setText("");
        this.tuloskentta.setText("" + tulos);
        if (tulos == 0) {
            this.nollaa.setEnabled(false);
        } else {
            this.nollaa.setEnabled(true);
        }
    }
    
    @Override
    public void peru() {
        this.sovellus.miinus(this.edellinen);
        this.tuloskentta.setText("" + this.sovellus.tulos());
        this.edellinen = 0;
    }
    
}
