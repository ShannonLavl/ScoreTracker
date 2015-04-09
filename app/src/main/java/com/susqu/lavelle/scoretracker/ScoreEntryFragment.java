package com.susqu.lavelle.scoretracker;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Shannon on 4/7/2015.
 */
public class ScoreEntryFragment extends DialogFragment {
    public static final String EXTRA_SCORE = "com.susqu.lavelle.scoretracker.score";
    public static final String EXTRA_PLAYER = "com.susqu.lavelle.scoretracker.player";

    private int mScore = 0;
    private String mPlayerName;

    public static ScoreEntryFragment newInstance(String playerName) {
        Bundle args = new Bundle();

        args.putSerializable(EXTRA_SCORE, 0);
        args.putSerializable(EXTRA_PLAYER, playerName);

        ScoreEntryFragment fragment = new ScoreEntryFragment();
        fragment.setArguments(args);

        return fragment;
    }

    private void sendResult(int resultCode) {
        if (getTargetFragment() == null) {
            return;
        }

        Intent i = new Intent();
        i.putExtra(EXTRA_SCORE, mScore);
        i.putExtra(EXTRA_PLAYER, mPlayerName);

        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, i);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mScore = (int) getArguments().getSerializable(EXTRA_SCORE);
        mPlayerName = (String) getArguments().getSerializable(EXTRA_PLAYER);

        View v = getActivity().getLayoutInflater().inflate(R.layout.dialog_score_entry, null);

        // Set up EditText for the user to enter a score
        EditText ScoreEntryEditText = (EditText) v.findViewById(R.id.edit_scoreEntry);
        ScoreEntryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mScore = Integer.parseInt(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.score_entry_title + mPlayerName)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sendResult(Activity.RESULT_OK);
                    }
                })
                .create();
    }
}