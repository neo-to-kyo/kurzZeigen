
package TreeADT;

import java.io.Serializable;

public abstract class Result<V> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Result() {
    }

    private static class Failure<V> extends Result<V> {

        private static final long serialVersionUID = 1L;
        private final RuntimeException exception;

        private Failure(String message) {
            super();
            this.exception = new IllegalStateException(message);
        }

        @Override
        public boolean equals(Object o) {
            return false;
        }



        private Failure(Exception e) {
            super();
            this.exception = new IllegalStateException(e.getMessage(), e);
        }

        @Override
        public String toString() {
            return String.format("Failure(%s)", exception.getMessage());
        }
    }

    private static class Success<V> extends Result<V> {

        private static final long serialVersionUID = 1L;
        private final V value;

        private Success(V value) {
            super();
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof Success && isEquals((Success<V>) o);
        }


        private boolean isEquals(Success<V> o) {
            return this.value == o.getValue();
        }
        public V getValue() {
            return this.value;
        }


        @Override
        public String toString() {

            return String.format("Success(%s)", value.toString());
        }
    }

    public static <V> Result<V> failure(String message) {
        return new Failure<>(message);
    }

    public static <V> Result<V> failure(Exception e) {
        return new Failure<V>(e);
    }

    public static <V> Result<V> failure(RuntimeException e) {
        return new Failure<V>(e);
    }

    public static <V> Result<V> success(V value) {
        return new Success<>(value);
    }
}