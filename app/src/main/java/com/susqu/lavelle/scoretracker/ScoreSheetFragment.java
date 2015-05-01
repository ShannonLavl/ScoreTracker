package com.susqu.lavelle.scoretracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Shannon on 3/23/2015.
 */
public class ScoreSheetFragment extends ListFragment {
    public static final String TAG = "ScoreSheetFragment";
    public static final String EXTRA_GAME_ID = "scoretracker.game_id";

    private static final int REQUEST_PLAYER1_SCORE = 0;
    private static final int REQUEST_PLAYER2_SCORE = 1;
    private static final int REQUEST_PLAYER3_SCORE = 2;
    private static final int REQUEST_PLAYER4_SCORE = 3;

    public static final String DIALOG_SCORE = "score";

    public UUID mGameID;
    public GamesList mGamesList;

    public int mNumPlayers = 4;
    public Player mPlayer1;
    public Player mPlayer2;
    public Player mPlayer3;
    public Player mPlayer4;

    public EditText mPlayer1EditText;
    public EditText mPlayer2EditText;
    public EditText mPlayer3EditText;
    public EditText mPlayer4EditText;

    public TextView mPlayer1Total;
    public TextView mPlayer2Total;
    public TextView mPlayer3Total;
    public TextView mPlayer4Total;

    public ArrayList<ArrayList<Integer>> mScores;


