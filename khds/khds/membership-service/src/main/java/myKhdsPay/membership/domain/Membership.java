package myKhdsPay.membership.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE) // 객체 내부에서만 접근할 수 있다.
public class Membership {

    @Getter
    private final String membershipId;

    @Getter
    private final String name;

    @Getter
    private final String email;

    @Getter
    private final String address;

    //고객이 유효한지
    @Getter
    private final boolean isValid;

    //고객이 법인이 아닌지
    @Getter
    private final boolean isCorp;

    //member를 정의할 때
    // getter, setter, @Data 등을 생성 할 수 있지만
    //PRIVATE를 통해 내부에서만 접근하도록 할 수 있다.
    // 그 이유는 오염이 되면 안되는 클래스 이기에, 고객 정보이며 핵심 도메인이다.
    //이러면 새롭게 클래스 생성이 어려워져

    // 위 Membership 클래스에 접근은 불가능하나
    // MembershipId라는 static 클래스를 사용해서
    // membershipId를 지정할 수 있다.

    public static Membership  generateMember(
        MembershipId membershipId,
        MemberShipName memberShipName,
        MembershipEmail membershipEmail,
        MembershipAddress membershipAddress,
        MembershipIsValid membershipIsValid,
        MembershipIsCorp membershipIsCorp) {

        return new Membership(
            membershipId.membershipId,
            memberShipName.memberShipName,
            membershipEmail.membershipEmail,
            membershipAddress.membershipAddress,
            membershipIsValid.membershipIsValid,
            membershipIsCorp.membershipIsCorp);
    }

    @Value
    public static class MembershipId {

        public MembershipId(String value) {
            this.membershipId = value;
        }
        String membershipId;
    }

    @Value
    public static class MemberShipName {

        public MemberShipName(String value) {
            this.memberShipName = value;
        }
        String memberShipName;
    }

    @Value
    public static class MembershipEmail {

        public MembershipEmail(String value) {
            this.membershipEmail = value;
        }
        String membershipEmail;
    }

    @Value
    public static class MembershipAddress {

        public MembershipAddress(String value) {
            this.membershipAddress = value;
        }
        String membershipAddress;
    }

    @Value
    public static class MembershipIsValid {
        public MembershipIsValid(boolean value) {
            this.membershipIsValid = value;
        }
        boolean membershipIsValid;
    }

    @Value
    public static class MembershipIsCorp {

        public MembershipIsCorp(boolean value) {
            this.membershipIsCorp = value;
        }
        boolean membershipIsCorp;
    }
}