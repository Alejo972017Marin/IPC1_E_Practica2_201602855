package practica2;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Inicio extends JFrame{
    public JTextField Gamer;
    private JButton Start, Cancel;
    private JLabel Jug1,Tam1;
    public  JTextField tam1;
    public static String Gama,Tama;
   private JLabel Imagen;
    public Inicio(){
        setSize(350,250);
        setTitle("Game Of Life");
        setDefaultCloseOperation(Inicio.EXIT_ON_CLOSE);
        setLayout(null);    
        
        Jug1 = new JLabel("Gamer : ");
        Gamer = new JTextField(Gama);
        Tam1 = new JLabel("Tamaño: ");
        tam1 = new JTextField(Tama);
        Start = new JButton("Start");
        Cancel = new JButton("Cancel");
        Imagen = new JLabel();
        
        Tam1.setForeground(Color.WHITE);
        Jug1.setForeground(Color.WHITE);
        
        add(Jug1);
        add(Gamer);
        add(Tam1);
        add(tam1);
        add(Start);
        add(Cancel);
        add(Imagen);
        Imagen.setSize(350,250);
  
        Jug1.reshape(20,20,100,30);
        Gamer.reshape(70,20,100,20);
        Tam1.reshape(20,70,100,30);
        tam1.reshape(70,70,100,20);
        Start.reshape(70,120,100,30);
        Cancel.reshape(190,120,100,30);
        
         ImageIcon imagen = new ImageIcon("src/practica2/GameLife.jpg");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_DEFAULT));
        Imagen.setIcon(icono);
        this.repaint();
        
        

         
         
         
             Start.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                StartActionPerformed(evt);
            }

            private void StartActionPerformed(ActionEvent evt) {
                Tama = tam1.getText();
                Gama= Gamer.getText();
                setVisible(false);
                
                Ventana vt = new Ventana();
                vt.setVisible(true);
               

            }

        });
        
        
        
        
        
    
    }
    
}
