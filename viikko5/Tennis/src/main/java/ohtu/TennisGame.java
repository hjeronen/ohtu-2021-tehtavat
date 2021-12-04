package ohtu;

public class TennisGame {
    
    private int p1_points = 0;
    private int p2_points = 0;
    private String player1Name;
    private String player2Name;
    private int nrOfRounds = 4;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            p1_points += 1;
        } else {
            p2_points += 1;
        }
    }

    public String getScore() {
        String score = "";
        
        if (p1_points==p2_points) {
            score = evenScore();
            return score;
        }
        
        int difference = p1_points - p2_points;
        
        if (p1_points>=nrOfRounds || p2_points>=nrOfRounds) {
            if (Math.abs(difference) == 1) {
                score = advantageForWho(difference);
            } else {
                score = winForWho(difference);
            }
        } else {
            score = score(p1_points) + "-" + score(p2_points);
        }
        return score;
    }
    
    public String evenScore() {
        if (p1_points < nrOfRounds) {
            return score(p1_points) + "-All";
        } else {
            return "Deuce";
        }
    }
    
    public String advantageForWho(int difference) {
        if (difference > 0) {
            return "Advantage player1";
        } else {
            return "Advantage player2";
        }
    }
    
    public String winForWho(int difference) {
        if (difference > 0) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }
    
    public String score(int points) {
        if (points == 0) {
            return "Love";
        } else if (points == 1) {
            return "Fifteen";
        } else if (points == 2) {
            return "Thirty";
        } else if (points == 3) {
            return "Forty";
        } else {
            return "";
        }
    }
}