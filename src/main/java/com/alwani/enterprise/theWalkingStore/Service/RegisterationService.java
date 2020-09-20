package com.alwani.enterprise.theWalkingStore.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alwani.enterprise.theWalkingStore.Repository.UserDetails;
import com.alwani.enterprise.theWalkingStore.bean.Partner;

@Service
public class RegisterationService{

	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterationService.class);
	
	 @Autowired 
	 UserDetails userdetails;
	
	public boolean checkIfPartnerExists(Partner partner) {
		//check for email ID or mobile number already registered, if yes then throw custom exception
		
		return false;
		
	}
	
	public boolean addPartner(Partner partner) {
		if(!checkIfPartnerExists(partner)) {
			partner.setIs_Active(true);
			partner.setIs_Verified(false);
			partner.setSS_Verified(false);
			try {
				userdetails.save(partner);
			}catch(IllegalArgumentException ex){
				
				LOGGER.debug("Unable to register user {} ", ex.getMessage());
				return false;
			}			
			return true;
		}
		return false;
	}
	
	public boolean userUpdate(Partner partner) {
		//check for authentication
		try {
			userdetails.save(partner);
		}catch(IllegalArgumentException ex){
			LOGGER.debug("Unable to register user {} ", ex.getMessage());
			return false;
		}			
		return true;
	}

	public List<Partner> getAllPartner() {
		//check ADMIN authentication
		List<Partner> p1 =userdetails.findAll();
		return p1;
	}
	
	public Object getPartnerById(int id) {
		//check ADMIN authentication
		
		return userdetails.findById(id);
		//return p1;
	}
	
}
