package myKhdsPay.banking.application.port.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberShipStatus {

    private String membershipId;
    private boolean isValid;
}