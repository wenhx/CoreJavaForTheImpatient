package ch06.e01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Stack<E> implements Iterable<E> {
    private ArrayList<E> innerList = new ArrayList<>();

    public boolean push(E e) {
        return innerList.add(e);
    }

    public E pop() {
        if (innerList.isEmpty())
            throw new RuntimeException("The stack is empty.");

        int lastIndex = innerList.size() - 1;
        E result = innerList.get(lastIndex);
        innerList.remove(lastIndex);
        return result;
    }

    public boolean isEmpty() {
        return innerList.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return innerList.iterator();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<E> spliterator() {
        return Iterable.super.spliterator();
    }
}
