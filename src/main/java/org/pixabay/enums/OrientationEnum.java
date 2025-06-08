package org.pixabay.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OrientationEnum {
    ALL, HORIZONTAL, VERTICAL;

    @JsonValue
    public String toValue() {
        return this.name().toLowerCase();
    }
}
