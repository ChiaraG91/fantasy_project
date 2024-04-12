package com.example.springfantasy.entities.enums;

public enum StatusEnum {

    ACTIVE("active"),
    INACTIVE("inactive");

    private String descrizione;

    StatusEnum(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
