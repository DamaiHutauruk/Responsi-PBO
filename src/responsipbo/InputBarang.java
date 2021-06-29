/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsipbo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author Damai Hutauruk
 */
public class InputBarang {
    public String id, nama, massa, harga;
    
    Connector connector = new Connector();    
    
    //DEKLARASI KOMPONEN
    JFrame window = new JFrame("JDBC");
   
    JLabel lID = new JLabel("ID ");
        JTextField tfID = new JTextField();
    JLabel lNama = new JLabel("NAMA BARANG  ");
        JTextField tfNama = new JTextField();
    JLabel lMassa= new JLabel("MASSA ");
        JTextField tfMassa = new JTextField();
    JLabel lHarga = new JLabel("HARGA ");
        JTextField tfHarga = new JTextField();

    JButton btnTambahPanel = new JButton("Tambah");
    JButton btnLihat = new JButton("Lihat");
    JButton btnHitung = new JButton("Hitung");
    
     public InputBarang() {
        window.setLayout(null);
        window.setSize(550,200);
      //  window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
    

       // setDefaultCloseOperation(EXIT_ON_CLOSE);

//ADD COMPONENT
        window.add(lNama);
        window.add(tfID);
        window.add(tfNama);
        window.add(tfMassa);
        window.add(tfHarga);
        window.add(lID);
        window.add(lHarga);
        window.add(lMassa);
        window.add(btnTambahPanel);
        window.add(btnLihat);
        window.add(btnHitung);



//LABEL
        lID.setBounds(5, 35, 120, 20);
        lNama.setBounds(5, 60, 120, 20);
        lMassa.setBounds(5,85,120,20);
        lHarga.setBounds(5,105,120,20);

//TEXTFIELD
        tfID.setBounds(110, 35, 120, 20);
        tfNama.setBounds(110, 60, 120, 20);
        tfMassa.setBounds(110, 85, 120, 20);
        tfHarga.setBounds(110, 105, 120, 20);


//BUTTON PANEL
        btnTambahPanel.setBounds(250, 35, 90, 20);
        btnLihat.setBounds(250,60,90,20);
        btnHitung.setBounds(250,85,90,20);
        
        btnTambahPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                   try {
            String query = "INSERT INTO `barang`(`id`, `nama`,`massa`,`harga`) VALUES ('"+getID()+"','"+getNama()+"','"+getMassa()+"','"+getHarga()+"')";
            
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);

            System.out.println("Insert Berhasil");
            JOptionPane.showMessageDialog(null,"Insert Berhasil !!");
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
            }
        });
        
         btnLihat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                LihatBarang lihat = new LihatBarang();
            }
        });
         
         btnHitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                HitungHarga hitung = new HitungHarga();
            }
        });
    }
     
    public String getNama(){
    return tfNama.getText();
    }

    public String getID() {
        return tfID.getText();
    }

    public String getMassa() {
        return tfMassa.getText();
    }

    public String getHarga() {
        return tfHarga.getText();
    }
    
    public void inputDB(){
        
    }
     
}
