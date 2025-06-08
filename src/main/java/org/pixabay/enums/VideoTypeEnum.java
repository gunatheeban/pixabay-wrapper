package org.pixabay.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum VideoTypeEnum {
    ALL, FILM, ANIMATION;

    @JsonValue
    public String toValue() {
        return this.name().toLowerCase();
    }
}
