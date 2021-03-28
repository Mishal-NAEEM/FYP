package com.fypproject.services;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fypproject.entities.DOP;
import com.fypproject.repositories.dopRepository;


@Component
@Service
public class dopServices {

	@Autowired
	private dopRepository dopRepo;
//	@Autowired
//	private patientRepository patientRepo;
	

	//create a new user
	 public DOP createUser(DOP obj) {    
	          return dopRepo.save(obj);
	    }
	
	 	//return all 
		public List<DOP> getAllDOPs(){
			List<DOP> list=(List<DOP>)dopRepo.findAll();
			return list;
		}
		
		//find DOPbyid
		public DOP getbyid(int id){
			DOP user=null;
			try {
			 user=dopRepo.findById(id).get();
			 return user;
			}
			catch(Exception e) {
				e.printStackTrace();
				return user;
			}
		}
		
		
		 // Update an Existing User */
	    @Transactional
	    public DOP updateDOP(DOP user, int id)
	    {
	    	 DOP newUser=null;
	        if(dopRepo.findById(id).isPresent()) {
	            newUser = dopRepo.findById(id).get();
	            newUser.setName(user.getName());
	            newUser.setEmail(user.getEmail());
	            newUser.setAddress(user.getAddress());
	            newUser.setCity(user.getCity());
	            newUser.setPatients(user.getPatients());
	           return dopRepo.save(newUser);
	        }
	        else
	        	return newUser;
	       }

	  //deletebyid
	  		public void deleteById(int id) {
	  			 dopRepo.deleteById(id);
	  		}
	  		
}
