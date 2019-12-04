package communication;

public enum WorksheetUrl {

    WITHOUT_ANSWER_SPACE_URL("http://sbcontent.imaxprogram.com:8080/app/inhouse/opsWorksheetHtmlWithoutAnswerSpace/"),
    WITH_ANSWER_SPACE_URL("http://sbcontent.imaxprogram.com:8080/app/inhouse/opsWorksheetHtmlWithAnswerSpace/");
    private String displayName;

    WorksheetUrl(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() { return displayName; }

    // Optionally and/or additionally, toString.
    @Override public String toString() { return displayName; }
}
