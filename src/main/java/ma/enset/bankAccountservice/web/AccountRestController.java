package ma.enset.bankAccountservice.web;

import lombok.AllArgsConstructor;
import ma.enset.bankAccountservice.Entities.BankAccount;
import ma.enset.bankAccountservice.Repository.AccountRepository;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@AllArgsConstructor
public class AccountRestController {


    private AccountRepository accountRepository;

    @GetMapping("/BankAccounts")
    public List<BankAccount> getBankAccounts(){
        return accountRepository.findAll();

    }
    @GetMapping("/BankAccounts/{id}")
    public BankAccount getBankAccount(@PathVariable String id){
      return accountRepository.findById(id).get();
    }

    @PostMapping("/BankAccount")
    public void saveAccount(@RequestBody BankAccount bankAccount){
        accountRepository.save(bankAccount);
    }
    @PostMapping("/BankAccounts")
    public void saveAccounts(@RequestBody List<BankAccount> bankAccounts){
        accountRepository.saveAll(bankAccounts);
    }
    @PutMapping("/BankAccounts/{id}")
    public void update(@PathVariable String id,@RequestBody BankAccount Account){
        BankAccount bankAccount=accountRepository.findById(id).get();

        if(bankAccount.getCurrency()!=null)bankAccount.setCurrency(Account.getCurrency());
        if(bankAccount.getType()!=null)bankAccount.setType(Account.getType());
        if(bankAccount.getCreatedAt()!=null) bankAccount.setCreatedAt(new Date());
        if(bankAccount.getBalance()!=null) bankAccount.setBalance(Account.getBalance());
         accountRepository.save(bankAccount);

    }
    @DeleteMapping("/BankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
        accountRepository.deleteById(id);

    }

}
