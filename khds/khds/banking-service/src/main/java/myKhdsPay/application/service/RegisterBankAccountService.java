package myKhdsPay.application.service;

import lombok.RequiredArgsConstructor;
import myKhdsPay.adaptor.out.bank.BankAccount;
import myKhdsPay.adaptor.out.bank.GetBankAccountRequest;
import myKhdsPay.adaptor.out.persistence.RegisteredBankAccountJpaEntity;
import myKhdsPay.adaptor.out.persistence.RegisteredBankAccountMapper;
import myKhdsPay.application.port.in.RegisterBankAccountCommand;
import myKhdsPay.application.port.in.RegisterBankAccountUseCase;
import myKhdsPay.application.port.out.RegisterBankAccountPort;
import myKhdsPay.application.port.out.RequestBankAccountInfoPort;
import myKhdsPay.common.UseCase;
import myKhdsPay.domain.RegisteredBankAccount;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

    private final RegisterBankAccountPort registerBankAccountPort;

    private final RegisteredBankAccountMapper mapper;

    private final RequestBankAccountInfoPort requestBankAccountInfoPort;

    @Override
    public RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command) {


            RegisteredBankAccountJpaEntity savedAccountInfo = registerBankAccountPort.createRegisterBankAccount(
                    new RegisteredBankAccount.MembershipId(command.getMembershipId() + ""),
                    new RegisteredBankAccount.BankName(command.getBankName()),
                    new RegisteredBankAccount.BankAccountNumber(command.getBankAccountNumber()),
                    new RegisteredBankAccount.LinkStatusIsValid(true));

            return mapper.mapToDomainEntity(savedAccountInfo);

    }
}