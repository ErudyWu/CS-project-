package ratings;

import ratings.datastructures.BinaryTreeNode;
import ratings.datastructures.Comparator;
import ratings.datastructures.LinkedListNode;
import tests.TestClasses1;

public class Playlist {
    private Comparator<Song> comparator_P;
    private BinaryTreeNode<Song> root;
    private LinkedListNode<Song> LK1;

    public Playlist(Comparator<Song> comparator) {
        this.comparator_P = comparator;
        this.LK1 = null;
//            this.BST1.setComparator(comparator);
        //not sure is there any variable I should initialize,Prob not
    }

    public void addSong(Song s1) {
        if (this.root == null) {
            this.root = new BinaryTreeNode<>(s1, null, null);
            ;
        } else {
            this.insertHelper(this.root, s1);
        }
    }

    private void insertHelper(BinaryTreeNode<Song> node, Song toInsert) {
        if (this.comparator_P.compare(toInsert, node.getValue())) {
            if (node.getLeft() == null) {
                node.setLeft(new BinaryTreeNode<>(toInsert, null, null));
            } else {
                insertHelper(node.getLeft(), toInsert);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new BinaryTreeNode<>(toInsert, null, null));
            } else {
                insertHelper(node.getRight(), toInsert);
            }
        }
    }

    public BinaryTreeNode<Song> getSongTree() {
        return this.root;
    }

    public LinkedListNode<Song> getSongList(BinaryTreeNode<Song> BTN) {
        if (BTN == null) {
            return null;
        }else{
           getListHelper(BTN);
           return this.LK1;

        }
    }
    public void getListHelper(BinaryTreeNode<Song> node){
        if (node != null){
            getListHelper(node.getLeft());
            if (!check_item_in_LK(this.LK1,node.getValue())){
            appendSong(node);}
            getListHelper(node.getRight());
        }
    }
    // for the Append method we need to update the instance variable in this class, but there is an issue when we
    //add the head node in the Linked List.
    public void appendSong(BinaryTreeNode<Song> node){
        if (this.LK1 == null){
            this.LK1 = new LinkedListNode<>(node.getValue(),null);
        }else{
            this.LK1.append(node.getValue());
        }
    }public boolean check_item_in_LK(LinkedListNode<Song> LK1,Song s1){
        if (LK1 == null){return false;}
        else{
            TestClasses1 TC1 =new TestClasses1();
            if (s1.getTitle().equals(LK1.getValue().getTitle())){
                return true;
            }else if (LK1.getNext() ==null ){return false;}
            else { return check_item_in_LK(LK1.getNext(),s1);
            }
        }
    }
        public LinkedListNode<Song> getSongList () {
            return getSongList(this.root);
        }

    }
