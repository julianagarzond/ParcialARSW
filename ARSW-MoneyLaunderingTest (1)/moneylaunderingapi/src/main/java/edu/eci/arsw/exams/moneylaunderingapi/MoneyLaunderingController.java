package edu.eci.arsw.exams.moneylaunderingapi;


import edu.eci.arsw.exams.moneylaunderingapi.model.SuspectAccount;
import edu.eci.arsw.exams.moneylaunderingapi.service.MoneyLaunderingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping( value = "/fraud-bank-accounts")
public class MoneyLaunderingController
{	
	@Autowired 
    MoneyLaunderingService moneyLaunderingService;

	@RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<SuspectAccount>> offendingAccounts() {
		
		try {
			
			return new ResponseEntity<List<SuspectAccount>>(moneyLaunderingService.getSuspectAccounts(),HttpStatus.ACCEPTED);
		}catch (Exception e) {
			return new ResponseEntity<List<SuspectAccount>>(new List<SuspectAccount>,HttpStatus.NOT_FOUND);
			
		}
    	
     
    }

    //TODO
}
