package com.alwani.enterprise.theWalkingStore.Controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alwani.enterprise.theWalkingStore.Service.RegisterationService;
import com.alwani.enterprise.theWalkingStore.bean.Partner;
import com.alwani.enterprise.theWalkingStore.security.AuthenticationRequest;
import com.alwani.enterprise.theWalkingStore.security.AuthenticationResponse;
import com.alwani.enterprise.theWalkingStore.security.JwtUtil;
import com.alwani.enterprise.theWalkingStore.security.MyUserDetailsService;





@RestController
@RequestMapping(path="/partner")
public class UserRegisterationController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserRegisterationController.class);
	
	@Autowired
	private RegisterationService registrationService;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@PostMapping(path="/authenticate")
	public ResponseEntity<?> createAuthenticationtoken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword())
					);
		} catch(BadCredentialsException e) {
			throw new Exception("Incorrect username or password",e);
		}
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUserName());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
	}
	
	@PostMapping(path="/register")
	public void createUser(@RequestBody Partner partner) {
			registrationService.addPartner(partner);
			LOGGER.debug("This partner details was registered {} ",partner.getID());
	}

	@PutMapping(path="/updateEmail")
	public void updateUserEmail(@RequestBody Partner partner) {
		registrationService.userUpdate(partner);
		LOGGER.debug("This partner details was updated {} ",partner.getID());
	}
	
	
	@PutMapping(path="/updateMobile")
	public void updateUserMobile(@RequestBody Partner partner) {
		registrationService.userUpdate(partner);
		LOGGER.debug("This partner details was updated {} ",partner.getID());
	}
	
	@DeleteMapping(path="/deRegister")
	public void deregisterUser(@RequestBody Partner partner) {
		//check authentication
		partner.setIs_Active(false);
		LOGGER.debug("This partner details was updated {} ",partner.getID());
	}
	
	@GetMapping(path="/all")
	public List<Partner> getAllPartner() {
		//check ADMIN authentication
		List<Partner> p1 =registrationService.getAllPartner();
		return p1;
	}
	
	@GetMapping(path="/{id}")
	public Object getPartnerById(@PathVariable String id) {
		//check ADMIN authentication
		return registrationService.getPartnerById(Integer.parseInt(id));
		//return p1;
	}
}
