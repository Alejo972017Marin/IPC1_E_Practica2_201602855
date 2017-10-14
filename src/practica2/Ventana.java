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
    Inicio In= new Inicio();
    Btn[][] botones;
    int n;
    private JLabel Jug;
    private JLabel Vel;
    private static JLabel ju;
    private JTextField jug;
    private JComboBox vel;
    private JPanel Tablero;
    private JButton Pausa;
    
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

            private void PausaActionPerformed(ActionEvent evt) {
                Hilo h = new Hilo();
                Pausa.setEnabled(false);
                h.start();
            }

        });

    }

    public void Btn1() {
         n = 6;
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
          int vivo1=0;
          
          while (true) {
              for (int i = 1; i < botones.length-1; i++) {
                  for (int j = 1; j < botones[i].length-1; j++) {
                      
                      //Verificacion interna
                      if (botones[i][j].getText().equals(".")) {
                          if (botones[i-1][j-1].getText().equals(".")) {vivo1=1;}
                          if (botones[i-1][j].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[i-1][j+1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[i][j-1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[i][j+1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[i+1][j-1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[i+1][j].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[i+1][j+1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (vivo1<2|| vivo1>3) {botones[i][j].setText(""); }else
                          if(vivo1==2||vivo1==3){botones[i][j].setText(".");}
                           vivo1=0;
                      }else
                      if(botones[i][j].getText().equals("")){
                          if (botones[i-1][j-1].getText().equals(".")) {vivo1=1;}
                          if (botones[i-1][j].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[i-1][j+1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[i][j-1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[i][j+1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[i+1][j-1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[i+1][j].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[i+1][j+1].getText().equals(".")) {vivo1=vivo1+1;}
                          if(vivo1==3){botones[i][j].setText("."); }
                          vivo1=0;
                          
                      }
                      
                      //Fin verificacion Interna
                      
                      //Lectura Esquinas donde 9=n-1 y 8 n-2
                      
                      if (botones[0][0].getText().equals(".")) {
                          if (botones[0][1].getText().equals(".")) {vivo1=1;}
                          if (botones[1][0].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[1][1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (vivo1<2|| vivo1>3) {botones[0][0].setText("");}else
                          if(vivo1==2||vivo1==3){botones[0][0].setText("."); }
                          vivo1=0;
                          
                      }else
                      
                      if(botones[0][0].getText().equals("")){
                          if (botones[0][1].getText().equals(".")) {vivo1=1;}
                          if (botones[1][0].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[1][1].getText().equals(".")) {vivo1=vivo1+1;}
                          if(vivo1==3){botones[0][0].setText("."); }
                          vivo1=0;
                          
                      }
                      
                      
                      
                      if (botones[0][n-1].getText().equals(".")) {
                          if (botones[0][n-2].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[1][n-2].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[1][n-1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (vivo1<2|| vivo1>3) {botones[0][n-1].setText("");}else{botones[0][n-1].setText("."); }
                          vivo1=0;
                      }else
                      if(botones[0][n-1].getText().equals("")){
                          if (botones[0][n-2].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[1][n-2].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[1][n-1].getText().equals(".")) {vivo1=vivo1+1;}
                          if(vivo1==3){botones[0][n-1].setText("."); }
                          vivo1=0;
                      }
                      
                      
                      if (botones[n-1][0].getText().equals(".")) {
                          if (botones[n-2][0].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[n-2][1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[n-1][1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (vivo1<2|| vivo1>3) {botones[n-1][0].setText("");}else
                          if(vivo1==2||vivo1==3){botones[n-1][0].setText("."); }
                          vivo1=0;
                      }else
                      if(botones[n-1][0].getText().equals("")){
                          if (botones[n-2][0].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[n-2][1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[n-1][1].getText().equals(".")) {vivo1=vivo1+1;}
                          if(vivo1==3){botones[n-1][0].setText(".");}
                          vivo1=0;
                      }
                      
                      
                      
                      if (botones[n-1][n-1].getText().equals(".")) {
                          if (botones[n-2][n-2].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[n-2][n-1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[n-1][n-2].getText().equals(".")) {vivo1=vivo1+1;}
                          if (vivo1<2|| vivo1>3) {botones[n-1][n-1].setText("");}else
                          if(vivo1==2||vivo1==3){botones[n-1][n-1].setText(".");}
                          vivo1=0;
                      }else
                      
                      if(botones[n-1][n-1].getText().equals("")){
                          if (botones[n-2][n-2].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[n-2][n-1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[n-1][n-2].getText().equals(".")) {vivo1=vivo1+1;}
                          if(vivo1==3){botones[n-1][n-1].setText("."); }
                          vivo1=0;
                      }
                      
                      
                      //FinLecturaEsquinas
                      
                      //LecturaBordes 9=i-1 y 8= j-2
                      if (botones[i][0].getText().equals(".")) {
                          if (botones[i-1][0].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[i-1][1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[i][1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[i+1][1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[i+1][0].getText().equals(".")) {vivo1=vivo1+1;}
                          if (vivo1<2|| vivo1>3) {botones[i][0].setText("");}else
                          if(vivo1==2||vivo1==3){botones[i][0].setText(".");}
                          vivo1=0;
                      }else
                      if(botones[i][0].getText().equals("")){
                          if (botones[i-1][0].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[i-1][1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[i][1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[i+1][1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[i+1][0].getText().equals(".")) {vivo1=vivo1+1;}
                          if(vivo1==3){botones[i][0].setText("."); }
                          vivo1=0;
                      }
                      
                      
                      if (botones[i][n-1].getText().equals(".")) {
                          if (botones[i-1][n-2].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[i-1][n-1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[i][n-2].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[i+1][n-2].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[i+1][n-1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (vivo1<2|| vivo1>3) {botones[i][n-1].setText(""); }else
                          if(vivo1==2||vivo1==3){botones[i][n-1].setText("."); }
                          vivo1=0;
                          
                      }else
                      if(botones[i][n-1].getText().equals("")){
                          if (botones[i-1][n-2].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[i-1][n-1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[i][n-2].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[i+1][n-2].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[i+1][n-1].getText().equals(".")) {vivo1=vivo1+1;}
                          if(vivo1==3){botones[i][n-1].setText(".");}
                           vivo1=0;
                      }
                      
                      
                      
                      if (botones[0][j].getText().equals(".")) {
                          if (botones[0][j-1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[1][j-1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[1][j].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[1][j+1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[0][j+1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (vivo1<2|| vivo1>3) {botones[0][j].setText("");}else
                          if(vivo1==2||vivo1==3){botones[0][j].setText("."); }
                          vivo1=0;
                      }else
                      if(botones[0][j].getText().equals("")){
                          if (botones[0][j-1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[1][j-1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[1][j].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[1][j+1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[0][j+1].getText().equals(".")) {vivo1=vivo1+1;}
                          if(vivo1==3){botones[0][j].setText("."); }
                          vivo1=0;
                      }
                      
                      
                      
                      if (botones[n-1][j].getText().equals(".")) {
                          if (botones[n-2][j-1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[n-2][j].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[n-2][j+1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[n-1][j-1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[n-1][j+1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (vivo1<2|| vivo1>3) {botones[n-1][j].setText("");}else
                          if(vivo1==2||vivo1==3){botones[n-1][j].setText("."); }
                          vivo1=0;
                      }else
                      if(botones[n-1][j].getText().equals("")){
                          if (botones[n-2][j-1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[n-2][j].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[n-2][j+1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[n-1][j-1].getText().equals(".")) {vivo1=vivo1+1;}
                          if (botones[n-1][j+1].getText().equals(".")) {vivo1=vivo1+1;}
                          if(vivo1==3){botones[n-1][j].setText("."); }
                          vivo1=0;
                      }
                      
                      
                      //FinLecturaBordes
                      
                  }
              }
              
          }

        }
        
    }

}
