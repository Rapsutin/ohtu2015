package ohtu;

public class TennisGame {
    
    private Player player1;
    private Player player2;
    boolean hasDeuced;

    public TennisGame(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
        hasDeuced = false;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
    
    public void wonPoint(Player player) {
        player.wonPoint();
        if(player1.hasAdvantage() && player1.hasAdvantage()) {
            player1.setScore(Score.FORTY);
            player2.setScore(Score.FORTY);
            hasDeuced = true;
        }
    } 

    public String getScore() {
        if(singlePlayerHasAdvantage()) return advantageScore();
        if(theGameIsTied()) return returnTiedGameString();
        if(aPlayerHasWon()) return winScore();
        return normalScore();
    }

    private boolean singlePlayerHasAdvantage() {
        return player1.hasAdvantage() ^ player2.hasAdvantage();
    }
    
    private String advantageScore() {
        if (player1.hasAdvantage()) {
           return "Player1 advantage"; 
        }
        else {
           return "Player2 advantage"; 
        }
    }

    private boolean aPlayerHasWon() {
        return player1.hasWon() || player2.hasWon();
    }
    
    private String winScore() {
        if(player1.hasWon()) return "Win for player1";
        else return "Win for player2";
    }

    private String normalScore() {
        return player1.getScore().getScoreName() + "-" + player2.getScore().getScoreName();
    }
    

    private String returnTiedGameString() {
        if(hasDeuced) return "Deuce";
        return player1.getScore().getScoreName()+"-"+"All";
    }

    private boolean theGameIsTied() {
        return player1.getScore() == player2.getScore();
    }
}