package ru.yandex.yamblz.euv.hackathon.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.yandex.yamblz.euv.hackathon.fragment.MainFragment;
import ru.yandex.yamblz.euv.hackathon.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            return;
        }

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, MainFragment.newInstance())
                .commit();
    }
}
