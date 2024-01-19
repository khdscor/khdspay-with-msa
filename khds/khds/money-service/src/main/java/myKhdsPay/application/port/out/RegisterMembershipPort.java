package myKhdsPay.application.port.out;

import myKhdsPay.membership.adaptor.out.persistence.MembershipJpaEntity;
import myKhdsPay.membership.domain.Membership;

public interface RegisterMembershipPort {

    MembershipJpaEntity createMembership(
        Membership.MemberShipName membershipName,
        Membership.MembershipEmail membershipEmail,
        Membership.MembershipAddress membershipAddress,
        Membership.MembershipIsValid membershipIsValid,
        Membership.MembershipIsCorp membershipIsCorp);
}
