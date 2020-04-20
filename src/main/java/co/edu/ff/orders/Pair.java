package co.edu.ff.orders;

import lombok.Value;

@Value(staticConstructor = "of")
public class Pair<T, R> {
    T left;
    R right;
}
