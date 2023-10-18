package ch07.e15;

import java.util.AbstractList;
import java.util.function.IntFunction;

public class ImmutableIntFunctionList<E> extends AbstractList<E> {
    private IntFunction<E> factory;

    public ImmutableIntFunctionList(IntFunction<E> factory) {
        this.factory = factory;
    }

    @Override
    public E get(int index) {
        return factory.apply(index);
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }
}
