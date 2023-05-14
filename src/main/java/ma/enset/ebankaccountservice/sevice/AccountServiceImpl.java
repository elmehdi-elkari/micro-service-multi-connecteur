package ma.enset.ebankaccountservice.sevice;

import ma.enset.ebankaccountservice._tools.dto.BankAccountRequestDTO;
import ma.enset.ebankaccountservice._tools.dto.BankAccountResponseDTO;
import ma.enset.ebankaccountservice._tools.entities.Account;
import ma.enset.ebankaccountservice._tools.mappers.AccountMapper;
import ma.enset.ebankaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> getAccounts() {
        return bankAccountRepository.findAll();
    }

    @Override
    public BankAccountResponseDTO getAccountById(String id) {
        BankAccountResponseDTO responseDTO = accountMapper.frombankAccountToRespenseDTO(bankAccountRepository.findById(id).get());
        return responseDTO;
    }

    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO account) {
        Account oldAccount = bankAccountRepository.findById(id).get();
        if(account.getBalance()!=null) oldAccount.setBalance(account.getBalance());
        if(account.getType()!=null) oldAccount.setType(account.getType());
        if(account.getCurrency()!=null) oldAccount.setCurrency(account.getCurrency());
        return accountMapper.frombankAccountToRespenseDTO(bankAccountRepository.save(oldAccount));
    }

    @Override
    public void deleteAccountById(String id) {
        bankAccountRepository.deleteById(id);
    }

    @Override
    public BankAccountResponseDTO addAcount(BankAccountRequestDTO bankAccountDTO) {
        Account bankAccount = Account.builder()
                .id(UUID.randomUUID().toString())
                .createDate(new Date())
                .balance(bankAccountDTO.getBalance())
                .currency(bankAccountDTO.getCurrency())
                .type(bankAccountDTO.getType())
                .build();
        Account savedAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.frombankAccountToRespenseDTO(savedAccount);
        return bankAccountResponseDTO;
    }
}
