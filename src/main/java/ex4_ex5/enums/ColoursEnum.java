package ex4_ex5.enums;

public enum ColoursEnum {
    COLORS("Colors"),
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    public String expectedText;

    ColoursEnum(String expectedText) {
        this.expectedText = expectedText;
    }
}
