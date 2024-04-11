package com.example.springfantasy.entities.enums;

public enum ClasseEnum {

    GUERRIERI("guerrieri"),
    RANGER("ranger"),
    MAGHI("maghi"),
    LADRI("maghi");

    private String descrizione;

    ClasseEnum(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
