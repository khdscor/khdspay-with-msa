package myKhdsPay.money.application.service;

import lombok.RequiredArgsConstructor;
import myKhdsPay.money.adaptor.out.persistence.MemberMoneyJpaEntity;
import myKhdsPay.money.adaptor.out.persistence.MoneyChangingRequestJpaEntity;
import myKhdsPay.money.adaptor.out.persistence.MoneyChangingRequestMapper;
import myKhdsPay.money.application.port.in.IncreaseMoneyRequestCommand;
import myKhdsPay.money.application.port.in.IncreaseMoneyRequestUseCase;
import myKhdsPay.money.application.port.out.IncreaseMoneyPort;
import myKhdsPay.money.domain.MemberMoney;
import myKhdsPay.money.domain.MoneyChangingRequest;

import myKhdsPay.common.UseCase;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@UseCase
@Transactional
@RequiredArgsConstructor
public class IncreaseMoneyRequestService implements IncreaseMoneyRequestUseCase {

    private final IncreaseMoneyPort increaseMoneyPort;

    private final MoneyChangingRequestMapper mapper;

    @Override
    public MoneyChangingRequest registerMembership(IncreaseMoneyRequestCommand command) {
        //머니의 충정.증액이라는 과정
        // 1. 고객 정보가 정상인지 확인(멤버)
        // 2. 고객의 연동도니 계좌가 있는지, 고객의 연동된 계좌의 잔액이 충분한지도 확인(뱅킹)
        // 3. 법인 계좌 상태도 정상인지 확인(뱅킹)
        // 4. 증액을 위한 "기록". 요청 상태로 MoneyChangingRequest 를 생성한다.(MoneyChangingRequest)
        // 5. 펑뱅킹을 수행하고 (고객의 연동된 계좌 -> 패캠페이 법인 계좌)(뱅킹)

        // 6-1. 결과가 정상이라면, 성공으로 MoneyChangingRequest 를 업데이트한다.
        // MemberMoney 증액이 필요
        MemberMoneyJpaEntity entity = increaseMoneyPort.increaseMoney(
            new MemberMoney.MembershipId(command.getTargetMembershipId()), command.getAmount());
        if (entity != null) {
            MoneyChangingRequestJpaEntity request = increaseMoneyPort.createMoneyChangingRequest(
                new MoneyChangingRequest.TargetMembershipId(command.getTargetMembershipId()),
                new MoneyChangingRequest.MoneyChangingType(1),
                new MoneyChangingRequest.ChangingMoneyAmount(Integer.toString(command.getAmount())),
                new MoneyChangingRequest.ChangingStatus(1),
                new MoneyChangingRequest.Uuid(UUID.randomUUID()));
            return mapper.mapToDomainEntity(request);
        }
        // 6-2. 결과가 비정상이라면, 실패로 MoneyChangingRequest 를 업데이트한다.
        return null;
    }
}