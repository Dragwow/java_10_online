package ua.com.alevel;

import java.util.Arrays;

public class MatList<E extends Number> {
    private E[] elements;
    private int size;

    public MatList(){
        elements = (E[]) new Number[10];
        size = 0;
    }
    public MatList(E[] ... numbers){
        this();
        for (E[] number : numbers){
            add(number);
        }
    }

    public MatList(MatList ... numbers){
        this();
        join(numbers);

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
            add((E[]) list.toArray());
        }
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
        bubbleSorter(elements, size);
    }

    public void sortDesc(int firstIndex, int lastIndex){
        for (int i = firstIndex; i < lastIndex; i++) {
            for (int j = firstIndex + 1; j < (lastIndex - i); j++) {
                if (elements[j - 1 ].doubleValue() < elements[j].doubleValue()){
                    E temp = elements[j];
                    elements[j] = elements[j - 1];
                    elements[j - 1] = temp;
                }

            }

        }
    }

    public void sortDesc(E value){
        int startIndex = -1;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(value)){
                startIndex = i;
                break;
            }
        }
        if (startIndex != -1){
            sortDesc();
        }
    }

    public void sortAsc(){
        bubbleSorterAsc(elements, size);
    }

    public void sortAsc(int firstIndex, int lastIndex){
        for (int i = firstIndex; i < lastIndex; i++) {
            for (int j = firstIndex + 1; j < (lastIndex - i); j++) {
                if (elements[j - 1 ].doubleValue() < elements[j].doubleValue()){
                    E temp = elements[j];
                    elements[j] = elements[j - 1];
                    elements[j - 1] = temp;
                }
            }
        }
    }

    public void sortAsc(E value){
        int startIndex = -1;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(value)){
                startIndex = i;
                break;
            }
        }
        if (startIndex != -1){
            sortAsc();
        }
    }

    public Number get(int index){
        return elements[index];

    }
    public Number getMax(){
        Number[] array = Arrays.copyOf(elements, size);
        bubbleSorter(elements, size);
        return array[0];
    }

    public Number getMin(){
        Number[] array = Arrays.copyOf(elements, size);
        bubbleSorterAsc(elements, size);
        return array[0];
    }

    public Number getAverage(){
        double sum = 0.0;
        for (int i = 0; i < size; i++) {
            sum += elements[i].doubleValue();
        }
        return sum / size;
    }

    public Number getMedian(){
        if(size == 0){
            return  null;
        }
        Number[] array = Arrays.copyOf(elements, size);
        bubbleSorter(array, this.size);
        double median;
        if (size % 2 == 0){
            median = (array[size / 2].doubleValue() + array[size / 2 -1].doubleValue()) / 2;
        }
        else {
            median = array[size / 2].doubleValue();
        }
        return median;
    }

    public Number[] toArray() {
        Number[] array = new Number[size];
        for (int i = 0; i < size; i++) {
            array[i] = elements[i];
        }
        return array;
    }

    public Number[] toArray(int firstIndex, int lastIndex){
        if (firstIndex < 0 || firstIndex >= size || lastIndex < 0 || lastIndex >= size || firstIndex > lastIndex) {
            return new Number[0];
        }
        int newArraySize = lastIndex - firstIndex + 1;
        Number[] array = new Number[newArraySize];
        for (int i = 0; i < newArraySize; i++) {
            array[i] = elements[firstIndex + i];
        }
        return array;
    }

    public MatList<E> cut(int firstIndex, int lastIndex){
        if (firstIndex < 0 || firstIndex >= size || lastIndex < 0 || lastIndex >= size || firstIndex > lastIndex) {
            return new MatList<>();
        }
        int newArraySize = firstIndex - lastIndex + 1;
        E[] newElements = (E[]) new Number[newArraySize];
        for (int i = 0; i < newArraySize; i++) {
            newElements[i] = elements[firstIndex + i];
        }
        MatList<E> newList = new MatList<>();
        newList.elements = newElements;
        newList.size = newArraySize;
        return  newList;
    }

    public void clear(){
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public void clear(Number[] numbers){
        if (numbers == null || numbers.length == 0){
            return;
        }
        int newSize = 0;
        E[] newElements = (E[]) new Number[elements.length];
        for (int i = 0; i < size; i++) {
            boolean found = false;
            for (Number number : numbers) {
                if (elements[i].equals(number)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                newElements[newSize++] = elements[i];
            }
        }
        elements = newElements;
        size = newSize;
    }


    private void bubbleSorter(Number[] sortArr, int size){
        int n = size;
        Number temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (sortArr[j - 1].doubleValue() < sortArr[j].doubleValue()){
                    temp = sortArr[j - 1];
                    sortArr[j - 1] = sortArr[j];
                    sortArr[j - 1] = temp;
                }

            }

        }
    }

    private void bubbleSorterAsc(Number[] sortArr, int size){
        int n = size;
        Number temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (sortArr[j - 1].doubleValue() < sortArr[j].doubleValue()){
                    temp = sortArr[j - 1];
                    sortArr[j - 1] = sortArr[j];
                    sortArr[j - 1] = temp;
                }

            }

        }
    }

    private void createArray(){
        E[] newArray =(E[])new Number[elements.length + 10];
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        elements = newArray;
    }


}
