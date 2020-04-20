package co.edu.ff.orders;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.Arrays;
import java.util.List;

public class EqualsJava {
    public static void main(String[] args) {
        Apple a1 = new Apple(new Color("RED"), 100);
        Apple a2 = new Apple(new Color("RED"), 100);

        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        List<Integer> integers1 = Arrays.asList(1, 2, 3, 4);
        System.out.println(integers.equals(integers1));
    }


    @Value
    @EqualsAndHashCode
    public static class Color {
        String value;
    }

    @Value
    @EqualsAndHashCode
    public static class Apple {
        Color color;
        Integer weight;
    }
}
