package tests;

import org.junit.Test;
import ratings.MediaLibrary;
import ratings.Movie;
import ratings.Ratable;
import ratings.Song;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestClasses3 {
    public boolean compareRatableArrayLists(ArrayList<Ratable> ary1, ArrayList<Ratable> ary2) {
        if (ary1.size() != ary2.size()) {
            return false;
        } else {
            TestClasses1 TC1 = new TestClasses1();
            for (int x = 0; x < ary1.size(); x++) {
                assertEquals(ary1.get(x).getTitle(), ary2.get(x).getTitle());
            }
        }
        return true;
    }

    @Test

    public void testing_invalid_K() {
        MediaLibrary ML = new MediaLibrary();
        assertTrue(compareRatableArrayLists(new ArrayList<>(), ML.topKRatables(0)));
    }
    @Test

    public void testing_valid_K_less_than_size() {
        MediaLibrary ML1 = new MediaLibrary();
        MediaLibrary ML2 = new MediaLibrary();
        Movie m1 = new Movie("Heat",new ArrayList<>());
        Song s1 = new Song("Flashing Lights","","");
        ArrayList<Ratable> ary1 = new ArrayList<>(Arrays.asList(m1,s1));
        ML2.populateLibrary("data/s1.csv","data/m1.csv","data/m_rating.csv");
        ArrayList<Ratable> ary2 =ML2.topKRatables(2);
        assertTrue(compareRatableArrayLists(ary1,ary2));


    }
    @Test

    public void testing_valid_K_greater_than_size() {
        MediaLibrary ML1 = new MediaLibrary();
        MediaLibrary ML2 = new MediaLibrary();
        Movie m1 = new Movie("Heat",new ArrayList<>());
        Movie m2 = new Movie("GoldenEye",new ArrayList<>());
        Song s1 = new Song("Flashing Lights","","");
        Song s2 = new Song("Endless Fashion","","");
        ArrayList<Ratable> ary1 = new ArrayList<>(Arrays.asList(m1,s1,s2,m2));
        ML2.populateLibrary("data/s1.csv","data/m1.csv","data/m_rating.csv");
        ArrayList<Ratable> ary2 =ML2.topKRatables(5);
        assertTrue(compareRatableArrayLists(ary1,ary2));
    }
}