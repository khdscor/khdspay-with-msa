package myKhdsPay.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.util.UUID;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE) // 객체 내부에서만 접근할 수 있다.
public class FirmBankingRequest {

    private final String firmBankingRequestId;

    private final String fromBankName;

    private final String fromBankAccountNumber;

    private final String toBankName;

    private final String toBankAccountNumber;

    private final int moneyAmount;

    private final int firmBankingStatus; //:0: 요청, 1: 완료 2: 실패

    private final UUID uuid;

    public static FirmBankingRequest generateFirmBankingRequest(
            FirmBankingRequestId firmBankingRequestId,
            FromBankName fromBankName,
            FromBankAccountNumber fromBankAccountNumber,
            ToBankName toBankName,
            ToBankAccountNumber toBankAccountNumber,
            MoneyAmount moneyAmount,
            FirmBankingStatus firmBankingStatus,
            UUID uuid) {

        return new FirmBankingRequest(
                firmBankingRequestId.getFirmBankingRequestId(),
                fromBankName.getFromBankName(),
                fromBankAccountNumber.getFromBankAccountNumber(),
                toBankName.getToBankName(),
                toBankAccountNumber.getToBankAccountNumber(),
                moneyAmount.getMoneyAmount(),
                firmBankingStatus.getFirmBankingStatus(),
                uuid);
    }

    @Value
    public static class FirmBankingRequestId {

        public FirmBankingRequestId(String value) {
            this.firmBankingRequestId = value;
        }

        String firmBankingRequestId;
    }

    @Value
    public static class FromBankName {

        public FromBankName(String value) {
            this.fromBankName = value;
        }

        String fromBankName;
    }

    @Value
    public static class FromBankAccountNumber {

        public FromBankAccountNumber(String value) {
            this.fromBankAccountNumber = value;
        }

        String fromBankAccountNumber;
    }

    @Value
    public static class ToBankName {

        public ToBankName(String value) {
            this.toBankName = value;
        }

        String toBankName;
    }

    @Value
    public static class ToBankAccountNumber {

        public ToBankAccountNumber(String value) {
            this.toBankAccountNumber = value;
        }

        String toBankAccountNumber;
    }

    @Value
    public static class MoneyAmount {

        public MoneyAmount(int value) {
            this.moneyAmount = value;
        }

        int moneyAmount;
    }

    @Value
    public static class FirmBankingStatus {

        public FirmBankingStatus(int value) {
            this.firmBankingStatus = value;
        }

        int firmBankingStatus;
    }
}