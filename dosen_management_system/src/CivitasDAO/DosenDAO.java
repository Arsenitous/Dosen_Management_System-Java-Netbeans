/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CivitasDAO;

import DBConnection.DBConnection;
import OOP.Dosen;
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
public class DosenDAO {
private Connection connection;
public DosenDAO () throws SQLException{
    connection = (Connection) DBConnection.getConnection(); }

// Insert Data Dosen
public int insertDosen(Dosen dosen) throws SQLException {
        try {
            String sql = "INSERT INTO dosen (nip, nama, tempat_lahir, tanggal_lahir, email, jenis_kelamin, nidn, tanggal_mulai, tanggal_selesai) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, dosen.getNip());
            ps.setString(2, dosen.getNama());
            ps.setString(3, dosen.getTempat_lahir());
            ps.setDate(4, new java.sql.Date(dosen.getTanggal().getTime()));
            ps.setString(5, dosen.getEmail());
            ps.setString(6, dosen.getJenis_kelamin());
            ps.setInt(7, dosen.getNidn());
            ps.setDate(8, new java.sql.Date(dosen.getTanggal_mulai().getTime()));

            if (dosen.getTanggal_selesai() != null) {
                ps.setDate(9, new java.sql.Date(dosen.getTanggal_selesai().getTime()));
            } else {
                ps.setNull(9, java.sql.Types.DATE);
            }

            ps.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace(); 
            return 0;
        }
    }

// Read Data
    public List<Dosen> getData() {
    List<Dosen> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM dosen";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Dosen dosen = new Dosen(
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getString("tempat_lahir"),
                    rs.getDate("tanggal_lahir"), 
                    rs.getString("email"),
                    rs.getString("jenis_kelamin"),
                    rs.getInt("nip"),
                    rs.getInt("nidn"),
                    rs.getDate("tanggal_mulai"),
                    rs.getDate("tanggal_selesai")
                );
                // Set tanggal selesai kalau ada
                if (rs.getDate("tanggal_selesai") != null) {
                    dosen.setTanggal_selesai(rs.getDate("tanggal_selesai"));
                }
                list.add(dosen);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    // Delete Dosen
    public void deleteDosen(int id) throws SQLException {
        String sql = "DELETE FROM dosen WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
    
    // Update Dosen
    public int updateDosen(Dosen dosen, int id) throws SQLException {
        String sql = "UPDATE dosen SET nip=?, nama=?, tempat_lahir=?, tanggal_lahir=?, email=?, jenis_kelamin=?, nidn=?, tanggal_mulai=?, tanggal_selesai=? WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, dosen.getNip());
            stmt.setString(2, dosen.getNama());
            stmt.setString(3, dosen.getTempat_lahir());
            stmt.setDate(4, new java.sql.Date(dosen.getTanggal().getTime()));
            stmt.setString(5, dosen.getEmail());
            stmt.setString(6, dosen.getJenis_kelamin());
            stmt.setInt(7, dosen.getNidn());
            stmt.setDate(8, new java.sql.Date(dosen.getTanggal_mulai().getTime()));
            if (dosen.getTanggal_selesai() != null) {
                stmt.setDate(9, new java.sql.Date(dosen.getTanggal_selesai().getTime()));
            } else {
                stmt.setNull(9, java.sql.Types.DATE);
            }
            stmt.setInt(10, id);

            return stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
    
    // Get Dosen by ID
    public Dosen getDosenById(int id) throws SQLException {
        String sql = "SELECT * FROM dosen WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Dosen dosen = new Dosen(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("tempat_lahir"),
                        rs.getDate("tanggal_lahir"),
                        rs.getString("email"),
                        rs.getString("jenis_kelamin"),
                        rs.getInt("nip"),
                        rs.getInt("nidn"),
                        rs.getDate("tanggal_mulai"),
                        rs.getDate("tanggal_selesai")
                    );
                    if (rs.getDate("tanggal_selesai") != null) {
                        dosen.setTanggal_selesai(rs.getDate("tanggal_selesai"));
                    }
                    return dosen;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
