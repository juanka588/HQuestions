package personal.unal.com.healthquestions.Data;

import android.content.Context;
import android.os.Parcel;

import personal.unal.com.healthquestions.GUI.QuestionFragment;

/**
 * Created by Miguel on 13/06/2017.
 */

public class RemoveOptions extends PowerUp {

    @Override
    public void showResult(QuestionFragment questionFragment, Question question) {
        int idx1 = (int) (Math.random() * question.getOptions().size());
        while (idx1 == question.getCorrectIndex()) {
            idx1 = (int) (Math.random() * question.getOptions().size());
        }
        question.getOptions().get(idx1).setOptionValue("");
        //second option
        int idx2 = (int) (Math.random() * question.getOptions().size());
        while (idx2 == question.getCorrectIndex() || idx2 == idx1) {
            idx2 = (int) (Math.random() * question.getOptions().size());
        }
        question.getOptions().get(idx2).setOptionValue("");

        questionFragment.bindData();
    }

    public RemoveOptions() {
        setUsed(false);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (isUsed() ? 1 : 0));
    }

    protected RemoveOptions(Parcel in) {
        setUsed(in.readByte() != 0);
    }

    public static final Creator<RemoveOptions> CREATOR = new Creator<RemoveOptions>() {
        @Override
        public RemoveOptions createFromParcel(Parcel in) {
            return new RemoveOptions(in);
        }

        @Override
        public RemoveOptions[] newArray(int size) {
            return new RemoveOptions[size];
        }
    };


}
