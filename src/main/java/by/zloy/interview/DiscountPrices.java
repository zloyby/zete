package by.zloy.interview;

public class DiscountPrices {
    public enum DiscountType {
        Standard, // 6%
        Seasonal, //12%
        Weight; // <10=6%, >10=18%
    }

    public static double getDiscountedPrice(double cartWeight,
                                            double totalPrice,
                                            DiscountType discountType) {
        return switch (discountType) {
            case Weight -> (totalPrice - totalPrice * ((cartWeight <= 10) ? 0.06 : 0.18));
            case Seasonal -> (totalPrice - totalPrice * 0.12);
            case Standard -> (totalPrice - totalPrice * 0.06);
        };
    }

    public static void main(String[] args) {
        System.out.println(getDiscountedPrice(12, 100, DiscountType.Weight));
    }
}
