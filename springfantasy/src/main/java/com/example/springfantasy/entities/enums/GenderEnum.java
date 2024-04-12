package com.example.springfantasy.entities.enums;

public enum GenderEnum {

    MALE("male"),
    FAMALE("famale");

    private final String descrizione;

    GenderEnum(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}
