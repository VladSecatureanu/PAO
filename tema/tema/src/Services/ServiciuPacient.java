package Services;

import Models.*;

import java.util.*;

public class ServiciuPacient {

    private static final Pacient[] listaPacienti = new Pacient[4];

    private static final ServiciuPacient instance = new ServiciuPacient();

    private ServiciuPacient() {
        listaPacienti[0] = new Pacient("Ivascu","Vlad-Mihai", "111111", 20, null);
        listaPacienti[1] = new Pacient("Secatureanu","Vlad-Cristian", "222222", 20, null);
        listaPacienti[2] = new Pacient("Staniea","Alexandru-Cristian", "333333", 20, null);
        listaPacienti[3] = new Pacient("Dima","Linux", "444444", 20, null);
    }

    public static ServiciuPacient getInstance() {
        return instance;
    }

    public Pacient getPacientDupaNume(String nume) {

        for(Pacient p : listaPacienti) {
            if(p.getNume().equals(nume)) {
                return p;
            }
        }
        return null;
    }

    public void AfisareDupaNume(){

        List<Pacient> pacientiDupaNume = new ArrayList<>(Arrays.asList(listaPacienti));
        Collections.sort(pacientiDupaNume);

        for(Pacient p : pacientiDupaNume)
            p.afisareInfo();
    }

    public Pacient ReturnarePacient(Integer index){

        if(index < listaPacienti.length)
            return new Pacient(listaPacienti[index].getNume()[0] , listaPacienti[index].getNume()[1], listaPacienti[index].getCnp(), listaPacienti[index].getVarsta(), listaPacienti[index].getAfectiune());
        else
            return new Pacient();

    }

    public int NumarPacienti(){

        return listaPacienti.length;

    }
}
