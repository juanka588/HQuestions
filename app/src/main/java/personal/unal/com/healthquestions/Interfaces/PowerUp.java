package personal.unal.com.healthquestions.Interfaces;

import android.content.Context;

import personal.unal.com.healthquestions.Data.Question;

/**
 * Created by JuanCamilo on 11/06/2017.
 */

public interface PowerUp {
    /**
     *
     * @param question
     * modifies the question option or the question itself
     */
    void apply(Question question);

    /**
     *
     * @param context show the power help result in the screen
     */
    void showResult(Context context);
}
