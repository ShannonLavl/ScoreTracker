package com.susqu.lavelle.scoretracker;

/**
 * Created by Shannon on 3/19/2015.
 */
import android.support.v4.app.Fragment;

/**
 * Created by Shannon on 2/5/2015.
 */
public class GameListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new GameListFragment();
    }
}
