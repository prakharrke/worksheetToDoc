package command;

public enum Commands {

    OPEN_FILE_IN_MAC("open -a TextEdit"),
    OPEN_FILE_IN_WINWORD("winword.exe");
    private String displayName;

    Commands(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() { return displayName; }

    // Optionally and/or additionally, toString.
    @Override public String toString() { return displayName; }
}
