package personal.unal.com.healthquestions.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import personal.unal.com.healthquestions.Data.AnswerOption;
import personal.unal.com.healthquestions.Data.Question;
import personal.unal.com.healthquestions.GUI.QuestionFragment;

/**
 * Created by JuanCamilo on 11/06/2017.
 */

public class QuestionAdapter extends FragmentPagerAdapter {

    private List<Question> questionList;

    public QuestionAdapter(FragmentManager fm) {
        super(fm);
        questionList = new ArrayList<>(15);
        Question q = new Question("¿Como me llamo?");
        q.getOptions().add(new AnswerOption("Carlos", false));
        q.getOptions().add(new AnswerOption("Laura", false));
        q.getOptions().add(new AnswerOption("Claudia", false));
        q.getOptions().add(new AnswerOption("Camilo", true));

        questionList.add(q);

        q = new Question("¿Otra Cosa?");
        q.getOptions().add(new AnswerOption("Carlos", false));
        q.getOptions().add(new AnswerOption("Laura", false));
        q.getOptions().add(new AnswerOption("Claudia", false));
        q.getOptions().add(new AnswerOption("Camilo", true));

        questionList.add(q);


        Collections.shuffle(questionList);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        //get items must be replaced with get question index i
        return QuestionFragment.newInstance(questionList.get(position));
    }

    @Override
    public int getCount() {
        //just 15 question between 20
        return questionList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "SECTION 1";
            case 1:
                return "SECTION 2";
            case 2:
                return "SECTION 3";
            default:
                return "NO SECTION";
        }
    }
}
