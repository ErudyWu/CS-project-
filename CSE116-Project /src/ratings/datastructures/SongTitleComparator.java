package ratings.datastructures;

import org.junit.Test;
import ratings.Song;

import static org.junit.Assert.*;

public class SongTitleComparator extends Comparator<Song> {
    @Override
    public boolean compare(Song song1, Song song2) {

        return 0 > (song1.getTitle().compareToIgnoreCase(song2.getTitle()));
    }
}
