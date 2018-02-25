package ex4_ex5.enums;

public enum MetalsEnum {
    METALS("metal"),
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    public String expectedText;

    MetalsEnum(String expectedText) {
        this.expectedText = expectedText;
    }
}