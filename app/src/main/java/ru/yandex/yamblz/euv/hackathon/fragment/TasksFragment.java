package ru.yandex.yamblz.euv.hackathon.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;

import ru.yandex.yamblz.euv.hackathon.R;
import ru.yandex.yamblz.euv.hackathon.TrainingType;

public class TasksFragment extends Fragment {
    ImageView close,skip;
    RoundCornerProgressBar progressBar;
    TrainingType trainingType;
    private TrainingFragment currentTrainingFragment;

    public TasksFragment(){
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tasks_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        close= (ImageView) view.findViewById(R.id.close_btn);
        skip= (ImageView) view.findViewById(R.id.skip_btn);
        progressBar= (RoundCornerProgressBar) view.findViewById(R.id.progress_bar);
        skip.setOnClickListener(view1 -> {
            skip();
        });
        close.setOnClickListener(view1 -> {
            close();
        });
        if(trainingType==TrainingType.training_cards){
            currentTrainingFragment=new TrainingCardsFragment();
            currentTrainingFragment.setTasksFragment(this);
            getChildFragmentManager().beginTransaction().replace(R.id.container,currentTrainingFragment).commit();
        }else{
            currentTrainingFragment=new TrainingMatchingFragment();
            currentTrainingFragment.setTasksFragment(this);
            getChildFragmentManager().beginTransaction().replace(R.id.container,currentTrainingFragment).commit();
        }
       // ((ViewGroup)view).addView(new StatChart(getContext()));
    }

    public void close(){
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MainFragment()).commit();
    }
    public void updateProgress(){
        if(progressBar.getProgress()==1){
            finish();
        }else{
            progressBar.setProgress(progressBar.getProgress()+0.1f);
        }


    }
    public void skip(){
        currentTrainingFragment.skip();
    }
    private void finish(){
        getChildFragmentManager().beginTransaction().replace(R.id.container,new StatFragment()).commit();
    }

    public void setTrainingType(TrainingType trainingType) {
        this.trainingType = trainingType;
    }

}
