import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    static JTextField jtfInput;
    static JButton jBtnHitung;
    static JLabel jlHasil;

    public static void main(String[] args) throws Exception {
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

        // membuat objek JTextField untuk menampilkan hasil faktorial 
        jlHasil = new JLabel();
        // mengatur text yang tampil di label
        jlHasil.setText("hasil faktorial : ");
        jPanel.add(jlHasil);

        jBtnHitung.addActionListener(new ActionListener() {     
          void factorial() {
            int number = Integer.parseInt(jtfInput.getText());
            try {
              if(number < 0 ) {
                jlHasil.setText("Masukan angka positif");
              } else {
                int res =1;

                for(int i=number;i>0;i--) {
                  res*=i;
                }
                jlHasil.setText(String.format("%d",res));
              }

            } catch(NumberFormatException e) {
              jlHasil.setText("Masukan angka");
            }
          }

          @Override
          public void actionPerformed(ActionEvent e) {
            factorial();
          }
        });

        // menambahkan jPanel ke JFrame
        jfFrame.add(jPanel);
        jfFrame.setVisible(true);
    }
}
