package ratings.datastructures;

public class BinaryTreeNode<A> {
    private A value;
    private BinaryTreeNode<A> left;
    private BinaryTreeNode<A> right;


    public BinaryTreeNode(A value, BinaryTreeNode<A> left, BinaryTreeNode<A> right){
        this.value=value;
        this.right=right;
        this.left=left;
    }

    public A getValue() {
        return value;
    }

    public void setValue(A value) {
        this.value = value;
    }

    public BinaryTreeNode<A> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<A> left) {
        this.left = left;
    }

    public BinaryTreeNode<A> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<A> right) {
        this.right = right;
    }
    public int findSize(BinaryTreeNode<A> root){
        if (root == null ){return 0;
    }else{
//            if (root.getRight() != null && root.getLeft() != null){
//                if(root.getLeft().getRight() != null && root.getRight().getRight() != null){
//                    if(root.getLeft().getRight().getValue().equals(root.getRight().getLeft().getValue())) {
//                        this.size -= 1;}}}}
            return 1+findSize(root.left)+findSize(root.right);

}}}