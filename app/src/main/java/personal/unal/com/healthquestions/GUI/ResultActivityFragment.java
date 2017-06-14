package personal.unal.com.healthquestions.GUI;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import personal.unal.com.healthquestions.Data.GameEngine;
import personal.unal.com.healthquestions.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ResultActivityFragment extends Fragment {

    public static final String ARG_RESULTS = "results";

    public ResultActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_result, container, false);
        GameEngine gameEngine = getArguments().getParcelable(ARG_RESULTS);
        return rootView;
    }
}
