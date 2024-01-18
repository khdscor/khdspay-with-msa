package myKhdsPay.application.port.out;

import myKhdsPay.adaptor.out.bank.ExternalFirmBankingRequest;
import myKhdsPay.adaptor.out.bank.FirmBankingResult;

public interface RequestExternalFirmBankingPort {
    FirmBankingResult requestExternalFirmBanking(ExternalFirmBankingRequest request);
}
