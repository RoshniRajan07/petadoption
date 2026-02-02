package com.pet.adoption.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pet.adoption.bean.Pet;
import com.pet.adoption.util.DBUtil;

public class PetDAO {

    public Pet findPet(String petID) {
        Connection con = DBUtil.getDBConnection();
        String query = "SELECT * FROM system.PET_TBL WHERE PET_ID=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, petID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Pet pet = new Pet();
                pet.setPetID(rs.getString(1));
                pet.setName(rs.getString(2));
                pet.setSpecies(rs.getString(3));
                pet.setBreed(rs.getString(4));
                pet.setAge(rs.getInt(5));
                pet.setMedicalStatus(rs.getString(6));
                pet.setAvailable(rs.getString(7));
                return pet;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Pet> viewAllPets() {
        Connection con = DBUtil.getDBConnection();
        List<Pet> list = new ArrayList<>();
        String query = "SELECT * FROM system.PET_TBL";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pet pet = new Pet();
                pet.setPetID(rs.getString(1));
                pet.setName(rs.getString(2));
                pet.setSpecies(rs.getString(3));
                pet.setBreed(rs.getString(4));
                pet.setAge(rs.getInt(5));
                pet.setMedicalStatus(rs.getString(6));
                pet.setAvailable(rs.getString(7));
                list.add(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insertPet(Pet pet) {
        Connection con = DBUtil.getDBConnection();
        String query = "INSERT system.INTO PET_TBL VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, pet.getPetID());
            ps.setString(2, pet.getName());
            ps.setString(3, pet.getSpecies());
            ps.setString(4, pet.getBreed());
            ps.setInt(5, pet.getAge());
            ps.setString(6, pet.getMedicalStatus());
            ps.setString(7, pet.getAvailable());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

   
    public boolean updateAvailability(String petID, String available) {
        Connection con = DBUtil.getDBConnection();
        String query = "UPDATE system.PET_TBL SET AVAILABLE=? WHERE PET_ID=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, available);
            ps.setString(2, petID);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

 
    public boolean updateMedicalStatus(String petID, String medicalStatus) {
        Connection con = DBUtil.getDBConnection();
        String query = "UPDATE system.PET_TBL SET MEDICAL_STATUS=? WHERE PET_ID=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, medicalStatus);
            ps.setString(2, petID);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deletePet(String petID) {
        Connection con = DBUtil.getDBConnection();
        String query = "DELETE FROM system.PET_TBL WHERE PET_ID=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, petID);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}