package ua.malysh.domain;

public enum Measure {
    KILOGRAM("kg"),
    LITER("l"),
    PACKAGE("pack"),
    PIECE("pts");
    
    private final String title;
    Measure(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }
}
