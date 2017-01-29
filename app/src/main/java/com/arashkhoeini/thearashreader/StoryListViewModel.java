package com.arashkhoeini.thearashreader;

import android.support.annotation.NonNull;

import java.util.List;

import rx.Observable;

/**
 * Created by arash on 1/27/17.
 */

public class StoryListViewModel {

    @NonNull
    private IStoryModel storyModel;

    public StoryListViewModel(@NonNull IStoryModel storyModel) {
        this.storyModel = storyModel;
    }

    public Observable<List<Story>> getStories(){
        return storyModel.getStories();
    }
}
