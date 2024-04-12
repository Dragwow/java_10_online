package ua.com.alevel;

import java.util.Arrays;

public class MatList<E extends Number> {
    private E[] elements;
    private int size;

    public MatList(){

    }
    public MatList(E[] ... numbers){

    }

    public MatList(MatList ... numbers){

    }

    public void add(E n){
        if (n != null){
            if (elements.length <= size){
                createArray();
            }
            elements[size++] = n;
        }
    }

    public void add(E ... n){
        for (E e : n){
            add(e);
        }
    }

    public void join(MatList<E> ... ml){
        for (MatList<E> list : ml) {
            add(list.toArray());
        }
    }
    public E[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    public void intersection (MatList ... ml){
        for (MatList<E> list : ml){
            int newSize = 0;
            for (int i = 0; i < size; i++) {
                if (list.equals(elements[i])){
                    elements[newSize++] = elements[i];
                }
            }
            size = newSize;
        }
    }

    public void sortDesc(){

    }

    private void bubbleSorter(){

    }

    public E[] toArray(int firstIndex, int lastIndex) {
        return Arrays.copyOfRange(elements, firstIndex, lastIndex + 1);
    }
    private void createArray(){
        E[] newArray =(E[])new Number[elements.length + 10];
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        elements = newArray;
    }


}
