package practica2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame {

    int filas = 4;
    int columnas = 4;
    Btn[][] botones ;


    private JLabel Jug;
    private JLabel Vel;
    private static JLabel ju;
    private JTextField jug;
    private JComboBox vel;
    private JPanel Tablero;
    private JButton Pausa;
    int Tam;
    static String JU;
    String V[] = {"10", "20", "30", "40", "50", "60", "70", "80", "90", "100"};

    public Ventana() {

        setSize(500, 400);
        setTitle("Game Of Life");
        setDefaultCloseOperation(Ventana.EXIT_ON_CLOSE);
        setLayout(null);
        
        
        Jug = new JLabel("Gamer : ");
        ju = new JLabel();
        Vel = new JLabel("Velocidad: ");
        jug = new JTextField("");
        vel = new JComboBox(V);
        Pausa = new JButton("Pausa");
        Tablero = new JPanel();
        
        
        
        Tablero.setBackground(Color.DARK_GRAY);
        Tablero.setBounds(150, 30, 300, 300);
        Tablero.setLayout(null);
        add(Tablero);
        add(Jug);
        add(ju);
        add(Vel);
        add(vel);
        add(Pausa);

        //Tam = Integer.parseInt(IN.tam1.getText());
        Jug.reshape(10, 30, 50, 40);
        ju.reshape(55, 30, 100, 40);
        Vel.reshape(10, 70, 100, 40);
        vel.reshape(10, 100, 70, 20);
        Pausa.reshape(10, 150, 100, 30);
        Btn1();

    }

    public void Btn1() {
       int n=5;
        int tam= n;
        botones = new Btn[tam][tam];
        Tablero.setLayout(new GridLayout(tam,tam));
       
      
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                botones[i][j] = new Btn( i, j, 52, 52);
                Tablero.add(botones[i][j]);
            }

        }
        Tablero.updateUI();
    }

}
