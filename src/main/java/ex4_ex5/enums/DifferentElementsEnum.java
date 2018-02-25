package ex4_ex5.enums;

public enum DifferentElementsEnum {
    URL_DIFFERENT_ELEMENTS("https://jdi-framework.github.io/tests/page8.htm"),
    INPUT("Input");

    public String expectedText;

    DifferentElementsEnum(String expectedText) {
        this.expectedText = expectedText;
    }
}
