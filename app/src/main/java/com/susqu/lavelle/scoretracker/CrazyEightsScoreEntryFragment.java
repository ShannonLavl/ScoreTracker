package com.susqu.lavelle.scoretracker;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * Created by Shannon on 4/16/2015.
 */
public class CrazyEightsScoreEntryFragment extends ScoreEntryFragment {
    public static CrazyEightsScoreEntryFragment newInstance(String playerName, int round) {
        Bundle args = new Bundle();

        args.putSerializable(EXTRA_SCORE, 0);
        args.putSerializable(EXTRA_PLAYER, playerName);
        args.putSerializable(EXTRA_ROUND, round);

        CrazyEightsScoreEntryFragment fragment = new CrazyEightsScoreEntryFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }
}
