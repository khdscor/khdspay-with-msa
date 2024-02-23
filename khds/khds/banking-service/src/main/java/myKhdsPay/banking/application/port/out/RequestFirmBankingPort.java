package myKhdsPay.banking.application.port.out;

import myKhdsPay.banking.adaptor.out.persistence.FirmBankingRequestJpaEntity;
import myKhdsPay.banking.domain.FirmBankingRequest.FirmBankingStatus;
import myKhdsPay.banking.domain.FirmBankingRequest.FromBankAccountNumber;
import myKhdsPay.banking.domain.FirmBankingRequest.FromBankName;
import myKhdsPay.banking.domain.FirmBankingRequest.MoneyAmount;
import myKhdsPay.banking.domain.FirmBankingRequest.ToBankAccountNumber;
import myKhdsPay.banking.domain.FirmBankingRequest.ToBankName;

public interface RequestFirmBankingPort {

    FirmBankingRequestJpaEntity createFirmBankingRequest(
           FromBankName fromBankName,
           FromBankAccountNumber fromBankAccountNumber,
           ToBankName toBankName,
           ToBankAccountNumber toBankAccountNumber,
           MoneyAmount moneyAmount,
           FirmBankingStatus firmBankingStatus
    );

    FirmBankingRequestJpaEntity modifyFirmBankingRequest(
            FirmBankingRequestJpaEntity entity
    );
}