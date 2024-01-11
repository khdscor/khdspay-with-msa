package myKhdsPay.membership.adaptor.out.persistence;

import lombok.RequiredArgsConstructor;
import myKhdsPay.common.PersistenceAdapter;
import myKhdsPay.membership.application.port.out.RegisterMembershipPort;
import myKhdsPay.membership.domain.Membership;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort {

    private final SpringDataMembershipRepository membershipRepository;

    @Override
    public MembershipJpaEntity createMembership(Membership.MemberShipName membershipName,
        Membership.MembershipEmail membershipEmail,
        Membership.MembershipAddress membershipAddress,
        Membership.MembershipIsValid membershipIsValid,
        Membership.MembershipIsCorp membershipIsCorp) {

        return membershipRepository.save(new MembershipJpaEntity(membershipName.getMemberShipName(),
            membershipAddress.getMembershipAddress(),
            membershipEmail.getMembershipEmail(),
            membershipIsValid.isMembershipIsValid(),
            membershipIsCorp.isMembershipIsCorp()
        ));
    }
}
