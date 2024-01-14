package myKhdsPay.adaptor.out.persistence;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "registered_bank_account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredBankAccountJpaEntity {

    @Id
    @GeneratedValue
    private Long registeredBankAccountId;

    private String membershipId;

    private String bankName;

    private String bankAccountNumber;

    private boolean linkStatusIsValid;

    public RegisteredBankAccountJpaEntity(String membershipId,
        String bankName, String bankAccountNumber, boolean linkStatusIsValid) {
        this.membershipId = membershipId;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.linkStatusIsValid = linkStatusIsValid;
    }

    @Override
    public String toString() {
        return "RegisteredBankAccountJpaEntity{" +
            "registeredBankAccountId=" + registeredBankAccountId +
            ", membershipId='" + membershipId + '\'' +
            ", bankName='" + bankName + '\'' +
            ", bankAccountNumber='" + bankAccountNumber + '\'' +
            ", linkStatusIsValid=" + linkStatusIsValid +
            '}';
    }
}