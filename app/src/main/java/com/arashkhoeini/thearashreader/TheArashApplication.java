package com.arashkhoeini.thearashreader;

import android.app.Application;

/**
 * Created by arash on 1/27/17.
 */

public class TheArashApplication extends Application {

    public StoryListViewModel getStoryListViewModel(){
        return new StoryListViewModel(StoryModel.getInstance(StoriesLocalDataSource.getInstance(),StoriesRemoteDataSource.getInstance()));
    }

}
