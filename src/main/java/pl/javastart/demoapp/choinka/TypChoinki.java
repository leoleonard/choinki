package pl.javastart.demoapp.choinka;

public enum TypChoinki {
    LEGIT("Prawdziwa"),
    FAKE("Sztuczna"),
    OTHER("Inna");

    private String displayName;

    TypChoinki(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
