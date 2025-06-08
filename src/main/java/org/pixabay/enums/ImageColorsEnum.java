package org.pixabay.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ImageColorsEnum {
    GRAYSCALE,
    TRANSPARENT,
    RED,
    ORANGE,
    YELLOW,
    GREEN,
    TURQUOISE,
    BLUE,
    LILAC,
    PINK,
    WHITE,
    GRAY,
    BLACK,
    BROWN;

    @JsonValue
    public String toValue() {
        return this.name().toLowerCase();
    }
}