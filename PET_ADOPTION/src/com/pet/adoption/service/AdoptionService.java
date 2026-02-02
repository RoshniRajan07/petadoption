package com.pet.adoption.service;

import java.sql.Date;
import java.util.List;

import com.pet.adoption.bean.Adoption;
import com.pet.adoption.bean.Pet;
import com.pet.adoption.dao.AdoptionDAO;
import com.pet.adoption.dao.PetDAO;
import com.pet.adoption.util.ActiveAdoptionException;
import com.pet.adoption.util.PetNotAvailableException;
import com.pet.adoption.util.ValidationException;

public class AdoptionService {

    private PetDAO petDAO = new PetDAO();
    private AdoptionDAO adoptionDAO = new AdoptionDAO();
    public Pet viewPetDetails(String petID) {
        if (petID == null || petID.isEmpty()) {
            return null;
        }
        return petDAO.findPet(petID);
    }

    
    public List<Pet> viewAllPets() {
        return petDAO.viewAllPets();
    }

   
    public boolean addNewPet(Pet pet) {

        if (pet == null ||
            pet.getPetID() == null || pet.getPetID().isEmpty() ||
            pet.getName() == null || pet.getName().isEmpty() ||
            pet.getSpecies() == null || pet.getSpecies().isEmpty() ||
            pet.getAge() < 0) {
            return false;
        }

        if (petDAO.findPet(pet.getPetID()) != null) {
            return false;
        }

        return petDAO.insertPet(pet);
    }

 
    public boolean removePet(String petID) throws ActiveAdoptionException{

        if (petID == null || petID.isEmpty()) {
            return false;
        }

        Pet pet = petDAO.findPet(petID);
        if (pet == null) {
            return false;
        }

        if ("NO".equals(pet.getAvailable())) {
            throw new ActiveAdoptionException();
        }

        return petDAO.deletePet(petID);
    }

 
    public boolean adoptPet (String petID,String adopterName,  String adopterContact, Date adoptionDate)  throws ValidationException,  PetNotAvailableException{

        if (petID == null || petID.isEmpty() ||
            adopterName == null || adopterName.isEmpty() ||
            adopterContact == null || adopterContact.isEmpty() ||
            adoptionDate == null) {
            throw new ValidationException();
        }

        Pet pet = petDAO.findPet(petID);
        if (pet == null) {
            return false;
        }

        if ("NO".equals(pet.getAvailable())) {
            throw new PetNotAvailableException();
        }

        if ("NeedsTreatment".equals(pet.getMedicalStatus()) ||
            "UnderObservation".equals(pet.getMedicalStatus())) {
            return false;
        }

        int adoptionID = adoptionDAO.generateAdoptionID();

        Adoption adoption = new Adoption();
        adoption.setAdoptionID(adoptionID);
        adoption.setPetID(petID);
        adoption.setAdopterName(adopterName);
        adoption.setAdopterContact(adopterContact);
        adoption.setAdoptionDate(adoptionDate);
        adoption.setStatus("ADOPTED");

        adoptionDAO.recordAdoption(adoption);
        petDAO.updateAvailability(petID, "NO");

        return true;
    }

  
    public boolean cancelAdoption(int adoptionID, String petID)throws ValidationException  {

        if (adoptionID <= 0) {
            throw new ValidationException();
        }

        adoptionDAO.cancelAdoption(adoptionID);
        petDAO.updateAvailability(petID, "YES");

        return true;
    }
}
