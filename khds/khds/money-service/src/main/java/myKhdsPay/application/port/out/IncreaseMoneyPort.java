package myKhdsPay.application.port.out;

import myKhdsPay.adaptor.out.persistence.MoneyChangingRequestJpaEntity;
import myKhdsPay.domain.MoneyChangingRequest;

public interface IncreaseMoneyPort {

    MoneyChangingRequestJpaEntity createMoneyChangingRequest(
            MoneyChangingRequest.TargetMembershipId targetMembershipId,
            MoneyChangingRequest.MoneyChangingType moneyChangingType,
            MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount,
            MoneyChangingRequest.ChangingStatus changingStatus,
            MoneyChangingRequest.Uuid uuid
    );

}
