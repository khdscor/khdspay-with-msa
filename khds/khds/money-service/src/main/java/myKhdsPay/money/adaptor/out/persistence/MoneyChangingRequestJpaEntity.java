package myKhdsPay.money.adaptor.out.persistence;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "money_changing_request")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyChangingRequestJpaEntity {

    @Id
    @GeneratedValue
    private Long moneyChangingRequestId;

    private String targetMembershipId;

    private int changingType; // 0 증액 1 감액

    private int changingMoneyAmount;

    private Timestamp timestamp;

    private int changingStatus; // 0 요청 1 성공 2 실패 3 취소

    private UUID uuid;

    public MoneyChangingRequestJpaEntity(String targetMembershipId, int changingType, int changingMoneyAmount, Timestamp timestamp, int changingStatus, UUID uuid) {
        this.targetMembershipId = targetMembershipId;
        this.changingType = changingType;
        this.changingMoneyAmount = changingMoneyAmount;
        this.timestamp = timestamp;
        this.changingStatus = changingStatus;
        this.uuid = uuid;
    }
}