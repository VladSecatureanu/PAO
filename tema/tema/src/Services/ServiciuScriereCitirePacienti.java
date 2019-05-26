package Services;

import Models.Pacient;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ServiciuScriereCitirePacienti {


    private static ServiciuPacient auxiliaryInstance = ServiciuPacient.getInstance();
    private static ServiciuScriereCitirePacienti instance = new ServiciuScriereCitirePacienti();
    private static String path = "Pacienti.csv";

    public static ServiciuScriereCitirePacienti getInstance() {
        return instance;
    }

    public boolean WriteInFile(){
        for(int i = 0; i < auxiliaryInstance.NumarPacienti(); i++){
            Pacient pacient = auxiliaryInstance.ReturnarePacient(i);
            File file = new File(path);
            try (PrintWriter writer = new PrintWriter(new FileOutputStream(path, false))) {

                StringBuilder sb = new StringBuilder();
                sb.append(pacient.getNume()[0]);
                sb.append(',');
                sb.append(pacient.getNume()[1]);
                sb.append(',');
                sb.append(pacient.getCnp());
                sb.append(',');
                sb.append(pacient.getVarsta());
                sb.append(',');
                sb.append(pacient.getAfectiune());
                sb.append('\n');

                writer.write(sb.toString());

            }catch(IOException e){

                e.printStackTrace();
            }
        }
        return true;
    }

    public List<Pacient> readFromCSV() {
        List<Pacient> listaMedici = new ArrayList<>();

        try {

            FileReader fileReader = new FileReader(path);
            LineNumberReader lineNumberReader = new LineNumberReader(fileReader);

            String line, aux[];

            while ((line = lineNumberReader.readLine()) != null) {

                aux = line.split(",");
                Pacient pacient = new Pacient(aux[0], aux[1], aux[2], Integer.parseInt(aux[3]), aux[4]);
                listaMedici.add(pacient);
            }

            lineNumberReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } //catch (ParseException e) {
        //    e.printStackTrace();
        //}

        return listaMedici;
    }

}
