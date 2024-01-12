package myKhdsPay.membership.application.service;

import lombok.RequiredArgsConstructor;
import myKhdsPay.common.UseCase;
import myKhdsPay.membership.adaptor.out.persistence.MembershipJpaEntity;
import myKhdsPay.membership.adaptor.out.persistence.MembershipMapper;
import myKhdsPay.membership.application.port.in.ModifyMembershipCommand;
import myKhdsPay.membership.application.port.in.ModifyMembershipUseCase;
import myKhdsPay.membership.application.port.out.ModifyMembershipPort;
import myKhdsPay.membership.domain.Membership;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class ModifyMembershipService implements ModifyMembershipUseCase {

    private final ModifyMembershipPort modifyMembershipPort;

    private final MembershipMapper membershipMapper;
    @Override
    public Membership modifyMembership(ModifyMembershipCommand command) {

        //command -> DB, return
        MembershipJpaEntity entity = modifyMembershipPort.modifyMembership(
            new Membership.MembershipId(command.getMembershipId()),
            new Membership.MemberShipName(command.getName()),
            new Membership.MembershipEmail(command.getEmail()),
            new Membership.MembershipAddress(command.getAddress()),
            new Membership.MembershipIsValid(command.isValid()),
            new Membership.MembershipIsCorp(command.isCorp())
        );

        return membershipMapper.mapToDomainEntity(entity);
    }
}