package com.illevia.illevia.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Record {
    @JsonProperty("@id")
    private int id;
    @JsonProperty("identifiant_station")
    private String identifiantStation;
    @JsonProperty("nom_station")
    private String nomStation;
    @JsonProperty("code_ligne")
    private String codeLigne;
    @JsonProperty("sens_ligne")
    private String sensLigne;
    @JsonProperty("heure_estimee_depart")
    private String heureEstimeeDepart;
    @JsonProperty("date_modification")
    private String dateModification;
    @JsonProperty("cle_modification")
    private String cleModifiction;
    @JsonProperty("cle_tri")
    private String cleTri;

    public Record() {
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", identifiantStation='" + identifiantStation + '\'' +
                ", nomStation='" + nomStation + '\'' +
                ", codeLigne='" + codeLigne + '\'' +
                ", sensLigne='" + sensLigne + '\'' +
                ", heureEstimeeDepart='" + heureEstimeeDepart + '\'' +
                ", dateModification='" + dateModification + '\'' +
                ", cleModifiction='" + cleModifiction + '\'' +
                ", cleTri='" + cleTri + '\'' +
                '}';
    }

    public boolean matchesIdentifiantStation(String identifiantStation) {
        if (identifiantStation == null || this.identifiantStation == null) {
            return false;
        }
        return identifiantStation.equals(this.identifiantStation);

    }
}
