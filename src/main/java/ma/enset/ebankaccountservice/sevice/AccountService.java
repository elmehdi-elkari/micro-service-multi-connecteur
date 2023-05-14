package ma.enset.ebankaccountservice.sevice;

import ma.enset.ebankaccountservice._tools.dto.BankAccountRequestDTO;
import ma.enset.ebankaccountservice._tools.dto.BankAccountResponseDTO;
import ma.enset.ebankaccountservice._tools.entities.Account;

import java.util.List;


public interface AccountService {

    List<Account> getAccounts();
    BankAccountResponseDTO getAccountById(String id);
    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO account);
    void deleteAccountById(String id);
    public BankAccountResponseDTO addAcount(BankAccountRequestDTO bankAccountDTO);

}
