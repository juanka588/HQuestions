package personal.unal.com.healthquestions.Interfaces;

import android.os.CountDownTimer;

import personal.unal.com.healthquestions.Data.AnswerOption;

/**
 * Created by JuanCamilo on 11/06/2017.
 */

public interface OnAnswerOptionClick {

    void onAnswerOptionClicked(AnswerOption answerOption, CountDownTimer timer);

    void skipQuestion();

    void finishGame();
}
