package personal.unal.com.healthquestions;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import personal.unal.com.healthquestions.Adapters.QuestionAdapter;
import personal.unal.com.healthquestions.Data.AnswerOption;
import personal.unal.com.healthquestions.Data.GameEngine;
import personal.unal.com.healthquestions.GUI.HealthQuestionDialog;
import personal.unal.com.healthquestions.GUI.ResultActivity;
import personal.unal.com.healthquestions.Interfaces.OnAnswerOptionClick;

import static personal.unal.com.healthquestions.GUI.ResultActivityFragment.ARG_RESULTS;

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

    private GameEngine gameEngine;

    private int currentQuestion = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameEngine = new GameEngine("Juan", 0, 0);
        gameEngine.initGame();

        mSectionsPagerAdapter = new QuestionAdapter(getSupportFragmentManager()
                , gameEngine.getQuestionList(), gameEngine.getPowers());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }

    @Override
    public void onAnswerOptionClicked(final AnswerOption answerOption, final CountDownTimer timer) {
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
                        mSectionsPagerAdapter.setItems(currentQuestion + 1);
                        //sum to score
                        gameEngine.setScore(gameEngine.getScore() + 10);
                        currentQuestion++;
                        //re init timers
                        timer.cancel();
                        addNewQuestion();


                    } else {
                        //mark as error
                        //return to main window showing total score
                        finishGame();
                    }
                }
                //else do nothing
            }
        });
    }

    private void addNewQuestion() {
        currentQuestion++;
        if (currentQuestion == gameEngine.getTotal()) {
            finishGame();
            return;
        }
        mViewPager.setCurrentItem(currentQuestion);
    }

    @Override
    public void skipQuestion() {
        Toast.makeText(this.getApplicationContext(), "callback called", Toast.LENGTH_LONG).show();
        addNewQuestion();
    }

    @Override
    public void finishGame() {
        Toast.makeText(this.getApplicationContext(), "must show statics and go to main", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(ARG_RESULTS, gameEngine);
        startActivity(intent);
        this.finish();
    }

}
