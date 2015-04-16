package com.susqu.lavelle.scoretracker;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * Created by Shannon on 4/16/2015.
 */
public class RummyScoreEntryFragment extends ScoreEntryFragment {

    public static RummyScoreEntryFragment newInstance(String playerName, int round) {
        Bundle args = new Bundle();

        args.putSerializable(EXTRA_SCORE, 0);
        args.putSerializable(EXTRA_PLAYER, playerName);
        args.putSerializable(EXTRA_ROUND, round);

        RummyScoreEntryFragment fragment = new RummyScoreEntryFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }
}
