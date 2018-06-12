package tech.mccauley.androidpersonalplaylist;

import android.content.ContentResolver;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ViewHolder> {

    // declarations
    PlaylistManager playlistManager;

    // recyclerview implementation
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ConstraintLayout playlistItemCl;
        public ViewHolder(ConstraintLayout c) {
            super(c);
            playlistItemCl = c;
        }
    }

    public PlaylistAdapter(PlaylistManager manager) {
        this.playlistManager = manager;
    }

    @Override
    public PlaylistAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
        ConstraintLayout c = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.playlist_item_layout, parent, false);
        ViewHolder v = new ViewHolder(c);
        return v;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        Context mainContext = playlistManager.getMainContext();

        // set songtitle
        TextView songTitle = (TextView) holder.playlistItemCl.getViewById(R.id.song_title_tv);
        songTitle.setText(playlistManager.getPlaylistItems()[position].getSongTitle());

        // set bandname
        TextView bandName = (TextView) holder.playlistItemCl.getViewById(R.id.band_name_tv);
        bandName.setText(playlistManager.getPlaylistItems()[position].getBandName());

        // set albumtitle
        TextView albumTitle = (TextView) holder.playlistItemCl.getViewById(R.id.album_title_tv);
        albumTitle.setText(playlistManager.getPlaylistItems()[position].getAlbumName());

        // set albumcover
        ImageView albumCover = (ImageView) holder.playlistItemCl.getViewById(R.id.album_cover_iv);
        albumCover.setImageResource(mainContext.getResources().getIdentifier(playlistManager.getPlaylistItems()[position].getAlbumCover(), "drawable", mainContext.getPackageName()));

        // set media
        MediaPlayer mediaPlayer = MediaPlayer.create(mainContext, mainContext.getResources().getIdentifier(playlistManager.getPlaylistItems()[position].getAlbumCover(), "raw", mainContext.getPackageName()));
        Button playBtn = (Button) holder.playlistItemCl.getViewById(R.id.play_btn);
        playlistManager.addPlaylistPlayer(mediaPlayer, playBtn);

        // set event listener
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playlistManager.playPlaylist(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return playlistManager.getPlaylistItems().length;
    }
}