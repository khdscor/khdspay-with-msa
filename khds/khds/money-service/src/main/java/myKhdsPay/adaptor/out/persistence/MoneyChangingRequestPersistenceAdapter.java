package myKhdsPay.adaptor.out.persistence;

import lombok.RequiredArgsConstructor;
import myKhdsPay.application.port.out.IncreaseMoneyPort;
import myKhdsPay.common.PersistenceAdapter;
import myKhdsPay.domain.MoneyChangingRequest;

import java.sql.Timestamp;
import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class MoneyChangingRequestPersistenceAdapter implements IncreaseMoneyPort {

    private final SpringDataMoneyChangingRequestRepository moneyChangingRequestRepository;

    @Override
    public MoneyChangingRequestJpaEntity createMoneyChangingRequest(MoneyChangingRequest.TargetMembershipId targetMembershipId, MoneyChangingRequest.MoneyChangingType moneyChangingType, MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount, MoneyChangingRequest.ChangingStatus changingStatus, MoneyChangingRequest.Uuid uuid) {
        return moneyChangingRequestRepository.save(
                new MoneyChangingRequestJpaEntity(
                        targetMembershipId.getTargetMembershipId(),
                        moneyChangingType.toValue(),
                        Integer.parseInt(changingMoneyAmount.getChangingMoneyAmount()),
                        new Timestamp(System.currentTimeMillis()),
                        changingStatus.toValue(),
                        UUID.randomUUID()
                ));
    }
}