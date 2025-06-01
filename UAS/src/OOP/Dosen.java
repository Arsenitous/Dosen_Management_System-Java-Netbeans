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
public class Dosen extends Civitas{
    private int nip, nidn, id;
    private Date tanggal_mulai, tanggal_selesai;

    public Dosen(int id, String nama, String tempat_lahir, Date tanggal, String email, String jenis_kelamin,
                 int nip, int nidn, Date tanggal_mulai, Date tanggal_selesai) {
        super(nama, tempat_lahir, tanggal, email, jenis_kelamin);
        this.id = id;
        this.nip = nip;
        this.nidn = nidn;
        this.tanggal_mulai = tanggal_mulai;
        this.tanggal_selesai = tanggal_selesai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }

    public int getNidn() {
        return nidn;
    }

    public void setNidn(int nidn) {
        this.nidn = nidn;
    }

    public Date getTanggal_mulai() {
        return tanggal_mulai;
    }

    public void setTanggal_mulai(Date tanggal_mulai) {
        this.tanggal_mulai = tanggal_mulai;
    }

    public Date getTanggal_selesai() {
        return tanggal_selesai;
    }

    public void setTanggal_selesai(Date tanggal_selesai) {
        this.tanggal_selesai = tanggal_selesai;
    }
    
    public void ApprovePRS() {
        System.out.println(getNama() + " telah menyetujui PRS.");
    }

    public void Mengajar() {
        System.out.println(getNama() + " sedang mengajar.");
    }

    public void Berhenti() {
        System.out.println(getNama() + " telah berhenti mengajar.");
    }
    
}
