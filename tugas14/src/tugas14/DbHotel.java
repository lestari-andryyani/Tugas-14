/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas14;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class DbHotel {
    private Connection conn;
    private final koneksi k = new koneksi();
    
    //SELECT
    
    public ArrayList<kamar> getKamar() throws SQLException{
        ArrayList<kamar> daftar = new ArrayList<>();      
        
        //langkah 1
        conn = k.getConnection();
        
        //langkah 2
        String kueri = "SELECT * FROM kamar";
        PreparedStatement ps = conn.prepareStatement(kueri);
        
        //langkah 3
        ResultSet rs = ps.executeQuery();
        
        //langkah 4
        while(rs.next()){
            String noKamar = rs.getString("noKamar");
            String statusKamar = rs.getString("statusKamar");
            String fiturKamar = rs.getString("fiturKamar");
            String jenisKamar = rs.getString("jenisKamar");
            String lantai = rs.getString("lantai");
            
            kamar p = new kamar(noKamar, statusKamar, fiturKamar, jenisKamar, Integer.parseInt(lantai));
            daftar.add(p);
        }
        //langkah 5
        rs.close(); ps.close();conn.close();
        return daftar;
    }
    
    //INSERT
     public boolean insertKamar(kamar p) throws SQLException{
        
        //langkah 1
        conn = k.getConnection();
        
        //langkah 2
        String kueri = "INSERT INTO kamar(noKamar, statusKamar, fiturKamar, jenisKamar,lantai) VALUES (?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(kueri);
        ps.setString(1, p.getNoKamar()); ps.setString(2, p.getStatusKamar());
        ps.setString(3, p.getFiturKamar()); ps.setString(4, p.getJenisKamar());ps.setInt(5, p.getLantai());
        //langkah 3
        int rowAffected = ps.executeUpdate();
        //langkah 4 & 5
        ps.close(); conn.close();
        return rowAffected == 1;
        
    }
    
    public boolean updateKamar(kamar p) throws SQLException{
        //langkah 1
        conn = k.getConnection();
        
        //langkah 2
        String kueri = "UPDATE kamar SET noKamar=?, statusKamar=?, fiturKamar=?, jenisKamar=?, lantai=?";
        PreparedStatement ps = conn.prepareStatement(kueri);
        ps.setString(1, p.getNoKamar()); ps.setString(2, p.getStatusKamar());
        ps.setString(3, p.getFiturKamar()); ps.setString(4, p.getJenisKamar());ps.setInt(5, p.getLantai());
        
        //langkah 3
        int rowAffected = ps.executeUpdate();
        
        //langkah 4 & 5
        ps.close(); conn.close();
        return rowAffected == 1;
    }
    public boolean deleteKamar(String noKamar) throws SQLException{
        
        //langkah 1
        conn = k.getConnection();
        
        //langkah 2
        String kueri = "DELETE FROM kamar WHERE noKamar = ?";
        PreparedStatement ps = conn.prepareStatement(kueri);
        ps.setString(1, noKamar); 
        
        //langkah 3
        int rowAffected = ps.executeUpdate();
        //langkah 4 & 5
        ps.close(); conn.close();
        return rowAffected == 1;
    }
    
    //CARI -- SELECT-WHERE
    public ArrayList<kamar> cariKamar(String keyword) throws SQLException{
        ArrayList<kamar> daftar = new ArrayList<>();
        
        //langkah 1
        conn = k.getConnection();
        
        //langkah 2
        String kueri = "SELECT * FROM kamar WHERE noKamar LIKE ? OR jenisKamar=? OR lantai=?";
        PreparedStatement ps = conn.prepareStatement(kueri);
        ps.setString(1, "%"+keyword+"%"); ps.setString(2, keyword);
        ps.setString(3, keyword);  
        
        //langkah 3
        ResultSet rs = ps.executeQuery();
        
        //langkah 4
        while(rs.next()){
            String noKamar = rs.getString("noKamar");
            String statusKamar = rs.getString("statusKamar");
            String fiturKamar = rs.getString("fiturKamar");
            String jenisKamar = rs.getString("jenisKamar");
            String lantai = rs.getString("lantai");
            
            kamar p = new kamar(noKamar, statusKamar, fiturKamar, jenisKamar, Integer.parseInt(lantai));
            daftar.add(p);
        }
        //langkah 5
        rs.close(); ps.close();conn.close();
        return daftar;
        
    }
    
}
