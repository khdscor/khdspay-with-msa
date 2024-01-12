package myKhdsPay.membership.application.port.in;

import myKhdsPay.membership.domain.Membership;

public interface FindMembershipUseCase {

    Membership findMembership(FindMembershipCommand command);
}