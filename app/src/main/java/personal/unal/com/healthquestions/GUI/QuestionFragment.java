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

    private Question mQuestion;
    private OnAnswerOptionClick mCallback;
    private Button timerBtn;

    public QuestionFragment() {

    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static QuestionFragment newInstance(Question question) {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_QUESTION, question);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.mQuestion = getArguments().getParcelable(ARG_QUESTION);

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        timerBtn = (Button) rootView.findViewById(R.id.timer);
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                timerBtn.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timerBtn.setText("done!");
            }
        }.start();

        TextView qStatement = (TextView) rootView.findViewById(R.id.question_statement);
        qStatement.setText(mQuestion.getStatement());

        Button optBtn1 = (Button) rootView.findViewById(R.id.option_1);
        optBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onAnswerOptionClicked(mQuestion.getOptions().get(0));
            }
        });

        Button optBtn2 = (Button) rootView.findViewById(R.id.option_2);
        optBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onAnswerOptionClicked(mQuestion.getOptions().get(1));
            }
        });

        Button optBtn3 = (Button) rootView.findViewById(R.id.option_3);
        optBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onAnswerOptionClicked(mQuestion.getOptions().get(2));
            }
        });

        Button optBtn4 = (Button) rootView.findViewById(R.id.option_4);
        optBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onAnswerOptionClicked(mQuestion.getOptions().get(3));
            }
        });

        optBtn1.setText(mQuestion.getOptions().get(0).getOptionValue());
        optBtn2.setText(mQuestion.getOptions().get(1).getOptionValue());
        optBtn3.setText(mQuestion.getOptions().get(2).getOptionValue());
        optBtn4.setText(mQuestion.getOptions().get(3).getOptionValue());
        return rootView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mCallback = (OnAnswerOptionClick) context;
    }
}

