package lotto;

public enum LottoMatch {
    THREE_MATCH(3, false, 5_000),
    FOUR_MATCH(4, false, 50_000),
    FIVE_MATCH(5, false, 1_500_000),
    FIVE_MATCH_BONUS(5, true, 30_000_000),
    SIX_MATCH(6, false, 2_000_000_000);

    private final int matchNumber;
    private final boolean hasBonus;
    private final long prize;

    LottoMatch(int matchNumber, boolean includeBonus, long prize) {
        this.matchNumber = matchNumber;
        this.prize = prize;
        this.hasBonus = includeBonus;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public boolean HasBonus() {
        return hasBonus;
    }

    public long getPrize() {
        return prize;
    }

    public static LottoMatch getRank(int matchNumber, boolean hasBonus) {
        if (matchNumber == SIX_MATCH.getMatchNumber()) {
            return SIX_MATCH;
        } else if (matchNumber == FIVE_MATCH_BONUS.getMatchNumber() && hasBonus == FIVE_MATCH_BONUS.HasBonus()) {
            return FIVE_MATCH_BONUS;
        } else if (matchNumber == FIVE_MATCH.getMatchNumber()) {
            return FIVE_MATCH;
        } else if (matchNumber == FOUR_MATCH.getMatchNumber()) {
            return FOUR_MATCH;
        } else if (matchNumber == THREE_MATCH.getMatchNumber()) {
            return THREE_MATCH;
        }
        return null;
    }
}
