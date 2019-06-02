package Services;

import java.sql.*;
import Models.Medic;
import Services.AuditAngajati;

public class JDBCMedici {

    private static JDBCMedici ourInstance = new JDBCMedici();

    public static JDBCMedici getInstance() {
        return ourInstance;
    }

    private JDBCMedici() {

    }

    public void InsertMedic(Medic medic){

        AuditAngajati.WriteInFile("InsertMedic", Thread.currentThread().toString());  //("InsertMedic " + ", Thread: " + Thread.currentThread());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("url",
                    "root", "admin");
            PreparedStatement preparedStatement = null;

            String comanda = "INSERT INTO medic(id_medic, password, nume, prenume, data_angajare, salariu, specializare, vechime) values(?,?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(comanda);
            preparedStatement.setString(1, medic.getId());
            preparedStatement.setString(2, medic.getPassword());
            preparedStatement.setString(3, medic.getNume());
            preparedStatement.setString(4, medic.getPrenume());
            preparedStatement.setInt(5, medic.getSalary());
            preparedStatement.setString(6, medic.getSpecializare());
            preparedStatement.setInt(7, medic.getVechime());

            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void ReadAngajat(){

        AuditAngajati.WriteInFile("ReadAngajat ", Thread.currentThread().toString());


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("url",
                    "root", "admin");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from angajat");

            while (resultSet.next()) {
                System.out.println("id=" + resultSet.getInt(1)
                        + ", password=" + resultSet.getString(2)
                        + ", nume=" + resultSet.getString(3)
                        + ", prenume= " + resultSet.getString(4)
                        + ", salariu= " + resultSet.getInt(5));

            }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void DeleteAngajat(String id){

        AuditAngajati.WriteInFile("DeleteAngajat "+ Thread.currentThread().toString());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("url",
                    "root", "admin");
            PreparedStatement preparedStatement = null;

            String comanda = "DELETE from angajat WHERE id_angajat = ?";

            preparedStatement = connection.prepareStatement(comanda);

            preparedStatement.setString(1, id);


            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
