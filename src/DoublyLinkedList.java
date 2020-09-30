import java.util.Scanner;

public class DoublyLinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }
        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DoublyLinkedList(){
        header = new Node<>(null,null,null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        }
        return header.getNext().getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return trailer.getPrev().getElement();
    }
    //update methods
    public void addBetween(E e, Node<E> predecessor, Node<E> successor){
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    public E remove(Node<E> node){
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    public void print(){
        Node<E> current = header.getNext();
        if (current.getNext()!= null){
            System.out.print(current.getElement() + " ");
            current = current.getNext();
        }
    }

    public void printReverse(){
        Node<E> current = trailer.getPrev();
        if (current.getPrev()!= null){
            System.out.print(current.getElement() + " ");
            current = current.getPrev();
        }
    }

    public void buildInput(){
        DoublyLinkedList<E> list = new DoublyLinkedList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a character or digit. Press 'Enter' to continue.");
        String input = sc.nextLine();
        E element = (E) input;
        Node<E> node = new Node<>(element, header, trailer);


    }
}