package personal.unal.com.healthquestions.Data;

import android.content.Context;
import android.os.Parcel;

import personal.unal.com.healthquestions.GUI.HealthQuestionDialog;
import personal.unal.com.healthquestions.GUI.QuestionFragment;
import personal.unal.com.healthquestions.R;

/**
 * Created by Miguel on 13/06/2017.
 */

public class PublicHelp extends PowerUp {

    @Override
    public void showResult(QuestionFragment questionFragment, Question question) {
        Context context = questionFragment.getContext();
        StringBuilder content = new StringBuilder();
        double[] prob = new double[question.getOptions().size()];

        for (int i = 0; i < prob.length; i++) {
            prob[i] = 100 / prob.length;
            if (i == question.getCorrectIndex()) {
                prob[i] += 90;
            }
            prob[i] = (prob[i] / 190) * 100;
        }

        for (int k = 0; k < prob.length; k++) {
            int rn = (int) (Math.random() * prob.length), gain = (int) (Math.random() * 30);
            for (int i = 0; i < prob.length; i++) {
                if (i == rn) {
                    prob[i] += gain;
                }
                prob[i] = (prob[i] / (100 + gain)) * 100;
            }
        }

        for (int i = 0; i < prob.length; i++) {
            content.append("Answer ");
            content.append((i + 1));
            content.append(" has probability of ");
            content.append((prob[i] + "").substring(0, 4));
            content.append("% \n");
        }

        HealthQuestionDialog dialog = new HealthQuestionDialog(context,
                R.drawable.logo, context.getString(R.string.app_name), content.toString()
                , context.getString(R.string.string_acept), "", R.style.ThemeHQDialog);
        dialog.show();
    }
}
