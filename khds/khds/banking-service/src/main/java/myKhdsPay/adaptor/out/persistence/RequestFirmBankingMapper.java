package myKhdsPay.adaptor.out.persistence;

import myKhdsPay.domain.FirmBankingRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RequestFirmBankingMapper {

    public FirmBankingRequest mapToDomainEntity(FirmBankingRequestJpaEntity firmBankingRequestJpaEntity, UUID uuid) {
        return FirmBankingRequest.generateFirmBankingRequest(
                new FirmBankingRequest.FirmBankingRequestId(
                        firmBankingRequestJpaEntity.getFirmBankingRequestId() + ""),
                new FirmBankingRequest.FromBankName(firmBankingRequestJpaEntity.getFromBankName()),
                new FirmBankingRequest.FromBankAccountNumber(
                        firmBankingRequestJpaEntity.getFromBankAccountNumber()),
                new FirmBankingRequest.ToBankName(firmBankingRequestJpaEntity.getToBankName()),
                new FirmBankingRequest.ToBankAccountNumber(
                        firmBankingRequestJpaEntity.getToBankAccountNumber()),
                new FirmBankingRequest.MoneyAmount(firmBankingRequestJpaEntity.getMoneyAmount()),
                new FirmBankingRequest.FirmBankingStatus(firmBankingRequestJpaEntity.getFirmBankingStatus()),
                uuid);
    }
}