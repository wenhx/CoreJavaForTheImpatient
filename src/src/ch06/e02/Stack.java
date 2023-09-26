package ch06.e02;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.IntFunction;

public class Stack<E> implements Iterable<E> {
    private int length = 0;
    private E[] array;
    private IntFunction<E[]> constr;

    public Stack(IntFunction<E[]> constr) {
        Objects.requireNonNull(constr);
        this.constr = constr;
        this.array = constr.apply(4);
    }

    public void push(E element) {
        if (length < array.length) {
            array[length++] = element;
            return;
        }

        E[] newArray = constr.apply(array.length * 2);
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[length++] = element;
        array = newArray;
    }

    public E pop() {
        E result = array[length - 1];
        length--;
        return result;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return Arrays.stream(array).iterator();
    }
}
