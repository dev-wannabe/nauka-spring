package pl.devwannabe.naukaspring.singleton_example;

public enum PersonUtils2 {

    INSTANCE;

    public final String operations (Person person) {
        return person.name.toUpperCase();
    }

}
