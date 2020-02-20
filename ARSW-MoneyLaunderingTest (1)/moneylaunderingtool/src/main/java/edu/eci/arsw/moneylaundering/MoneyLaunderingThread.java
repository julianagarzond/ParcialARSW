/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.moneylaundering;


import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


/**
 *
 * @author juliana.garzon-d
 */
public class MoneyLaunderingThread extends Thread {
    
    private TransactionReader transactionReader;
    private List<File> transactionFiles;


    MoneyLaunderingThread( List<File> subList) {
        transactionFiles= subList;
        transactionReader = new TransactionReader();
     
    }
    
     @Override
    public void run() {
        
        for(File transactionFile : transactionFiles)
        {            
            List<Transaction> transactions = transactionReader.readTransactionsFromFile(transactionFile);
            for(Transaction transaction : transactions)
            {
               synchronized(MoneyLaundering.monitor){ 
                   if(MoneyLaundering.pause){
                      try{
                          
                   MoneyLaundering.monitor.wait();
                      }catch (InrerruptedException e){
                      e.printStackTrace();}
                   }
               
                
               }
                MoneyLaundering.transactionAnalyzer.addTransaction(transaction);
            }
             MoneyLaundering.amountOfFilesProcessed.incrementAndGet();
        } 
    }
       public synchronized void continuar(){
        MoneyLaundering.monitor.notifyAll();}
    }
    
    
    
}
