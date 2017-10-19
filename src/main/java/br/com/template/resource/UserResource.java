package br.com.template.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.template.business.IUserBO;
import br.com.template.facade.IFacade;
import br.com.template.model.Response;
import br.com.template.model.User;

@RestController
@RequestMapping(value = "/user")
public class UserResource {
	
	 @Autowired
	 private IFacade facade;
	 
	 private final Logger logger = LoggerFactory.getLogger(getClass());
	 
	 @RequestMapping(value = "/recuperarUsers/", method = RequestMethod.GET, produces = {"application/json"})
	    public ResponseEntity<?> recuperarUsers(){
	        try {
	        	List<User> users = facade.get(IUserBO.class).recuperarUsers();
	            return ResponseEntity.ok(users);
	        }catch (Exception ex){
	            logger.error(ex.getMessage());
	            return new ResponseEntity<>(new Response(13,ex.getMessage()), HttpStatus.BAD_REQUEST);
	        }
	    }
	 
	 @RequestMapping(value = "/insertUser/", method = RequestMethod.POST, produces = {"application/json"})
	    public ResponseEntity<?> insertUser(@RequestBody User user){
	        try {	        	
	            return ResponseEntity.ok(facade.get(IUserBO.class).insertUser(user));
	        }catch (Exception ex){
	            logger.error(ex.getMessage());
	            return new ResponseEntity<>(new Response(13,ex.getMessage()), HttpStatus.BAD_REQUEST);
	        }
	    }
	 
	 @RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET, produces = {"application/json"})
	    public ResponseEntity<?>  getUserById(@PathVariable("id") Integer id) throws Exception{
	    	try{
	    		//Plano plano = facade.get(IPlanoBO.class).getPlanosById(id);
	    		User user  = facade.get(IUserBO.class).getUserById(id);
	    		return ResponseEntity.ok(user);
	    	}catch(Exception ex){
	    		logger.error(ex.getMessage());
	            return new ResponseEntity<>(new Response(13,ex.getMessage()), HttpStatus.BAD_REQUEST);
	    	}
	    }
	 
	 @RequestMapping(value = "/updateUser/", method = RequestMethod.POST, produces = {"application/json"})
	    public ResponseEntity<?> updateUser(@RequestBody User user){
	        try {	        	
	            return ResponseEntity.ok(facade.get(IUserBO.class).updateUser(user));
	        }catch (Exception ex){
	            logger.error(ex.getMessage());
	            return new ResponseEntity<>(new Response(13,ex.getMessage()), HttpStatus.BAD_REQUEST);
	        }
	    }
	
}
