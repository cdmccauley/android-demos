package tech.mccauley.androidweddingphotography;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainRvAdapter extends RecyclerView.Adapter<MainRvAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mainRvCellIv;

        public ViewHolder(View v) {
            super(v);
            mainRvCellIv = v.findViewById(R.id.main_rv_cell_iv);
        }
    }

    private Context mainContext;
    private PhotoManager photoManager;
    private ImageView mainIv;
    private Toast infoToast;
    private ScrollView mainSv;

    public MainRvAdapter(Context mainContext, PhotoManager photoManager, ImageView mainIv, ScrollView mainSv) {
        this.mainContext = mainContext;
        this.photoManager = photoManager;
        this.mainIv = mainIv;
        this.infoToast = Toast.makeText(mainContext, "", Toast.LENGTH_SHORT);
        this.mainSv = mainSv;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_rv_cell, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.mainRvCellIv.setImageResource(photoManager.getManagerPhotos()[position].getPhotoFile());
        holder.mainRvCellIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainIv.setImageResource(photoManager.getManagerPhotos()[position].getPhotoFile());
                infoToast.setText("Anthology Wedding Photo " + photoManager.getManagerPhotos()[position].getPhotoNum());
                infoToast.setGravity(Gravity.BOTTOM, 0, 250);
                infoToast.show();
                mainSv.fullScroll(ScrollView.FOCUS_UP);
            }
        });
    }

    @Override
    public int getItemCount() {
        return photoManager.getManagerPhotos().length;
    }
}
