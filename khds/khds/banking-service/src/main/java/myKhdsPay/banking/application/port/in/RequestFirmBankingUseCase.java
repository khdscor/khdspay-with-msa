package myKhdsPay.banking.application.port.in;

import myKhdsPay.banking.domain.FirmBankingRequest;

public interface RequestFirmBankingUseCase {

    FirmBankingRequest requestFirmBanking(RequestFirmBankingCommand command);
}
