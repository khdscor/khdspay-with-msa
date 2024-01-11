package myKhdsPay.membership.application.port.in;

import myKhdsPay.membership.domain.Membership;

public interface ModifyMembershipUseCase {

    Membership modifyMembership(ModifyMembershipCommand command);
}
