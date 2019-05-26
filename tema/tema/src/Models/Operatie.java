package Models;

import java.util.*;

public class Operatie implements Verificare{

    private List<Angajat> listaPersonal;
    private Pacient pacient;
    private String afectiune;

    public Operatie (Pacient p , Medic m ,String a){
        listaPersonal = new ArrayList<Angajat>();
        pacient = p;
        listaPersonal.add(m);
        afectiune = a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operatie operatie = (Operatie) o;
        return listaPersonal.equals(operatie.listaPersonal) &&
                pacient.equals(operatie.pacient) &&
                afectiune.equals(operatie.afectiune);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listaPersonal, pacient, afectiune);
    }

    public List<Angajat> getListaPersonal() {
        return listaPersonal;
    }

    public void setListaPersonal(List<Angajat> listaPersonal) {
        this.listaPersonal = listaPersonal;
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    public String getAfectiune() {
        return afectiune;
    }

    public void setAfectiune(String afectiune) {
        this.afectiune = afectiune;
    }

    @Override
    public boolean VerificaAfectiune() {
        if(pacient.afectiune.equals(afectiune))
            return true;
        else
            return false;
    }
}
