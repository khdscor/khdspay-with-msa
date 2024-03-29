package myKhdsPay.banking.adaptor.in.web;

import lombok.RequiredArgsConstructor;
import myKhdsPay.banking.application.port.in.RegisterBankAccountCommand;
import myKhdsPay.banking.application.port.in.RegisterBankAccountUseCase;
import myKhdsPay.common.WebAdapter;
import myKhdsPay.banking.domain.RegisteredBankAccount;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterBankAccountController {

    private final RegisterBankAccountUseCase registerBankAccountUseCase;

    @PostMapping("/bankAccount/resister")
    RegisteredBankAccount registerBankAccount(@RequestBody RegisterBankAccountRequest request)
        throws Exception {
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
