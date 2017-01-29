package com.arashkhoeini.thearashreader;

import java.util.List;

import rx.Observable;

/**
 * Created by arash on 1/27/17.
 */

public class StoriesLocalDataSource implements IStoryModel {

    private static StoriesLocalDataSource INSTANCE ;

    private  StoriesLocalDataSource(){}

    public static StoriesLocalDataSource getInstance(){
        if(INSTANCE == null){
            INSTANCE = new StoriesLocalDataSource();
        }
        return  INSTANCE;
    }
    @Override
    public Observable<List<Story>> getStories() {
        return null;
    }
}
