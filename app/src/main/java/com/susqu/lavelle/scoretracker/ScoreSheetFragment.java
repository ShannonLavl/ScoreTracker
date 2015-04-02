package com.susqu.lavelle.scoretracker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Shannon on 3/23/2015.
 */
public class ScoreSheetFragment extends Fragment {
    public static final String EXTRA_GAME_ID = "scoretracker.game_id";

    public Player player1;
    public Player player2;
    public Player player3;
    public Player player4;

    public ArrayList<ArrayList<TextView>> Scores;


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

        player1 = new Player("Shannon");
        player2 = new Player("Jon");
        player3 = new Player("Phil");
        player4 = new Player("Herman");

        Scores = new ArrayList<ArrayList<TextView>>();
        // Get the information for this game

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_score_sheet, container, false);

        // Set up the EditTexts so the user can enter the players' names
        EditText player1EditText = (EditText) v.findViewById(R.id.P1_name);
        if (player1.getName() != null) {
            player1EditText.setText(player1.getName());
        }
        player1EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                player1.setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        EditText player2EditText = (EditText) v.findViewById(R.id.P2_name);
        if (player2.getName() != null) {
            player2EditText.setText(player2.getName());
        }
        player2EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                player2.setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        EditText player3EditText = (EditText) v.findViewById(R.id.P3_name);
        if (player3.getName() != null) {
            player3EditText.setText(player3.getName());
        }
        player3EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                player3.setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        EditText player4EditText = (EditText) v.findViewById(R.id.P4_name);
        if (player4.getName() != null) {
            player4EditText.setText(player4.getName());
        }
        player4EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                player4.setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

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
                // add a new row of scores to the score sheet



 /*               Crime crime = new Crime();
                CrimeLab.get(getActivity()).addCrime(crime);
                Intent i = new Intent(getActivity(), CrimePagerActivity.class);
                i.putExtra(CrimeFragment.EXTRA_CRIME_ID, crime.getId());
                startActivityForResult(i, 0); */
                return true;
            default:
                return super.onOptionsItemSelected(item);
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
