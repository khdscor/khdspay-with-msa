package myKhdsPay.money.adaptor.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyChangingResultDetail {

    private String moneyChangingRequestId;

    //증액, 감액
    private MoneyChangingType moneyChangingType;

    private MoneyChangingStatus moneyChangingStatus;

    private int amount;

    public MoneyChangingResultDetail(String moneyChangingRequestId, int moneyChangingType, int moneyChangingStatus, int amount) {
        this.moneyChangingRequestId = moneyChangingRequestId;
        this.moneyChangingType = MoneyChangingType.from(moneyChangingType);
        this.moneyChangingStatus = MoneyChangingStatus.from(moneyChangingStatus);
        this.amount = amount;
    }
}

enum MoneyChangingType {
    INCREASE(1), DECREASE(0);

    final int moneyChangingType;


    MoneyChangingType(int moneyChangingType) {
        this.moneyChangingType = moneyChangingType;
    }

    public static MoneyChangingType from(int input) {
        return Arrays.stream(values()).filter(value -> value.moneyChangingType == input)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("예외 발생"));
    }
}

enum MoneyChangingStatus {
    SUCCEEDED(1), FAILED(2), FAILED_NOT_ENOUGH_MONEY(3), FAILED_NOT_EXIST_MEMBERSHIP(4);

    final int moneyChangingStatus;

    MoneyChangingStatus(int moneyChangingStatus) {
        this.moneyChangingStatus = moneyChangingStatus;
    }

    public static MoneyChangingStatus from(int input) {
        return Arrays.stream(values()).filter(value -> value.moneyChangingStatus == input)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("예외 발생"));
    }
}