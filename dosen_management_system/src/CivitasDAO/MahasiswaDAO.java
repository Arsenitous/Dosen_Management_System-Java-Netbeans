/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CivitasDAO;

import DBConnection.DBConnection;
import OOP.Dosen;
import OOP.Mahasiswa;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ryan F
 */
public class MahasiswaDAO {
private Connection connection;
public MahasiswaDAO () throws SQLException{
    connection = (Connection) DBConnection.getConnection(); }

// Insert Data Mahasiswa
    public int insertMahasiswa(Mahasiswa mahasiswa) throws SQLException {
        try {
            String sql = "INSERT INTO mahasiswa (nik, nama, tempat_lahir, tanggal_lahir, email, jenis_kelamin, ips, ipk, jurusan, angkatan) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, mahasiswa.getNik());
            ps.setString(2, mahasiswa.getNama());
            ps.setString(3, mahasiswa.getTempat_lahir());
            ps.setDate(4, new java.sql.Date(mahasiswa.getTanggal().getTime()));
            ps.setString(5, mahasiswa.getEmail());
            ps.setString(6, mahasiswa.getJenis_kelamin());
            ps.setFloat(7, mahasiswa.getIps());
            ps.setFloat(8, mahasiswa.getIpk());
            ps.setString(9, mahasiswa.getJurusan());
            ps.setString(10, mahasiswa.getAngkatan());

            ps.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

 // Read Data Mahasiswa
    public List<Mahasiswa> getData() {
        List<Mahasiswa> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM mahasiswa";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Mahasiswa mahasiswa = new Mahasiswa(
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getString("tempat_lahir"),
                    rs.getDate("tanggal_lahir"),
                    rs.getString("email"),
                    rs.getString("jenis_kelamin"),
                    rs.getInt("nik"),
                    rs.getFloat("ips"),
                    rs.getFloat("ipk"),
                    rs.getString("jurusan"),
                    rs.getString("angkatan")
                );
                list.add(mahasiswa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    // Delete Mahasiswa
    public void deleteMahasiswa(int id) throws SQLException {
        String sql = "DELETE FROM mahasiswa WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
    
    // Update Mahasiswa
    public int updateMahasiswa(Mahasiswa mahasiswa, int id) throws SQLException {
        String sql = "UPDATE mahasiswa SET nik=?, nama=?, tempat_lahir=?, tanggal_lahir=?, email=?, jenis_kelamin=?, ips=?, ipk=?, jurusan=?, angkatan=? WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, mahasiswa.getNik());
            stmt.setString(2, mahasiswa.getNama());
            stmt.setString(3, mahasiswa.getTempat_lahir());
            stmt.setDate(4, new java.sql.Date(mahasiswa.getTanggal().getTime()));
            stmt.setString(5, mahasiswa.getEmail());
            stmt.setString(6, mahasiswa.getJenis_kelamin());
            stmt.setFloat(7, mahasiswa.getIps());
            stmt.setFloat(8, mahasiswa.getIpk());
            stmt.setString(9, mahasiswa.getJurusan());
            stmt.setString(10, mahasiswa.getAngkatan());
            stmt.setInt(11, id);

            return stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

   // Get Mahasiswa by ID
    public Mahasiswa getMahasiswaById(int id) throws SQLException {
        String sql = "SELECT * FROM mahasiswa WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Mahasiswa mahasiswa = new Mahasiswa(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("tempat_lahir"),
                        rs.getDate("tanggal_lahir"),
                        rs.getString("email"),
                        rs.getString("jenis_kelamin"),
                        rs.getInt("nik"),
                        rs.getFloat("ips"),
                        rs.getFloat("ipk"),
                        rs.getString("jurusan"),
                        rs.getString("angkatan")
                    );
                    return mahasiswa;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

        
    
}

