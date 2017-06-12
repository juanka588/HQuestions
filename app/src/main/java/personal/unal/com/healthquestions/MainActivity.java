package personal.unal.com.healthquestions;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import personal.unal.com.healthquestions.Adapters.QuestionAdapter;
import personal.unal.com.healthquestions.Data.AnswerOption;
import personal.unal.com.healthquestions.GUI.HealthQuestionDialog;
import personal.unal.com.healthquestions.Interfaces.OnAnswerOptionClick;

public class MainActivity extends AppCompatActivity implements OnAnswerOptionClick {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private QuestionAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionsPagerAdapter = new QuestionAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


    }

    @Override
    public void onAnswerOptionClicked(final AnswerOption answerOption) {
        final HealthQuestionDialog dialog = new HealthQuestionDialog(this, R.drawable.logo, getString(R.string.action_settings)
                , getString(R.string.control_question), getString(R.string.option_yes), getString(R.string.option_no)
                , R.style.ThemeHQDialog);
        dialog.show();
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface d) {
                int selection = dialog.getSelection();
                if (selection == HealthQuestionDialog.SELECTION_POSITIVE) {
                    if (answerOption.isCorrect()) {
                        //mark as correct
                        //add a new page
                        //sum to score
                        //re init timers

                    } else {
                        //mark as error
                        //return to main window showing total score
                    }
                }
                //else do nothing
            }
        });
    }
}
