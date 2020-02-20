package edu.eci.arsw.exams.moneylaunderingapi.service;

import edu.eci.arsw.exams.moneylaunderingapi.model.SuspectAccount;
import java.util.List;

public interface MoneyLaunderingService {
    public void updateAccountStatus(SuspectAccount suspectAccount) ;
    public SuspectAccount getAccountStatus(String accountId) ;
    public List<SuspectAccount> getSuspectAccounts();
}
