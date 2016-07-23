package ru.yandex.yamblz.euv.hackathon.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.yandex.yamblz.euv.hackathon.R;
import ru.yandex.yamblz.euv.hackathon.fragment.TrainingMatchingFragment;

/**
 * Created by user on 7/23/16.
 */
public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.MyViewHolder>{

    private List<String> data;
    private TrainingMatchingFragment.ClickCallback clickCallback;
    private Context context;

    public WordsAdapter(List<String> data, TrainingMatchingFragment.ClickCallback clickCallback){
        this.data = data;
        this.clickCallback = clickCallback;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.word_card_layout, parent, false),clickCallback);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        private TrainingMatchingFragment.ClickCallback clickCallback;

        public MyViewHolder(View itemView, TrainingMatchingFragment.ClickCallback clickCallback) {
            super(itemView);
            this.clickCallback = clickCallback;
            textView= (TextView) itemView.findViewById(R.id.word_text);
            itemView.setOnClickListener(view -> {
                clickCallback.clicked((String) textView.getText());
            });
        }

        public void bind(String text){
            textView.setText(text);
        }

    }
}
