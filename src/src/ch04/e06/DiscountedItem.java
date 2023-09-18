package ch04.e06;

import java.util.Objects;

public class DiscountedItem extends Item {
    private double discount;

    public DiscountedItem(String description, double price, double discount) {
        super(description, price);
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
        if (o instanceof DiscountedItem) {
            DiscountedItem that = (DiscountedItem) o;
            return super.equals(o) && Double.compare(discount, that.discount) == 0;
        }
        if (o instanceof Item)
            return super.equals(o);
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount);
    }
}
