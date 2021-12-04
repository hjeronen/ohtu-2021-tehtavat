
package ohtu;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Summa extends Komento {
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private JButton nollaa;
    private JButton undo;
    
    public Summa(JTextField tuloskentta, JTextField syotekentta, JButton nollaa, JButton undo, Sovelluslogiikka sovellus) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
    }
    
    @Override
    public void suorita() {
        String syote = this.syotekentta.getText();
        int luku = 0;
        if (!syote.isEmpty()) {
            luku = Integer.parseInt(syote);
        }
        this.sovellus.plus(luku);
        
        int tulos = this.sovellus.tulos();
        this.syotekentta.setText("");
        this.tuloskentta.setText("" + tulos);
        if (tulos == 0) {
            nollaa.setEnabled(false);
        } else {
            nollaa.setEnabled(true);
        }
    }
    
    @Override
    public void peru() {
        
    }
    
}
