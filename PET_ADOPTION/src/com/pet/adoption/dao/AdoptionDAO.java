package com.pet.adoption.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import com.pet.adoption.bean.Adoption;
import com.pet.adoption.util.DBUtil;

public class AdoptionDAO {

   
    public int generateAdoptionID() {
        Connection con = DBUtil.getDBConnection();
        String query = "SELECT  ADOPTION_SEQ2.NEXTVAL FROM dual";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean recordAdoption(Adoption adoption) {
        Connection con = DBUtil.getDBConnection();
        String query = "INSERT INTO system.ADOPTION_TBL VALUES (ADOPTION_SEQ2.NEXTVAL,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, adoption.getAdoptionID());
            ps.setString(2, adoption.getPetID());
            ps.setString(3, adoption.getAdopterName());
            ps.setString(4, adoption.getAdopterContact());
            ps.setDate(5, new Date(adoption.getAdoptionDate().getTime()));
            ps.setString(6, adoption.getStatus());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean cancelAdoption(int adoptionID) {
        Connection con = DBUtil.getDBConnection();
        String query = "UPDATE system.ADOPTION_TBL SET STATUS='CANCELLED' WHERE ADOPTION_ID=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, adoptionID);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}