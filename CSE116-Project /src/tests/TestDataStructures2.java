package tests;

import org.junit.Test;
import ratings.Playlist;
import ratings.Rating;
import ratings.Song;
import ratings.datastructures.BinaryTreeNode;
import ratings.datastructures.Comparator;
import ratings.datastructures.LinkedListNode;
import ratings.datastructures.SongTitleComparator;

import static org.junit.Assert.*;

public class TestDataStructures2 {

    public int findSize(BinaryTreeNode<Song> root){
        if (root == null ){return 0;
        }else{
            return 1+findSize(root.getLeft())+findSize(root.getRight());}}

        public boolean compareSongTrees(BinaryTreeNode<Song> ST1,BinaryTreeNode<Song>ST2){
            if(ST1==null && ST2==null){return true;}
            if(ST1==null || ST2==null){return false;}
            if(findSize(ST1) != findSize(ST2)){return false;}
            TestClasses1 TC1 = new TestClasses1();
            TC1.compareSongs(ST1.getValue(),ST2.getValue());
            compareSongTrees(ST1.getLeft(),ST2.getLeft());
            compareSongTrees(ST1.getRight(),ST2.getRight());
            return true;}
    public boolean compareSongLK(LinkedListNode<Song> LK1, LinkedListNode<Song>LK2){

        if(LK1==null && LK2==null){return true;}
        if(LK1==null || LK2==null){return false;}
        if (LK1.size() != LK2.size()){
            return false;}
        TestClasses1 TC1 = new TestClasses1();
        if (LK1.getNext()==null && LK2.getNext()==null){
            TC1.compareSongs(LK1.getValue(),LK2.getValue());
        }else{compareSongLK(LK1.getNext(),LK2.getNext());}
        return true;}


