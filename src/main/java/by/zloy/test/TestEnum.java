package by.zloy.test;

public enum TestEnum {

    BEST_SINGLETON;

    public static TestEnum getInstance() {
        return BEST_SINGLETON;
    }
}
