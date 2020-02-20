package edu.eci.arsw.exams.moneylaunderingapi.model;

public class SuspectAccount {
    public String accountId;
    public int amountOfSmallTransactions;
    
    
    
public String getId(){
    return accountId;
}

public void setId(String accountId){
    this.accountId=accountId;
}

public int getAmount(){
    return amountOfSmallTransactions; 
}

public void setAmount(int amount){
    this.amountOfSmallTransactions=amountOfSmallTransactions; 
}
        
}
