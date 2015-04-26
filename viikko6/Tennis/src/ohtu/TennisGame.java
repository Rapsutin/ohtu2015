package ohtu;

public class TennisGame {
    
    private static final int ADVANTAGE = 4;
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        String score = "";
        if (playersAreTied())
        {
            score = tiedScore();
        }
        else if (GameIsDeuceOrWin())
        {
            score = lastScores(score);
        }
        else
        {
            score = normalScore();
        }
        return score;
    }

    private boolean playersAreTied() {
        return player1Score==player2Score;
    }

    private boolean GameIsDeuceOrWin() {
        return player1Score>=ADVANTAGE || player2Score>=ADVANTAGE;
    }

    private String lastScores(String score) {
        String player = player1Score > player2Score ? "player1" : "player2";
        String situation = Math.abs(player1Score - player2Score) == 1 ? "Advantage " : "Win for ";
        
        return situation + player;
    }
    
    private String normalScore() {
        return getScoreName(player1Score)+"-"+getScoreName(player2Score);
    }

    private String getScoreName(int score) {
        switch(score)
        {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
        return null;
    }

    private String tiedScore() {
        if(player1Score <= 3) {
            return getScoreName(player1Score)+"-"+"All";
        } else {
            return "Deuce";
        }
    }
}