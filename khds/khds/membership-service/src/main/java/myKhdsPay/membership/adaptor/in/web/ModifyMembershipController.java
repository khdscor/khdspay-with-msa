package myKhdsPay.membership.adaptor.in.web;

import lombok.RequiredArgsConstructor;
import myKhdsPay.common.WebAdapter;
import myKhdsPay.membership.application.port.in.ModifyMembershipCommand;
import myKhdsPay.membership.application.port.in.ModifyMembershipUseCase;
import myKhdsPay.membership.domain.Membership;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class ModifyMembershipController {

    private final ModifyMembershipUseCase modifyMembershipUseCase;

    @PostMapping("/membership/modify")
    ResponseEntity<Membership> modifyMembershipByMemberId(@RequestBody ModifyMembershipRequest request) {
        ModifyMembershipCommand command = ModifyMembershipCommand.builder()
                .membershipId(request.getMembershipId())
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .isValid(true)
                .isCorp(request.isCorp())
                .build();

        return ResponseEntity.ok(modifyMembershipUseCase.modifyMembership(command));
    }
}