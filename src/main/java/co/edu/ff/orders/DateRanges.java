package co.edu.ff.orders;

import com.google.common.collect.Range;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;

public class DateRanges {
    public static void main(String[] args) {
        Range<LocalDateTime> range = Range.closed(
                LocalDateTime.now(),
                LocalDateTime.now().plus(1, ChronoUnit.DAYS)
        );

        boolean contains = range.contains(LocalDateTime.now().plus(2, ChronoUnit.DAYS));
        System.out.println("contains = " + contains);
    }
}
