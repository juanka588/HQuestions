package personal.unal.com.healthquestions.Data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by JuanCamilo on 11/06/2017.
 */

public class AnswerOption implements Parcelable {

    public static final Creator<AnswerOption> CREATOR = new Creator<AnswerOption>() {
        @Override
        public AnswerOption createFromParcel(Parcel in) {
            return new AnswerOption(in);
        }

        @Override
        public AnswerOption[] newArray(int size) {
            return new AnswerOption[size];
        }
    };
    private String optionValue;
    private boolean isCorrect;

    public AnswerOption(String optionValue, boolean isCorrect) {
        this.optionValue = optionValue;
        this.isCorrect = isCorrect;
    }

    protected AnswerOption(Parcel in) {
        optionValue = in.readString();
        isCorrect = in.readByte() != 0;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(optionValue);
        dest.writeByte((byte) (isCorrect ? 1 : 0));
    }
}
