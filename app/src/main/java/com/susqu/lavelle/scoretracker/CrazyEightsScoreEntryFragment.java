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
 * Created by Shannon on 4/16/2015.
 */
public class CrazyEightsScoreEntryFragment extends ScoreEntryFragment {

    int mNumAces;
    int mNumTwos;
    int mNumThrees;
    int mNumFours;
    int mNumFives;
    int mNumSixes;
    int mNumSevens;
    int mNumEights;
    int mNumNines;
    int mNumTens;
    int mNumJQKs;

    TextView mNumAcesView;
    TextView mNumTwosView;
    TextView mNumThreesView;
    TextView mNumFoursView;
    TextView mNumFivesView;
    TextView mNumSixesView;
    TextView mNumSevensView;
    TextView mNumEightsView;
    TextView mNumNinesView;
    TextView mNumTensView;
    TextView mNumJQKsView;

    void updateTextView(int n, boolean inc) {
        switch (n) {
            case 1:
                if (inc) {
                    mNumAces++;
                }
                else mNumAces = 0;
                mNumAcesView.setText(Integer.toString(mNumAces));
                break;
            case 2:
                if (inc) {
                    mNumTwos++;
                }
                else mNumTwos = 0;
                mNumTwosView.setText(Integer.toString(mNumTwos));
                break;
            case 3:
                if (inc) {
                    mNumThrees++;
                }
                else mNumThrees = 0;
                mNumThreesView.setText(Integer.toString(mNumThrees));
                break;
            case 4:
                if (inc) {
                    mNumFours++;
                }
                else mNumFours = 0;
                mNumFoursView.setText(Integer.toString(mNumFours));
                break;
            case 5:
                if (inc) {
                    mNumFives++;
                }
                else mNumFives = 0;
                mNumFivesView.setText(Integer.toString(mNumFives));
                break;
            case 6:
                if (inc) {
                    mNumSixes++;
                }
                else mNumSixes = 0;
                mNumSixesView.setText(Integer.toString(mNumSixes));
                break;
            case 7:
                if (inc) {
                    mNumSevens++;
                }
                else mNumSevens = 0;
                mNumSevensView.setText(Integer.toString(mNumSevens));
                break;
            case 8:
                if (inc) {
                    mNumEights++;
                }
                else mNumEights = 0;
                mNumEightsView.setText(Integer.toString(mNumEights));
                break;
            case 9:
                if (inc) {
                    mNumNines++;
                }
                else mNumNines = 0;
                mNumNinesView.setText(Integer.toString(mNumNines));
                break;
            case 10:
                if (inc) {
                    mNumTens++;
                }
                else mNumTens = 0;
                mNumTensView.setText(Integer.toString(mNumTens));
                break;
            case 13:
                if (inc) {
                    mNumJQKs++;
                }
                else mNumJQKs = 0;
                mNumJQKsView.setText(Integer.toString(mNumJQKs));
                break;
            default:
                break;
        }
    }

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
        mScore = (int) getArguments().getSerializable(EXTRA_SCORE);
        mPlayerName = (String) getArguments().getSerializable(EXTRA_PLAYER);
        mRound = (int) getArguments().getSerializable(EXTRA_ROUND);

        View v = getActivity().getLayoutInflater().inflate(R.layout.dialog_crazy_eights_score_entry, null);

        // wire up buttons
        mNumAcesView = (TextView) v.findViewById(R.id.text_numAs);
        updateTextView(1, false);
        mNumAcesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTextView(1, true);
            }
        });
        //------------------------------------------------------------------------
        mNumTwosView = (TextView) v.findViewById(R.id.text_num2s);
        updateTextView(2, false);
        mNumTwosView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTextView(2, true);
            }
        });
        //------------------------------------------------------------------------
        mNumThreesView = (TextView) v.findViewById(R.id.text_num3s);
        updateTextView(3, false);
        mNumThreesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTextView(3, true);
            }
        });
        //------------------------------------------------------------------------
        mNumFoursView = (TextView) v.findViewById(R.id.text_num4s);
        updateTextView(4, false);
        mNumFoursView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTextView(4, true);
            }
        });
        //------------------------------------------------------------------------
        mNumFivesView = (TextView) v.findViewById(R.id.text_num5s);
        updateTextView(5, false);
        mNumFivesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTextView(5, true);
            }
        });
        //------------------------------------------------------------------------
        mNumSixesView = (TextView) v.findViewById(R.id.text_num6s);
        updateTextView(6, false);
        mNumSixesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTextView(6, true);
            }
        });
        //------------------------------------------------------------------------
        mNumSevensView = (TextView) v.findViewById(R.id.text_num7s);
        updateTextView(7, false);
        mNumSevensView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTextView(7, true);
            }
        });
        //------------------------------------------------------------------------
        mNumEightsView = (TextView) v.findViewById(R.id.text_num8s);
        updateTextView(8, false);
        mNumEightsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTextView(8, true);
            }
        });
        //------------------------------------------------------------------------
        mNumNinesView = (TextView) v.findViewById(R.id.text_num9s);
        updateTextView(9, false);
        mNumNinesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTextView(9, true);
            }
        });
        //------------------------------------------------------------------------
        mNumTensView = (TextView) v.findViewById(R.id.text_num10s);
        updateTextView(10, false);
        mNumTensView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTextView(10, true);
            }
        });
        //------------------------------------------------------------------------
        mNumJQKsView = (TextView) v.findViewById(R.id.text_numJQKs);
        updateTextView(13, false);
        mNumJQKsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTextView(13, true);
            }
        });
        //------------------------------------------------------------------------
        Button clearButton = (Button) v.findViewById(R.id.button_clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTextView(1, false);
                updateTextView(2, false);
                updateTextView(3, false);
                updateTextView(4, false);
                updateTextView(5, false);
                updateTextView(6, false);
                updateTextView(7, false);
                updateTextView(8, false);
                updateTextView(9, false);
                updateTextView(10, false);
                updateTextView(13, false);
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
        mScore = 0;
        mScore += 1*mNumAces;
        mScore += 2*mNumTwos;
        mScore += 3*mNumThrees;
        mScore += 4*mNumFours;
        mScore += 5*mNumFives;
        mScore += 6*mNumSixes;
        mScore += 7*mNumSevens;
        mScore += 50*mNumEights;
        mScore += 9*mNumNines;
        mScore += 10*mNumTens;
        mScore += 10*mNumJQKs;
    }
}
