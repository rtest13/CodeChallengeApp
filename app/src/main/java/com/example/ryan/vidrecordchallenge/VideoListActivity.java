package com.example.ryan.vidrecordchallenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ryan.vidrecordchallenge.adapters.VideoRecyclerAdapter;
import com.example.ryan.vidrecordchallenge.utils.SharedPrefHelper;

import java.util.ArrayList;

import static com.example.ryan.vidrecordchallenge.VideoRecorderFragment.LIST_OF_VIDEO_PATHS;

/**
 * Created by Ryan on 1/15/2017.
 */

public class VideoListActivity extends AppCompatActivity {

    private String[] filePaths;
    private VideoRecyclerAdapter adapter;
    private RecyclerView rv;
    private LinearLayoutManager layoutManager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);
        rv = (RecyclerView) findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);

        // retrieve preference
        ArrayList<String> fileList = new ArrayList<String>();
        fileList = SharedPrefHelper.getStringArrayPref(this, LIST_OF_VIDEO_PATHS);
        filePaths = fileList.toArray(new String[fileList.size()]);

        adapter = new VideoRecyclerAdapter(this, filePaths);
        rv.setAdapter(adapter);
    }
}