package com.arashkhoeini.thearashreader;

import java.util.List;

import rx.Observable;

/**
 * Created by arash on 1/27/17.
 */

public interface IStoryModel {
    public Observable<List<Story>> getStories();
}
