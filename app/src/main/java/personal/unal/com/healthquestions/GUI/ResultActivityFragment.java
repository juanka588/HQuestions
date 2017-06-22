package personal.unal.com.healthquestions.GUI;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import personal.unal.com.healthquestions.Data.GameEngine;
import personal.unal.com.healthquestions.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ResultActivityFragment extends Fragment {

    public static final String ARG_RESULTS = "results";
    private TextView playerName, totalScore, totalPowers, progress;
    private GameEngine gameEngine;

    public ResultActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_result, container, false);
        gameEngine = getArguments().getParcelable(ARG_RESULTS);
        playerName = (TextView) rootView.findViewById(R.id.player_name);
        totalScore = (TextView) rootView.findViewById(R.id.total_score);
        totalPowers = (TextView) rootView.findViewById(R.id.powers_used);
        progress = (TextView) rootView.findViewById(R.id.total_questions);
        bindData();
        return rootView;
    }

    private void bindData() {
        playerName.setText(gameEngine.getPlayerName());
        totalScore.setText("Puntaje Total: " + gameEngine.getScore());
        totalPowers.setText("Ayudas Usadas: " + gameEngine.getUsedPowers());
        progress.setText("Progreso: " + gameEngine.getProgress());
    }
}
