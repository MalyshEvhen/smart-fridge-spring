package ua.malysh.domain;

public enum Role {
    USER("user"),
    ADMIN("admin");
    
    private final String title;
    
    Role(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }
}
