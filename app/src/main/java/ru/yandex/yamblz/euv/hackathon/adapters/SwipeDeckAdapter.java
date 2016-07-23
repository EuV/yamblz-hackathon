package ru.yandex.yamblz.euv.hackathon.adapters;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import ru.yandex.speechkit.Vocalizer;
import ru.yandex.yamblz.euv.hackathon.R;

public class SwipeDeckAdapter extends BaseAdapter {
    private Context context;
    private final List<String> from;
    private final List<String> to;

    public SwipeDeckAdapter(Context context,List<String> from,List<String> to) {
        this.context = context;
        this.from = from;
        this.to = to;
    }

    @Override
    public int getCount() {
        return from.size();
    }

    @Override
    public Object getItem(int i) {
        return from.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //todo viewholders
    @Override
    public View getView(int i, View v, ViewGroup viewGroup) {
        CardView cardView= (CardView) LayoutInflater.from(context).inflate(R.layout.training_card_layout, viewGroup, false);
        TextView textView= (TextView) cardView.findViewById(R.id.card_text);
        textView.setText(from.get(i));
        TextView transText= (TextView) cardView.findViewById(R.id.card_text_trans);
        transText.setText(to.get(i));
        transText.setAlpha(0);
        cardView.setOnClickListener(view->{
            textView.clearAnimation();
            transText.clearAnimation();
            transText.setTranslationY(0);
            textView.animate().translationY(-50).setDuration(300).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    textView.animate().translationY(0).setStartDelay(500).setDuration(300).start();
                }
            }).start();
            transText.animate().translationY(50).alpha(1).setDuration(300).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    transText.animate().translationY(0).alpha(0).setStartDelay(500).setDuration(300).start();
                }
            }).start();
            //

        });
        ((Button) cardView.findViewById(R.id.btn_speak)).setOnClickListener(view -> {
            Vocalizer.createVocalizer("ru-RU",from.get(i),true).start();
        });
        return cardView;
    }
}
