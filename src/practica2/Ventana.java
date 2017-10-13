package practica2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame {

    Btn[][] botones;

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
       
        Pausa.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                PausaActionPerformed(evt);
            }
int conti=0;
int contj=0;
            private void PausaActionPerformed(ActionEvent evt) {
                Hilo h = new Hilo();
                Pausa.setEnabled(false);
                h.start();
               /*
                for (int i = 1; i < botones.length-2; i++) {
                    for (int j = 1; j < botones[i].length-1; j++) {
                        //Lectura Esquinas donde 9=n-1
                        if (botones[0][0].getText().equals(".")||botones[0][9].getText().equals(".")||botones[9][0].getText().equals(".")||botones[9][9].getText().equals(".")) {
                        if (botones[0][0].getText().equals(".")) {botones[0][1].setText("X"); botones[1][0].setText("X"); botones[1][1].setText("X");}   
                        if (botones[0][9].getText().equals(".")) {botones[0][8].setText("X"); botones[1][8].setText("X"); botones[1][9].setText("X");} 
                        if (botones[9][0].getText().equals(".")) {botones[8][0].setText("X"); botones[8][1].setText("X"); botones[9][1].setText("X");}
                        if (botones[9][9].getText().equals(".")) {botones[8][8].setText("X"); botones[8][9].setText("X"); botones[9][8].setText("X");}
                        }else
                       
                        //Lectura bordes
                       if (botones[i][0].getText().equals(".")||botones[i][9].getText().equals(".")||botones[0][j+1].getText().equals(".")||botones[9][j+1].getText().equals(".")) {
                            
                            if (botones[i][0].getText().equals(".")) {botones[i-1][0].setText("X"); botones[i-1][1].setText("X"); botones[i][1].setText("X"); botones[i+1][0].setText("X"); botones[i+1][1].setText("X");}
                            if (botones[i][9].getText().equals(".")) {botones[i-1][8].setText("Y"); botones[i-1][9].setText("Y"); botones[i][8].setText("Y"); botones[i+1][8].setText("Y"); botones[i+1][9].setText("Y"); }
                            if (botones[0][j].getText().equals(".")) {botones[0][j-1].setText("Y"); botones[0][j+1].setText("Y"); botones[1][j-1].setText("Y"); botones[1][j].setText("Y"); botones[1][j+1].setText("Y"); }
                            if (botones[9][j].getText().equals(".")) {botones[8][j-1].setText("X"); botones[8][j].setText("X"); botones[8][j+1].setText("X"); botones[9][j-1].setText("X"); botones[9][j+1].setText("X"); }
                        }else
                           //Lectura parte interna 
                    
                           
                       if (botones[i][j].getText().equals(".")) {
                           
                       botones[i-1][j].setText("X"); 
                       botones[i-1][j+1].setText("X"); 
                       botones[i][j+1].setText("X"); 
                       botones[i+1][j].setText("X"); 
                       botones[i+1][j+1].setText("X");
                       botones[i][j-1].setText("Y"); 
                       botones[i+1][j-1].setText("Y");
                       botones[i-1][j-1].setText("Y");
                       
                       }
                      
                          
                        
                        
                        
                    }
                    
                }
                
               */
                
                

            }

        });

    }

    public void Btn1() {
        int n = 10;
        int tam = n;
        botones = new Btn[tam][tam];
        Tablero.setLayout(new GridLayout(tam, tam));

        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                botones[i][j] = new Btn(i, j, 52, 52);
                Tablero.add(botones[i][j]);
            }

        }
        Tablero.updateUI();
    }

    private class Hilo extends Thread {

        public void run() {
            
            while(true){
                for (int i = 1; i < botones.length-2; i++) {
                    for (int j = 1; j < botones[i].length-1; j++) {
                        
                        //Lectura parte interna
                        if (botones[i][j].getText().equals(".")) {
                            if (botones[i-1][j].getText().equals("")) { }
                          
                            
                            //esquina superior izquierda
                            botones[i-1][j-1].setText("X");
                            // arriba centro
                            botones[i-1][j].setText("X");
                            //esquina superior derecha
                            botones[i-1][j+1].setText("X");
                            //medio izquierda
                            botones[i][j-1].setText("X");
                            //medio derecha
                            botones[i][j+1].setText("x");
                             //esquina Inferior izquierda
                            botones[i+1][j-1].setText("X");
                            //abajo centro
                            botones[i+1][j].setText("X");
                            //Esquina Inferior derecha
                            botones[i+1][j+1].setText("X");
                            
                           
                            
                            
                        }
                        
                    }
                }
            }



        }
    }

}
