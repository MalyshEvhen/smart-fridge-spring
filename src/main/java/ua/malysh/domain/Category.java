package ua.malysh.domain;

public enum Category {
    MEAT("meat"),
    FISH("fish"),
    SOUSE("souse"),
    GROCERY("grocery"),
    VEGETABLES("vegetables"),
    FRUITS("fruits"),
    SPICES("spices"),
    BAKERY("bakery"),
    DAIRY("dairy");
    
    private final String title;
    
    Category(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }
}
