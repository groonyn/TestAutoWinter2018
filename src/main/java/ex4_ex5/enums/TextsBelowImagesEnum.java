package ex4_ex5.enums;

public enum TextsBelowImagesEnum {
    TEXT_1("To include good practices and ideas from successful EPAM projec"),
    TEXT_2("To be flexible and customizable"),
    TEXT_3("To be multiplatform"),
    TEXT_4("Already have good base (about 20 internal and some external projects), wish to get more…");

    public String expectedText;

    TextsBelowImagesEnum(String expectedText) {
        this.expectedText = expectedText;
    }
}