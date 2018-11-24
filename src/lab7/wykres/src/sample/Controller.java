package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private LineChart<?,?> lineChart;
    XYChart.Series dane= new XYChart.Series();
    @FXML private TextField from;
    @FXML private TextField probkowanie;
    @FXML private TextField to;
    @FXML private TextField a;
    @FXML private TextField b;
    @FXML private TextField c;
    @FXML private TextField d;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lineChart.getData().addAll(dane);
        }
    @FXML public void draw(){
        dane.getData().clear();
        int prob = Integer.parseInt(probkowanie.getText());
        float a_=0;
        float b_=0;
        float c_=0;
        float d_=0;
        int x;
        a_ = Integer.parseInt(a.getText());
        b_ = Integer.parseInt(b.getText());
        c_ = Integer.parseInt(c.getText());
        d_ = Integer.parseInt(d.getText());

        for (x = Integer.parseInt(from.getText()); x <= Integer.parseInt(to.getText()); x=x+prob) {
            dane.getData().add(new XYChart.Data(x, funkcja(a_,b_,c_,d_,x )));
        }
}
    public float funkcja(float a,float b,float c,float d,int x){
        return a*x*x*x+b*x*x+c*x+d;
    }

}
