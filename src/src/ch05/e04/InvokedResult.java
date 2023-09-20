package ch05.e04;

public final class InvokedResult<T> {
    private int errorCode = 0;
    private T result = null;

    public InvokedResult(T result) {
        this.result = result;
    }

    public InvokedResult(int errorCode, T result) {
        this.errorCode = errorCode;
        this.result = result;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public T getResult() {
        return result;
    }

    public boolean IsSucceeded() {
        return errorCode == 0;
    }

    @Override
    public String toString() {
        return "InvokedResult { " +
                "errorCode=" + errorCode +
                ", result=" + result +
                " }";
    }
}
