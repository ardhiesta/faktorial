import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

static JTextField jtfInput;
static JButton jBtnHitung;
static JLabel jlHasil;
static JButton btn = new JButton();

public static void main(String[] args) throws Exception {
    
    // membuat frame / window
    JFrame jfFrame = new JFrame();

    public static void main(String[] args) throws Exception {
    
            // menambahkan komponen JPanel
            JPanel jPanel = new JPanel();
    
            // mengatur layout JPanel, komponen akan disusun tampil secara vertikal
            jPanel.setLayout(new GridLayout(3,1));
            jPanel.setLayout(new GridLayout(4,1));
    
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
    
            //Mengatur action saat menekan button
            jBtnHitung.addActionListener(new ActionListener(){
                private long Faktorial() {
                    int x = Integer.parseInt(jtfInput.getText());
                    int i, fact=1;  
                    for(i=1;i<=x;i++){    
                        fact=fact*i;    
                    }    
                    return fact;
    
                }
                public void actionPerformed(ActionEvent e){ 
                    long result = Faktorial();
                    jlHasil.setText(String.valueOf(result));  
                }
    
            });
    
            // membuat objek JTextField untuk menampilkan hasil faktorial 
            jlHasil = new JLabel();
    
            // mengatur text yang tampil di label
            jlHasil.setText("hasil faktorial : ");
            jPanel.add(jlHasil);
        }
    }
