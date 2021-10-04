/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_t1a1_433lambda;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 *
 * @author usuario
 */
public class CalcPrestamo extends Application {
    //Atributos
    BorderPane root;
    TilePane root2;
    Label lbAnualInteres;
    TextField tfAnualInteres;
    Label lbYears;
    TextField tfYears;
    Label lbLoan;
    TextField tfLoan;
    Label lbMonthlyPay;
    TextField tfMonthlyPay;
    Label lbTotal;
    TextField tfTotal;
    Button btnResultado;
    
    @Override
    public void start(Stage primaryStage) {
        //Escogemos el layout que tendremos
        root = new BorderPane();
        //Escogemos el TilePane que va a incluir todos los datos menos el botón y sus características luego lo añadimos al root
        root2 = new TilePane();
        root2.setPrefColumns(2);
        root.setPadding(new Insets(10,10,10,10));
        root2.setVgap(5);
        root2.setHgap(5);
        //Añadimos el root2 al root en la posición central
        root.setCenter(root2);
        
        
        //Creamos la escena, teniendo como layout "root" y de dimensiones 350x250
        Scene scene = new Scene(root, 350, 200);
        
        //Añadimos Label lbAnualInteres en el root2
        lbAnualInteres = new Label("Annual Interest Rate: ");
        root2.getChildren().add(lbAnualInteres);
        
        //Añadimos TextField tfAnualInteres en el root2
        tfAnualInteres = new TextField();
        root2.getChildren().add(tfAnualInteres);
        
        //Añadimos Label lbYears en el root2
        lbYears = new Label("Number of Years: ");
        root2.getChildren().add(lbYears);
        
        //Añadimos TextField tfYears en el root2
        tfYears = new TextField();
        root2.getChildren().add(tfYears);
        
        //Añadimos Label lbLoan en el root2
        lbLoan = new Label("Loan Amount: ");
        root2.getChildren().add(lbLoan);
        
        //Añadimos TextField tfLoan en el root2
        tfLoan = new TextField();
        root2.getChildren().add(tfLoan);
        
        //Añadimos Label lbMonthlyPay en el root2
        lbMonthlyPay = new Label("Monthly Payment: ");
        root2.getChildren().add(lbMonthlyPay);
        
        //Añadimos TextField tfMonthyPay en el root2
        tfMonthlyPay = new TextField();
        root2.getChildren().add(tfMonthlyPay);
        
        //Añadimos Label lbTotal en el root2
        lbTotal = new Label("Total Payment: ");
        root2.getChildren().add(lbTotal);
        
        //Añadimos TextField tfTotal en el root2
        tfTotal = new TextField();
        root2.getChildren().add(tfTotal);
        
        //Añadimos Button btnResultado en el root
        btnResultado = new Button("Calculate");
        //btnResultado.setAlignment(Pos.BOTTOM_RIGHT);
        btnResultado.setOnAction(e -> {
            //Obtenemos el interese anual
            double i = Double.parseDouble(tfAnualInteres.getText());
            //Obtenemos los años
            double n = Double.parseDouble(tfYears.getText());
            //Obtenemos la cantidad
            double h = Double.parseDouble(tfLoan.getText());
            //Introducimos la variable donde se guardará el resultado de la fórmula para ver el pago mensual
            double m;
            //Introducimos la cantidad total 
            double t;
            //Introducimos auxiliares
            double r = i/(100 * 12);
            
            double numerador = h*r;
            double denominador = 1 - Math.pow(1+r, -12*n);
            
            //Calculo de mensual
            m = numerador/denominador;
            //Calculo del total
            t = m*n*12;
            
            tfMonthlyPay.setText("$"+ String.format("%.2f", m));
            tfTotal.setText("$" +  String.format("%.2f", t));
            
            
        });
        
        //Alineamos btnResultado en la posición derecha y abajo
        BorderPane.setAlignment(btnResultado, Pos.BOTTOM_RIGHT);
        //Añadimos el boton
        root.setBottom(btnResultado);

        
        //Escogemos titulo para la ventana
        primaryStage.setTitle("Ejercicio 4.3.3 Expresiones Lambda");
        //Establecemos que en la ventana que la escena sea "scene"
        primaryStage.setScene(scene);
        //Mostramos la ventana
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
