package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.SQLException;


public class Controller {

    @FXML private ListView<String> lista;
    @FXML private TextField ISBN;
    @FXML private TextField author;
    @FXML private TextField addISBN;
    @FXML private TextField addTitle;
    @FXML private TextField addAuthor;
    @FXML private TextField addYear;

    public void WriteToListView(String zapytanie)
    {
        DBConnect connect = new DBConnect();
        for (String string: connect.GetData(zapytanie)){
            lista.getItems().add(string);
        }
    }
    public void bAll(){
        String query="SELECT * FROM `books` WHERE 1";
        WriteToListView(query);
    }
    public void bISBN(){
        WriteToListView("SELECT * FROM `books` WHERE isbn='"+ISBN.getText()+"'");
    }
    public void bName(){
        String n=author.getText();
        if(n.contains(" "))
            {
                WriteToListView("SELECT * FROM `books` WHERE author like '"+author.getText()+"'");
            }
        else{ //mozliwosc wyszukiwania tylko po nazwisku autora
            WriteToListView("SELECT * FROM `books` WHERE author like '%"+author.getText()+"'");
        }
    }
    public void bClear(){
        lista.getItems().clear();
    }
    public void adddata() throws SQLException {
        DBConnect connect = new DBConnect();

        connect.addData("'"+addISBN.getText()+"'"+",'"+addTitle.getText()+"','"+addAuthor.getText()+"',"+addYear.getText());

    }

}
