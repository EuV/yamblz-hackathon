package ru.yandex.yamblz.euv.hackathon.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.yandex.yamblz.euv.hackathon.R;
import ru.yandex.yamblz.euv.hackathon.adapters.WordsAdapter;

public class TrainingMatchingFragment extends TrainingFragment {
    RecyclerView left,right;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.training_macthing_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<String> data=new ArrayList<>();
        data.add("one");
        data.add("one");
        data.add("one");
        data.add("one");
        data.add("one");
        data.add("one");
        data.add("one");
        List<String> data2=new ArrayList<>();
        data2.add("one");
        data2.add("one");
        data2.add("one");
        data2.add("one");
        data2.add("one");
        data2.add("one");
        data2.add("one");
        data2.add("one");
        left= (RecyclerView) view.findViewById(R.id.rv_left);
        left.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        left.setAdapter(new WordsAdapter(data, new ClickCallback() {
            @Override
            public void clicked(String word) {

            }
        }));
        right= (RecyclerView) view.findViewById(R.id.rv_right);
        right.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        right.setAdapter(new WordsAdapter(data2, new ClickCallback() {
            @Override
            public void clicked(String word) {

            }
        }));
    }



    @Override
    public void skip() {
        super.skip();
    }

    public interface ClickCallback{
        void clicked(String word);
    }
}
