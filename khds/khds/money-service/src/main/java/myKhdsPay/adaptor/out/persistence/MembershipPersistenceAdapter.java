package myKhdsPay.adaptor.out.persistence;

import lombok.RequiredArgsConstructor;
import myKhdsPay.common.PersistenceAdapter;
import myKhdsPay.membership.application.port.out.FindMembershipPort;
import myKhdsPay.membership.application.port.out.ModifyMembershipPort;
import myKhdsPay.membership.application.port.out.RegisterMembershipPort;
import myKhdsPay.membership.domain.Membership;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, ModifyMembershipPort, FindMembershipPort {

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

    @Override
    public MembershipJpaEntity modifyMembership(Membership.MembershipId membershipId,
        Membership.MemberShipName membershipName,
        Membership.MembershipEmail membershipEmail,
        Membership.MembershipAddress membershipAddress,
        Membership.MembershipIsValid membershipIsValid,
        Membership.MembershipIsCorp membershipIsCorp) {
        MembershipJpaEntity entity = membershipRepository.findById(Long.parseLong(membershipId.getMembershipId()))
                .orElseThrow(()-> new IllegalArgumentException("해당하는 회원이 존재하지 않습니다."));
        entity.setName(membershipName.getMemberShipName());
        entity.setEmail(membershipEmail.getMembershipEmail());
        entity.setAddress(membershipAddress.getMembershipAddress());
        entity.setValid(membershipIsValid.isMembershipIsValid());
        entity.setCorp(membershipIsCorp.isMembershipIsCorp());
        return membershipRepository.save(entity);
    }

    @Override
    public MembershipJpaEntity findMembership(Membership.MembershipId membershipId) {
        return membershipRepository.findById(Long.parseLong(membershipId.getMembershipId()))
                .orElseThrow(()-> new IllegalArgumentException("해당하는 회원이 존재하지 않습니다."));
    }
}