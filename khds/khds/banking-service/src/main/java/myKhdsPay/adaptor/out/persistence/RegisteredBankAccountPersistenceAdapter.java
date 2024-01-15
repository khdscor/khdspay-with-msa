package myKhdsPay.adaptor.out.persistence;

import lombok.RequiredArgsConstructor;
import myKhdsPay.application.port.out.RegisterBankAccountPort;
import myKhdsPay.common.PersistenceAdapter;
import myKhdsPay.domain.RegisteredBankAccount;


@PersistenceAdapter
@RequiredArgsConstructor
public class RegisteredBankAccountPersistenceAdapter implements RegisterBankAccountPort {

    private final SpringDataRegisteredBankAccountRepository bankAccountRepository;

    @Override
    public RegisteredBankAccountJpaEntity createRegisterBankAccount(
            RegisteredBankAccount.MembershipId membershipId,
             RegisteredBankAccount.BankName bankName,
            RegisteredBankAccount.BankAccountNumber bankAccountNumber,
            RegisteredBankAccount.LinkStatusIsValid linkStatusIsValid) {

        return bankAccountRepository.save(
                new RegisteredBankAccountJpaEntity(
                        membershipId.getMembershipId(),
                        bankName.getBankName(),
                        bankAccountNumber.getBankAccountNumber(),
                        linkStatusIsValid.isLinkStatusIsValid() ));
    }
}