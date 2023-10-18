package ch07.e16;

import java.util.AbstractList;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.IntFunction;

public class CachedImmutableIntFunctionList<E> extends AbstractList<E> {
    private int maxNumber = 100;
    private Queue<E> cache = new ArrayDeque<E>();
    private IntFunction<E> factory;

    public CachedImmutableIntFunctionList(IntFunction<E> factory) {
        this.factory = factory;
    }

    @Override
    public E get(int index) {
        E funcResult = factory.apply(index);
        cache.add(funcResult);
        while (cache.size() > maxNumber) {
            cache.poll();
        }
        return funcResult;
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public Queue<E> getCache() {
        return cache;
    }
}
