package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static javafx.application.Platform.exit;

public class DBConnect {
    private Connection conn = null;
    private Statement st;
    private ResultSet rs;

    public  DBConnect(){
        int tries = 0;
        while(tries < 3) { //trzykrotna automatyczna próba połączenia się z bazą danych
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                conn = DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/user",
                        "user", "password");

                st = conn.createStatement();
                tries = 3;
            } catch (SQLException ex) {
                if (conn == null) {
                    tries++;
                }
                if(conn==null && tries==2) {
                    System.out.println("Brak połączenia! Zamykamy program! Bład podczas trzykrotnego łączenia się z bazą!");
                    System.out.println("SQLException: " + ex.getMessage());
                    System.out.println("SQLState: " + ex.getSQLState());
                    System.out.println("VendorError: " + ex.getErrorCode());
                    exit();
                }
            } catch (Exception e) {
                 e.printStackTrace();
            }
        }
    }
    public List<String> GetData(String query){
        List<String> lista = new ArrayList<String>();
        List<String> dbcolumns = new ArrayList<String>();
        String t ="";
        try{
            rs =  st.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int col=rsmd.getColumnCount();

            for (int i = 1; i <= col; i++ ) {
                dbcolumns.add(rsmd.getColumnName(i));
            }

            while(rs.next())
            {
                for(String s:dbcolumns)
                {
                    t = t + " " + rs.getString(s);
                }
                lista.add(t);
                t="";
            }


        }catch(NullPointerException e){
            System.out.print("Bład podczas wysyłania zapytania do bazy danych!!!");
        }
        catch(Exception ex){
            System.out.print(ex);
            ex.printStackTrace();
        }
        return lista;
    }
    public void addData(String values){

        try {
            st.executeUpdate("INSERT INTO books VALUES (" + values + ")");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Blad podczas wstawiania wartosci!!!");
        }
    }
}