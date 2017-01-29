package com.arashkhoeini.thearashreader;

import android.support.annotation.NonNull;

/**
 * Created by arash on 1/27/17.
 */

public class Story {

    @NonNull
    private final String title;

    @NonNull
    private final String story;

    public Story(@NonNull String title, @NonNull String story) {
        this.title = title;
        this.story = story;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    @NonNull
    public String getStory() {
        return story;
    }
}
