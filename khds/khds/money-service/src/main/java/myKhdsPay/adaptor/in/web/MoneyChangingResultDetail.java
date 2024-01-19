package myKhdsPay.adaptor.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyChangingResultDetail {

    private String moneyChangingRequestId;

    //증액, 감액
    private MoneyChangingType moneyChangingType;

    private MoneyChangingStatus moneyChangingStatus;

    private int amount;
}

enum MoneyChangingType {
    INCREASE, DECREASE
}

enum MoneyChangingStatus {
    SUCCEEDED, FAILED, FAILED_NOT_ENOUGH_MONEY, FAILED_NOT_EXIST_MEMBERSHIP
}