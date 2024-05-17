package ratings;

import com.sun.tools.jconsole.JConsoleContext;
import ratings.datastructures.LinkedListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
public class Song extends Ratable{

    private String artist;
    private String ID;
    public Song(String title_p, String artist_p, String ID_p) {
        this.setTitle(title_p);
        this.artist = artist_p;
        this.ID = ID_p;

    }
    public String getArtist() {
        return this.artist;
    }
    public void setArtist(String artist_p) {
        this.artist = artist_p;
    }
    public String getSongID() {
        return this.ID;
    }
    public void setSongID(String ID_p) {
        this.ID = ID_p;
    }


    }

















