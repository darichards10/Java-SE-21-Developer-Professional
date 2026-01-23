package se21.exam;

public class BaseClass {

    public int pub = 1;
    protected int pro = 2;
    int def = 3;           // package-private (default)
    private int pri = 4;

    protected void protectedMethod() {}
    void defaultMethod() {}
    private void privateMethod() {}
}