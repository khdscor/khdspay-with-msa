package myKhdsPay.banking.adaptor.out.bank;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BankAccount {
    private String bankName;
    private String bankAccountNumber;
    private boolean isValid;
}
