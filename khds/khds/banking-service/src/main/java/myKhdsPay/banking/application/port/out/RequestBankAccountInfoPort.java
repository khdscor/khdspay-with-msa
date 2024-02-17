package myKhdsPay.banking.application.port.out;

import myKhdsPay.banking.adaptor.out.bank.BankAccount;
import myKhdsPay.banking.adaptor.out.bank.GetBankAccountRequest;

public interface RequestBankAccountInfoPort {
    BankAccount getBankAccountInfo(GetBankAccountRequest request);
}
