package personal.unal.com.healthquestions.Data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by JuanCamilo on 11/06/2017.
 */

public class GameEngine implements Parcelable {
    private String playerName;
    private int score;
    private int progress;
    private int total;


    private ArrayList<PowerUp> powers;
    private List<Question> questionList;

    public GameEngine(String playerName, int score, int progress) {
        this.playerName = playerName;
        this.score = score;
        this.progress = progress;
        this.total = 20;
        this.questionList = new ArrayList<>(15);
    }

    protected GameEngine(Parcel in) {
        playerName = in.readString();
        score = in.readInt();
        progress = in.readInt();
        total = in.readInt();
        powers = in.createTypedArrayList(PowerUp.CREATOR);
        questionList = in.createTypedArrayList(Question.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(playerName);
        dest.writeInt(score);
        dest.writeInt(progress);
        dest.writeInt(total);
        dest.writeTypedList(powers);
        dest.writeTypedList(questionList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<GameEngine> CREATOR = new Creator<GameEngine>() {
        @Override
        public GameEngine createFromParcel(Parcel in) {
            return new GameEngine(in);
        }

        @Override
        public GameEngine[] newArray(int size) {
            return new GameEngine[size];
        }
    };

    public void initGame() {
        powers = new ArrayList<>(3);
        powers.add(new RemoveOptions());
        powers.add(new PublicHelp());
        powers.add(new RemoveOptions());

        Question q = new Question("¿Como me llamo?");
        q.addAnswerOption(new AnswerOption("Carlos", false));
        q.addAnswerOption(new AnswerOption("Laura", false));
        q.addAnswerOption(new AnswerOption("Claudia", false));
        q.addAnswerOption(new AnswerOption("Camilo", true));

        questionList.add(q);

        q = new Question("¿Otra Cosa?");
        q.addAnswerOption(new AnswerOption("Carlos", false));
        q.addAnswerOption(new AnswerOption("Laura", true));
        q.addAnswerOption(new AnswerOption("Claudia", false));
        q.addAnswerOption(new AnswerOption("Camilo", false));

        questionList.add(q);


        Collections.shuffle(questionList);
    }


    public List<Question> getQuestionList() {
        return this.questionList;
    }

    public ArrayList<PowerUp> getPowers() {
        return this.powers;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
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


    public int getUsedPowers() {
        int used = 0;
        for (PowerUp pw : getPowers()) {
            if (pw.isUsed()) {
                used++;
            }
        }
        return used;
    }
}
