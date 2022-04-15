package com.company.springbootcrudbasic.enum2;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public enum TypeIdentificationEnum {
    CC(0,"CC"),
    CE(1,"CE"),
    RUT(2,"RUT");

    private final Integer value;
    private final String identification;
}
