package myKhdsPay.membership.application.service;

import lombok.RequiredArgsConstructor;
import myKhdsPay.common.UseCase;
import myKhdsPay.membership.adaptor.out.persistence.MembershipJpaEntity;
import myKhdsPay.membership.adaptor.out.persistence.MembershipMapper;
import myKhdsPay.membership.application.port.in.FindMembershipCommand;
import myKhdsPay.membership.application.port.in.FindMembershipUseCase;
import myKhdsPay.membership.application.port.out.FindMembershipPort;
import myKhdsPay.membership.domain.Membership;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class FindMembershipService implements FindMembershipUseCase {

    private final FindMembershipPort findMembershipPort;

    private final MembershipMapper membershipMapper;

    @Override
    public Membership findMembership(FindMembershipCommand command) {
        MembershipJpaEntity entity = findMembershipPort.findMembership(new Membership.MembershipId(command.getMembershipId()));
        return membershipMapper.mapToDomainEntity(entity);
    }
}