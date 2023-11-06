package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    @DisplayName("1등과 3등 한번 당첨되었을지 수익률이 총 당첨금액/지불금액과 같다.")
    @Test
    void calculateProfitRate() {
        WinningTicketCounts winningTicketCounts = new WinningTicketCounts();
        winningTicketCounts.incrementCount(WinningRank.FIRST);
        winningTicketCounts.incrementCount(WinningRank.THIRD);
        winningTicketCounts.incrementCount(WinningRank.NO_WIN);
        PaidAmount paidAmount = new PaidAmount(3000);

        WinningStatistics winningStatistics = new WinningStatistics(winningTicketCounts, paidAmount);
        double expectedRate = (double) (WinningRank.FIRST.getPrize() + WinningRank.THIRD.getPrize()) / 3000;

        //when
        double profitRate = winningStatistics.calculateProfitRate();

        //then
        assertThat(profitRate)
                .isEqualTo(expectedRate);
    }
}