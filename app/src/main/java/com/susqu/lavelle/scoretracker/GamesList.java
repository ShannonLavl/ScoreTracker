package com.susqu.lavelle.scoretracker;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Shannon on 3/24/2015.
 */
public class GamesList {
    public static final String TAG = "GamesList";

    public static GamesList sGamesList;
    private Context mAppContext;
    private ArrayList<Game> mGames;

    public GamesList(Context appContext) {
        mAppContext = appContext;
        mGames = new ArrayList<Game>();

        // populate the list of games
        createGameList();
    }

    public static GamesList get(Context c) {
        if (sGamesList == null) {
            sGamesList = new GamesList(c.getApplicationContext());
        }
        return sGamesList;
    }

    public ArrayList<Game> getGames() {
        return mGames;
    }

    public Game getGame(UUID id) {
        for (Game g : mGames) {
            if (g.getId().equals(id)) {
                return g;
            }
        }
        return null;
    }

    private void createGameList() {
        Game basicScoreSheet = new Game();
        basicScoreSheet.setName("Basic Score Sheet");
        mGames.add(basicScoreSheet);

        Game UNO = new Game();
        UNO.setName("UNO");
        mGames.add(UNO);

        Game Rummy500 = new Game();
        Rummy500.setName("Rummy 500");
        mGames.add(Rummy500);

        Game CrazyEights = new Game();
        CrazyEights.setName("Crazy Eights");
        mGames.add(CrazyEights);

        Game Creights = new Game();
        Creights.setName("Creights");
        mGames.add(Creights);

        Game Hearts = new Game();
        Hearts.setName("Hearts");
        mGames.add(Hearts);
    }
}
