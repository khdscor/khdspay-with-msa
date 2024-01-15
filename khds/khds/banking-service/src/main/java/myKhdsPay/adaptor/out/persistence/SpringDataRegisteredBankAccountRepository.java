package myKhdsPay.adaptor.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataRegisteredBankAccountRepository extends
    JpaRepository<RegisteredBankAccountJpaEntity, Long> {

}
