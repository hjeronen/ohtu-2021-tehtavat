
package ohtu;

public class Player implements Comparable<Player> {
    private String name;
    private String nationality;
    private int assists;
    private int goals;
    private int penalties;
    private String team;
    private int games;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setNationality(String nat) {
        this.nationality = nat;
    }
    
    public String getNationality() {
        return this.nationality;
    }
    
    public void setAssists(int a) {
        this.assists = a;
    }
    
    public int getAssists() {
        return this.assists;
    }
    
    public void setGoals(int g) {
        this.goals = g;
    }
    
    public int getGoals() {
        return this.goals;
    }
    
    public void setPenalties(int p) {
        this.penalties = p;
    }
    
    public int getPenalties() {
        return this.penalties;
    }
    
    public void setTeam(String t) {
        this.team = t;
    }
    
    public String getTeam() {
        return this.team;
    }
    
    public void setGames(int g) {
        this.games = g;
    }
    
    public int getGames() {
        return this.games;
    }

    @Override
    public String toString() {
        return name + " team " + team + " goals " + goals + " assists " + assists;
    }

    @Override
    public int compareTo(Player p2) {
        return  (p2.goals + p2.assists) - (goals + assists);
    }
      
}
