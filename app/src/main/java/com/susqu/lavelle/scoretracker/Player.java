package com.susqu.lavelle.scoretracker;

import java.util.ArrayList;

/**
 * Created by Shannon on 3/24/2015.
 *
 * We assume that rounds start counting with 0
 */
public class Player {
    private String mName;
    private ArrayList<Integer> mScores;

    public Player() {
        mScores = new ArrayList<Integer>();
    }

    public Player(String name) {
        mName = name;
        mScores = new ArrayList<Integer>();
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getRoundScore(int round) {
        // check that the round asked for HAS a score
        if (round < mScores.size()) {
            return mScores.get(round);
        }
        else return 0;
    }

    public void addRoundScore(int score) {
        mScores.add(score);
    }

    public boolean changeRoundScore(int round, int score) {
        if (round < mScores.size()) {
            mScores.set(round, score);
            return true;
        }
        else return false;
    }

    public int getTotalScore() {
        int totalScore = 0;
        for (int s : mScores) {
            totalScore += s;
        }
        return totalScore;
    }
}