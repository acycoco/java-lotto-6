package lotto.view;

import lotto.LottoTicketsDto;
import lotto.WinningCountsDto;

import java.util.Collections;
import java.util.List;

public class OutputView {

    private static final String TOTAL_TICKETS_MESSAGE = "를 구매했습니다.";
    private static final String NEW_LINE = "\n";
    private static final String WINNING_COUNTS_FORMAT = "%d개 일치 (%,d원) - %d개" + NEW_LINE;

    public void print(String message) {
        System.out.println(message);
    }

    public void printIssuedLottoTickets(LottoTicketsDto lottoTicketsDto) {
        StringBuilder issued = new StringBuilder();
        appendTotalTickets(issued, lottoTicketsDto.getTotalTickets());
        appendLottoTickets(issued, lottoTicketsDto.getLottos());
        print(issued.toString());
    }

    public void printWinningCounts(List<WinningCountsDto> winningCountsDtos) {
        StringBuilder line = new StringBuilder();
        winningCountsDtos.forEach(winningCountsDto -> {
            line.append(String.format(WINNING_COUNTS_FORMAT,
                    winningCountsDto.getCountOfMatchingNumbers(),
                    winningCountsDto.getPrize(),
                    winningCountsDto.getWinningCount()));
        });
        print(line.toString());
    }

    private void appendTotalTickets(StringBuilder issued, Integer totalTickets) {
        issued.append(totalTickets)
                .append(TOTAL_TICKETS_MESSAGE);
    }

    private void appendLottoTickets(StringBuilder issued, List<List<Integer>> lottoTickets) {
        lottoTickets.forEach(ticket -> {
            Collections.sort(ticket);
            issued.append(ticket);
            issued.append(NEW_LINE);
        });
    }

}
