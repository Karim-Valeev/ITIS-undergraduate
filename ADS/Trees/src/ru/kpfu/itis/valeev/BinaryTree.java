package ru.kpfu.itis.valeev;

import java.util.Objects;

public class BinaryTree<T> {

    private class Node<T>{

        private Node<T> parent;
        private T data;
        private Node<T> left;
        private Node<T> right;

        public Node(Node<T> parent, T data, Node<T> left, Node<T> right) {
            this.parent = parent;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node<T> getParent() {
            return parent;
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

        public void setParent(Node<T> parent) {
            this.parent = parent;
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
            return Objects.equals(parent, node.parent) &&
                    Objects.equals(data, node.data) &&
                    Objects.equals(left, node.left) &&
                    Objects.equals(right, node.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(parent, data, left, right);
        }

        @Override
        public String toString() {
            return  "\n parent= " + parent +
                    "\n data= " + data +
                    "\n left= " + left +
                    "\n right= " + right;
        }
    }

    private Node<T> root;
    private static StringBuilder str;

    public void dfs(Node<T> n){
        if(root == null){
            System.out.println("Tree is empty.");

        } else {

            str.append(n.getData()).append(" ");

            if(n.getLeft() != null) dfs(n.getLeft());

            if(n.getRight() != null) dfs(n.getRight());
        }
    }

    @Override
    public String toString() {
        dfs(root);
        return str.toString();
    }

    // ToDo в икуалсе будет какой-то из обходов
}
