package refactula.design.patterns.factory;

public enum ForgetfulStorage implements Storage {
    INSTANCE;

    @Override
    public void store(String key, String value) {

    }

    @Override
    public String retrieve(String key) {
        return null;
    }
}
