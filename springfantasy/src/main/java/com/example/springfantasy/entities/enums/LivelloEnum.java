package com.example.springfantasy.entities.enums;

public enum LivelloEnum {

    NOVIZIO("novizio","Colpo semplice"),
    PRINCIPIANTE("principiante","Difesa temporanea"),
    INTERMEDIO("intermedio","Attacco potenziato"),
    ESPERTO("esperto","Guarigione rapida"),
    MAESTRO("maestro","Colpo critico");

    private String descrizione;
    private String abilitàSpeciale;

    LivelloEnum(String descrizione, String abilitàSpeciale) {
        this.descrizione = descrizione;
        this.abilitàSpeciale = abilitàSpeciale;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getAbilitàSpeciale() {
        return abilitàSpeciale;
    }

    public void setAbilitàSpeciale(String abilitàSpeciale) {
        this.abilitàSpeciale = abilitàSpeciale;
    }
}
