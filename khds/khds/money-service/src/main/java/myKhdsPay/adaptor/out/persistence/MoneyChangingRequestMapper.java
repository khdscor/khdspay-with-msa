package myKhdsPay.adaptor.out.persistence;

import myKhdsPay.domain.MoneyChangingRequest;
import org.springframework.stereotype.Component;

@Component
public class MoneyChangingRequestMapper {
    public MoneyChangingRequest mapToDomainEntity(MoneyChangingRequestJpaEntity moneyChangingRequestJpaEntity){
        return MoneyChangingRequest.generateMoneyChangingRequest(
                new MoneyChangingRequest.MoneyChangingRequestId(moneyChangingRequestJpaEntity.getMoneyChangingRequestId().toString()),
                new MoneyChangingRequest.TargetMembershipId(moneyChangingRequestJpaEntity.getTargetMembershipId()),
                new MoneyChangingRequest.MoneyChangingType(moneyChangingRequestJpaEntity.getChangingType()),
                new MoneyChangingRequest.ChangingMoneyAmount(String.valueOf(moneyChangingRequestJpaEntity.getChangingMoneyAmount())),
                new MoneyChangingRequest.ChangingStatus(moneyChangingRequestJpaEntity.getChangingStatus()),
                new MoneyChangingRequest.Uuid(moneyChangingRequestJpaEntity.getUuid())
        );
    }
}
