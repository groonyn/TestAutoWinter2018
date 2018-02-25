package ex4_ex5.enums;

public enum ServiceElementsEnum {
    SERVICE_DROPDOWN_1("Support"),
    SERVICE_DROPDOWN_2("Dates"),
    SERVICE_DROPDOWN_3("Complex Table"),
    SERVICE_DROPDOWN_4("Simple Table"),
    SERVICE_DROPDOWN_5("Table With Pages"),
    SERVICE_DROPDOWN_6("Different Elements");

    public String expectedText;

    ServiceElementsEnum(String expectedText) {
        this.expectedText = expectedText;
    }
}