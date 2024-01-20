package myKhdsPay.adaptor.out.persistence;

import lombok.RequiredArgsConstructor;
import myKhdsPay.application.port.out.IncreaseMoneyPort;
import myKhdsPay.common.PersistenceAdapter;
import myKhdsPay.domain.MemberMoney.Balance;
import myKhdsPay.domain.MemberMoney.MemberMoneyId;
import myKhdsPay.domain.MemberMoney.MembershipId;
import myKhdsPay.domain.MoneyChangingRequest;

import java.sql.Timestamp;
import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class MoneyChangingRequestPersistenceAdapter implements IncreaseMoneyPort {

    private final SpringDataMoneyChangingRequestRepository moneyChangingRequestRepository;

    private final SpringDataMemberMoneyRepository memberMoneyRepository;

    @Override
    public MoneyChangingRequestJpaEntity createMoneyChangingRequest(
        MoneyChangingRequest.TargetMembershipId targetMembershipId,
        MoneyChangingRequest.MoneyChangingType moneyChangingType,
        MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount,
        MoneyChangingRequest.ChangingStatus changingStatus, MoneyChangingRequest.Uuid uuid) {
        return moneyChangingRequestRepository.save(
            new MoneyChangingRequestJpaEntity(targetMembershipId.getTargetMembershipId(),
                moneyChangingType.toValue(),
                Integer.parseInt(changingMoneyAmount.getChangingMoneyAmount()),
                new Timestamp(System.currentTimeMillis()), changingStatus.toValue(),
                UUID.randomUUID()));
    }

    @Override
    public MemberMoneyJpaEntity increaseMoney(MembershipId membershipId, int increaseMoneyAmount) {
        MemberMoneyJpaEntity entity = memberMoneyRepository.findByMembershipId(
            membershipId.getMembershipId());
        if (entity == null) {
            entity = new MemberMoneyJpaEntity(membershipId.getMembershipId(), increaseMoneyAmount);
            return memberMoneyRepository.save(entity);
        }
        entity.setBalance(entity.getBalance() + increaseMoneyAmount);
        return memberMoneyRepository.save(entity);
    }
}