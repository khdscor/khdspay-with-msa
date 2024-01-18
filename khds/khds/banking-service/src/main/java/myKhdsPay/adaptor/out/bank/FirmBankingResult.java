package myKhdsPay.adaptor.out.bank;

import lombok.Data;

@Data
public class FirmBankingResult {

    private int result; // 1: 성공, 0: 실패

    public FirmBankingResult(int result) {
        this.result = result;
    }
}
