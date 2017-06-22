package personal.unal.com.healthquestions.GUI;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import personal.unal.com.healthquestions.Data.PowerUp;
import personal.unal.com.healthquestions.Data.Question;
import personal.unal.com.healthquestions.Interfaces.OnAnswerOptionClick;
import personal.unal.com.healthquestions.R;

/**
 * Created by JuanCamilo on 11/06/2017.
 */

public class QuestionFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_QUESTION = "question";
    private static final String ARG_POWERS = "powers";

    private Question mQuestion;
    private OnAnswerOptionClick mCallback;
    private Button timerBtn, optBtn1, optBtn2, optBtn3, optBtn4;

    private Button removeOps, publicHelp, skipBtn;

    private TextView qStatement;
    private List<PowerUp> powers;

    private CountDownTimer timer;

    public QuestionFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static QuestionFragment newInstance(Question question, ArrayList<PowerUp> powers) {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_QUESTION, question);
        args.putParcelableArrayList(ARG_POWERS, powers);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.mQuestion = getArguments().getParcelable(ARG_QUESTION);
        this.powers = getArguments().getParcelableArrayList(ARG_POWERS);

        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        associateControls(rootView);

        bindData();

        return rootView;
    }

    private void associateControls(View rootView) {
        timerBtn = (Button) rootView.findViewById(R.id.timer);
        timer = new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                timerBtn.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                mCallback.finishGame();
            }
        }.start();

        qStatement = (TextView) rootView.findViewById(R.id.question_statement);

        optBtn1 = (Button) rootView.findViewById(R.id.option_1);
        optBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onAnswerOptionClicked(mQuestion.getOptions().get(0), timer);
            }
        });

        optBtn2 = (Button) rootView.findViewById(R.id.option_2);
        optBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onAnswerOptionClicked(mQuestion.getOptions().get(1), timer);
            }
        });

        optBtn3 = (Button) rootView.findViewById(R.id.option_3);
        optBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onAnswerOptionClicked(mQuestion.getOptions().get(2), timer);
            }
        });

        optBtn4 = (Button) rootView.findViewById(R.id.option_4);
        optBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onAnswerOptionClicked(mQuestion.getOptions().get(3), timer);
            }
        });

        removeOps = (Button) rootView.findViewById(R.id.removeOps);
        removeOps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!powers.get(0).isUsed()) {
                    powers.get(0).showResult(QuestionFragment.this, mQuestion);
                    powers.get(0).setUsed(true);
                }
            }
        });
        publicHelp = (Button) rootView.findViewById(R.id.public_help);
        publicHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!powers.get(1).isUsed()) {
                    powers.get(1).showResult(QuestionFragment.this, mQuestion);
                    powers.get(1).setUsed(true);
                }
            }
        });
        skipBtn = (Button) rootView.findViewById(R.id.skip_button);
        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (powers.get(2).isUsed()) {
                    return;
                }
                mCallback.skipQuestion();
                powers.get(2).setUsed(true);
            }
        });
    }


    public void bindData() {
        qStatement.setText(mQuestion.getStatement());
        if (mQuestion.getStatement().length() > 30) {
            qStatement.setTextSize(12);
        }

        optBtn1.setText(mQuestion.getOptions().get(0).getOptionValue());
        if (mQuestion.getOptions().get(0).getOptionValue().length() > 30) {
            optBtn1.setTextSize(12);
        }
        optBtn2.setText(mQuestion.getOptions().get(1).getOptionValue());
        if (mQuestion.getOptions().get(1).getOptionValue().length() > 30) {
            optBtn2.setTextSize(12);
        }

        optBtn3.setText(mQuestion.getOptions().get(2).getOptionValue());
        if (mQuestion.getOptions().get(2).getOptionValue().length() > 30) {
            optBtn3.setTextSize(12);
        }

        optBtn4.setText(mQuestion.getOptions().get(3).getOptionValue());

        if (mQuestion.getOptions().get(3).getOptionValue().length() > 30) {
            optBtn4.setTextSize(12);
        }

        if (powers.get(0).isUsed()) {
            removeOps.setEnabled(false);
        }
        if (powers.get(1).isUsed()) {
            publicHelp.setEnabled(false);
        }
        if (powers.get(2).isUsed()) {
            skipBtn.setEnabled(false);
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mCallback = (OnAnswerOptionClick) context;
    }
}

