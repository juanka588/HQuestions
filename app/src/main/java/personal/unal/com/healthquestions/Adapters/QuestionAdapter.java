package personal.unal.com.healthquestions.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import personal.unal.com.healthquestions.Data.PowerUp;
import personal.unal.com.healthquestions.Data.Question;
import personal.unal.com.healthquestions.GUI.QuestionFragment;

/**
 * Created by JuanCamilo on 11/06/2017.
 */

public class QuestionAdapter extends FragmentPagerAdapter {

    private List<Question> questionList;
    private ArrayList<PowerUp> powers;

    public QuestionAdapter(FragmentManager fm, List<Question> questionList, ArrayList<PowerUp> powers) {
        super(fm);
        this.questionList = questionList;
        this.powers = powers;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        //get items must be replaced with get question index i
        return QuestionFragment.newInstance(questionList.get(position), powers, 0);
    }

    @Override
    public int getCount() {
        //just 15 question between 20
        return 1;
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
