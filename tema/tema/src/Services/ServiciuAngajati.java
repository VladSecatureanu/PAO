package Services;

import Models.*;

import java.util.*;

public class ServiciuAngajati {

    private static final Angajat listaAngajati[] = new Angajat[4];

    private static final ServiciuAngajati instance = new ServiciuAngajati();

    private ServiciuAngajati() {
        listaAngajati[0] = new Angajat("Roundhouse", "Kick", "Joe", "Rogan", 444 );
        listaAngajati[1] = new Medic("Wanderlei", "Silva", 777, "Chirurgie", 12 );
        listaAngajati[2] = new Asistenta("Dana", "White", 555, 3, ((Medic)listaAngajati[1]).getNume());
        listaAngajati[3] = new Medic("user" , "password" ,"Connor", "McGregor", 888, "Plastician", 8 );
    }

    public static ServiciuAngajati getInstance() {
        return instance;
    }

    public void AfisareDupaNume(){

        List<Angajat> angajatiDupaNume = new ArrayList<Angajat>(Arrays.asList(listaAngajati));
        Collections.sort(angajatiDupaNume);

        for(Angajat a : listaAngajati)
            a.afisareInfo();
    }

    public Angajat ReturnareAngajat(Integer index) {
        if (index < listaAngajati.length){

            return listaAngajati[index];

        }
        else
            return new Angajat();
    }

    public int NumarAngajati() {
        return listaAngajati.length;
    }

    public String returneazaMedici(){

        StringBuilder aux = new StringBuilder();

        for(int i=0; i < listaAngajati.length; i++){

            if(listaAngajati[i] instanceof Medic)
                aux.append(listaAngajati[i].returnareInfo());


        }
        return aux.toString();
    }

    public String returneazaAsistente(){

        StringBuilder aux = new StringBuilder();

        for(int i=0; i < listaAngajati.length; i++){

            if(listaAngajati[i] instanceof Asistenta)
                aux.append(listaAngajati[i].returnareInfo());
        }
        return aux.toString();
    }

    public String returneazaTotiAngajatii(){

        StringBuilder aux = new StringBuilder();

        for(int i=0; i < listaAngajati.length; i++){

            aux.append(listaAngajati[i].returnareInfo());
        }
        return aux.toString();
    }

}
