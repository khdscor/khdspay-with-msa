package myKhdsPay.adaptor.out.persistence;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMemberMoneyRepository extends JpaRepository<MemberMoneyJpaEntity, Long> {

    MemberMoneyJpaEntity findByMembershipId(String membershipId);
}
