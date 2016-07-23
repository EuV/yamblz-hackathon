package ru.yandex.yamblz.euv.hackathon.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.yandex.yamblz.euv.hackathon.R;

/**
 * Created by user on 7/23/16.
 */
public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.MyViewHolder>{

    private List<String> data;
    private Context context;

    public WordsAdapter(List<String> data){
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.training_card_layout, parent, false));
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
        public MyViewHolder(View itemView) {
            super(itemView);
            textView.findViewById(R.id.card_text);
        }

        public void bind(String text){
            textView.setText(text);
        }

    }
}
