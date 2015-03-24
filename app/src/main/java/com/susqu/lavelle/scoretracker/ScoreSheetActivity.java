package com.susqu.lavelle.scoretracker;

import android.support.v4.app.Fragment;

/**
 * Created by Shannon on 3/24/2015.
 */
public class ScoreSheetActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new ScoreSheetFragment();
    }
}
