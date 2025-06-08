package org.pixabay.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderEnum {
    POPULAR, LATEST;

    @JsonValue
    public String toValue() {
        return this.name().toLowerCase();
    }
}
