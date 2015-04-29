package com.susqu.lavelle.scoretracker;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by Shannon on 4/16/2015.
 */
public class HeartsScoreEntryFragment extends ScoreEntryFragment {
    Boolean gets26Points = false;
    Boolean gets13Points = false;
    int mNumHearts = 0;

    TextView mNumHeartsView;
    CheckBox mQueenSpades;
    CheckBox mShotTheMoon;

    public static HeartsScoreEntryFragment newInstance(String playerName, int round) {
        Bundle args = new Bundle();

        args.putSerializable(EXTRA_SCORE, 0);
        args.putSerializable(EXTRA_PLAYER, playerName);
        args.putSerializable(EXTRA_ROUND, round);

        HeartsScoreEntryFragment fragment = new HeartsScoreEntryFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mScore = (int) getArguments().getSerializable(EXTRA_SCORE);
        mPlayerName = (String) getArguments().getSerializable(EXTRA_PLAYER);
        mRound = (int) getArguments().getSerializable(EXTRA_ROUND);

        View v = getActivity().getLayoutInflater().inflate(R.layout.dialog_hearts_score_entry, null);

        // wire up buttons and checkboxes
        mNumHeartsView = (TextView) v.findViewById(R.id.text_numHearts);
        mNumHeartsView.setText(Integer.toString(mNumHearts));
        mNumHeartsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNumHearts++;
                mNumHeartsView.setText(Integer.toString(mNumHearts));
            }
        });

        Button clearButton = (Button) v.findViewById(R.id.button_clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNumHearts = 0;
                mNumHeartsView.setText(Integer.toString(mNumHearts));
            }
        });

        mQueenSpades = (CheckBox) v.findViewById(R.id.checkbox_queen);

        mShotTheMoon = (CheckBox) v.findViewById(R.id.checkbox_shoot);

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
        mScore += mNumHearts;
        if (mShotTheMoon.isChecked()) {
            mScore = 26;
        }
        else if (mQueenSpades.isChecked()) {
            mScore += 13;
        }
     }
}