    private void updateTotalScores() {
        mPlayer1Total.setText(Integer.toString(mPlayer1.getTotalScore()));
        mPlayer2Total.setText(Integer.toString(mPlayer2.getTotalScore()));
        mPlayer3Total.setText(Integer.toString(mPlayer3.getTotalScore()));
        mPlayer4Total.setText(Integer.toString(mPlayer4.getTotalScore()));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPlayer1 = new Player("Shannon");
        mPlayer2 = new Player("Herman");
        mPlayer3 = new Player("Jon");
        mPlayer4 = new Player("Phil");

        mScores = new ArrayList<ArrayList<Integer>>();

        ScoresAdapter adapter = new ScoresAdapter(mScores);
        setListAdapter(adapter);

        // Get the information for this game
        mGameID = (UUID) getActivity().getIntent().getSerializableExtra(EXTRA_GAME_ID);
        mGamesList = GamesList.get(getActivity());

        getActivity().setTitle(mGamesList.getGame(mGameID).getName());

        setHasOptionsMenu(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_score_sheet, container, false);

        // Set up the EditTexts so the user can enter the players' names
        // Also lock the sizes of the EditTexts so the columns stay aligned
        mPlayer1EditText = (EditText) v.findViewById(R.id.P1_name);
        mPlayer1EditText.setWidth(mPlayer1EditText.getWidth());
        if (mPlayer1.getName() != null) {
            mPlayer1EditText.setText(mPlayer1.getName());
        }
        mPlayer1EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPlayer1.setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // do nothing
            }
        });

        mPlayer2EditText = (EditText) v.findViewById(R.id.P2_name);
        mPlayer2EditText.setWidth(mPlayer2EditText.getWidth());
        if (mPlayer2.getName() != null) {
            mPlayer2EditText.setText(mPlayer2.getName());
        }
        mPlayer2EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPlayer2.setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mPlayer3EditText = (EditText) v.findViewById(R.id.P3_name);
        mPlayer3EditText.setWidth(mPlayer3EditText.getWidth());
        if (mPlayer3.getName() != null) {
            mPlayer3EditText.setText(mPlayer3.getName());
        }
        mPlayer3EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPlayer3.setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mPlayer4EditText = (EditText) v.findViewById(R.id.P4_name);
        mPlayer4EditText.setWidth(mPlayer4EditText.getWidth());
        if (mPlayer4.getName() != null) {
            mPlayer4EditText.setText(mPlayer4.getName());
        }
        mPlayer4EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPlayer4.setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ListView listView = (ListView)v.findViewById(android.R.id.list);

        // get the TextViews that will display the players' total scores
        mPlayer1Total = (TextView) v.findViewById(R.id.P1_total);
        mPlayer2Total = (TextView) v.findViewById(R.id.P2_total);
        mPlayer3Total = (TextView) v.findViewById(R.id.P3_total);
        mPlayer4Total = (TextView) v.findViewById(R.id.P4_total);
        // lock the sizes of these textViews so they don't redistribute extra space as scores are entered
        mPlayer1Total.setWidth(mPlayer1Total.getWidth());
        mPlayer2Total.setWidth(mPlayer2Total.getWidth());
        mPlayer3Total.setWidth(mPlayer3Total.getWidth());
        mPlayer4Total.setWidth(mPlayer4Total.getWidth());
        // display updated totals for each player
        updateTotalScores();



        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_score_sheet, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_new_round:
                ScoresAdapter adapter = (ScoresAdapter) getListAdapter();
                // add a new row of scores to the score sheet
                ArrayList<Integer> round = new ArrayList<Integer>();
                for (int i = 0; i < mNumPlayers; i++) {
                    round.add(0);
                }
                mPlayer1.addRoundScore(0);
                mPlayer2.addRoundScore(0);
                mPlayer3.addRoundScore(0);
                mPlayer4.addRoundScore(0);
                mScores.add(round);
                adapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        int round = (int) data.getSerializableExtra(NumericalScoreEntryFragment.EXTRA_ROUND);
        int score = (int) data.getSerializableExtra(NumericalScoreEntryFragment.EXTRA_SCORE);
        switch (requestCode) {
            case REQUEST_PLAYER1_SCORE:
                mPlayer1.changeRoundScore(round, score);
                break;
            case REQUEST_PLAYER2_SCORE:
                mPlayer2.changeRoundScore(round, score);
                break;
            case REQUEST_PLAYER3_SCORE:
                mPlayer3.changeRoundScore(round, score);
                break;
            case REQUEST_PLAYER4_SCORE:
                mPlayer4.changeRoundScore(round, score);
                break;
            default:
        }

        ScoresAdapter adapter = (ScoresAdapter) getListAdapter();
        adapter.notifyDataSetChanged();
        updateTotalScores();
    }

    private class ScoresAdapter extends ArrayAdapter<ArrayList<Integer>> {
        public ScoresAdapter(ArrayList<ArrayList<Integer>> scores) {
            super(getActivity(), 0, scores);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            // if we weren't given a View, inflate one
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_scores, null);
            }

            // Configure the View for this round - a score for each player
            TextView player1ScoreTV = (TextView) convertView.findViewById(R.id.P1_score);
            player1ScoreTV.setWidth(player1ScoreTV.getWidth());
            player1ScoreTV.setText(Integer.toString(mPlayer1.getRoundScore(position)));
            player1ScoreTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "clicked player 1's score");
                    // create a Score Entry Dialog to accept Player1's score for this round
                    displayScoreEntryDialog(REQUEST_PLAYER1_SCORE, mPlayer1.getName(), position);

                }
            });
            TextView player2ScoreTV = (TextView) convertView.findViewById(R.id.P2_score);
            player2ScoreTV.setWidth(player2ScoreTV.getWidth());
            player2ScoreTV.setText(Integer.toString(mPlayer2.getRoundScore(position)));
            player2ScoreTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "clicked player 2's score");
                    // create a Score Entry Dialog to accept Player1's score for this round
                    displayScoreEntryDialog(REQUEST_PLAYER2_SCORE, mPlayer2.getName(), position);

                }
            });
            TextView player3ScoreTV = (TextView) convertView.findViewById(R.id.P3_score);
            player3ScoreTV.setWidth(player3ScoreTV.getWidth());
            player3ScoreTV.setText(Integer.toString(mPlayer3.getRoundScore(position)));
            player3ScoreTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "clicked player 3's score");
                    // create a Score Entry Dialog to accept Player1's score for this round
                    displayScoreEntryDialog(REQUEST_PLAYER3_SCORE, mPlayer3.getName(), position);
                }
            });
            TextView player4ScoreTV = (TextView) convertView.findViewById(R.id.P4_score);
            player4ScoreTV.setWidth(player4ScoreTV.getWidth());
            player4ScoreTV.setText(Integer.toString(mPlayer4.getRoundScore(position)));
            player4ScoreTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "clicked player 4's score");
                    // create a Score Entry Dialog to accept Player1's score for this round
                    displayScoreEntryDialog(REQUEST_PLAYER4_SCORE, mPlayer4.getName(), position);
                }
            });

            return convertView;
        }

        private void displayScoreEntryDialog(int requestCode, String playerName, int position) {
            // determines the appropriate score entry method for the chosen game
            // and displays a dialog

            ScoreEntryFragment dialog;

            switch(mGamesList.getGame(mGameID).getName()) {
                case "UNO":
                    dialog = UNOScoreEntryFragment.newInstance(playerName, position);
                    break;
                case "Rummy 500":
                    dialog = NumericalScoreEntryFragment.newInstance(playerName, position);
                    break;
                case "Crazy Eights":
                    dialog = CrazyEightsScoreEntryFragment.newInstance(playerName, position);
                    break;
                case "Creights":
                    dialog = CreightsScoreEntryFragment.newInstance(playerName, position);
                    break;
                case "Hearts":
                    dialog = HeartsScoreEntryFragment.newInstance(playerName, position);
                    break;
                case "Phase 10":
                    dialog = Phase10ScoreEntryFragment.newInstance(playerName, position);
                    break;
                case "Basic Score Sheet":
                default:
                    dialog = NumericalScoreEntryFragment.newInstance(playerName, position);
                    break;
            }

            FragmentManager fm = getActivity().getSupportFragmentManager();
            dialog.setTargetFragment(ScoreSheetFragment.this, requestCode);
            dialog.show(fm, DIALOG_SCORE);
        }
    }
}