package Services;

import Models.Angajat;
import Models.Asistenta;
import Models.Medic;
import Models.Reteta;

public class ServiciuRetete {
    private static final Reteta listaReteta[] = new Reteta[4];

    private static final ServiciuRetete instance = new ServiciuRetete();

    public static ServiciuRetete getInstance() {
        return instance;
    }


    private ServiciuRetete() {
        listaReteta[0] = new Reteta(1 , "Nurofen", "Antonio" , true,"21.05.2000");
        listaReteta[1] = new Reteta(2 , "Nurofen", "Antonio" , true,"21.05.2000");
        listaReteta[2] = new Reteta(3 , "Nurofen", "Antonio" , true,"21.05.2000");
        listaReteta[3] = new Reteta(4 , "Nurofen", "Antonio" , true,"21.05.2000");
    }

    public Reteta ReturnareReteta(Integer index){

        if(index < listaReteta.length)
            return listaReteta[index];
        else
            return new Reteta();

    }

    public int NumarRetete(){

        return listaReteta.length;

    }
}
