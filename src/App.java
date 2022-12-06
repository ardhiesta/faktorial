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

        // membuat action jika button diklik
        jBtnHitung.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                // menyimpan hasil dari input user sbg number
                int number= Integer.parseInt(jtfInput.getText());
                try {
                    if(number < 0){
                        System.out.println("Bilangan yang dimasukkan harus > 0!");
                    }
                    else{
                        
                        // memanggil method untuk melakukan perhitungan
                        int fact = factorialCalcu(number);
                        // menampilkan hasil perhitungan ke layar
                        jlHasil.setText(" hasil faktorial : " + fact); 

                    }
                    
                } catch (NumberFormatException er) {
                    System.out.println("Input yang anda masukkan harus berupa angka!");
                };
 
            }
        });

        jPanel.add(jlHasil);

        // menambahkan jPanel ke JFrame
        jfFrame.add(jPanel);
        jfFrame.setVisible(true);
    }

    // method yang berisi rumus untuk menghitung faktorial
    public static int factorialCalcu(int number){
        int i,fact=1;  
            for(i=1;i<=number;i++){    
            fact=fact*i;    
            }

        return fact;
    }
}
