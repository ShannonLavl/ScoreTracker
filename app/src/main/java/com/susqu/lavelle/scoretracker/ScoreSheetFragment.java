package com.susqu.lavelle.scoretracker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Shannon on 3/23/2015.
 */
public class ScoreSheetFragment extends Fragment {
    public static final String EXTRA_GAME_ID = "scoretracker.game_id";


/*    public static ScoreSheetFragment newInstance(UUID gameId) {
        Bundle args = new Bundle();
        //args.putSerializable(EXTRA_CRIME_ID, crimeId);

        ScoreSheetFragment fragment = new ScoreSheetFragment();
        fragment.setArguments(args);

        return fragment;
    }  */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the information for this game

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_score_sheet, container, false);



        return v;
    }
}
