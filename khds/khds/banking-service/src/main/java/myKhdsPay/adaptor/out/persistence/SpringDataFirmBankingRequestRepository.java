package myKhdsPay.adaptor.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataFirmBankingRequestRepository extends
    JpaRepository<FirmBankingRequestJpaEntity, Long> {

}
