package myKhdsPay.banking.application.port.out;

import myKhdsPay.banking.adaptor.out.persistence.RegisteredBankAccountJpaEntity;
import myKhdsPay.banking.domain.RegisteredBankAccount.BankAccountNumber;
import myKhdsPay.banking.domain.RegisteredBankAccount.BankName;
import myKhdsPay.banking.domain.RegisteredBankAccount.LinkStatusIsValid;
import myKhdsPay.banking.domain.RegisteredBankAccount.MembershipId;

public interface RegisterBankAccountPort {

    RegisteredBankAccountJpaEntity createRegisterBankAccount(
            MembershipId membershipId,
            BankName bankName,
            BankAccountNumber bankAccountNumber,
            LinkStatusIsValid linkStatusIsValid
    );
}
