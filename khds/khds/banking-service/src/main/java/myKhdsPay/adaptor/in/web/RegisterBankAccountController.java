package myKhdsPay.adaptor.in.web;

import lombok.RequiredArgsConstructor;
import myKhdsPay.common.WebAdapter;
import myKhdsPay.membership.application.port.in.RegisterMembershipCommand;
import myKhdsPay.membership.application.port.in.RegisterMembershipUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterBankAccountController {

    private final RegisterMembershipUseCase registerMembershipUseCase;

    @PostMapping("/membership/resister")
    void registerMembership(@RequestBody RegisterBankAccountRequest request) {
        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
            .name(request.getName())
            .address(request.getAddress())
            .email(request.getEmail())
            .isValid(true)
            .isCorp(request.isCorp())
            .build();

        registerMembershipUseCase.registerMembership(command);
    }
}
