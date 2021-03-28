package com.fypproject.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fypproject.entities.DOP;
import com.fypproject.services.dopServices;

@RestController
@RequestMapping("/DOP")
public class DOPcontroller {

	@Autowired
	private dopServices service;
	
	@PostMapping("/")
    public ResponseEntity<DOP> createUser(@RequestBody DOP user){
		 DOP b=null;
	      try{
	             b=service.createUser(user);
	             return ResponseEntity.of(Optional.of(b));
	           
	        }
	        catch(Exception e){
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
    }
	
	@GetMapping("/")
    public ResponseEntity<List<DOP>> getallDOPs()
    {
        List<DOP> list=service.getAllDOPs();
        if(list.size()<=0){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }
	
	@GetMapping("/{id}")
	 public  ResponseEntity<DOP> getById(@PathVariable int id) {
		
        DOP obj=service.getbyid(id);
        if(obj==null) {
        	
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(obj));
        
    }
	
	 @PutMapping("/{id}")
	 public ResponseEntity<DOP> updateUser(@PathVariable int id, @RequestBody DOP user) {
		 
		 DOP obj=null;
		 try {
			 obj= service.updateDOP(user, id);
			 return ResponseEntity.ok().body(obj);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}   
	  }
	
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletebyid(@PathVariable int id) {
	        try {
	            this.service.deleteById(id);
	            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }
	
	
	
	
	
}