package myKhdsPay.banking.application.service;

import lombok.RequiredArgsConstructor;
import myKhdsPay.banking.adaptor.out.bank.ExternalFirmBankingRequest;
import myKhdsPay.banking.adaptor.out.bank.FirmBankingResult;
import myKhdsPay.banking.adaptor.out.persistence.FirmBankingRequestJpaEntity;
import myKhdsPay.banking.adaptor.out.persistence.RequestFirmBankingMapper;
import myKhdsPay.banking.application.port.in.RequestFirmBankingCommand;
import myKhdsPay.banking.application.port.in.RequestFirmBankingUseCase;
import myKhdsPay.banking.application.port.out.RequestExternalFirmBankingPort;
import myKhdsPay.banking.application.port.out.RequestFirmBankingPort;
import myKhdsPay.common.UseCase;
import myKhdsPay.banking.domain.FirmBankingRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@UseCase
@Transactional
@RequiredArgsConstructor
public class RequestFirmBankingService implements RequestFirmBankingUseCase {

    private final RequestFirmBankingMapper requestFirmBankingMapper;

    private final RequestFirmBankingPort requestFirmBankingPort;

    private final RequestExternalFirmBankingPort requestExternalFirmBankingPort;

    @Override
    public FirmBankingRequest requestFirmBanking(RequestFirmBankingCommand command) {
        //Business logic
        // a -> b 계좌
        FirmBankingRequestJpaEntity requestJpaEntity = requestFirmBankingPort.createFirmBankingRequest(
                new FirmBankingRequest.FromBankName(command.getFromBankName()),
                new FirmBankingRequest.FromBankAccountNumber(command.getFromBankAccountNumber()),
                new FirmBankingRequest.ToBankName(command.getToBankName()),
                new FirmBankingRequest.ToBankAccountNumber(command.getToBankAccountNumber()),
                new FirmBankingRequest.MoneyAmount(command.getMoneyAmount()),
                new FirmBankingRequest.FirmBankingStatus(0));
        //1. 요청에 대해 정보를 먼저 write. "요청" 상태로


        //2. 외부 은행에 펌뱅킹 요청
        FirmBankingResult result = requestExternalFirmBankingPort.requestExternalFirmBanking(
                new ExternalFirmBankingRequest(
                        command.getFromBankName(),
                        command.getFromBankAccountNumber(),
                        command.getToBankName(),
                        command.getToBankAccountNumber()
                )
        );

        UUID randomUUID = UUID.randomUUID();
        requestJpaEntity.setUuid(randomUUID.toString());

        //3. 결과에  따라서 1번에서 작성헀던 Firm Banking Request의 정보를 update
        if (result.getResult() == 1) {
            //성공
            requestJpaEntity.setFirmBankingStatus(1);
        } else {
            requestJpaEntity.setFirmBankingStatus(2);
        }
        //4. 결과를 리턴


        return requestFirmBankingMapper.mapToDomainEntity(requestFirmBankingPort.modifyFirmBankingRequest(requestJpaEntity), randomUUID);
    }
}