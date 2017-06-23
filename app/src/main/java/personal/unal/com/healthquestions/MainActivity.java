package personal.unal.com.healthquestions;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import personal.unal.com.healthquestions.Data.AnswerOption;
import personal.unal.com.healthquestions.Data.GameEngine;
import personal.unal.com.healthquestions.GUI.HealthQuestionDialog;
import personal.unal.com.healthquestions.GUI.QuestionFragment;
import personal.unal.com.healthquestions.GUI.ResultActivity;
import personal.unal.com.healthquestions.Interfaces.OnAnswerOptionClick;

import static personal.unal.com.healthquestions.GUI.ResultActivityFragment.ARG_RESULTS;

public class MainActivity extends AppCompatActivity implements OnAnswerOptionClick {

    private GameEngine gameEngine;

    private int currentQuestion = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameEngine = new GameEngine("Juan", 0, 0);
        gameEngine.initGame();

        refreshScreen();
    }

    private void refreshScreen() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container
                , QuestionFragment.newInstance(gameEngine.getQuestionList().get(currentQuestion)
                        , gameEngine.getPowers(), gameEngine.getScore()));
        fragmentTransaction.commit();
    }

    @Override
    public void onAnswerOptionClicked(final AnswerOption answerOption, final CountDownTimer timer) {
        final HealthQuestionDialog dialog = new HealthQuestionDialog(this, R.drawable.logo, null
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

                        //sum to score
                        gameEngine.setScore(gameEngine.getScore() + 10);
                        gameEngine.setProgress(gameEngine.getProgress() + 1);
                        //re init timers
                        timer.cancel();
                        //add new question
                        addNewQuestion();
                    } else {
                        //mark as error
                        //return to main window showing total score
                        timer.cancel();
                        finishGame();
                    }
                }
                //else do nothing
            }
        });
    }

    private void addNewQuestion() {
        //add a new page
        currentQuestion++;
        if (gameEngine.getProgress() == gameEngine.getTotal() || currentQuestion >= gameEngine.getQuestionList().size()) {
            finishGame();
            return;
        }
        HealthQuestionDialog dialog = new HealthQuestionDialog(this, R.drawable.logo, null
                , getString(R.string.correct_answer), getString(R.string.next_question), ""
                , R.style.ThemeHQDialog);
        dialog.show();
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface d) {
                refreshScreen();
            }
        });
    }

    @Override
    public void skipQuestion() {
        addNewQuestion();
        gameEngine.setTotal(gameEngine.getTotal() + 1);
    }

    @Override
    public void finishGame() {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(ARG_RESULTS, gameEngine);
        startActivity(intent);
        this.finish();
    }

}
