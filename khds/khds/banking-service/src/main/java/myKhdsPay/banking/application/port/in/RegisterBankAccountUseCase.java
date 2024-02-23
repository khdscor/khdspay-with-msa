package myKhdsPay.banking.application.port.in;

import myKhdsPay.banking.domain.RegisteredBankAccount;

public interface RegisterBankAccountUseCase {

    RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command) throws Exception;
}
