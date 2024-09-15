package org.example.enums;

public enum TransmissionType
{
    MANUAL("Manual"),
    AUTOMATIC("Automatic");

    private final String description;

    TransmissionType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
