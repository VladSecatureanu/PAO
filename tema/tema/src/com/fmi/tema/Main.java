package com.fmi.tema;

import Services.ServiciuScriereCitireAsistente;
import Services.ServiciuScriereCitirePacienti;

public class Main {

    public static void main(String[] args) {


        ServiciuScriereCitireAsistente ss = ServiciuScriereCitireAsistente.getInstance();

        ss.WriteInFile();

        //Pacient p = new Pacient("Ivascu","Vlad-Mihai", "1980346123889", 20, null);

        //String[] sanky;

        //sanky = p.getNume();

        //System.out.println(sanky[0]);

    }
}
