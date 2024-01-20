package myKhdsPay.application.service;

import lombok.RequiredArgsConstructor;
import myKhdsPay.adaptor.out.persistence.MoneyChangingRequestJpaEntity;
import myKhdsPay.adaptor.out.persistence.MoneyChangingRequestMapper;
import myKhdsPay.application.port.in.IncreaseMoneyRequestCommand;
import myKhdsPay.application.port.in.IncreaseMoneyRequestUseCase;
import myKhdsPay.application.port.out.IncreaseMoneyPort;
import myKhdsPay.common.UseCase;
import myKhdsPay.domain.MoneyChangingRequest;
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
        // 1. 고객 정보가 정상인지 확인
        // 2. 고객의 연동도니 계좌가 있는지, 고객의 연동된 계좌의 잔액이 충분한지도 확인
        // 3. 법인 계좌 상태도 정상인지 확인
        // 4. 증액을 위한 "기록". 요청 상태로 MoneyChangingRequest 를 생성한다.
        // 5. 펑뱅킹을 수행하고 (고객의 연동된 계좌 -> 패캠페이 법인 계좌)
        // 6-1. 결과가 정상이라면, 성공으로 MoneyChangingRequest 를 업데이트한다.
        // 6-2. 결과가 비정상이라면, 실패로 MoneyChangingRequest 를 업데이트한다.
        // 6-3. 이후 반환

        //임시 저장
        MoneyChangingRequestJpaEntity request = increaseMoneyPort.createMoneyChangingRequest(
                new MoneyChangingRequest.TargetMembershipId(command.getTargetMembershipId()),
                new MoneyChangingRequest.MoneyChangingType(1),
                new MoneyChangingRequest.ChangingMoneyAmount(Integer.toString(command.getAmount())),
                new MoneyChangingRequest.ChangingStatus(2),
                new MoneyChangingRequest.Uuid(UUID.randomUUID())
        );


        return mapper.mapToDomainEntity(request);
    }
}