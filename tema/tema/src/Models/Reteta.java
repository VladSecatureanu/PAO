package Models;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Objects;

public class Reteta {

    protected Integer nr;
    protected String medicamente;
    protected String doctor;
    protected Boolean decontat;
    protected String dataEliberarii;

    public String getDataEliberarii() {
        return dataEliberarii;
    }

    public void setDataEliberarii(String dataEliberarii) {
        this.dataEliberarii = dataEliberarii;
    }

    public Reteta(Integer nr, String medicamente, String doctor, Boolean decontat , String dataEliberarii) {
        this.dataEliberarii = dataEliberarii;
        this.nr = nr;
        this.medicamente = medicamente;
        this.doctor = doctor;
        this.decontat = decontat;
    }

    public Reteta() {
        this.dataEliberarii = "";
        this.nr = -1;
        this.medicamente = "";
        this.doctor = "";
        this.decontat = null;
    }

    public Integer getNr() {
        return nr;
    }

    public void setNr(Integer nr) {
        this.nr = nr;
    }

    public String getMedicamente() {
        return medicamente;
    }

    public void setMedicamente(String medicamente) {
        this.medicamente = medicamente;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public Boolean getDecontat() {
        return decontat;
    }

    public void setDecontat(String casaAsigurare) {
        this.decontat = decontat;
    }

    public void afisareInfoReteta() {
        System.out.println("\nReteta : \n" + medicamente + "\nDoctor: " + doctor + "\nDecontat: " + decontat + "\nData eliberarii: " + dataEliberarii);

    }

    @Override
    public boolean equals(Object ob) {
        if (this == ob) return true;
        if (ob == null || getClass() != ob.getClass()) return false;
        Reteta reteta = (Reteta) ob;
        return nr.equals(reteta.nr) &&
                medicamente.equals(reteta.medicamente) &&
                doctor.equals(reteta.doctor) &&
                decontat.equals(reteta.decontat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nr, medicamente, doctor, decontat);
    }

}
