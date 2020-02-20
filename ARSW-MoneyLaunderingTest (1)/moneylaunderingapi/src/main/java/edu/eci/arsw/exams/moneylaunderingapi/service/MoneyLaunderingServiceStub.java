package edu.eci.arsw.exams.moneylaunderingapi.service;

import edu.eci.arsw.exams.moneylaunderingapi.model.SuspectAccount;
import java.util.ArrayList;

import java.util.List;

public class MoneyLaunderingServiceStub implements MoneyLaunderingService {
    List<SuspectAccount> suspectList= new ArrayList<SuspectAccount>();
    
    public MoneyLaunderingServiceStub(){
        SuspectAccount sus1= new SuspectAccount();
        SuspectAccount sus2= new SuspectAccount();
        SuspectAccount sus3= new SuspectAccount();
        sus1.setId("12355");
        sus1.setAmount(2345656);
        sus2.setId("675447");
        sus2.setAmount(4436463);
        sus3.setId("14236");
        sus3.setAmount(993235);
        suspectList.add(sus1);
        suspectList.add(sus2);
        suspectList.add(sus3);
        
        
        
}
    @Override
    public void updateAccountStatus(SuspectAccount suspectAccount) {
        if(suspectList.contains(suspectAccount)){
            suspectAccount.setId(suspectAccount.getId());
            suspectAccount.setAmount(suspectAccount.getAmount());    
        }
    }

    @Override
    public SuspectAccount getAccountStatus(String accountId) {
    SuspectAccount susa =new SuspectAccount();
       
        for(SuspectAccount sus :suspectList){
            if(sus.getId()== accountId){
              susa=sus;
            }
         }
        return susa;
    }
        
       
    

    @Override
    public List<SuspectAccount> getSuspectAccounts() {

        return suspectList;

        
    }
}

