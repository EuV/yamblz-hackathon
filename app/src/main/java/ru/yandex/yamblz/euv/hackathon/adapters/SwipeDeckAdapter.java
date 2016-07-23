package ru.yandex.yamblz.euv.hackathon.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.yandex.speechkit.Vocalizer;
import ru.yandex.yamblz.euv.hackathon.R;

public class SwipeDeckAdapter extends BaseAdapter {
    List<String> data;
    private Context context;

    public SwipeDeckAdapter(Context context) {
        this.context = context;
        data = new ArrayList<>();
        data.add("first");
        data.add("second");
        data.add("third");
        data.add("4");
        data.add("5");
        data.add("6");
        data.add("7");
        data.add("8");
        data.add("9");
        data.add("10");
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //todo viewholders
    @Override
    public View getView(int i, View v, ViewGroup viewGroup) {
        CardView cardView= (CardView) LayoutInflater.from(context).inflate(R.layout.training_card_layout, viewGroup, false);
        ((TextView) cardView.findViewById(R.id.card_text)).setText(data.get(i));
        ((Button) cardView.findViewById(R.id.btn_speak)).setOnClickListener(view -> {
            Vocalizer.createVocalizer("en-EN",data.get(i),true).start();
        });
        return cardView;
    }
}
