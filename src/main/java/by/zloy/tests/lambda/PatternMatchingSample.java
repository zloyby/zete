package by.zloy.tests.lambda;

import by.zloy.utils.LambdaVisitorUtil;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class PatternMatchingSample {

    private final static Function<Object, Double> AREA_CALCULATOR = new LambdaVisitorUtil<Double>()
            .on(Circle.class).then(c -> Math.PI * c.getRadius() * c.getRadius())
            .on(Rectangle.class).then(r -> r.getHeight() * r.getWidth());

    private final static Function<Object, Double> PERIMETER_CALCULATOR = new LambdaVisitorUtil<Double>()
            .on(Circle.class).then(c -> 2 * Math.PI * c.getRadius())
            .on(Rectangle.class).then(r -> 2 * r.getHeight() + 2 * r.getWidth());

    public static void main(String[] args) {
        List<Object> figures = Arrays.asList(new Circle(4), new Rectangle(6, 7));

        double totalArea = figures.stream()
                .map(AREA_CALCULATOR)
                .reduce(0.0, Double::sum);
        System.out.println("Total area = " + totalArea);

        double totalPerimeter = figures.stream()
                .map(PERIMETER_CALCULATOR)
                .reduce(0.0, Double::sum);
        System.out.println("Total perimeter = " + totalPerimeter);
    }

    static class Rectangle {
        private final double width;
        private final double height;

        Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        double getWidth() {
            return width;
        }

        double getHeight() {
            return height;
        }
    }

    static class Circle {
        private final double radius;

        Circle(double radius) {
            this.radius = radius;
        }

        double getRadius() {
            return radius;
        }
    }
}
