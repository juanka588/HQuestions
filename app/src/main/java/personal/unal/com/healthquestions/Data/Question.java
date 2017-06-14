package personal.unal.com.healthquestions.Data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JuanCamilo on 11/06/2017.
 */

public class Question implements Parcelable {
    private List<AnswerOption> options;
    private String statement;
    private int correctIndex;

    public Question(List<AnswerOption> options, String statement) {
        this.options = options;
        this.statement = statement;
        this.correctIndex = -1;
    }

    public Question(String statement) {
        this.statement = statement;
        this.options = new ArrayList<>();
    }


    protected Question(Parcel in) {
        options = in.createTypedArrayList(AnswerOption.CREATOR);
        statement = in.readString();
        correctIndex = in.readInt();
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    public List<AnswerOption> getOptions() {
        return options;
    }

    public void setOptions(List<AnswerOption> options) {
        this.options = options;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public void addAnswerOption(AnswerOption option) {
        if (option.isCorrect()) {
            correctIndex = options.size();
        }
        options.add(option);
    }

    public int getCorrectIndex() {
        return correctIndex;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(options);
        parcel.writeString(statement);
        parcel.writeInt(correctIndex);
    }
}
