package org.example.classes;

public class CustomLinkedList<T> {

    // Attributes
    private Node<T> head;// referencia al primer nodo en la lista
    private int size;//tamaño de la lista

    // Constructor
    public CustomLinkedList() {
        this.head = null;
        this.size = 0;
    }

    private static class Node<T> {
        T data; //El dato que almacena el nodo
        Node<T> next; //referencia al siguiente nodo en la lista

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Agrega un nuevo nodo con el dato especifico al final de la lista
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    //Devuelve el elemento en la posicion especifica
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Devuelve el tamaño de la lista
    public int size() {
        return size;
    }

    // Devuelve true si la lista esta vacia
    public boolean isEmpty() {
        return size == 0;
    }

    //Elimina el nodo en la posicion especifica
    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }


}
