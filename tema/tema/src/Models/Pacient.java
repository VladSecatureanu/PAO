package Models;

import java.util.Arrays;
import java.util.Objects;

public class Pacient implements Comparable<Pacient>{

    protected String[] nume;
    protected String cnp;
    protected Integer varsta;
    protected String afectiune;


    public Pacient(String nume, String prenume, String cnp, Integer varsta, String afectiune) {
        this.nume = new String[2];
        this.nume[0] = prenume;
        this.nume[1] = nume;
        this.cnp = cnp;
        this.varsta = varsta;
        this.afectiune = afectiune;
    }

    public Pacient() {
        this.nume = new String[2];
        this.nume[0] = "";
        this.nume[1] = "";
        this.cnp = "";
        this.varsta = 0;
        this.afectiune = "";
    }


    public String[] getNume() {
        return nume;
    }

    public void setNume(String[] nume) {
        this.nume = nume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public Integer getVarsta() {
        return varsta;
    }

    public void setVarsta(Integer varsta) {
        this.varsta = varsta;
    }

    public String getAfectiune() {
        return afectiune;
    }

    public void setAfectiune(String afectiune) {
        this.afectiune = afectiune;
    }

    @Override
    public boolean equals(Object ob) {
        if (this == ob) return true;
        if (ob == null || getClass() != ob.getClass()) return false;
        Pacient pacient = (Pacient) ob;
        return Arrays.equals(nume, pacient.nume) &&
                Objects.equals(cnp, pacient.cnp) &&
                Objects.equals(varsta, pacient.varsta) &&
                afectiune.equals(pacient.afectiune);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(cnp, varsta, afectiune);
        result = 31 * result + Arrays.hashCode(nume);
        return result;
    }

    @Override
    public int compareTo(Pacient ob) {
        return this.nume[0].compareTo(ob.nume[0]) + this.nume[0].compareTo(ob.nume[1]);
    }

    public void afisareInfo() {

        System.out.println("Nume: " + nume[0] + "\nPrenume: " + nume[1] + "\nCNP: " + cnp);

    }
}
