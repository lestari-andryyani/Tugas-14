/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas14;

/**
 *
 * @author ASUS
 */
public class kamar {
    private String noKamar, statusKamar, fiturKamar, jenisKamar;
    private int lantai;
    
    public kamar(String noKamar, String statusKamar, String fiturKamar, String jenisKamar, int lantai){
        this.noKamar = noKamar;
        this.statusKamar = statusKamar;
        this.fiturKamar = fiturKamar;
        this.jenisKamar= jenisKamar;
        this.lantai = lantai;
    }
    
    public String getNoKamar(){
        return noKamar;
    }
    public String getStatusKamar(){
        return statusKamar;
    }
    public String getFiturKamar(){
        return fiturKamar;
    }
    public String getJenisKamar(){
        return jenisKamar;
    }
    public int getLantai(){
        return lantai;
    }
    
}
