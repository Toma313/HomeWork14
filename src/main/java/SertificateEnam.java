public enum SertificateEnam {
    VALIDSERTIFICATE("valid", false),
    NOTVALIDSERTIFICATE("notvalid", true),
    NOTVALIDCERTIFICATE12("notvalid1", true),
    ALLNULL("allnulls", true),
    LETTERS("allletters", true);

    private String type;
    private boolean result;

    SertificateEnam(String type, boolean result) {
        this.type = type;
        this.result = result;
    }

    public String getType() {
        return type;
    }
}


