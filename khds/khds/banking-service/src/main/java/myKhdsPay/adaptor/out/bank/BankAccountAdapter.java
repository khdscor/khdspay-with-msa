package myKhdsPay.adaptor.out.bank;

import lombok.RequiredArgsConstructor;
import myKhdsPay.application.port.out.RequestBankAccountInfoPort;
import myKhdsPay.application.port.out.RequestExternalFirmBankingPort;
import myKhdsPay.common.ExternalSystemAdapter;


@ExternalSystemAdapter
@RequiredArgsConstructor
public class BankAccountAdapter implements RequestBankAccountInfoPort, RequestExternalFirmBankingPort {
    @Override
    public BankAccount getBankAccountInfo(GetBankAccountRequest request) {

        //실제 외부 은행 http 통해서
        //실제 은행 계좌 정보를 가져오고

        //실제 은행 계좌 -> BankAccount

        return new BankAccount(request.getBankName(), request.getBankAccountNumber(), true);
    }

    @Override
    public FirmBankingResult requestExternalFirmBanking(ExternalFirmBankingRequest request) {

        //실제로 외부 은행에 http 통신을 통해서
        //펌뱅킹 요청을 하고

        //그 결과를
        //외부 은행의 실제 결과를 -> 패캠 페이으 ㅣFirmBankingResult 작성
        FirmBankingResult result = new FirmBankingResult(1);
        return result;
    }
}