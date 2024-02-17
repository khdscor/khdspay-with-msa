package myKhdsPay.banking.application.port.out;

import myKhdsPay.banking.adaptor.out.bank.ExternalFirmBankingRequest;
import myKhdsPay.banking.adaptor.out.bank.FirmBankingResult;

public interface RequestExternalFirmBankingPort {
    FirmBankingResult requestExternalFirmBanking(ExternalFirmBankingRequest request);
}
