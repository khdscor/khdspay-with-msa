package myKhdsPay.application.port.out;

import myKhdsPay.adaptor.out.bank.BankAccount;
import myKhdsPay.adaptor.out.bank.GetBankAccountRequest;

public interface RequestBankAccountInfoPort {
    BankAccount getBankAccountInfo(GetBankAccountRequest request);
}
