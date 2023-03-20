package com.SpringCrud.Tierheim.entity;

import jakarta.persistence.*;

@Entity
@Table(name= "tier")

public class Tier {
    @Id
    @Column(name = "tier_id", length =50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tierid;

    @Column(name = "tier_name", length =50)
    private String tiername;
    @Column(name = "tier_art", length = 50)
    private String tierart;
    @Column(name = "tier_geschlecht", length = 10)
    private String tiergeschlecht;
    @Column(name = "tier_geburtstag", length =50)
    private String tiergeburtstag;

    @Column(name = "tier_rasse", length =50)
    private String tierrasse;

    @Column(name = "tier_bild", length =100)
    private String tierbild;

    public Tier(int tierid, String tiername, String tierart, String tiergeschlecht, String tiergeburtstag, String tierrasse, String tierbild) {
        this.tierid = tierid;
        this.tiername = tiername;
        this.tierart = tierart;
        this.tiergeschlecht = tiergeschlecht;
        this.tiergeburtstag = tiergeburtstag;
        this.tierrasse = tierrasse;
        this.tierbild = tierbild;
    }

    public Tier(String tiername, String tierart, String tiergeschlecht, String tiergeburtstag, String tierrasse, String tierbild) {
        this.tiername = tiername;
        this.tierart = tierart;
        this.tiergeschlecht = tiergeschlecht;
        this.tiergeburtstag = tiergeburtstag;
        this.tierrasse = tierrasse;
        this.tierbild = tierbild;
    }

    public Tier(){

    }

    public int getTierid() {
        return tierid;
    }

    public void setTierid(int tierid) {
        this.tierid = tierid;
    }

    public String getTiername() {
        return tiername;
    }

    public void setTiername(String tiername) {
        this.tiername = tiername;
    }

    public String getTierart() {
        return tierart;
    }

    public void setTierart(String tierart) {
        this.tierart = tierart;
    }

    public String getTiergeschlecht() {
        return tiergeschlecht;
    }

    public void setTiergeschlecht(String tiergeschlecht) {
        this.tiergeschlecht = tiergeschlecht;
    }

    public String getTiergeburtstag() {
        return tiergeburtstag;
    }

    public void setTiergeburtstag(String tiergeburtstag) {
        this.tiergeburtstag = tiergeburtstag;
    }

    public String getTierrasse() {
        return tierrasse;
    }

    public void setTierrasse(String tierrasse) {
        this.tierrasse = tierrasse;
    }

    public String getTierbild() {
        return tierbild;
    }

    public void setTierbild(String tierbild) {
        this.tierbild = tierbild;
    }
}
