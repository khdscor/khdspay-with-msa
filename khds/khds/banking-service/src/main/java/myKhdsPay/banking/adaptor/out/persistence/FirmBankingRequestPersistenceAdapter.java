package myKhdsPay.banking.adaptor.out.persistence;

import lombok.RequiredArgsConstructor;
import myKhdsPay.banking.application.port.out.RequestFirmBankingPort;
import myKhdsPay.common.PersistenceAdapter;
import myKhdsPay.banking.domain.FirmBankingRequest;

import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class FirmBankingRequestPersistenceAdapter implements RequestFirmBankingPort {

    private final SpringDataFirmBankingRequestRepository firmBankingRequestRepository;

    @Override
    public FirmBankingRequestJpaEntity createFirmBankingRequest(FirmBankingRequest.FromBankName fromBankName, FirmBankingRequest.FromBankAccountNumber fromBankAccountNumber, FirmBankingRequest.ToBankName toBankName, FirmBankingRequest.ToBankAccountNumber toBankAccountNumber, FirmBankingRequest.MoneyAmount moneyAmount, FirmBankingRequest.FirmBankingStatus firmBankingStatus) {
        return firmBankingRequestRepository.save(new FirmBankingRequestJpaEntity(
                fromBankName.getFromBankName(),
                fromBankAccountNumber.getFromBankAccountNumber(),
                toBankName.getToBankName(),
                toBankAccountNumber.getToBankAccountNumber(),
                moneyAmount.getMoneyAmount(), firmBankingStatus.getFirmBankingStatus(),
                UUID.randomUUID()));
    }

    @Override
    public FirmBankingRequestJpaEntity modifyFirmBankingRequest(FirmBankingRequestJpaEntity entity) {
        return firmBankingRequestRepository.save(entity);
    }
}