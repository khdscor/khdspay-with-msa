package myKhdsPay.membership.application.port.in;

import common.UseCase;
import myKhdsPay.membership.domain.Membership;

public interface RegisterMembershipUseCase {

    Membership registerMembership(RegisterMembershipCommand command);
}
