package myKhdsPay.money.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE) // 객체 내부에서만 접근할 수 있다.
public class MemberMoney {

    @Getter
    private final String memberMoneyId;

    @Getter
    private final String membershipId;

    // 잔액
    @Getter
    private final int balance;

    public static MemberMoney generateMemberMoney(
        MemberMoneyId memberMoneyId,
        MembershipId membershipId,
        Balance balance) {
        return new MemberMoney(
            memberMoneyId.getMemberMoneyId(),
            membershipId.getMembershipId(),
            balance.getBalance()
        );
    }

    @Value
    public static class MemberMoneyId {
        public MemberMoneyId(String value) {
            this.memberMoneyId = value;
        }

        String memberMoneyId;
    }

    @Value
    public static class MembershipId {
        public MembershipId(String value) {
            this.membershipId = value;
        }
        String membershipId;
    }

    @Value
    public static class Balance {
        public Balance(int value) {
            this.balance = value;
        }
        int balance;
    }
}