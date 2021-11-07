/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Heli
 */
public class StatisticsTest {
    
    Reader readerStub = new Reader() {
 
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
    
    Statistics stats;
    
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void searchLoytaaPelaajan() {
        Player p = new Player("Kurri", "EDM", 37, 53);
        assertEquals(p.getName(), stats.search("Kurri").getName());
    }
    
    @Test
    public void searchPalauttaaNull() {
        assertEquals(null, stats.search("Pirlo"));
    }
    
    @Test
    public void teamLoytaaPelaajat() {
        ArrayList<Player> edmPelaajat = new ArrayList<>();
        edmPelaajat.add(stats.search("Semenko"));
        edmPelaajat.add(stats.search("Kurri"));
        edmPelaajat.add(stats.search("Gretzky"));
        
        assertEquals(edmPelaajat, stats.team("EDM"));
    }
    
    @Test
    public void topScorersSijoittaaPelaajatOikein() {
        assertEquals(stats.search("Gretzky"), stats.topScorers(5).get(0));
        assertEquals(stats.search("Lemieux"), stats.topScorers(5).get(1));
        assertEquals(stats.search("Yzerman"), stats.topScorers(5).get(2));
        assertEquals(stats.search("Kurri"), stats.topScorers(5).get(3));
        assertEquals(stats.search("Semenko"), stats.topScorers(5).get(4));
    }
    
    
    
}
