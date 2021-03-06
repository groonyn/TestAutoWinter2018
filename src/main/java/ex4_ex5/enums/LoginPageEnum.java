package ex4_ex5.enums;

public enum LoginPageEnum {
    URL("https://jdi-framework.github.io/tests/"),
    LOGIN("epam"),
    PASSWORD("1234"),
    TITLE("Index Page"),
    USERNAME("PITER CHAILOVSKII"),
    TEXT_MAIN_TITLE_CENTER("EPAM FRAMEWORK WISHES…"),
    TEXT_BELOW_MAIN_TITLE_CENTER("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING " +
            "ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, " +
            "QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE " +
            "IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

    public String expectedText;

    LoginPageEnum(String expectedText) {
        this.expectedText = expectedText;
    }
}