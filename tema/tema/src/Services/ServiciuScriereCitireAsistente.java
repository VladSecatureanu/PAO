package Services;

import Models.Angajat;
import Models.Asistenta;
import Models.Medic;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ServiciuScriereCitireAsistente {

    private static ServiciuAngajati auxiliaryInstance = ServiciuAngajati.getInstance();
    private static ServiciuScriereCitireAsistente instance = new ServiciuScriereCitireAsistente();
    private static String path = "Asistente.csv";

    public static ServiciuScriereCitireAsistente getInstance() {
        return instance;
    }

    public boolean WriteInFile(){
        for(int i = 0; i < auxiliaryInstance.NumarAngajati(); i++){
            Angajat angajat = auxiliaryInstance.ReturnareAngajat(i);
            if(angajat instanceof Asistenta){
                try (PrintWriter writer = new PrintWriter(new FileOutputStream(path, false))) {

                    Asistenta m = (Asistenta)angajat;
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
                    sb.append(m.getSectie());
                    sb.append(',');
                    sb.append(m.getMedic());
                    sb.append('\n');

                    writer.write(sb.toString());

                }catch(IOException e){

                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    public List<Asistenta> readFromCSV() {
        List<Asistenta> listaAsistente = new ArrayList<>();

        try {

            FileReader fileReader = new FileReader(path);
            LineNumberReader lineNumberReader = new LineNumberReader(fileReader);

            String line, aux[];

            while ((line = lineNumberReader.readLine()) != null) {

                aux = line.split(",");
                Asistenta asistenta = new Asistenta(aux[0], aux[1], aux[2], aux[3], Integer.parseInt(aux[4]), Integer.parseInt(aux[5]), aux[6]);
                listaAsistente.add(asistenta);
            }

            lineNumberReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } //catch (ParseException e) {
        //    e.printStackTrace();
        //}

        return listaAsistente;
    }
}
