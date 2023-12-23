package myKhdsPay.membership.adaptor.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMembershipRepository extends JpaRepository<MembershipJpaEntity, Long> {

}
