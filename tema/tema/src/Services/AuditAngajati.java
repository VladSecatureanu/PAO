package Services;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuditAngajati {

    private static AuditAngajati instance = new AuditAngajati();
    private static ServiciuAngajati auxiliaryInstance = ServiciuAngajati.getInstance();
    private static String path = "Actions.csv";

    public static AuditAngajati getInstance() {
        return instance;
    }

    private static boolean WriteInFile(String actiune){

        File file = new File(path);
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(path, true))) {

            StringBuilder sb = new StringBuilder();
            sb.append("Action");
            sb.append(',');
            sb.append("Time Stamp");
            sb.append('\n');

            sb.append(actiune);
            sb.append(',');
            sb.append((new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).format(new Date()));
            sb.append('\n');

            writer.write(sb.toString());

        }catch(IOException e){

            e.printStackTrace();
        }

        return true;
    }

    public void ConsolaDupaNume(){

        auxiliaryInstance.AfisareDupaNume();
        WriteInFile("Afisare dupa nume");

    }

    public String ReturnareInfo(){

        WriteInFile("ReturnareInfo");

        return auxiliaryInstance.returneazaMedici();


    }
}
