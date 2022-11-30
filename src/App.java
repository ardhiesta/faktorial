import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;

import java.math.BigInteger;
public class App {
    static JTextField jtfInput;
    static JButton jBtnHitung;
    static JLabel jlHasil;
    final static Integer limitFaktorial = 1000;

    public static  void main(String[] args) throws Exception {
        // membuat frame / window
        JFrame jfFrame = new JFrame();

        // set window title 
        jfFrame.setTitle("Program sederhana hitung faktorial");
        jfFrame.setSize(500, 180);
        jfFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // menambahkan komponen JPanel
        JPanel jPanel = new JPanel();
        // mengatur layout JPanel, komponen akan disusun tampil secara vertikal
        jPanel.setLayout(new GridLayout(3,1));

        // membuat objek JTextField untuk menampung input 
        jtfInput = new JTextField(10);
        jtfInput.setText("");
        // menambahkan objek JTextField ke dalam JPanel
        jPanel.add(jtfInput);

        // membuat objek JButton untuk menghitung faktorial 
        jBtnHitung = new JButton();
        // mengatur text dalam button
        jBtnHitung.setText("Hitung Faktorial");
        // menambahkan objek JButton ke dalam JPanel
        jPanel.add(jBtnHitung);
        jBtnHitung.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                    int number;
                    try {
                        number = Integer.parseInt(jtfInput.getText());  
                        if(number < limitFaktorial){
                            jlHasil.setText("hasil faktorial("+(number)+") : "+Factorial.bigint(number).toString()); 
                        }else{
                            jlHasil.setText("Angka terlalu besar!");
                        }
                      } catch (NumberFormatException ga_angka ) {
                        jlHasil.setText("Input hanya boleh mengandung angka saja!");
                      }  
            }  
        });

        // membuat objek JTextField untuk menampilkan hasil faktorial 
        jlHasil = new JLabel();
        // mengatur text yang tampil di label
        jlHasil.setText("hasil faktorial : ");
        jPanel.add(jlHasil);

        // menambahkan jPanel ke JFrame
        jfFrame.add(jPanel);
        jfFrame.setVisible(true);
    }
    
}

class Factorial{
    public static BigInteger bigint(int num) {
        BigInteger bi = new BigInteger("1");
        for (int j = 2; j <= num; j++) {
            bi = bi.multiply(BigInteger.valueOf(j));
        }

        return bi;
    }
}

