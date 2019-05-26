package Services;

import Models.Angajat;
import Models.Medic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ServiciuScriereCitireMedici {

    private static ServiciuAngajati auxiliaryInstance = ServiciuAngajati.getInstance();
    private static ServiciuScriereCitireMedici instance = new ServiciuScriereCitireMedici();
    private static String path = "Medici.csv";

    public static ServiciuScriereCitireMedici getInstance() {
        return instance;
    }

    public boolean WriteInFile(){
        for(int i = 0; i < auxiliaryInstance.NumarAngajati(); i++){
            Angajat angajat = auxiliaryInstance.ReturnareAngajat(i);
            if(angajat instanceof Medic){
                try (PrintWriter writer = new PrintWriter(new FileOutputStream(path, false))) {

                    Medic m = (Medic)angajat;
                    StringBuilder sb = new StringBuilder();
                    sb.append(m.getId());
                    sb.append(',');
                    sb.append(m.getPassword());
                    sb.append(',');
                    sb.append(m.getNume());
                    sb.append(',');
                    sb.append(m.getPrenume());
                    sb.append(',');
                    sb.append(m.getSalary());
                    sb.append(',');
                    sb.append(m.getSpecializare());
                    sb.append(',');
                    sb.append(m.getVechime());
                    sb.append('\n');

                    writer.write(sb.toString());

                }catch(IOException e){

                    e.printStackTrace();
                }
            }
        }
        return true;
    }


    public List<Medic> readFromCSV() {
        List<Medic> listaMedici = new ArrayList<>();

        try {

            FileReader fileReader = new FileReader(path);
            LineNumberReader lineNumberReader = new LineNumberReader(fileReader);

            String line, aux[];

            while ((line = lineNumberReader.readLine()) != null) {

                aux = line.split(",");
                Medic medic = new Medic(aux[0], aux[1], aux[2], aux[3], Integer.parseInt(aux[4]), aux[5], Integer.parseInt(aux[6]));
                listaMedici.add(medic);
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
