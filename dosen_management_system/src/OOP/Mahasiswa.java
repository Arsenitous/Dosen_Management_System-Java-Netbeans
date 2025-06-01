/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOP;

import java.util.Date;

/**
 *
 * @author ITBSS
 */
public class Mahasiswa extends Civitas {
    private int nik, id;
    private float ips, ipk;
    private String jurusan, angkatan;

     public Mahasiswa(int id, String nama, String tempat_lahir, Date tanggal, String email, String jenis_kelamin,
                     int nik, float ips, float ipk, String jurusan, String angkatan) {
        super(nama, tempat_lahir, tanggal, email, jenis_kelamin);
        this.id = id;
        this.nik = nik;
        this.ips = ips;
        this.ipk = ipk;
        this.jurusan = jurusan;
        this.angkatan = angkatan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
     
     
    public int getNik() {
        return nik;
    }

    public void setNik(int nik) {
        this.nik = nik;
    }

    public float getIps() {
        return ips;
    }

    public void setIps(float ips) {
        this.ips = ips;
    }

    public float getIpk() {
        return ipk;
    }

    public void setIpk(float ipk) {
        this.ipk = ipk;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(String angkatan) {
        this.angkatan = angkatan;
    }
    
    public void EntryPRS() {
        System.out.println(getNama() + " sedang entry PRS.");
    }

    public void IkutPerkuliahan() {
        System.out.println(getNama() + " mengikuti perkuliahan.");
    }

    public void Lulus() {
        System.out.println(getNama() + " telah lulus.");
    }

    public void CekInfoKampus(String jurusan) {
        super.CekInfoKampus();
        System.out.println("Jurusan: " + jurusan);
    }
}
