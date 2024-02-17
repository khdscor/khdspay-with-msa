package myKhdsPay.banking.application.service;

import lombok.RequiredArgsConstructor;
import myKhdsPay.banking.adaptor.out.bank.BankAccount;
import myKhdsPay.banking.adaptor.out.bank.GetBankAccountRequest;
import myKhdsPay.banking.adaptor.out.persistence.RegisteredBankAccountJpaEntity;
import myKhdsPay.banking.adaptor.out.persistence.RegisteredBankAccountMapper;
import myKhdsPay.banking.application.port.in.RegisterBankAccountCommand;
import myKhdsPay.banking.application.port.in.RegisterBankAccountUseCase;
import myKhdsPay.banking.application.port.out.RegisterBankAccountPort;
import myKhdsPay.banking.application.port.out.RequestBankAccountInfoPort;
import myKhdsPay.common.UseCase;
import myKhdsPay.banking.domain.RegisteredBankAccount;
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

        //은행 계죄를 등록해야하는 서비스 (비즈니스 로직)
        // 멤버 서비스 확인은 (여기서는) skip =>  membershipId에 해당하는 멤버가 존재하는지 확인
        //1. 외부 실제 은행에 등록이 가능한 계좌인지(정상인지) 확인한다.
        // 외부의 은행에 이 계좌가 정상인지? 확인을 해야한다.
        //biz logic -> External System
        //port -> adapter
        //port를 우선 구현

        //실제 외부의 은행 계좌 정보를 get
        BankAccount accountInfo = requestBankAccountInfoPort.getBankAccountInfo(
                new GetBankAccountRequest(command.getBankName(), command.getBankAccountNumber()));
        boolean accountIsValid = accountInfo.isValid();

        //2. 등록가능한 계좌라면, 등록한다. 등록에 성공한 등록 정보를 리턴
        //2-1. 등록하지 않은 계좌라면 에러를 리턴
        if (accountIsValid) {
            RegisteredBankAccountJpaEntity savedAccountInfo = registerBankAccountPort.createRegisterBankAccount(
                    new RegisteredBankAccount.MembershipId(command.getMembershipId() + ""),
                    new RegisteredBankAccount.BankName(command.getBankName()),
                    new RegisteredBankAccount.BankAccountNumber(command.getBankAccountNumber()),
                    new RegisteredBankAccount.LinkStatusIsValid(accountIsValid)
            );
            return mapper.mapToDomainEntity(savedAccountInfo);
        }
        return null;
    }
}