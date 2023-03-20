package com.SpringCrud.Tierheim.DTO;

public class TierSaveDTO {


    private String tiername;

    private String tierart;

    private String tiergeschlecht;

    private String tiergeburtstag;

    private String tierrasse;

    private String tierbild;

    public TierSaveDTO(String tiername, String tierart, String tiergeschlecht, String tiergeburtstag, String tierrasse, String tierbild) {

        this.tiername = tiername;
        this.tierart = tierart;
        this.tiergeschlecht = tiergeschlecht;
        this.tiergeburtstag = tiergeburtstag;
        this.tierrasse = tierrasse;
        this.tierbild = tierbild;
    }

    public TierSaveDTO() {
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

    @Override
    public String toString() {
        return "TierDTO{" +
                ", tiername='" + tiername + '\'' +
                ", tierart='" + tierart + '\'' +
                ", tiergeschlecht='" + tiergeschlecht + '\'' +
                ", tiergeburtstag='" + tiergeburtstag + '\'' +
                ", tierrasse='" + tierrasse + '\'' +
                ", tierbild='" + tierbild + '\'' +
                '}';
    }
}
