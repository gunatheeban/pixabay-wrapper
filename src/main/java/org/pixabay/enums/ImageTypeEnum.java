package org.pixabay.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ImageTypeEnum {
    ALL, PHOTO, ILLUSTRATION, VECTOR;

    @JsonValue
    public String toValue() {
        return this.name().toLowerCase();
    }
}
