package Models;

import java.util.Date;
import java.util.Objects;

public class Medic extends Angajat{

    private String specializare;
    private Integer vechime;

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public Integer getVechime() {
        return vechime;
    }

    public void setVechime(Integer vechime) {
        this.vechime = vechime;
    }

    public Medic(String id, String password, String nume, String prenume, Integer salary, String specializare, Integer vechime) {
        super(id, password, nume, prenume, salary);
        this.specializare = specializare;
        this.vechime = vechime;
    }

    public Medic(String nume, String prenume, Integer salary, String specializare, Integer vechime) {
        super(nume, prenume, salary);
        this.specializare = specializare;
        this.vechime = vechime;
    }

    @Override
    public void afisareInfo() {

        super.afisareInfo();
        System.out.println("Specializare: " + specializare);
        System.out.println("Vechime: " + vechime);
    }

    @Override
    public String returnareInfo() {

        StringBuilder aux = new StringBuilder();
        aux.append(super.returnareInfo());
        aux.append(specializare + " ");
        aux.append(vechime + " \n");

        return aux.toString();
    }


    @Override
    public boolean equals(Object ob) {
        if (this == ob) return true;
        if (ob == null || getClass() != ob.getClass()) return false;
        if (!super.equals(ob)) return false;
        Medic medic = (Medic) ob;
        return specializare.equals(medic.specializare) &&
                vechime.equals(medic.vechime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), specializare, vechime);
    }

}
