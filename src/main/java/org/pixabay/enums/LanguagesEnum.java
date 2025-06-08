package org.pixabay.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum LanguagesEnum {
    CS,
    DA,
    DE,
    EN,
    ES,
    FR,
    ID,
    IT,
    HU,
    NL,
    NO,
    PL,
    PT,
    RO,
    SK,
    FI,
    SV,
    TR,
    VI,
    TH,
    BG,
    RU,
    EL,
    JA,
    KO,
    ZH;

    @JsonValue
    public String toValue() {
        return this.name().toLowerCase();
    }
}
