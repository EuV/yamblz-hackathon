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
import ru.yandex.yamblz.euv.hackathon.views.StatChart;

/**
 * Created by user on 7/23/16.
 */
public class TasksFragment extends Fragment {
    ImageView close,skip;
    RoundCornerProgressBar progressBar;

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
        });
        ((ViewGroup)view).addView(new StatChart(getContext()));
    }

    public void close(){

    }
    public void showNext(){
        if(progressBar.getProgress()==1){
            finish();
        }else{
            progressBar.setProgress(progressBar.getProgress()+0.1f);
            //show next
        }


    }
    public void skip(){
    }
    private void finish(){

    }
}
