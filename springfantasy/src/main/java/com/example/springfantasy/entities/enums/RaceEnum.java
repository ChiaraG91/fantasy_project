package com.example.springfantasy.entities.enums;

public enum RaceEnum {

    UMANI("umani"),
    NANI("nani"),
    ELFI("elfi"),
    ORCHI("orchi");

    private String descrizione;
    RaceEnum(String descrizione) {
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
