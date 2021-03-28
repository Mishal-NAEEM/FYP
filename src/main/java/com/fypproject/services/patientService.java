package com.fypproject.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fypproject.entities.Patient;
import com.fypproject.repositories.patientRepository;

@Service
public class patientService {

//	@Autowired
//	private dopRepository dopRepo;
	@Autowired
	private patientRepository patientRepo;
	
	
	 public Patient createUser(Patient obj) {    
         return patientRepo.save(obj);
	 }
	 
	 public Patient getbyid(int id){
		 Patient obj=null;
		 try {
			 obj=patientRepo.findById(id).get();
			 return obj;
			
		} catch (Exception e) {
			// TODO: handle exception
			return obj;
		}
			
	}
	
	//return all
	public List<Patient> getAllPatients(){
		List<Patient> list=(List<Patient>)patientRepo.findAll();
		return list;
	}
	
	 // Update an Existing User */
    @Transactional
    public Patient updatePatient(Patient user, int id)
    {
    	 Patient  newUser=null;
        if(patientRepo.findById(id).isPresent()) {
            newUser = patientRepo.findById(id).get();
            newUser.setName(user.getName());
            newUser.setEmail(user.getEmail());
            newUser.setAddress(user.getAddress());
            newUser.setCity(user.getCity());
            newUser.setPhysioterapists(user.getPhysioterapists());
           return  patientRepo.save(newUser);
        }
        else
        	return newUser;
       }

    //deletebyid
		public void deleteById(int id) {
			patientRepo.deleteById(id);
		}

}
