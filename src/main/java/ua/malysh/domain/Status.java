package ua.malysh.domain;

public enum Status {
    IN_PROCESS("in_process"),
    FINISHED("finished"),
    CANCELED("canceled");

    private final String title;

    Status(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
