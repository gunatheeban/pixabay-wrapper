package org.pixabay.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CategoryEnum {
    BACKGROUNDS,
    FASHION,
    NATURE,
    SCIENCE,
    EDUCATION,
    FEELINGS,
    HEALTH,
    PEOPLE,
    RELIGION,
    PLACES,
    ANIMALS,
    INDUSTRY,
    COMPUTER,
    FOOD,
    SPORTS,
    TRANSPORTATION,
    TRAVEL,
    BUILDINGS,
    BUSINESS,
    MUSIC;

    @JsonValue
    public String toValue() {
        return this.name().toLowerCase();
    }
}

