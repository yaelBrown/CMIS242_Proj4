/**
 * Filename: StateChangeable.java
 * Author: Yael Brown
 * Date: May 10, 2020
 * A program to manage a real estate database
 */

public interface StateChangeable<T extends Enum<T>> {
    void changeState(T t);
}

