package dev.sassine.api;

public sealed interface Result<E, A> {

    record Success<E, A>(A value) implements Result<E, A> {
    }

    record Failure<E, A>(E error) implements Result<E, A> {
    }
}