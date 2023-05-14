package ma.enset.ebankaccountservice.web.qraphQl;

import ma.enset.ebankaccountservice._tools.dto.BankAccountRequestDTO;
import ma.enset.ebankaccountservice._tools.dto.BankAccountResponseDTO;
import ma.enset.ebankaccountservice._tools.entities.Account;
import ma.enset.ebankaccountservice.sevice.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AccountGraphQlController {

    @Autowired
    private AccountService accountService;

    // même nom que schema qraphql sinon utilise @GraphqlMapping
    @QueryMapping
    public List<Account> accounts(){
        return accountService.getAccounts();
    }

    @QueryMapping
    public BankAccountResponseDTO accountById(@Argument String id){
        return accountService.getAccountById(id);
    }

    @MutationMapping
    public BankAccountResponseDTO addAcount(@Argument BankAccountRequestDTO newAccount){
        return accountService.addAcount(newAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id,@Argument BankAccountRequestDTO oldAccount){
        return accountService.updateAccount(id,oldAccount);
    }

    @MutationMapping
    public Boolean deleteAccount(@Argument String id){
        accountService.deleteAccountById(id);
        return true;
    }
}
