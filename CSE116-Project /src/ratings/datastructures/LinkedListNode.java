package ratings.datastructures;
import java.util.LinkedList;
import ratings.Rating;

public class LinkedListNode<T> {

    private T value;
    public LinkedListNode<T> next;
    private String ID;



    public LinkedListNode(T val, LinkedListNode<T> next) {
        this.value = val;
        this.next = next;
    }

    public T getValue() {
        return this.value;
    }
    public void setValue(T val) {
        this.value = val;
    }
    public void setNext(LinkedListNode<T> node) {
        this.next = node;
    }


    public LinkedListNode<T> getNext() {
        return this.next;
    }
    public void append(T value) {
        if (this.next == null) {
            this.next = new LinkedListNode<>(value, null);
        } else {
            this.next.append(value);
        }

    }
    public int size() {
        if (this.next == null) {
            return 1;
        } else {
            return 1 + this.next.size();
        }
    }
    public String find(String ID_p) {
        if (this.ID.equals(ID_p)) {
            return this.ID;
        } else if (this.next == null) {
            return null;
        } else {
            return this.next.find(ID_p);
        }

        }

    }






