package com.susqu.lavelle.scoretracker;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Shannon on 4/29/2015.
 */
public class Phase10ScoreEntryFragment extends ScoreEntryFragment {

    int mNum5s = 0;
    int mNum10s = 0;
    int mNum15s = 0;
    int mNum25s = 0;

    TextView mNum5sView;
    TextView mNum10sView;
    TextView mNum15sView;
    TextView mNum25sView;

    public static Phase10ScoreEntryFragment newInstance(String playerName, int round) {
        Bundle args = new Bundle();

        args.putSerializable(EXTRA_SCORE, 0);
        args.putSerializable(EXTRA_PLAYER, playerName);
        args.putSerializable(EXTRA_ROUND, round);

        Phase10ScoreEntryFragment fragment = new Phase10ScoreEntryFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mScore = (int) getArguments().getSerializable(EXTRA_SCORE);
        mPlayerName = (String) getArguments().getSerializable(EXTRA_PLAYER);
        mRound = (int) getArguments().getSerializable(EXTRA_ROUND);

        View v = getActivity().getLayoutInflater().inflate(R.layout.dialog_phase10_score_entry, null);

        mNum5sView = (TextView) v.findViewById(R.id.text_num5s);
        mNum5sView.setText(Integer.toString(mNum5s));
        mNum5sView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNum5s++;
                mNum5sView.setText(Integer.toString(mNum5s));
            }
        });

        mNum10sView = (TextView) v.findViewById(R.id.text_num10s);
        mNum10sView.setText(Integer.toString(mNum10s));
        mNum10sView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNum10s++;
                mNum10sView.setText(Integer.toString(mNum10s));
            }
        });

        mNum15sView = (TextView) v.findViewById(R.id.text_num15s);
        mNum15sView.setText(Integer.toString(mNum15s));
        mNum15sView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNum15s++;
                mNum15sView.setText(Integer.toString(mNum15s));
            }
        });

        mNum25sView = (TextView) v.findViewById(R.id.text_num25s);
        mNum25sView.setText(Integer.toString(mNum25s));
        mNum25sView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNum25s++;
                mNum25sView.setText(Integer.toString(mNum25s));
            }
        });

        Button clearButton = (Button) v.findViewById(R.id.button_clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNum5s = 0;
                mNum5sView.setText(Integer.toString(mNum5s));
                mNum10s = 0;
                mNum10sView.setText(Integer.toString(mNum10s));
                mNum15s = 0;
                mNum15sView.setText(Integer.toString(mNum15s));
                mNum25s = 0;
                mNum25sView.setText(Integer.toString(mNum25s));
            }
        });

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle("Input " + mPlayerName + "'s cards for Round " + (mRound + 1))
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
        mScore = 0;
        mScore += 5*mNum5s;
        mScore += 10*mNum10s;
        mScore += 15*mNum15s;
        mScore += 25*mNum25s;
    }
}
