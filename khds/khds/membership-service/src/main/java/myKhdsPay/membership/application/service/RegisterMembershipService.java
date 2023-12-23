package myKhdsPay.membership.application.service;

import common.UseCase;
import lombok.RequiredArgsConstructor;
import myKhdsPay.membership.adaptor.out.persistence.MembershipJpaEntity;
import myKhdsPay.membership.adaptor.out.persistence.MembershipMapper;
import myKhdsPay.membership.application.port.in.RegisterMembershipCommand;
import myKhdsPay.membership.application.port.in.RegisterMembershipUseCase;
import myKhdsPay.membership.application.port.out.RegisterMembershipPort;
import myKhdsPay.membership.domain.Membership;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class RegisterMembershipService implements RegisterMembershipUseCase {

    private final RegisterMembershipPort registerMembershipPort;

    private final MembershipMapper membershipMapper;
    @Override
    public Membership registerMembership(RegisterMembershipCommand command) {

        //command -> DB, return
        MembershipJpaEntity entity = registerMembershipPort.createMembership(
            new Membership.MemberShipName(command.getName()),
            new Membership.MembershipEmail(command.getEmail()),
            new Membership.MembershipAddress(command.getAddress()),
            new Membership.MembershipIsValid(command.isValid()),
            new Membership.MembershipIsCorp(command.isValid())
        );

        return membershipMapper.mapToDomainEntity(entity);
    }
}