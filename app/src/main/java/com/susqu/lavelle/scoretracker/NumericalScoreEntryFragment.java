package com.susqu.lavelle.scoretracker;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Shannon on 4/7/2015.
 */
public class NumericalScoreEntryFragment extends ScoreEntryFragment {

        public static NumericalScoreEntryFragment newInstance(String playerName, int round) {
        Bundle args = new Bundle();

        args.putSerializable(EXTRA_SCORE, 0);
        args.putSerializable(EXTRA_PLAYER, playerName);
        args.putSerializable(EXTRA_ROUND, round);

        NumericalScoreEntryFragment fragment = new NumericalScoreEntryFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mScore = (int) getArguments().getSerializable(EXTRA_SCORE);
        mPlayerName = (String) getArguments().getSerializable(EXTRA_PLAYER);
        mRound = (int) getArguments().getSerializable(EXTRA_ROUND);

        View v = getActivity().getLayoutInflater().inflate(R.layout.dialog_numerical_score_entry, null);

        // Set up EditText for the user to enter a score
        EditText ScoreEntryEditText = (EditText) v.findViewById(R.id.edit_scoreEntry);
        ScoreEntryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    // negative numbers
                    if (s.charAt(0) == '-') {
                        // only the - sign has been entered
                        if (s.length() == 1) {
                            mScore = -1;
                        }
                        // multiply the rest of the entry by -1
                        else {
                            mScore = -1*Integer.parseInt(s.subSequence(1, s.length()).toString());
                        }
                    }
                    // positive numbers
                    else {
                        mScore = Integer.parseInt(s.toString());
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle("Enter a score for " + mPlayerName + " for round " + (mRound + 1))
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sendResult(Activity.RESULT_OK);
                    }
                })
                .create();
    }

    @Override
    public void computeScore() {
    }
}
