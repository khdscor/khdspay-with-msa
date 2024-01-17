package myKhdsPay.application.port.out;

import myKhdsPay.adaptor.out.persistence.FirmBankingRequestJpaEntity;
import myKhdsPay.domain.FirmBankingRequest;

public interface RequestFirmBankingPort {

    FirmBankingRequestJpaEntity createFirmBankingRequest(
           FirmBankingRequest.FromBankName fromBankName,
           FirmBankingRequest.FromBankAccountNumber fromBankAccountNumber,
           FirmBankingRequest.ToBankName toBankName,
           FirmBankingRequest.ToBankAccountNumber toBankAccountNumber,
           FirmBankingRequest.MoneyAmount moneyAmount,
           FirmBankingRequest.FirmBankingStatus firmBankingStatus
    );

    FirmBankingRequestJpaEntity modifyFirmBankingRequest(
            FirmBankingRequestJpaEntity entity
    );
}