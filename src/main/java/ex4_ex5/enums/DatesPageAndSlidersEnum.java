package ex4_ex5.enums;

public enum DatesPageAndSlidersEnum {
    URL_DATES("https://jdi-framework.github.io/tests/page4.htm");

    public String expectedText;

    DatesPageAndSlidersEnum(String expectedText) {
        this.expectedText = expectedText;
    }
}
