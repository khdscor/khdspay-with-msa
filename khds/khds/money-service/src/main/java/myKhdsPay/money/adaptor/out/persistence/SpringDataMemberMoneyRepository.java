package myKhdsPay.money.adaptor.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMemberMoneyRepository extends JpaRepository<MemberMoneyJpaEntity, Long> {

    MemberMoneyJpaEntity findByMembershipId(String membershipId);
}
