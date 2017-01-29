package com.arashkhoeini.thearashreader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by arash on 1/27/17.
 */

public class StoryListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @NonNull
    Context context;

    @NonNull
    List<Story> stories;

    public StoryListAdapter(@NonNull Context context, @NonNull List<Story> stories) {
        this.context = context;
        this.stories = stories;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.story_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ViewHolder){
            ((ViewHolder) holder).title.setText(stories.get(position).getTitle());
            ((ViewHolder) holder).story.setText(stories.get(position).getStory());
        }

    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    private static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView story;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            story = (TextView) itemView.findViewById(R.id.story);
        }
    }
}
