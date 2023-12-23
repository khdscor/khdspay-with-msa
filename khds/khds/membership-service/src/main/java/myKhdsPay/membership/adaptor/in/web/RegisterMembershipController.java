package myKhdsPay.membership.adaptor.in.web;

import common.WebAdapter;
import lombok.RequiredArgsConstructor;
import myKhdsPay.membership.application.port.in.RegisterMembershipCommand;
import myKhdsPay.membership.application.port.in.RegisterMembershipUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RequiredArgsConstructor
public class RegisterMembershipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;

    @PostMapping("/membership/resister")
    void registerMembership(@RequestBody RegisterMembershipRequest request) {
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
