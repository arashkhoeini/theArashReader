package com.arashkhoeini.thearashreader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Created by arash on 1/27/17.
 */

public class StoriesRemoteDataSource implements IStoryModel {

    private static StoriesRemoteDataSource INSTANCE = null;

    private static final int SERVICE_LATENCY_IN_MILLIS = 3000;
    private static List<Story> STORY_SERVICE_DATA;

    static {
        STORY_SERVICE_DATA = new ArrayList<>();
        STORY_SERVICE_DATA.add(new Story("سلام دنیا" , "این یک پست وبلاگ است. این اولین پست وبلاگ من است. من آرش هستم."));
    }

    private StoriesRemoteDataSource(){

    }

    public static StoriesRemoteDataSource getInstance(){
        if (INSTANCE == null){
            INSTANCE = new StoriesRemoteDataSource();
        }
        return INSTANCE;
    }

    @Override
    public Observable<List<Story>> getStories() {
        return Observable
                .from(STORY_SERVICE_DATA)
                .delay(SERVICE_LATENCY_IN_MILLIS , TimeUnit.MILLISECONDS)
                .toList();
    }
}
