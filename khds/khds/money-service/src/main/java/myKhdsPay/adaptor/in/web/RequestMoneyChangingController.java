package myKhdsPay.adaptor.in.web;

import lombok.RequiredArgsConstructor;
import myKhdsPay.application.port.in.IncreaseMoneyRequestCommand;
import myKhdsPay.application.port.in.IncreaseMoneyRequestUseCase;
import myKhdsPay.common.WebAdapter;
import myKhdsPay.domain.MoneyChangingRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RequestMoneyChangingController {

    private final IncreaseMoneyRequestUseCase registerMembershipUseCase;

    @PostMapping("/money/increase")
    MoneyChangingResultDetail increaseMoneyChangingRequest(@RequestBody IncreaseMoneyChangingRequest request) {

        IncreaseMoneyRequestCommand command = IncreaseMoneyRequestCommand.builder()
                .targetMembershipId(request.getTargetMembershipId())
                .amount(request.getAmount()).build();

        MoneyChangingRequest moneyChangingRequest = registerMembershipUseCase.registerMembership(command);

        return new MoneyChangingResultDetail(
                moneyChangingRequest.getTargetMembershipId(),
                moneyChangingRequest.changingMoneyTypeToValue(),
                moneyChangingRequest.changingMoneyStatusToValue(),
                moneyChangingRequest.getChangingMoneyAmount()
        );
    }
}