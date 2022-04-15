package com.company.springbootcrudbasic.enum2;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public enum TypePersonEnum {
    PERSON_NATURAL(0,"NATURAL"),
    PERSON_LEGAL(1,"LEGAL");

    private final Integer value;
    private final String type;
}
