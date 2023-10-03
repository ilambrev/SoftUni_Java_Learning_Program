package bg.softuni.ex20230218reseller.models.enums;

public enum ConditionNameEnum {

    EXCELLENT("Excellent"),
    GOOD("Good"),
    ACCEPTABLE("Acceptable");

    public final String label;

    ConditionNameEnum(String label) {
        this.label = label;
    }

}
