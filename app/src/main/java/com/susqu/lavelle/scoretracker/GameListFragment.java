package com.susqu.lavelle.scoretracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Shannon on 2/5/2015.
 */
public class GameListFragment extends ListFragment {
    private static final String TAG = "GameListFragment";
    private ArrayList<Game> mGames;
    private Button mAddGameButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setHasOptionsMenu(true);

        getActivity().setTitle(R.string.list_instruction);

        // load the list of Games:
        mGames = GamesList.get(getActivity()).getGames();

        GameAdapter adapter = new GameAdapter(mGames);
        setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.game_list, container, false);

        // Wire up AddGameButton
/*        mAddGameButton = (Button) v.findViewById(R.id.add_game_button);
        mAddGaimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Crime crime = new Crime();
                CrimeLab.get(getActivity()).addCrime(crime);
                Intent i = new Intent(getActivity(), CrimePagerActivity.class);
                i.putExtra(CrimeFragment.EXTRA_CRIME_ID, crime.getId());
                startActivityForResult(i, 0);
            }
        }); */

      return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((GameAdapter) getListAdapter()).notifyDataSetChanged();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Get the Crime from the adapter
        Game g = ((GameAdapter)getListAdapter()).getItem(position);

        // Start the Scoring Activity for this Game
        Intent i = new Intent(getActivity(), ScoreSheetActivity.class);
        i.putExtra(ScoreSheetFragment.EXTRA_GAME_ID, g.getId());
        startActivity(i);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {


        // the user has just added a new game to the list
        ((GameAdapter)getListAdapter()).notifyDataSetChanged();
    }

/*    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        // inflate the menu:       //inflater.inflate(R.menu.fragment_crime_list, menu);
    } */

/*    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_new_crime:
                Crime crime = new Crime();
                CrimeLab.get(getActivity()).addCrime(crime);
                Intent i = new Intent(getActivity(), CrimePagerActivity.class);
                i.putExtra(CrimeFragment.EXTRA_CRIME_ID, crime.getId());
                startActivityForResult(i, 0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

        return super.onOptionsItemSelected(item);
    }*/

    private class GameAdapter extends ArrayAdapter<Game> {
        public GameAdapter(ArrayList<Game> games) {
            super(getActivity(), 0, games);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // If we weren't given a View, inflate one
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_game, null);
            }

            // Configure the view for this Game
            Game g = getItem(position);

            TextView titleTextView = (TextView) convertView.findViewById(R.id.game_list_item_titleTextView);
            titleTextView.setText(g.getName());

            return convertView;
        }
    }
}
