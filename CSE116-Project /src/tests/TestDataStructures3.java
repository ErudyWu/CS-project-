package tests;

import org.junit.Test;
import ratings.DegreesOfSeparation;
import ratings.FileReader;

import static org.junit.Assert.assertEquals;

public class TestDataStructures3 {
    @Test
    public void Testing_for_itself(){
            DegreesOfSeparation d1 = new DegreesOfSeparation(FileReader.readMovies("data/movieForGraph.csv"));
            assertEquals(d1.degreesOfSeparation("a1", "a1"),0);
    }
    @Test
    public void Testing_for_invalid(){
        DegreesOfSeparation d1 = new DegreesOfSeparation(FileReader.readMovies("data/movieForGraph.csv"));
        assertEquals(d1.degreesOfSeparation("a1", "a"),-1);
    }
    @Test
    public void Testing_for_valid_1(){
        DegreesOfSeparation d1 = new DegreesOfSeparation(FileReader.readMovies("data/movieForGraph.csv"));
        assertEquals(d1.degreesOfSeparation("a1", "a4"),2);
    }
    @Test
    public void Testing_for_valid_2(){
        DegreesOfSeparation d1 = new DegreesOfSeparation(FileReader.readMovies("data/movieForGraph.csv"));
        assertEquals(d1.degreesOfSeparation("a1", "a6"),3);
    }

    @Test
    public void Testing_for_valid_3(){
        DegreesOfSeparation d1 = new DegreesOfSeparation(FileReader.readMovies("data/movies.csv"));
        assertEquals(d1.degreesOfSeparation("Leslie Nielsen", "Peter Sellers"),2);
    }
    @Test
    public void Testing_for_valid_4(){
        DegreesOfSeparation d1 = new DegreesOfSeparation(FileReader.readMovies("data/movieForGraph.csv"));
        assertEquals(d1.degreesOfSeparation("a1", "a7"),4);
    }
    @Test
    public void Testing_null_HashMap(){
        DegreesOfSeparation d1 = new DegreesOfSeparation(FileReader.readMovies("data/ForGraph.csv"));
        assertEquals(d1.degreesOfSeparation("a1", "a"),-1);
    }
    @Test
    public void Testing_oneActor(){
        DegreesOfSeparation d1 = new DegreesOfSeparation(FileReader.readMovies("data/m_one.csv"));
        assertEquals(d1.degreesOfSeparation("a1", "a3"),-1);
    }
}
