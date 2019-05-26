package Models;

import java.util.Objects;

public class Angajat extends User implements Comparable<Angajat>, Cloneable{

    protected String nume;
    protected String prenume;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    protected Integer salary;

    public Angajat(String id, String password, String nume, String prenume, Integer salary) {
        super(id, password);
        this.nume = nume;
        this.prenume = prenume;
        this.salary = salary;
    }

    public Angajat(String nume, String prenume, Integer salary) {

        super();
        this.nume = nume;
        this.prenume = prenume;
        this.salary = salary;
    }

    public Angajat() {

        this.nume = "";
        this.prenume = "";
        this.salary = 0;
    }

    @Override
    public int compareTo(Angajat ob) {

        int numefamilie = this.nume.compareTo(ob.nume);
        return numefamilie == 0 ? this.nume.compareTo(ob.prenume) : numefamilie;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, prenume);
    }

    @Override
    public boolean equals(Object ob) {
        if (this == ob) return true;
        if (ob == null || getClass() != ob.getClass()) return false;
        Angajat angajat = (Angajat) ob;
        return Objects.equals(nume, angajat.nume) &&
                Objects.equals(prenume, angajat.prenume);
    }

    @Override
    public void afisareInfo() {
        super.afisareInfo();
        System.out.println("Nume: " + nume + "\nPrenume: " + prenume + "\nSalariu: " + salary);

    }

    @Override
    public String returnareInfo() {

        StringBuilder aux = new StringBuilder();
        aux.append(super.returnareInfo());
        aux.append(nume + " " + prenume + " " + salary + " ");

        return aux.toString();

    }
}
