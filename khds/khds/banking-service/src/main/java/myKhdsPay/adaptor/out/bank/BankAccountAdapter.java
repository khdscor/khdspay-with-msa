package myKhdsPay.adaptor.out.bank;

import lombok.RequiredArgsConstructor;
import myKhdsPay.application.port.out.RequestBankAccountInfoPort;
import myKhdsPay.common.ExternalSystemAdapter;


@ExternalSystemAdapter
@RequiredArgsConstructor
public class BankAccountAdapter implements RequestBankAccountInfoPort {
    @Override
    public BankAccount getBankAccountInfo(GetBankAccountRequest request) {

        //실제 외부 은행 http 통해서
        //실제 은행 계좌 정보를 가져오고

        //실제 은행 계좌 -> BankAccount

        return new BankAccount(request.getBankName(), request.getBankAccountNumber(), true);
    }
}