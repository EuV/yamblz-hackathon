package ru.yandex.yamblz.euv.hackathon.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

public class TrainingFragment extends Fragment {
    TasksFragment tasksFragment;

    public void setTasksFragment(TasksFragment tasksFragment) {
        this.tasksFragment = tasksFragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void skip() {
    }
}
