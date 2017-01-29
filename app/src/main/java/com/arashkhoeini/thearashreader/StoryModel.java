package com.arashkhoeini.thearashreader;

import android.support.annotation.NonNull;

import java.util.List;

import rx.Observable;

/**
 * Created by arash on 1/27/17.
 */

public class StoryModel implements IStoryModel {

    public static StoryModel INSTANCE;


    public static StoryModel getInstance(@NonNull IStoryModel storyLocalSource, @NonNull IStoryModel storyRemoteSource){
        if(INSTANCE == null){
            INSTANCE = new StoryModel(storyLocalSource,storyRemoteSource);
        }
        return INSTANCE;
    }

    @NonNull
    private IStoryModel storyLocalSource;

    @NonNull
    private IStoryModel storyRemoteSource;

    public StoryModel(@NonNull IStoryModel storyLocalSource, @NonNull IStoryModel storyRemoteSource) {
        this.storyLocalSource = storyLocalSource;
        this.storyRemoteSource = storyRemoteSource;
    }

    @Override
    public Observable<List<Story>> getStories() {
        return storyRemoteSource.getStories();
    }
}
