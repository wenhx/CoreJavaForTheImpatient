package ch06.e02;

import java.util.Arrays;
import java.util.Iterator;

public class Stack2<E> implements Iterable<E> {
    int length = 0;
    private Object[] innerArray = new Object[4];

    public void push(E element) {
        if (length < innerArray.length) {
            innerArray[length++] = element;
            return;
        }

        Object[] newArray = new Object[innerArray.length * 2];
        for (int i = 0; i < innerArray.length; i++) {
            newArray[i] = innerArray[i];
        }
        newArray[length++] = element;
        innerArray = newArray;
    }

    public E pop() {
        E result = (E)innerArray[length - 1];
        length--;
        return result;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return Arrays.stream(innerArray).map(o -> (E)o).iterator();
    }
}
