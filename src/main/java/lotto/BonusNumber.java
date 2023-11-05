package lotto;

import lotto.constants.LottoConfig;

public class BonusNumber {

    private final Integer number;

    public BonusNumber(final Integer number) {
        validate(number);
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    private void validate(final Integer number) {
        if (isNotInRange(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotInRange(final Integer number) {
        return number < LottoConfig.LOTTO_NUMBER_MIN || number > LottoConfig.LOTTO_NUMBER_MAX;
    }
}
