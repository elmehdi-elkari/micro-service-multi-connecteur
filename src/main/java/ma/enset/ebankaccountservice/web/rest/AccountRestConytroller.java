package ma.enset.ebankaccountservice.web.rest;

import ma.enset.ebankaccountservice._tools.dto.BankAccountRequestDTO;
import ma.enset.ebankaccountservice._tools.dto.BankAccountResponseDTO;
import ma.enset.ebankaccountservice._tools.entities.Account;
import ma.enset.ebankaccountservice.sevice.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AccountRestConytroller {
    @Autowired
    private AccountService accountService;


    @GetMapping("/accounts")
    public List<Account> accounts(){
        return accountService.getAccounts();
    }

    @GetMapping("/accounts/{id}")
    public BankAccountResponseDTO account(@PathVariable String id){
        return accountService.getAccountById(id);
                //orElseThrow(()->new RuntimeException("Account not found"));
    }

    @PostMapping("/accounts")
    public BankAccountResponseDTO addAcount(@RequestBody BankAccountRequestDTO account){
        return accountService.addAcount(account);
    }

    @PutMapping("/accounts/{id}")
    public BankAccountResponseDTO updateAccount(@PathVariable String id, @RequestBody BankAccountRequestDTO account){
        return  accountService.updateAccount(id,account);
    }

    @DeleteMapping("accounts/{id}")
    public void deleteAccount(@PathVariable String id){
        accountService.deleteAccountById(id);
    }

}
