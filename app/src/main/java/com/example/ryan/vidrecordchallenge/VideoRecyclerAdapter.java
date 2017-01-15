package com.example.ryan.vidrecordchallenge;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ryan on 1/15/2017.
 */

public class VideoRecyclerAdapter extends RecyclerView.Adapter<VideoRecyclerAdapter.ViewHolder> {

    private List<String> itemList;
    private Context mContext;

    public VideoRecyclerAdapter(Context context, String[] list) {
        this.itemList = Arrays.asList(list);
        this.mContext = context;
    }

    @Override
    public VideoRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_file, parent, false);
        return new VideoRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final VideoRecyclerAdapter.ViewHolder holder, int position) {
        holder.file.setText(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView file;

        ViewHolder(View itemView) {
            super(itemView);
            file = (TextView)itemView.findViewById(R.id.file_text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            File fileWithinMyDir = new File(file.getText().toString());
            fileWithinMyDir.setReadable(true, false);
            String videoResource = fileWithinMyDir.getPath();
            Uri intentUri = Uri.fromFile(new File(videoResource));

            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setDataAndType(intentUri, "video/mp4");
            mContext.startActivity(intent);
        }
    }
}