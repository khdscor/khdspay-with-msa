package myKhdsPay.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE) // 객체 내부에서만 접근할 수 있다.
public class RegisteredBankAccount {

    private final String registeredBankAccountId;

    private final String membershipId;

    private final String bankName;

    private final String bankAccountNumber;

    private final boolean linkStatusIsValid;

    public static RegisteredBankAccount generateRegisteredBankAccount(
        RegisteredBankAccountId registeredBankAccountId,
        MembershipId membershipId,
        BankName bankName,
        BankAccountNumber bankAccountNumber,
        LinkStatusIsValid linkStatusIsValid) {

        return new RegisteredBankAccount(
            registeredBankAccountId.registeredBankAccountId,
            membershipId.membershipId,
            bankName.bankName,
            bankAccountNumber.bankAccountNumber,
            linkStatusIsValid.linkStatusIsValid);
    }

    @Value
    public static class RegisteredBankAccountId {

        public RegisteredBankAccountId(String value) {
            this.registeredBankAccountId = value;
        }

        String registeredBankAccountId;
    }

    @Value
    public static class MembershipId {

        public MembershipId(String value) {
            this.membershipId = value;
        }

        String membershipId;
    }

    @Value
    public static class BankName {

        public BankName(String value) {
            this.bankName = value;
        }

        String bankName;
    }

    @Value
    public static class BankAccountNumber {

        public BankAccountNumber(String value) {
            this.bankAccountNumber = value;
        }

        String bankAccountNumber;
    }

    @Value
    public static class LinkStatusIsValid {

        public LinkStatusIsValid(boolean value) {
            this.linkStatusIsValid = value;
        }

        boolean linkStatusIsValid;
    }
}