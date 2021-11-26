package ohtu;

public class Main {
    public static void main(String[] args) {
        // testikoodi tänne
        Ostoskori kori = new Ostoskori();
        Tuote maito = new Tuote("maito", 3);
        kori.lisaaTuote(maito);
        for (Ostos o : kori.ostokset()) {
            System.out.println(o.tuotteenNimi());
        }
        kori.poista(maito);
        for (Ostos o : kori.ostokset()) {
            System.out.println(o.tuotteenNimi());
        }
        
    }
}