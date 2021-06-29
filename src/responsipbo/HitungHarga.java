/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsipbo;
import hitunghitung.Total;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Damai Hutauruk
 */
public class HitungHarga extends JFrame implements ActionListener {
    JLabel lbljudul = new JLabel("HITUNG HARGA BARANG");
    
    JLabel lblharga = new JLabel("Harga");
    JTextField tfharga = new JTextField(15);
    JLabel lbljumlah = new JLabel("Jumlah");
    JTextField tfjumlah = new JTextField(15); 
    JLabel lbltinggi = new JLabel("Tinggi");
    JTextField tftinggi = new JTextField(15);
       
    JLabel lblhasil = new JLabel("Hasil");
    JLabel lbltotal = new JLabel();
    JLabel lblkeliling = new JLabel();
    JLabel lbltotalpermukaan = new JLabel();
    JLabel lblvolume = new JLabel();
       
    JButton btnhitung = new JButton("Hitung");
    JButton btnreset = new JButton("Reset");

    public HitungHarga() {
        setTitle("Kalkulator Harga");
           
        setSize(350, 400);
        setLayout(null);
        add(lbljudul);
        add(lblharga);
        add(tfharga);
        add(lbljumlah);
        add(tfjumlah);
        
        add(lblhasil);
        add(lbltotal);
        
        add(btnhitung);
        add(btnreset);
           
        //setBounds(int x-coordinate, int y-coordinate, int width, int height)
        lbljudul.setBounds(120,5,140,30);
        lblharga.setBounds(20,40,100,20);
        tfharga.setBounds(130,40,150,20);
        lbljumlah.setBounds(20,65,100,20);
        tfjumlah.setBounds(130,65,150,20);
       
        lblhasil.setBounds(145,125,100,30);
        lbltotal.setBounds(30,160,200,30);
        
        btnhitung.setBounds(70,300,80,20);
        btnreset.setBounds(170,300,80,20);
           
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
       
        btnhitung.addActionListener(this);
        btnreset.addActionListener(this);
       }
       
    @Override
    public void actionPerformed(ActionEvent e){
        int harga, jumlah;
           
        if (e.getSource() == btnhitung) {
            if (tfharga.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Harga cannot empty");
            } else if (tfjumlah.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Jumlah cannot empty");
            } else {
                try {
                    harga = Integer.parseInt(tfharga.getText());
                    jumlah = Integer.parseInt(tfjumlah.getText());
                    
                    Total Total = new Total(harga, jumlah);
                    
                    lbltotal.setText("Total Harga         : " + Total.totaall());
                } catch(NumberFormatException err){
                    JOptionPane.showMessageDialog(this, "Mohon Masukkan Angka!");
                }
            }
        }
           
        if (e.getSource() == btnreset) {
            lbltotal.setText(" ");
            tfharga.setText("");
            tfjumlah.setText("");
        }
    }
}
