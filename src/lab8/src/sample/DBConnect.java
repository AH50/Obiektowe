package sample;

import javafx.scene.control.ListView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnect {
    private Connection conn = null;
    private Statement st;
    private ResultSet rs;

    public  DBConnect(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/user",
                    "user","password");
            st = conn.createStatement();

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }catch(Exception e){e.printStackTrace();}
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


        }catch(Exception ex){
            System.out.print(ex);
            ex.printStackTrace();
        }
        return lista;
    }
    public void addData(String values) throws SQLException {
        st.executeUpdate("INSERT INTO books VALUES (" + values + ")");
    }
}