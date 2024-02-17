package myKhdsPay.money.application.port.in;

import myKhdsPay.money.domain.MoneyChangingRequest;

public interface IncreaseMoneyRequestUseCase {

    MoneyChangingRequest registerMembership(IncreaseMoneyRequestCommand command);
}
