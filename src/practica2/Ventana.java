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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JSlider;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame {

    Inicio In = new Inicio();
    Btn[][] botones;
    int n;
    static String  tamo;
    public static int v;
    private JLabel Jug;
    private JLabel Vel;
    private static JLabel ju;
    private JTextField jug;
    public static javax.swing.JSlider jSlider1;
    private JPanel Tablero;
    private JButton Pausa;
    private JButton Pausa1;
    private JButton Estab;
    int vidas[][];
    private int on;

    public Ventana() {

        setSize(500, 400);
        setTitle("Game Of Life");
        setDefaultCloseOperation(Ventana.EXIT_ON_CLOSE);
        setLayout(null);
        this.getContentPane().setBackground(Color.black);
        Jug = new JLabel("Gamer : ");
        ju = new JLabel(In.Gamer.getText());
        Vel = new JLabel("Velocidad: ");
        jSlider1 = new javax.swing.JSlider();
        Pausa = new JButton("Start");
        Pausa1 = new JButton("Pausa");
        Estab = new JButton("Continuar");
        Tablero = new JPanel();
        Vel.setForeground(Color.WHITE); 
        Jug.setForeground(Color.WHITE); 
        ju.setForeground(Color.WHITE); 
        
        Tablero.setBackground(Color.DARK_GRAY);
        Tablero.setBounds(150, 30, 300, 300);
        Tablero.setLayout(null);
        add(Tablero);
        add(Jug);
        add(ju);
        add(Vel);
        add(Pausa);
        add(Pausa1);
        add(Estab);
        add(jSlider1);

        Jug.reshape(10, 30, 50, 40);
        ju.reshape(55, 30, 100, 40);
        Vel.reshape(10, 70, 100, 40);
        jSlider1.reshape(10, 120, 120, 20);
        Pausa.reshape(10, 150, 100, 30);
        Pausa1.reshape(10, 200, 100, 30);
        Estab.reshape(10, 250, 100, 30);
        tamo=In.tam1.getText();
        Btn1();
        Hilo h = new Hilo();
        jSlider1.setMinimum(-100);
        jSlider1.setValue(0);
        jSlider1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {

                velo(evt);
            }

            private void velo(java.awt.event.MouseEvent evt) {
                v = jSlider1.getValue();

            }

        });

        Pausa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                PausaActionPerformed(evt);
            }

            private void PausaActionPerformed(ActionEvent evt) {

                Pausa.setEnabled(false);
                h.start();

            }

        });

        Pausa1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Pausa1ActionPerformed(evt);
            }

            private void Pausa1ActionPerformed(ActionEvent evt) {

                on = 0;
                if (on == 0) {h.suspend();}
            
            }
        });
                Estab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                EstabActionPerformed(evt);
            }

            private void EstabActionPerformed(ActionEvent evt) {

                on = 1;
                if(on==1){
                    h.resume();
                    on = 0;}
               
            }
        });

    }

    public void Btn1() {
        n = Integer.parseInt(tamo);
        int tam = n;
        botones = new Btn[tam][tam];
        vidas = new int[tam][tam];

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
            int vivo1 = 0;

            int vivos1 = 0;
            int vivos2 = 0;
            int vivos3 = 0;
            int vivos4 = 0;
            int vivos5 = 0;
            int vivos6 = 0;
            int vivos7 = 0;
            int vivos8 = 0;
            int vivos9 = 0;

            while (true) {

                for (int i = 1; i < botones.length - 1; i++) {
                    for (int j = 1; j < botones[i].length - 1; j++) {

                        //Verificacion interna
                        if (botones[i][j].getText().equals(".")) {
                            if (botones[i - 1][j - 1].getText().equals(".")) {
                                vivo1 = 1;
                            }
                            if (botones[i - 1][j].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }
                            if (botones[i - 1][j + 1].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }
                            if (botones[i][j - 1].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }
                            if (botones[i][j + 1].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }
                            if (botones[i + 1][j - 1].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }
                            if (botones[i + 1][j].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }
                            if (botones[i + 1][j + 1].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }

                            vivos1 = vivo1;
                            vivo1 = 0;

                            vidas[i][j] = vivos1;

                        } else {
                            if (botones[i][j].getText().equals("")) {
                                if (botones[i - 1][j - 1].getText().equals(".")) {
                                    vivo1 = 1;
                                }
                                if (botones[i - 1][j].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }
                                if (botones[i - 1][j + 1].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }
                                if (botones[i][j - 1].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }
                                if (botones[i][j + 1].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }
                                if (botones[i + 1][j - 1].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }
                                if (botones[i + 1][j].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }
                                if (botones[i + 1][j + 1].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }

                                vivos1 = vivo1;
                                vivo1 = 0;

                                vidas[i][j] = vivos1;
                            }
                        }

                        //Fin verificacion Interna
                        //Lectura Esquinas donde 9=n-1 y 8 n-2
                        if (botones[0][0].getText().equals(".")) {
                            if (botones[0][1].getText().equals(".")) {
                                vivo1 = 1;
                            }
                            if (botones[1][0].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }
                            if (botones[1][1].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }

                            vivos2 = vivo1;
                            vivo1 = 0;

                            vidas[0][0] = vivos2;

                        } else {
                            if (botones[0][0].getText().equals("")) {
                                if (botones[0][1].getText().equals(".")) {
                                    vivo1 = 1;
                                }
                                if (botones[1][0].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }
                                if (botones[1][1].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }

                                vivos2 = vivo1;
                                vivo1 = 0;

                                vidas[0][0] = vivos2;
                            }
                        }

                        if (botones[0][n - 1].getText().equals(".")) {
                            if (botones[0][n - 2].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }
                            if (botones[1][n - 2].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }
                            if (botones[1][n - 1].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }

                            vivos3 = vivo1;
                            vivo1 = 0;

                            vidas[0][n - 1] = vivos3;
                        } else {
                            if (botones[0][n - 1].getText().equals("")) {
                                if (botones[0][n - 2].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }
                                if (botones[1][n - 2].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }
                                if (botones[1][n - 1].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }

                                vivos3 = vivo1;
                                vivo1 = 0;

                                vidas[0][n - 1] = vivos3;
                            }
                        }

                        if (botones[n - 1][0].getText().equals(".")) {
                            if (botones[n - 2][0].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }
                            if (botones[n - 2][1].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }
                            if (botones[n - 1][1].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }

                            vivos4 = vivo1;
                            vivo1 = 0;

                            vidas[n - 1][0] = vivos4;

                        } else {
                            if (botones[n - 1][0].getText().equals("")) {
                                if (botones[n - 2][0].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }
                                if (botones[n - 2][1].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }
                                if (botones[n - 1][1].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }

                                vivos4 = vivo1;
                                vivo1 = 0;

                                vidas[n - 1][0] = vivos4;
                            }
                        }

                        if (botones[n - 1][n - 1].getText().equals(".")) {
                            if (botones[n - 2][n - 2].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }
                            if (botones[n - 2][n - 1].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }
                            if (botones[n - 1][n - 2].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }

                            vivos5 = vivo1;
                            vivo1 = 0;

                            vidas[n - 1][n - 1] = vivos5;
                        } else {
                            if (botones[n - 1][n - 1].getText().equals("")) {
                                if (botones[n - 2][n - 2].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }
                                if (botones[n - 2][n - 1].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }
                                if (botones[n - 1][n - 2].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }

                                vivos5 = vivo1;
                                vivo1 = 0;

                                vidas[n - 1][n - 1] = vivos5;

                            }
                        }

                        //FinLecturaEsquinas
                        
                        
                        
                        //LecturaBordes 9=i-1 y 8= j-2
                        if (botones[i][0].getText().equals(".")) {
                            if (botones[i - 1][0].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }
                            if (botones[i - 1][1].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }
                            if (botones[i][1].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }
                            if (botones[i + 1][1].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }
                            if (botones[i + 1][0].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }

                            vivos6 = vivo1;
                            vivo1 = 0;

                            vidas[i][0] = vivos6;

                        } else {
                            if (botones[i][0].getText().equals("")) {
                                if (botones[i - 1][0].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }
                                if (botones[i - 1][1].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }
                                if (botones[i][1].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }
                                if (botones[i + 1][1].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }
                                if (botones[i + 1][0].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }

                                vivos6 = vivo1;
                                vivo1 = 0;

                                vidas[i][0] = vivos6;

                            }
                        }

                        if (botones[i][n - 1].getText().equals("")) {
                            if (botones[i - 1][n - 2].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }
                            if (botones[i - 1][n - 1].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }
                            if (botones[i][n - 2].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }
                            if (botones[i + 1][n - 2].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }
                            if (botones[i + 1][n - 1].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }

                            vivos7 = vivo1;
                            vivo1 = 0;

                            vidas[i][n - 1] = vivos7;

                        } else {
                            if (botones[i][n - 1].getText().equals("")) {
                                if (botones[i - 1][n - 2].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }
                                if (botones[i - 1][n - 1].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }
                                if (botones[i][n - 2].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }
                                if (botones[i + 1][n - 2].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }
                                if (botones[i + 1][n - 1].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }

                                vivos7 = vivo1;
                                vivo1 = 0;

                                vidas[i][n - 1] = vivos7;
                            }
                        }

                        if (botones[0][j].getText().equals(".")) {
                            if (botones[0][j - 1].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }
                            if (botones[1][j - 1].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }
                            if (botones[1][j].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }
                            if (botones[1][j + 1].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }
                            if (botones[0][j + 1].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }

                            vivos8 = vivo1;
                            vivo1 = 0;

                            vidas[0][j] = vivos8;

                        } else {
                            if (botones[0][j].getText().equals("")) {
                                if (botones[0][j - 1].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }
                                if (botones[1][j - 1].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }
                                if (botones[1][j].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }
                                if (botones[1][j + 1].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }
                                if (botones[0][j + 1].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }

                                vivos8 = vivo1;
                                vivo1 = 0;

                                vidas[0][j] = vivos8;
                            }
                        }

                        if (botones[n - 1][j].getText().equals(".")) {
                            if (botones[n - 2][j - 1].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }
                            if (botones[n - 2][j].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }
                            if (botones[n - 2][j + 1].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }
                            if (botones[n - 1][j - 1].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }
                            if (botones[n - 1][j + 1].getText().equals(".")) {
                                vivo1 = vivo1 + 1;
                            }

                            vivos9 = vivo1;
                            vivo1 = 0;

                            vidas[n - 1][j] = vivos9;
                        } else {
                            if (botones[n - 1][j].getText().equals("")) {
                                if (botones[n - 2][j - 1].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }
                                if (botones[n - 2][j].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }
                                if (botones[n - 2][j + 1].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }
                                if (botones[n - 1][j - 1].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }
                                if (botones[n - 1][j + 1].getText().equals(".")) {
                                    vivo1 = vivo1 + 1;
                                }

                                vivos9 = vivo1;
                                vivo1 = 0;

                                vidas[n - 1][j] = vivos9;

                            }
                        }

                        //FinLecturaBordes
                    }

                }

                //ELjuicio
                for (int i = 1; i < botones.length - 1; i++) {
                    for (int j = 1; j < botones[i].length - 1; j++) {

                        //LecInt
                        if (botones[i][j].getText().equals(".")) {
                            if (vidas[i][j] < 2 || vidas[i][j] > 3) {
                                botones[i][j].setText("");
                                botones[i][j].setBackground(Color.DARK_GRAY);
                            } else if (vidas[i][j] == 2 || vidas[i][j] == 3) {
                                botones[i][j].setText(".");
                                botones[i][j].setBackground(Color.WHITE);
                            }
                            vivos1 = 0;
                        } else if (botones[i][j].getText().equals("")) {
                            if (vidas[i][j] == 3) {
                                botones[i][j].setText(".");
                                botones[i][j].setBackground(Color.WHITE);
                            }
                            vivos1 = 0;
                        }

                        //FinLecInt
                        //LecturasEsq
                        if (botones[0][0].getText().equals(".")) {
                            if (vidas[0][0] < 2 || vidas[0][0] > 3) {
                                botones[0][0].setText("");
                                botones[0][0].setBackground(Color.DARK_GRAY);
                            } else if (vidas[0][0] == 2 || vidas[0][0] == 3) {
                                botones[0][0].setText(".");
                                botones[0][0].setBackground(Color.WHITE);
                            }
                            vivos2 = 0;
                        } else if (botones[0][0].getText().equals("")) {
                            if (vidas[0][0] == 3) {
                                botones[0][0].setText(".");
                                botones[0][0].setBackground(Color.WHITE);
                            }
                            vivos2 = 0;
                        } else if (botones[0][n - 1].getText().equals(".")) {
                            if (vidas[0][n - 1] < 2 || vidas[0][n - 1] > 3) {
                                botones[0][n - 1].setText("");
                                botones[0][n - 1].setBackground(Color.DARK_GRAY);
                            } else if (vidas[0][n - 1] == 2 || vidas[0][n - 1] == 3) {
                                botones[0][n - 1].setText(".");
                                botones[0][n - 1].setBackground(Color.WHITE);
                            }
                            vivos3 = 0;
                        } else if (botones[0][n - 1].getText().equals("")) {
                            if (vidas[0][n - 1] == 3) {
                                botones[0][n - 1].setText(".");
                                botones[0][n - 1].setBackground(Color.WHITE);
                            }
                            vivos3 = 0;
                        } else if (botones[n - 1][0].getText().equals(".")) {
                            if (vidas[n - 1][0] < 2 || vidas[n - 1][0] > 3) {
                                botones[n - 1][0].setText("");
                                botones[n - 1][0].setBackground(Color.DARK_GRAY);
                            } else if (vidas[n - 1][0] == 2 || vidas[n - 1][0] == 3) {
                                botones[n - 1][0].setText(".");
                                botones[n - 1][0].setBackground(Color.WHITE);
                            }
                            vivos4 = 0;
                        } else if (botones[n - 1][0].getText().equals("")) {
                            if (vidas[n - 1][0] == 3) {
                                botones[n - 1][0].setText(".");
                                botones[n - 1][0].setBackground(Color.WHITE);
                            }
                            vivos4 = 0;
                        } else if (botones[n - 1][n - 1].getText().equals(".")) {
                            if (vidas[n - 1][n - 1] < 2 || vidas[n - 1][n - 1] > 3) {
                                botones[n - 1][n - 1].setText("");
                                botones[n - 1][n - 1].setBackground(Color.DARK_GRAY);
                            } else if (vidas[n - 1][n - 1] == 2 || vidas[n - 1][n - 1] == 3) {
                                botones[n - 1][n - 1].setText(".");
                                botones[n - 1][n - 1].setBackground(Color.WHITE);
                            }
                            vivos5 = 0;
                        } else if (botones[n - 1][n - 1].getText().equals("")) {
                            if (vidas[n - 1][n - 1] == 3) {
                                botones[n - 1][n - 1].setText(".");
                                botones[n - 1][n - 1].setBackground(Color.WHITE);
                            }
                            vivos5 = 0;
                        } else //FinLecEsqu
                        //IniLecBord
                        if (botones[i][0].getText().equals(".")) {
                            if (vidas[i][0] < 2 || vidas[i][0] > 3) {
                                botones[i][0].setText("");
                                botones[i][0].setBackground(Color.DARK_GRAY);
                            } else if (vidas[i][0] == 2 || vidas[i][0] == 3) {
                                botones[i][0].setText(".");
                                botones[i][0].setBackground(Color.WHITE);
                            }
                            vivos6 = 0;
                        } else if (botones[i][0].getText().equals("")) {
                            if (vidas[i][0] == 3) {
                                botones[i][0].setText(".");
                                botones[i][0].setBackground(Color.WHITE);
                            }
                            vivos6 = 0;
                        } else if (botones[i][n - 1].getText().equals(".")) {
                            if (vidas[i][n - 1] < 2 || vidas[i][n - 1] > 3) {
                                botones[i][n - 1].setText("");
                                botones[i][n - 1].setBackground(Color.DARK_GRAY);
                            } else if (vidas[i][n - 1] == 2 || vidas[i][n - 1] == 3) {
                                botones[i][n - 1].setText(".");
                                botones[i][n - 1].setBackground(Color.WHITE);
                            }
                            vivos7 = 0;
                        } else if (botones[i][n - 1].getText().equals("")) {
                            if (vidas[i][n - 1] == 3) {
                                botones[i][n - 1].setText(".");
                                botones[i][n - 1].setBackground(Color.WHITE);
                            }
                            vivos7 = 0;
                        } else if (botones[0][j].getText().equals(".")) {
                            if (vidas[0][j] < 2 || vidas[0][j] > 3) {
                                botones[0][j].setText("");
                                botones[0][j].setBackground(Color.DARK_GRAY);
                            } else if (vidas[0][j] == 2 || vidas[0][j] == 3) {
                                botones[0][j].setText(".");
                                botones[0][j].setBackground(Color.WHITE);
                            }
                            vivos8 = 0;
                        } else if (botones[0][j].getText().equals("")) {
                            if (vidas[0][j] == 3) {
                                botones[0][j].setText(".");
                                botones[0][j].setBackground(Color.WHITE);
                            }
                            vivos8 = 0;
                        } else if (botones[n - 1][j].getText().equals(".")) {
                            if (vidas[n - 1][j] < 2 || vidas[n - 1][j] > 3) {
                                botones[n - 1][j].setText("");
                                botones[n - 1][j].setBackground(Color.DARK_GRAY);
                            } else if (vidas[n - 1][j] == 2 || vidas[n - 1][j] == 3) {
                                botones[n - 1][j].setText(".");
                                botones[n - 1][j].setBackground(Color.WHITE);
                            }
                            vivos9 = 0;
                        } else if (botones[n - 1][j].getText().equals("")) {
                            if (vidas[n - 1][j] == 3) {
                                botones[n - 1][j].setText(".");
                                botones[n - 1][j].setBackground(Color.WHITE);
                            }
                            vivos9 = 0;
                        }

                        //FinLecBord
                    }
                }
//control de la velocidad de ejecucion
                try {
                    Thread.sleep(1000 - 9 * (Ventana.v));
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

    }

}
