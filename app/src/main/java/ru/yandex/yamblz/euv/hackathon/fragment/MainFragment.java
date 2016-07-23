package ru.yandex.yamblz.euv.hackathon.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.yandex.yamblz.euv.hackathon.R;
import ru.yandex.yamblz.euv.hackathon.TrainingType;

public class MainFragment extends Fragment {

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CardView card= (CardView) view.findViewById(R.id.training_cards);
        card.setOnClickListener(view1->{
            TasksFragment tasksFragment=new TasksFragment();
            tasksFragment.setTrainingType(TrainingType.training_cards);
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container,tasksFragment).commit();
        });
        card= (CardView) view.findViewById(R.id.training_matching);
        card.setOnClickListener(view1->{
            TasksFragment tasksFragment=new TasksFragment();
            tasksFragment.setTrainingType(TrainingType.training_matching);
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container,tasksFragment).commit();
        });
    }
}
