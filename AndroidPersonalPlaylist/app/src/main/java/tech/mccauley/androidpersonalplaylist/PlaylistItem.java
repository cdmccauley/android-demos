package tech.mccauley.androidpersonalplaylist;

public class PlaylistItem {

    // declarations
    private String songTitle;
    private String bandName;
    private String albumName;
    private String albumCover;

    // constructor
    public PlaylistItem(String songTitle, String bandName, String albumName, String albumCover) {
        this.songTitle = songTitle;
        this.bandName = bandName;
        this.albumName = albumName;
        this.albumCover = albumCover;
    }

    // getters
    public String getSongTitle() {
        return songTitle;
    }

    public String getBandName() {
        return bandName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getAlbumCover() {
        return albumCover;
    }
}
