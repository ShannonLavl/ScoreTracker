package com.susqu.lavelle.scoretracker;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Shannon on 3/23/2015.
 */
public class ScoreSheetFragment extends ListFragment {
    public static final String TAG = "ScoreSheetFragment";
    public static final String EXTRA_GAME_ID = "scoretracker.game_id";

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

        mPlayer1 = new Player();
        mPlayer2 = new Player();
        mPlayer3 = new Player();
        mPlayer4 = new Player();


        mScores = new ArrayList<ArrayList<Integer>>();

        ScoresAdapter adapter = new ScoresAdapter(mScores);
        setListAdapter(adapter);


        // Get the information for this game

        setHasOptionsMenu(true);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_score_sheet, container, false);

        // Set up the EditTexts so the user can enter the players' names
        mPlayer1EditText = (EditText) v.findViewById(R.id.P1_name);
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






        mPlayer1Total = (TextView) v.findViewById(R.id.P1_total);
        mPlayer1Total.setText(Integer.toString(mPlayer1.getTotalScore()));
        mPlayer2Total = (TextView) v.findViewById(R.id.P2_total);
        mPlayer2Total.setText(Integer.toString(mPlayer2.getTotalScore()));
        mPlayer3Total = (TextView) v.findViewById(R.id.P3_total);
        mPlayer3Total.setText(Integer.toString(mPlayer3.getTotalScore()));
        mPlayer4Total = (TextView) v.findViewById(R.id.P4_total);
        mPlayer4Total.setText(Integer.toString(mPlayer4.getTotalScore()));

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

    private class ScoresAdapter extends ArrayAdapter<ArrayList<Integer>> {
        public ScoresAdapter(ArrayList<ArrayList<Integer>> scores) {
            super(getActivity(), 0, scores);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // if we weren't given a View, inflate one
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_scores, null);
            }

            // Configure the View for this round - a score for each player
            TextView player1ScoreTV = (TextView) convertView.findViewById(R.id.P1_score);
            player1ScoreTV.setText(Integer.toString(mPlayer1.getRoundScore(position)));
            player1ScoreTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "clicked player 1's score");
                }
            });
            TextView player2ScoreTV = (TextView) convertView.findViewById(R.id.P2_score);
            player2ScoreTV.setText(Integer.toString(mPlayer2.getRoundScore(position)));
            player2ScoreTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "clicked player 2's score");
                }
            });
            TextView player3ScoreTV = (TextView) convertView.findViewById(R.id.P3_score);
            player3ScoreTV.setText(Integer.toString(mPlayer3.getRoundScore(position)));
            player3ScoreTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "clicked player 3's score");
                }
            });
            TextView player4ScoreTV = (TextView) convertView.findViewById(R.id.P4_score);
            player4ScoreTV.setText(Integer.toString(mPlayer4.getRoundScore(position)));
            player4ScoreTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "clicked player 4's score");
                }
            });

            return convertView;
        }
    }

/*
    private class ScoresAdapter extends ArrayAdapter<Crime> {
        public CrimeAdapter(ArrayList<Crime> crimes) {
            super(getActivity(), 0, crimes);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // If we weren't given a View, inflate one
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_crime, null);
            }

            // Configure the view for this Crime
            Crime c = getItem(position);

            TextView titleTextView = (TextView) convertView.findViewById(R.id.crime_list_item_titleTextView);
            titleTextView.setText(c.getTitle());

            TextView dateTextView = (TextView) convertView.findViewById(R.id.crime_list_item_dateTextView);
            dateTextView.setText(c.getDateString() + " - " + c.getTimeString());

            CheckBox solvedCheckBox = (CheckBox) convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
            solvedCheckBox.setChecked(c.isSolved());

            return convertView;
        }
    }

    */
}
