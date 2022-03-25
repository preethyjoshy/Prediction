package com.CGI.prediction.resources;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.CGI.prediction.models.NameAge;
import com.CGI.prediction.models.NameGender;
import com.CGI.prediction.models.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@RequestMapping("/prediction")
public class PredictionResouce {
    
    @Autowired
    private RestTemplate restTemplate;
    private static final String GENDRIZE_API_URL="https://api.genderize.io";
    private static final String AGIFY_API_URL="https://api.agify.io";

    @RequestMapping("/{name}")
    public ResponseEntity<Object> getPredictedAgeAndGender(@PathVariable("name") String name) throws Exception{
        try{
        NameGender nameGender= restTemplate.getForObject(GENDRIZE_API_URL+"?name="+name, NameGender.class);
        NameAge nameAge= restTemplate.getForObject(AGIFY_API_URL+"?name="+name, NameAge.class);
        Person person=new Person(name,nameGender.getGender(), nameAge.getAge());
        return new ResponseEntity<>(person,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(" Unable to connect "+GENDRIZE_API_URL+", "+AGIFY_API_URL+"\nException:"+e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
