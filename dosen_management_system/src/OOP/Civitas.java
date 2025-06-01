package OOP;

import java.util.Date;

/**
 *
 * @author ITBSS
 */
public class Civitas {
    private String nama, tempat_lahir, email, jenis_kelamin;
    private Date tanggal;
    private static String domain = "itbss.ac.id";
    private static final String kampus = "ITBSS";

    public Civitas(String nama, String tempat_lahir, Date tanggal, String email, String jenis_kelamin) {
        this.nama = nama;
        this.tempat_lahir = tempat_lahir;
        this.tanggal = tanggal;
        this.email = email;
        this.jenis_kelamin = jenis_kelamin;
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public static String getDomain() {
        return domain;
    }

    public static void setDomain(String domain) {
        Civitas.domain = domain;
    }
    
    
    
    public void CekInfoKampus(){
        System.out.println("Kampus: " + kampus);
        System.out.println("Domain Email: " + domain);
    }
}
