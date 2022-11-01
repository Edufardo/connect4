package types;

public enum Error {

    NOT_EMPTY,
    NOT_OWNER,
    WRONG_COORDINATES,
    NULL;

    public boolean isNull() {
        return this == Error.NULL;
    }
}