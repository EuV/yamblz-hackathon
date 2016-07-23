package ru.yandex.yamblz.euv.hackathon.activity;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Window;
import android.view.WindowManager;

import ru.yandex.yamblz.euv.hackathon.Loader;
import ru.yandex.yamblz.euv.hackathon.R;
import ru.yandex.yamblz.euv.hackathon.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            return;
        }
        //небольши хаки так бытрее
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setColor(Color.parseColor("#ffdd60"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        getSupportActionBar().setTitle((Html.fromHtml("<font color=\"#22222\">" + "Режим обучения" + "</font>")));
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(Color.parseColor("#eecc50"));

        Loader.getInstance().updateWords();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, MainFragment.newInstance())
                .commit();
    }
}
