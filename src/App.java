import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.math.BigInteger;

public class App {
    static JTextField jtfInput;
    static JButton jBtnHitung;
    static JLabel jlHasil;

    // menghitung nilai faktorial
    static String faktorial(int number) {
        BigInteger hasil = new BigInteger("1");
        while(true) {
            // akhir dari perhitungan
            if(number == 1)
                return hasil.toString();
            // 0! bernilai 1
            else if(number == 0)
                return "1";
            // apabila memasukkan bilangan negatif
            else if(number < 0)
                throw new NumberFormatException();
            // apabila bilangan terlalu besar
            else if(number >= 1000)
                throw new IllegalArgumentException();
            // perhitungan
            else
                hasil = hasil.multiply(BigInteger.valueOf(number--));
        }
    }

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
        jlHasil.setText("Masukkan unsigned integer!");
        jPanel.add(jlHasil);

        // menghitung nilai faktorial dan menampilkannya, tidak menggunakan listener karena sudah memakai lambda
        jBtnHitung.addActionListener(e -> {
            try {
                int number = Integer.parseInt(jtfInput.getText());
                jlHasil.setText("Hasil "+ number + " faktorial: " + faktorial(number));
            } catch (NumberFormatException exception1) {
                // apabila memasukkan bukan unsigned integer (misal: -123, ASD, dll.)
                jlHasil.setText("Masukkan unsigned integer!");
            } catch (IllegalArgumentException exception2) {
                jlHasil.setText("Bilangan terlalu besar!");
            }
        });

        // menambahkan jPanel ke JFrame
        jfFrame.add(jPanel);
        jfFrame.setVisible(true);
    }
}
