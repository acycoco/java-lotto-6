package lotto.domain.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @DisplayName("번호가 로또 숫자 범위(1~45)를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void createNumberByNotInRangeNumber(int number) {
        assertThatThrownBy(() -> LottoNumber.from(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("번호가 로또 숫자 범위(1~45)에 맞는 숫자를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 13, 45})
    void createNumberInRangeNumber(int number) {
        LottoNumber lottoNumber = LottoNumber.from(number);

        assertThat(lottoNumber.getNumber())
                .isEqualTo(number);
    }

    @DisplayName("번호가 로또 숫자 범위(1~45)를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 13, 45})
    void testEquals(int number) {
        LottoNumber lottoNumber1 = LottoNumber.from(number);
        LottoNumber lottoNumber2 = LottoNumber.from(number);

        assertThat(lottoNumber1)
                .isEqualTo(lottoNumber2);
    }
}