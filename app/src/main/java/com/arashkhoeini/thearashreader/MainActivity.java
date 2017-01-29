package com.arashkhoeini.thearashreader;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity {

    @NonNull
    private CompositeSubscription mSubscription;

    @NonNull
    private RecyclerView storyList;

    @NonNull
    private  StoryListViewModel mStoryListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStoryListViewModel = ((TheArashApplication) getApplicationContext()).getStoryListViewModel();
        setUpViews();
    }

    private void setUpViews(){
        storyList = (RecyclerView) findViewById(R.id.story_list);
    }

    @Override
    protected void onResume() {
        super.onResume();
        bind();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unbind();
    }

    private void bind(){
        mSubscription = new CompositeSubscription();
        mSubscription.add(mStoryListViewModel.getStories()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::setStories));

    }

    private void setStories(@NonNull List<Story> stories){
        Log.d("MAIN ACTIVITY" ,"Story size: "+  stories.size());
        StoryListAdapter storyListAdapter = new StoryListAdapter(this, stories);
        storyList.setLayoutManager(new LinearLayoutManager(this));
        storyList.setAdapter(storyListAdapter);
    }

    private void unbind(){
        mSubscription.unsubscribe();
    }

}
