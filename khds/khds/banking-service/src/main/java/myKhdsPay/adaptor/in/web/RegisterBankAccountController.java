package myKhdsPay.adaptor.in.web;

import lombok.RequiredArgsConstructor;
import myKhdsPay.application.port.in.RegisterBankAccountCommand;
import myKhdsPay.application.port.in.RegisterBankAccountUseCase;
import myKhdsPay.common.WebAdapter;
import myKhdsPay.domain.RegisteredBankAccount;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterBankAccountController {

    private final RegisterBankAccountUseCase registerBankAccountUseCase;

    @PostMapping("/bankAccount/resister")
    RegisteredBankAccount registerBankAccount(@RequestBody RegisterBankAccountRequest request) {
        RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
                .membershipId(request.getMembershipId())
                .bankName(request.getBankName())
                .bankAccountNumber(request.getBankAccountNumber())
                .isValid(request.isValid())
                .build();

        RegisteredBankAccount registeredBankAccount = registerBankAccountUseCase.registerBankAccount(command);
        if(registeredBankAccount == null){
            //TOdo: error handling
            return null;
        }
        return registeredBankAccount;
    }
}
