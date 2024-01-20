package myKhdsPay.application.port.in;

import myKhdsPay.domain.MoneyChangingRequest;


public interface IncreaseMoneyRequestUseCase {

    MoneyChangingRequest registerMembership(IncreaseMoneyRequestCommand command);
}
