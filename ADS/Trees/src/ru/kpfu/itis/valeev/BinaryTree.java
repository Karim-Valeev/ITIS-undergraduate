package ru.kpfu.itis.valeev;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BinaryTree<T> {

    private class Node<T>{

        private T data;
        private Node<T> left;
        private Node<T> right;

        public Node(T data, Node<T> left, Node<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public T getData() {
            return data;
        }

        public Node<T> getLeft() {
            return left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(data, node.data) &&
                    Objects.equals(left, node.left) &&
                    Objects.equals(right, node.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, left, right);
        }

        @Override
        public String toString() {
            return  "\n data= " + data +
                    "\n left= " + left +
                    "\n right= " + right;
        }
    }

    private Node<T> root;
    private static StringBuilder str;
    private Comparator<T> comparator;

    public BinaryTree(T value, Comparator<T> comparator){
        this.root = new Node<>(value,null,null);
        this.comparator = comparator;
    }

    public void add(T value) {
        root = addRec(root, value);
    }

    private Node<T> addRec(Node<T> current, T value) {
        if (current == null) {
            return new Node(value, null, null);
        }

        if (comparator.compare(value,current.data) < 0) {
            current.left = addRec(current.left, value);
        } else if (comparator.compare(value,current.data) > 0) {
            current.right = addRec(current.right, value);
        } else {
            //value already exists
            return current;
        }

        return current;
    }

    public void dfs(Node<T> n){ // InOrder левое корень правое
        if(root == null){
            System.out.println("Tree is empty.");

        } else {
            if(n.getLeft() != null) dfs(n.getLeft());

            str.append(n.getData()).append(" ");

            if(n.getRight() != null) dfs(n.getRight());
        }
    }

    public void bfs() {
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            str.append(node.getData()).append(" ");

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right!= null) {
                nodes.add(node.right);
            }
        }
    }

    public String toStringDFS() {
        str = new StringBuilder();
        dfs(root);
        return str.toString();
    }
    public String toStringBFS() {
        str = new StringBuilder();
        bfs();
        return str.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BinaryTree)) return false;
        BinaryTree<?> that = (BinaryTree<?>) o;
        return this.toStringDFS().equals(that.toStringDFS());
    }

    @Override
    public int hashCode() {
        return Objects.hash(root, comparator);
    }

    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<>(1, Comparator.comparingInt(x -> x));
        bt.add(23);
        bt.add(47);
        bt.add(7);
        bt.add(23);
        bt.add(81);
        bt.add(55);

        System.out.println(bt.toStringDFS() + "\n");
        System.out.println(bt.toStringBFS());

    }

}
