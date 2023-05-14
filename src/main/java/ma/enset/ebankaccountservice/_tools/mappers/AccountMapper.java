package ma.enset.ebankaccountservice._tools.mappers;

import ma.enset.ebankaccountservice._tools.dto.BankAccountRequestDTO;
import ma.enset.ebankaccountservice._tools.dto.BankAccountResponseDTO;
import ma.enset.ebankaccountservice._tools.entities.Account;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public BankAccountResponseDTO frombankAccountToRespenseDTO(Account bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO =new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
    public BankAccountRequestDTO frombankAccountToRequestDTO(Account bankAccount){
        BankAccountRequestDTO bankAccountRequestDTO =new BankAccountRequestDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountRequestDTO);
        return bankAccountRequestDTO;
    }



}
