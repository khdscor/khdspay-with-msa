package myKhdsPay.membership.adaptor.in.web;

import lombok.RequiredArgsConstructor;
import myKhdsPay.common.WebAdapter;
import myKhdsPay.membership.application.port.in.FindMembershipCommand;
import myKhdsPay.membership.application.port.in.FindMembershipUseCase;
import myKhdsPay.membership.domain.Membership;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class FindMembershipController {

    private final FindMembershipUseCase findMembershipUseCase;

    @GetMapping("/membership/find/{membershipId}")
    ResponseEntity<Membership> modifyMembershipByMemberId(@PathVariable String membershipId) {
        FindMembershipCommand command = FindMembershipCommand.builder().membershipId(membershipId).build();

        return ResponseEntity.ok(findMembershipUseCase.findMembership(command));
    }
}