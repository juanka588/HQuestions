package personal.unal.com.healthquestions.Data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JuanCamilo on 11/06/2017.
 */

public class Question implements Parcelable {
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
    private List<AnswerOption> options;
    private String statement;

    public Question(List<AnswerOption> options, String statement) {
        this.options = options;
        this.statement = statement;
    }

    public Question(String statement) {
        this.statement = statement;
        this.options = new ArrayList<>();
    }

    protected Question(Parcel in) {
        statement = in.readString();
//        options=new ArrayList<AnswerOption>(in.readParcelableArray(AnswerOption.class.getClassLoader()));
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(statement);
        dest.writeParcelableArray((Parcelable[]) options.toArray(), 0);
    }
}
