package com.jx.mall.enums;

import lombok.Getter;

@Getter
public enum PaymentypeEnum {

    PAY_ONLINE(1),
    ;

    Integer code;

    PaymentypeEnum(Integer code) {
        this.code = code;
    }
}
