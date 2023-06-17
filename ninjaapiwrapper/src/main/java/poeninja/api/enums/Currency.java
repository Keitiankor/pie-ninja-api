package poeninja.api.enums;

import lombok.Getter;

@Getter
public enum Currency {
    Currency("Currency"),
    Fragment("Fragment");

    private String str;

    private Currency(String str) {
        this.str = str;
    }
}
