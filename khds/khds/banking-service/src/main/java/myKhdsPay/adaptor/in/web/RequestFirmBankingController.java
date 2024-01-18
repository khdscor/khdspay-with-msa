package myKhdsPay.adaptor.in.web;

import lombok.RequiredArgsConstructor;
import myKhdsPay.application.port.in.RequestFirmBankingUseCase;
import myKhdsPay.application.port.in.RequestFirmBankingCommand;
import myKhdsPay.common.WebAdapter;
import myKhdsPay.domain.FirmBankingRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RequestFirmBankingController {

    private final RequestFirmBankingUseCase requestFirmBankingUseCase;

    @PostMapping("/banking/firmBanking/request")
    FirmBankingRequest requestFirmBankBanking(@RequestBody RequestFirmBankingRequest request) {
        RequestFirmBankingCommand command = RequestFirmBankingCommand.builder()
                .fromBankName(request.getFromBankName())
                .fromBankAccountNumber(request.getFromBankAccountNumber())
                .toBankName(request.getToBankName())
                .toBankAccountNumber(request.getToBankAccountNumber())
                .moneyAmount(request.getMoneyAmount())
                .build();

        return requestFirmBankingUseCase.requestFirmBanking(command);
    }
}
