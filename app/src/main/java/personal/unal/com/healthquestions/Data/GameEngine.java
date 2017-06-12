package personal.unal.com.healthquestions.Data;

/**
 * Created by JuanCamilo on 11/06/2017.
 */

public class GameEngine {
    private String playerName;
    private int score;
    private int progress;

    public GameEngine(String playerName, int score, int progress) {
        this.playerName = playerName;
        this.score = score;
        this.progress = progress;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
