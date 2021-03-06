package com.susqu.lavelle.scoretracker;

import android.content.Intent;
import android.support.v4.app.DialogFragment;

/**
 * Created by Shannon on 4/14/2015.
 */
public abstract class ScoreEntryFragment extends DialogFragment {
    public static final String EXTRA_SCORE = "com.susqu.lavelle.scoretracker.score";
    public static final String EXTRA_ROUND = "com.susqu.lavelle.scoretracker.round";
    public static final String EXTRA_PLAYER = "com.susqu.lavelle.scoretracker.player";

    protected int mScore = 0;
    protected int mRound = 0;
    protected String mPlayerName;



    // to be implemented by subclasses
    // and called in sendResult
    // computes the final score and stores in mScore
    public abstract void computeScore();

    protected void sendResult(int resultCode) {
        if (getTargetFragment() == null) {
            return;
        }

        computeScore();

        Intent i = new Intent();
        i.putExtra(EXTRA_SCORE, mScore);
        i.putExtra(EXTRA_ROUND, mRound);

        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, i);
    }
}
