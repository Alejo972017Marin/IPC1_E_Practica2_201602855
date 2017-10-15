
package practica2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class Btn extends JButton implements ActionListener{
    
    public Btn(int F,int C, int An, int Al){
        setBackground(Color.DARK_GRAY);
        setBounds(F , C , An, Al);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
     setText(".");
    }
    
}
