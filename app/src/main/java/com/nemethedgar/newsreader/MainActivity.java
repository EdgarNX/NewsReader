package com.nemethedgar.newsreader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.nemethedgar.newsreader.fragment.NewsListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, NewsListFragment.newInstance())
                    .commitNow();
        }
    }
}