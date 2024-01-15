package myKhdsPay.adaptor.out.persistence;

import lombok.RequiredArgsConstructor;
import myKhdsPay.common.PersistenceAdapter;


@PersistenceAdapter
@RequiredArgsConstructor
public class RegisteredBankAccountPersistenceAdapter  {

    private final SpringDataRegisteredBankAccountRepository registeredBankAccountRepository;
}