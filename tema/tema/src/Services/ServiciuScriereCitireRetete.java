package Services;

import Models.Reteta;

import javax.print.DocFlavor;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ServiciuScriereCitireRetete {

    private static ServiciuRetete auxiliaryInstance = ServiciuRetete.getInstance();
    private static ServiciuScriereCitireAsistente instance = new ServiciuScriereCitireAsistente();
    private static String path = "Medici.csv";

    public static ServiciuScriereCitireAsistente getInstance() {
        return instance;
    }

    public boolean WriteInFile(){
        for(int i = 0; i < auxiliaryInstance.NumarRetete(); i++) {
            Reteta reteta = auxiliaryInstance.ReturnareReteta(i);

            try (PrintWriter writer = new PrintWriter(new FileOutputStream(path, false))) {

                StringBuilder sb = new StringBuilder();
                sb.append(reteta.getNr());
                sb.append(',');
                sb.append(reteta.getDoctor());
                sb.append(',');
                sb.append(reteta.getMedicamente());
                sb.append(',');
                sb.append(reteta.getDecontat());
                sb.append(',');
                sb.append(reteta.getDataEliberarii());
                sb.append('\n');

                writer.write(sb.toString());

            } catch (IOException e) {

                e.printStackTrace();
            }
        }
        return true;
    }

    public List<Reteta> readFromCSV() {
        List<Reteta> listaMedici = new ArrayList<>();

        try {

            FileReader fileReader = new FileReader(path);
            LineNumberReader lineNumberReader = new LineNumberReader(fileReader);

            String line, aux[];

            while ((line = lineNumberReader.readLine()) != null) {

                aux = line.split(",");
                Reteta medic = new Reteta(Integer.parseInt(aux[0]), aux[1], aux[2], Boolean.valueOf(aux[3]), aux[4]);
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
