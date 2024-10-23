package com.illevia.illevia.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//@JsonFormat(with = JsonFormat.Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)
public class Resultat {
    //@JsonIgnore
    private int numberMatched;
    //@JsonIgnore
    private int numberReturned;
    //@JsonProperty
    private Record[] records;
    //@JsonIgnore
    private List<Link> links;

    public Resultat() {
    }

    public Resultat(List<Record> records) {
        this.records = (Record[]) records.stream().toArray(Record[]::new);
    }

    @Override
    public String toString() {
        return "Resultat{" +
                "numberMatched=" + numberMatched +
                ", numberReturned=" + numberReturned +
                ", records=" + records +
                ", links=" + links +
                '}';
    }

    public Record[] getRecords() {
        return records;
    }

    public void setRecords(Record[] records) {
        this.records = records;
    }

    public int getNumberMatched() {
        return numberMatched;
    }

    public void setNumberMatched(int numberMatched) {
        this.numberMatched = numberMatched;
    }

    public int getNumberReturned() {
        return numberReturned;
    }

    public void setNumberReturned(int numberReturned) {
        this.numberReturned = numberReturned;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }


    public List<Record> getRecordsByIdentifiantStation(String identifiantStation) {
        return Arrays.stream(this.records)
                .filter(r -> r.matchesIdentifiantStation(identifiantStation))
                /* équivalent à

                 */
                .collect(Collectors.toList());

    }

}
