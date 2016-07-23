package ru.yandex.yamblz.euv.hackathon.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daprlabs.cardstack.SwipeDeck;

import ru.yandex.yamblz.euv.hackathon.R;
import ru.yandex.yamblz.euv.hackathon.adapters.SwipeDeckAdapter;

public class TrainingCardsFragment extends TrainingFragment {
    SwipeDeck swipeDeck;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.trainig_cards_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        swipeDeck= (SwipeDeck) view.findViewById(R.id.swipe_deck);
        swipeDeck.setAdapter(new SwipeDeckAdapter(getContext()));
        swipeDeck.setLeftImage(R.id.btn_false);
        swipeDeck.setRightImage(R.id.btn_true);
        swipeDeck.setEventCallback(new SwipeDeck.SwipeEventCallback() {
            @Override
            public void cardSwipedLeft(int position) {
                tasksFragment.updateProgress();
            }

            @Override
            public void cardSwipedRight(int position) {
                tasksFragment.updateProgress();
            }

            @Override
            public void cardsDepleted() {

            }

            @Override
            public void cardActionDown() {

            }

            @Override
            public void cardActionUp() {

            }
        });

    }

    @Override
    public void skip() {
        super.skip();
        swipeDeck.swipeTopCardLeft(3000);
    }
}
