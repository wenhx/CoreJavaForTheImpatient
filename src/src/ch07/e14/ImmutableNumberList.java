package ch07.e14;

import java.util.AbstractList;

public class ImmutableNumberList extends AbstractList<Integer> {
    private int maxValue;

    public ImmutableNumberList(int maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index > maxValue)
            throw new IndexOutOfBoundsException();

        return index;
    }

    @Override
    public int size() {
        return maxValue;
    }


}
