package myKhdsPay.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE) // 객체 내부에서만 접근할 수 있다.
public class MoneyChangingRequest {

    @Getter
    private final String moneyChangingRequestId;

    //어떤 고객의 증액/감액 요청을 요청했는지 멤버 정보
    @Getter
    private final String targetMembershipId;

    // 그 요청이 증액 요청인지 감액 요청인지
    @Getter
    private final ChangingType changingType; // enum: 0: 증액, 1: 감액

    enum ChangingType {
        INCREASE, DECREASE
    }

    // 증액 또는 감액 요청 금액
    @Getter
    private final int changingMoneyAmount;

    // 머니 변경 요청 상태
    @Getter
    private final ChangingMoneyStatus changingStatus; // enum: 0: 요청, 1: 승인, 2: 거절

    enum ChangingMoneyStatus {
        REQUESTED, SUCCEEDED, FAILED,  CANCELLED
    }

    @Getter
    private final String uuid;

    @Getter
    private final Date createdAt;

    public static MoneyChangingRequest generateMoneyChangingRequest(
            MoneyChangingRequestId moneyChangingRequestId,
            TargetMembershipId targetMembershipId,
            MoneyChangingType changingType,
            ChangingMoneyAmount changingMoneyAmount,
            ChangingStatus changingStatus,
            Uuid uuid) {

        return new MoneyChangingRequest(
                moneyChangingRequestId.moneyChangingRequestId,
                targetMembershipId.targetMembershipId,
                changingType.changingType,
                Integer.parseInt(changingMoneyAmount.changingMoneyAmount),
                changingStatus.changingStatus,
                uuid.getUuid(),
                new Date()
            );
    }

    @Value
    public static class MoneyChangingRequestId {

        public MoneyChangingRequestId(String value) {
            this.moneyChangingRequestId = value;
        }
        String moneyChangingRequestId;
    }

    @Value
    public static class TargetMembershipId {

        public TargetMembershipId(String value) {
            this.targetMembershipId = value;
        }
        String targetMembershipId;
    }

    @Value
    public static class MoneyChangingType {

        public MoneyChangingType(ChangingType value) {
            this.changingType = value;
        }
        ChangingType changingType;
    }

    @Value
    public static class ChangingMoneyAmount {

        public ChangingMoneyAmount(String value) {
            this.changingMoneyAmount = value;
        }
        String changingMoneyAmount;
    }

    @Value
    public static class ChangingStatus {

        public ChangingStatus(ChangingMoneyStatus value) {
            this.changingStatus = value;
        }
        ChangingMoneyStatus changingStatus;
    }

    @Value
    public static class Uuid {

        public Uuid(UUID uuid) {
            this.uuid = uuid.toString();
        }
        String uuid;
    }

    @Value
    public static class CreatedAt {

        public CreatedAt(String value) {
            this.createdAt = value;
        }
        String createdAt;
    }
}