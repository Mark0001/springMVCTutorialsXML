package controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
 
import java.util.List; 
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController; 
 

import model.Person;
import utils.PseudoData;
 
 
@RestController
@RequestMapping(value=  "/stocks", produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
public class StockProductController  { 	
	 
	@RequestMapping(value="/exp", method=GET)
	@ResponseStatus(HttpStatus.OK) 
	public List<Person> getData( ){
		final  List<Person> result = PseudoData.getPersons();
		return  result;
	}
	 
}