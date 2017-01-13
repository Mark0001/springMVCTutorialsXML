package controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.LinkedList;
import java.util.List; 
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController; 
 

import model.Person;
 
 
@RestController
@RequestMapping(value=  "/stocks", produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
public class StockProductController  { 	
	 
	@RequestMapping(value="/exp", method=GET)
	@ResponseStatus(HttpStatus.OK) 
	public List<Person> getData( ){
		final  List<Person> result = getPseudoData();
		return  result;
	}
	private List<Person> getPseudoData(){
		final  List<Person> result =new LinkedList<Person>();
		Person p1 = new Person();
		p1.setAge(2);
		p1.setGender(false);
		p1.setName("老王1");
		result.add(p1);
		Person p2 = new Person();
		p2.setAge(2);
		p2.setGender(true);
		p2.setName("老王2");
		result.add(p2);
		
		return  result;
	} 
}