    @Test
    public void testing_with_diff_title_In_root(){
        Playlist PL1 =new Playlist(new SongTitleComparator());
        Song s1 = new Song("b","Erudy","8820"); //1
        Song s2 = new Song("a","Cherry","0208"); // 0
        Song s3 = new Song ("d","Ye","0346");  //2
        Song s_Testing = new Song ("b","Erudy","8820");
        Rating r1 = new Rating("1",5);
        Rating r2 = new Rating("2",4);
        Rating r3 = new Rating("3",3);
        s1.addRating(r1);s1.addRating(r2);s1.addRating(r3);
        s2.addRating(r1);s2.addRating(r2);s2.addRating(r3);
        s3.addRating(r1);s3.addRating(r2);s3.addRating(r3);
        s_Testing.addRating(r1);s_Testing.addRating(r2);s_Testing.addRating(r3);
        PL1.addSong(s1); PL1.addSong(s2); PL1.addSong(s3);
        BinaryTreeNode<Song> BTN1 = PL1.getSongTree();
        BinaryTreeNode<Song> bt2 = new BinaryTreeNode<>(s2,null,null);
        BinaryTreeNode<Song> bt3 = new BinaryTreeNode<>(s3,null,null);
        BinaryTreeNode<Song> bt1 = new BinaryTreeNode<>(s_Testing,bt2,bt3);
        assertTrue(compareSongTrees(BTN1,bt1));
    }
    @Test
    public void testing_with_diff_artist_In_root(){
        Playlist PL1 =new Playlist(new SongTitleComparator());
        Song s1 = new Song("b","Erudy","8820"); //1
        Song s2 = new Song("a","Cherry","0208"); // 0
        Song s3 = new Song ("d","Ye","0346");  //2
        Song s_Testing = new Song ("b","erudy","8820");
        Rating r1 = new Rating("1",5);
        Rating r2 = new Rating("2",4);
        Rating r3 = new Rating("3",3);
        s1.addRating(r1);s1.addRating(r2);s1.addRating(r3);
        s2.addRating(r1);s2.addRating(r2);s2.addRating(r3);
        s3.addRating(r1);s3.addRating(r2);s3.addRating(r3);
        s_Testing.addRating(r1);s_Testing.addRating(r2);s_Testing.addRating(r3);
        PL1.addSong(s1); PL1.addSong(s2); PL1.addSong(s3);
        BinaryTreeNode<Song> BTN1 = PL1.getSongTree();
        BinaryTreeNode<Song> bt2 = new BinaryTreeNode<>(s2,null,null);
        BinaryTreeNode<Song> bt3 = new BinaryTreeNode<>(s3,null,null);
        BinaryTreeNode<Song> bt1 = new BinaryTreeNode<>(s_Testing,bt2,bt3);
        assertTrue(compareSongTrees(BTN1,bt1));
    }
    @Test
    public void testing_with_diff_ID_In_root(){
        Playlist PL1 =new Playlist(new SongTitleComparator());
        Song s1 = new Song("b","Erudy","hello"); //1
        Song s2 = new Song("a","Cherry","0208"); // 0
        Song s3 = new Song ("d","Ye","0346");  //2
        Song s_Testing = new Song ("b","erudy","HeLLo");
        Rating r1 = new Rating("1",5);
        Rating r2 = new Rating("2",4);
        Rating r3 = new Rating("3",3);
        s1.addRating(r1);s1.addRating(r2);s1.addRating(r3);
        s2.addRating(r1);s2.addRating(r2);s2.addRating(r3);
        s3.addRating(r1);s3.addRating(r2);s3.addRating(r3);
        s_Testing.addRating(r1);s_Testing.addRating(r2);s_Testing.addRating(r3);
        PL1.addSong(s1); PL1.addSong(s2); PL1.addSong(s3);
        BinaryTreeNode<Song> BTN1 = PL1.getSongTree();
        BinaryTreeNode<Song> bt2 = new BinaryTreeNode<>(s2,null,null);
        BinaryTreeNode<Song> bt3 = new BinaryTreeNode<>(s3,null,null);
        BinaryTreeNode<Song> bt1 = new BinaryTreeNode<>(s_Testing,bt2,bt3);
        assertTrue(compareSongTrees(BTN1,bt1));
    }
    @Test
    public void testing_with_diff_RWID_In_root(){
        Playlist PL1 =new Playlist(new SongTitleComparator());
        Song s1 = new Song("b","Erudy","hello"); //1
        Song s2 = new Song("a","Cherry","0208"); // 0
        Song s3 = new Song ("d","Ye","0346");  //2
        Song s_Testing = new Song ("b","erudy","HeLLo");
        Rating r1 = new Rating("1",5);
        Rating r2 = new Rating("2",4);
        Rating r3 = new Rating("qwert",3);
        Rating r4 = new Rating("QwERt",3);
        s1.addRating(r1);s1.addRating(r2);s1.addRating(r3);
        s2.addRating(r1);s2.addRating(r2);s2.addRating(r3);
        s3.addRating(r1);s3.addRating(r2);s3.addRating(r3);
        s_Testing.addRating(r1); s_Testing.addRating(r2); s_Testing.addRating(r4);
        PL1.addSong(s1); PL1.addSong(s2); PL1.addSong(s3);
        BinaryTreeNode<Song> BTN1 = PL1.getSongTree();
        BinaryTreeNode<Song> bt2 = new BinaryTreeNode<>(s2,null,null);
        BinaryTreeNode<Song> bt3 = new BinaryTreeNode<>(s3,null,null);
        BinaryTreeNode<Song> bt1 = new BinaryTreeNode<>(s_Testing,bt2,bt3);
        assertTrue(compareSongTrees(BTN1,bt1));
    }
    @Test
    public void testing_with_diff_rate_In_root(){
        Playlist PL1 =new Playlist(new SongTitleComparator());
        Song s1 = new Song("b","Erudy","hello"); //1
        Song s2 = new Song("a","Cherry","0208"); // 0
        Song s3 = new Song ("d","Ye","0346");  //2
        Song s_Testing = new Song ("b","erudy","HeLLo");
        Rating r1 = new Rating("1",5);
        Rating r2 = new Rating("2",4);
        Rating r3 = new Rating("qwert",3);
        Rating r4 = new Rating("QwERt",3);
        s1.addRating(r1);s1.addRating(r2);s1.addRating(r3);
        s2.addRating(r1);s2.addRating(r2);s2.addRating(r3);
        s3.addRating(r1);s3.addRating(r2);s3.addRating(r3);
        s_Testing.addRating(r1); s_Testing.addRating(r2); s_Testing.addRating(r4);
        PL1.addSong(s1); PL1.addSong(s2); PL1.addSong(s3);
        BinaryTreeNode<Song> BTN1 = PL1.getSongTree();
        BinaryTreeNode<Song> bt2 = new BinaryTreeNode<>(s2,null,null);
        BinaryTreeNode<Song> bt3 = new BinaryTreeNode<>(s3,null,null);
        BinaryTreeNode<Song> bt1 = new BinaryTreeNode<>(s_Testing,bt2,bt3);
        assertTrue(compareSongTrees(BTN1,bt1));
    }
    @Test
    public void testing_playlist_title_allLeft(){
        Playlist PL1 =new Playlist(new SongTitleComparator());
        Song s1 =  new Song("a","a","a");
        Song s2 =  new Song("b","a","a");
        Song s3 =  new Song("c","a","a");
        Song s4 =  new Song("d","a","a");
        Song s5 =  new Song("e","a","a");
        PL1.addSong(s5);
        PL1.addSong(s4);
        PL1.addSong(s3);
        PL1.addSong(s2);
        PL1.addSong(s1);
        Rating r1 = new Rating("1",5);
        Rating r2 = new Rating("2",5);
        s1.addRating(r1);
        s2.addRating(r1);
        s3.addRating(r1);
        s4.addRating(r1);
        s5.addRating(r1);
        s1.addRating(r2);
        s2.addRating(r2);
        s3.addRating(r2);
        s4.addRating(r2);
        s5.addRating(r2);
        BinaryTreeNode<Song> BTN9 = new BinaryTreeNode<>(s1,null,null);
        BinaryTreeNode<Song> BTN8 = new BinaryTreeNode<>(s2,BTN9,null);
        BinaryTreeNode<Song> BTN7 = new BinaryTreeNode<>(s3,BTN8,null);
        BinaryTreeNode<Song> BTN6 = new BinaryTreeNode<>(s4,BTN7,null);
        BinaryTreeNode<Song> BTN5 = new BinaryTreeNode<>(s5,BTN6,null);
        BinaryTreeNode<Song> BTN0 =PL1.getSongTree();
        assertTrue(compareSongTrees(BTN5,BTN0));
    }
    @Test
    public void testing_playlist_title_empty_Tree(){
        Playlist PL1 =new Playlist(new SongTitleComparator());
        BinaryTreeNode<Song> BTN0 =PL1.getSongTree();
        assertTrue(compareSongTrees(null,BTN0));}
    @Test
    public void testing_playlist_title_Balanced(){
        Playlist PL1 =new Playlist(new SongTitleComparator());
        Song s1 =  new Song("a","a","a");
        Song s2 =  new Song("b","a","a");
        Song s3 =  new Song("c","a","a");
        Song s4 =  new Song("d","a","a");
        Song s5 =  new Song("e","a","a");
        Song s6 =  new Song("f","a","a");
        Song s7 =  new Song("g","a","a");
        Song s8 =  new Song("h","a","a");
        Song s9 =  new Song("i","a","a");
        PL1.addSong(s5);
        PL1.addSong(s3);
        PL1.addSong(s7);
        PL1.addSong(s2);
        PL1.addSong(s4);
        PL1.addSong(s6);
        PL1.addSong(s8);
        PL1.addSong(s1);
        PL1.addSong(s9);
        BinaryTreeNode<Song> BTN1 = new BinaryTreeNode<>(s1,null,null);
        BinaryTreeNode<Song> BTN2 = new BinaryTreeNode<>(s2,BTN1,null);
        BinaryTreeNode<Song> BTN4 = new BinaryTreeNode<>(s4,null,null);
        BinaryTreeNode<Song> BTN3 = new BinaryTreeNode<>(s3,BTN2,BTN4);
        BinaryTreeNode<Song> BTN9 = new BinaryTreeNode<>(s9,null,null);
        BinaryTreeNode<Song> BTN8 = new BinaryTreeNode<>(s8,null,BTN9);
        BinaryTreeNode<Song> BTN6 = new BinaryTreeNode<>(s6,null,null);
        BinaryTreeNode<Song> BTN7 = new BinaryTreeNode<>(s7,BTN6,BTN8);
        BinaryTreeNode<Song> BTN5 = new BinaryTreeNode<>(s5,BTN3,BTN7);
        BinaryTreeNode<Song> BTN0 =PL1.getSongTree();
        assertTrue(compareSongTrees(BTN5,BTN0));
    }
@Test
    public void Testing_getSongList_No_empty(){
    Playlist PL1 =new Playlist(new SongTitleComparator());
    LinkedListNode<Song> LK1 = PL1.getSongList();
    assertTrue(compareSongLK(PL1.getSongList(),LK1));
}
    @Test
    public void Testing_getSongList_all_right() {
        Playlist PL1 = new Playlist(new SongTitleComparator());
        Song s1 = new Song("a", "a", "a");
        Song s2 = new Song("b", "a", "a");
        Song s3 = new Song("c", "a", "a");
        Song s4 = new Song("d", "a", "a");
        Song s5 = new Song("e", "a", "a");
        Song s6 = new Song("f", "a", "a");
        Song s7 = new Song("g", "a", "a");
        Song s8 = new Song("h", "a", "a");
        Song s9 = new Song("i", "a", "a");
        PL1.addSong(s1);PL1.addSong(s2);PL1.addSong(s3);
        PL1.addSong(s4);PL1.addSong(s5);PL1.addSong(s6);
        PL1.addSong(s7);PL1.addSong(s8);PL1.addSong(s9);
        LinkedListNode<Song> LK0 = PL1.getSongList();
        LinkedListNode<Song> LK1 = new LinkedListNode<>(s9,null);
        LK1 = new LinkedListNode<>(s8,LK1);LK1 = new LinkedListNode<>(s7,LK1);
        LK1 = new LinkedListNode<>(s6,LK1);LK1 = new LinkedListNode<>(s5,LK1);
        LK1 = new LinkedListNode<>(s4,LK1);LK1 = new LinkedListNode<>(s3,LK1);
        LK1 = new LinkedListNode<>(s2,LK1);LK1 = new LinkedListNode<>(s1,LK1);
        assertTrue(compareSongLK(LK0,LK1));
    }
    @Test
    public void Testing_getSongList_all_left() {
        Playlist PL1 = new Playlist(new SongTitleComparator());
        Song s1 = new Song("a", "a", "a");
        Song s2 = new Song("b", "a", "a");
        Song s3 = new Song("c", "a", "a");
        Song s4 = new Song("d", "a", "a");
        Song s5 = new Song("e", "a", "a");
        Song s6 = new Song("f", "a", "a");
        Song s7 = new Song("g", "a", "a");
        Song s8 = new Song("h", "a", "a");
        Song s9 = new Song("i", "a", "a");
        PL1.addSong(s9);
        PL1.addSong(s8);
        PL1.addSong(s7);
        PL1.addSong(s6);
        PL1.addSong(s5);
        PL1.addSong(s4);
        PL1.addSong(s3);
        PL1.addSong(s2);
        PL1.addSong(s1);
        LinkedListNode<Song> LK0 = PL1.getSongList();
        LinkedListNode<Song> LK1 = new LinkedListNode<>(s9,null);
        LK1 = new LinkedListNode<>(s8,LK1);LK1 = new LinkedListNode<>(s7,LK1);
        LK1 = new LinkedListNode<>(s6,LK1);LK1 = new LinkedListNode<>(s5,LK1);
        LK1 = new LinkedListNode<>(s4,LK1);LK1 = new LinkedListNode<>(s3,LK1);
        LK1 = new LinkedListNode<>(s2,LK1);LK1 = new LinkedListNode<>(s1,LK1);
        assertTrue(compareSongLK(PL1.getSongList(),LK1));
    }
@Test
    public void Testing_expected_songs(){
    Playlist PL1 =new Playlist(new SongTitleComparator());
    Song s1 =  new Song("a","unknown","unknown");
    Song s2 =  new Song("b","unknown","unknown");
    Song s3 =  new Song("c","unknown","unknown");
    Song s4 =  new Song("d","unknown","unknown");
    Song s5 =  new Song("e","unknown","unknown");
    Song s6 =  new Song("f","unknown","unknown");
    Song s7 =  new Song("g","unknown","unknown");
    Song s8 =  new Song("h","unknown","unknown");
    Song s9 =  new Song("i","unknown","unknown");
    Rating r1 = new Rating("1",5);
    Rating r2 = new Rating("2",4);
    Rating r3 = new Rating("1",3);
    s1.addRating(r1);s1.addRating(r2);s1.addRating(r3);
    s2.addRating(r1);s2.addRating(r2);s2.addRating(r3);
    s3.addRating(r1);s3.addRating(r2);s3.addRating(r3);
    s4.addRating(r1);s4.addRating(r2);s4.addRating(r3);
    s5.addRating(r1);s5.addRating(r2);s5.addRating(r3);
    s6.addRating(r1);s6.addRating(r2);s6.addRating(r3);
    s7.addRating(r1);s7.addRating(r2);s7.addRating(r3);
    s8.addRating(r1);s8.addRating(r2);s8.addRating(r3);
    s9.addRating(r1);s9.addRating(r2);s9.addRating(r3);
    PL1.addSong(s5);PL1.addSong(s7);PL1.addSong(s8);
    PL1.addSong(s2);PL1.addSong(s6);PL1.addSong(s1);
    PL1.addSong(s3);PL1.addSong(s4);PL1.addSong(s9);
    LinkedListNode<Song> LK0 = PL1.getSongList();
    LinkedListNode<Song> LK1 = new LinkedListNode<>(s9,null);
    LK1 = new LinkedListNode<>(s8,LK1);LK1 = new LinkedListNode<>(s7,LK1);
    LK1 = new LinkedListNode<>(s6,LK1);LK1 = new LinkedListNode<>(s5,LK1);
    LK1 = new LinkedListNode<>(s4,LK1);LK1 = new LinkedListNode<>(s3,LK1);
    LK1 = new LinkedListNode<>(s2,LK1);LK1 = new LinkedListNode<>(s1,LK1);
    assertTrue(compareSongLK(PL1.getSongList(),LK1));}




}
