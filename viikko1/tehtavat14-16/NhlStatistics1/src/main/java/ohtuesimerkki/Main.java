package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReader("https://nhlstatisticsforohtu.herokuapp.com/players.txt"));
          
        System.out.println("Philadelphia Flyers");
        for (Player player : stats.team("PHI") ) {
            System.out.println( player );
        }
        
        System.out.println("");
        
        System.out.println("Top scorers");
        for (Player player : stats.topScorers(10) ) {
            System.out.println( player );
        }   
        
        /*Reader readerStub = new Reader() {
 
            public List<Player> getPlayers() {
                ArrayList<Player> players = new ArrayList<>();
 
                players.add(new Player("Semenko", "EDM", 4, 12)); // points: 16
                players.add(new Player("Lemieux", "PIT", 45, 54)); // 99
                players.add(new Player("Kurri",   "EDM", 37, 53)); // 90
                players.add(new Player("Yzerman", "DET", 42, 56)); // 98
                players.add(new Player("Gretzky", "EDM", 35, 89)); // 124
 
                return players;
            }
        };
        
        Statistics stats2 = new Statistics(readerStub);
        ArrayList<Player> top = (ArrayList) stats2.topScorers(5);
        System.out.println(top);*/
    }
}
