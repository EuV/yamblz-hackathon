package ru.yandex.yamblz.euv.hackathon.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ru.yandex.yamblz.euv.hackathon.Loader;
import ru.yandex.yamblz.euv.hackathon.R;
import ru.yandex.yamblz.euv.hackathon.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            return;
        }

        Loader.getInstance().updateWords();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, MainFragment.newInstance())
                .commit();
    }
}
