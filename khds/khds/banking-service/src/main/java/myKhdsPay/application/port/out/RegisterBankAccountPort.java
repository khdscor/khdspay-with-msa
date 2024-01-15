package myKhdsPay.application.port.out;

import myKhdsPay.adaptor.out.persistence.RegisteredBankAccountJpaEntity;
import myKhdsPay.domain.RegisteredBankAccount;

public interface RegisterBankAccountPort {

    RegisteredBankAccountJpaEntity createRegisterBankAccount(
            RegisteredBankAccount.MembershipId membershipId,
            RegisteredBankAccount.BankName bankName,
            RegisteredBankAccount.BankAccountNumber bankAccountNumber,
            RegisteredBankAccount.LinkStatusIsValid linkStatusIsValid
    );
}
