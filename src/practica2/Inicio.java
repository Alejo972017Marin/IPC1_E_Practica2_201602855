package practica2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Inicio extends JFrame{
    JTextField Gamer;
    private JButton Start, Cancel;
    private JLabel Jug1,Tam1;
    JTextField tam1;
    public static String Gama,Tama;
   
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
        
        Gama= Gamer.getText();
        
        add(Jug1);
        add(Gamer);
        add(Tam1);
        add(tam1);
        add(Start);
        add(Cancel);
        
        Tama = tam1.getText();
        
        Jug1.reshape(20,20,100,30);
        Gamer.reshape(70,20,100,30);
        Tam1.reshape(20,70,100,30);
        tam1.reshape(70,70,100,30);
        Start.reshape(30,120,100,30);
        Cancel.reshape(160,120,100,30);

             Start.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                StartActionPerformed(evt);
            }

            private void StartActionPerformed(ActionEvent evt) {
                setVisible(false);
                
                Ventana vt = new Ventana();
                vt.setVisible(true);
               

            }

        });
        
        
        
        
        
    
    }
    
}
