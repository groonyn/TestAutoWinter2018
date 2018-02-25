package ex4_ex5.enums;

public enum CheckboxEnum {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    public String expectedText;

    CheckboxEnum(String expectedText) {
        this.expectedText = expectedText;
    }
}
