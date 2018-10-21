public enum VehicleMakes {
    TOYOTA("Public"),
    FORD("Public"),
    BMW("Public"),
    AUDI("Public"),
    PORCHE("Private"),
    TESLA("Public"),
    GM("Public"),
    HONDA("Public"),
    HYUNDAI("Public"),
    ;

    private final String companyStatus; //public or private company

    VehicleMakes(String companyStatus) {
        this.companyStatus = companyStatus;
    }

    public String getCompanyStatus() {
        return companyStatus;
    }
}
