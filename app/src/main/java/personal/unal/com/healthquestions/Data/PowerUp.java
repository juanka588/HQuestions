package personal.unal.com.healthquestions.Data;

import android.os.Parcel;
import android.os.Parcelable;

import personal.unal.com.healthquestions.GUI.QuestionFragment;

/**
 * Created by Miguel on 13/06/2017.
 */

public class PowerUp implements Parcelable {
    private boolean used;

    public PowerUp() {
        setUsed(false);
    }

    public static final Creator<PowerUp> CREATOR = new Creator<PowerUp>() {
        @Override
        public PowerUp createFromParcel(Parcel in) {
            return new PowerUp(in);
        }

        @Override
        public PowerUp[] newArray(int size) {
            return new PowerUp[size];
        }
    };


    public void showResult(QuestionFragment questionFragment, Question question) {
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (isUsed() ? 1 : 0));
    }

    protected PowerUp(Parcel in) {
        setUsed(in.readByte() != 0);
    }
}
