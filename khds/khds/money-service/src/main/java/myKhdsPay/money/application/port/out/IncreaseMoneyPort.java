package myKhdsPay.money.application.port.out;

import myKhdsPay.money.adaptor.out.persistence.MemberMoneyJpaEntity;
import myKhdsPay.money.adaptor.out.persistence.MoneyChangingRequestJpaEntity;
import myKhdsPay.money.domain.MemberMoney;
import myKhdsPay.money.domain.MoneyChangingRequest;

public interface IncreaseMoneyPort {

    MoneyChangingRequestJpaEntity createMoneyChangingRequest(
            MoneyChangingRequest.TargetMembershipId targetMembershipId,
            MoneyChangingRequest.MoneyChangingType moneyChangingType,
            MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount,
            MoneyChangingRequest.ChangingStatus changingStatus,
            MoneyChangingRequest.Uuid uuid
    );

    MemberMoneyJpaEntity increaseMoney(
        MemberMoney.MembershipId membershipId,
        int increaseMoneyAmount
    );
}
