package com.susqu.lavelle.scoretracker;

import java.util.UUID;

/**
 * Created by Shannon on 3/19/2015.
 */
public class Game {
    private UUID mId;
    private String mName;
    private String mScoreLayoutFilename;
    private String mImageFilename;

    public Game() {
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getScoreLayoutFilename() {
        return mScoreLayoutFilename;
    }

    public void setScoreLayoutFilename(String mScoreLayoutFilename) {
        this.mScoreLayoutFilename = mScoreLayoutFilename;
    }

    public String getImageFilename() {
        return mImageFilename;
    }

    public void setImageFilename(String mImageFilename) {
        this.mImageFilename = mImageFilename;
    }
}
