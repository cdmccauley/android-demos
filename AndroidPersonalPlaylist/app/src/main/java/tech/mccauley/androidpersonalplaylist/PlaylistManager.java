package tech.mccauley.androidpersonalplaylist;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class PlaylistManager {

    // declarations
    PlaylistItem[] playlistItems;
    Context mainContext;
    ArrayList<MediaPlayer> playlistPlayers;
    ArrayList<Button> playButtons;
    boolean playing;

    // constructor
    public PlaylistManager(Context mainContext) {
        playlistItems = new PlaylistItem[] {
                new PlaylistItem("CHOKE", "I Don't Know How But They Found Me", "CHOKE", "choke"),
                new PlaylistItem("Ma Chérie (feat. Kellin Quinn)", "Palaye Royale", "Boom Boom Room", "boomboomroom"),
                new PlaylistItem("High Hopes", "Panic! At The Disco", "Pray For The Wicked", "prayforthewicked")
        };
        this.mainContext = mainContext;
        playlistPlayers = new ArrayList<>();
        playButtons = new ArrayList<>();
        playing = false;
    }

    public PlaylistItem[] getPlaylistItems() {
        return playlistItems;
    }

    public Context getMainContext() {
        return mainContext;
    }

    public void addPlaylistPlayer(MediaPlayer player, Button button) {
        playlistPlayers.add(player);
        playButtons.add(button);
    }

    public void playPlaylist(int item) {
        if (playing) {
            playing = false;
            playButtons.get(item).setText("Play");
            playlistPlayers.get(item).pause();
            for (int i = 0; i < playlistPlayers.size(); i++) {
                if (i != item) {
                    playButtons.get(i).setEnabled(true);
                }
            }
        } else {
            for (int i = 0; i < playlistPlayers.size(); i++) {
                if (i != item) {
                    playButtons.get(i).setEnabled(false);
                }
            }
            playlistPlayers.get(item).start();
            playButtons.get(item).setText("Pause");
            playing = true;
        }

    }
}
