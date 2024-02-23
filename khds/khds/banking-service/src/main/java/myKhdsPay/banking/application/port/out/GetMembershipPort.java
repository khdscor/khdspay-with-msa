package myKhdsPay.banking.application.port.out;

public interface GetMembershipPort {

    public MemberShipStatus getMembership(String membershipId) throws Exception;
}
