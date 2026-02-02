package com.pet.adoption.bean;

import java.util.Date;

public class Adoption {
    private int adoptionID;
    private String petID;
    private String adopterName;
    private String adopterContact;
    private Date adoptionDate;
    private String status;

    public int getAdoptionID() { return adoptionID; }
    public void setAdoptionID(int adoptionID) { this.adoptionID = adoptionID; }

    public String getPetID() { return petID; }
    public void setPetID(String petID) { this.petID = petID; }

    public String getAdopterName() { return adopterName; }
    public void setAdopterName(String adopterName) { this.adopterName = adopterName; }

    public String getAdopterContact() { return adopterContact; }
    public void setAdopterContact(String adopterContact) { this.adopterContact = adopterContact; }

    public Date getAdoptionDate() { return adoptionDate; }
    public void setAdoptionDate(Date adoptionDate) { this.adoptionDate = adoptionDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
