public class BattleUtils {

    // 챔피언 중 더 체력이 높은 챔피언을 반환
    public static Champion pickHighHp(Champion a, Champion b, Champion c, Champion d) {
        Champion[] champions = {a, b, c, d};
        Champion winner = champions[0];
        for (int i = 0; i < 3; i++) {
            if (champions[i].getHp() > winner.getHp()) {
                winner = champions[i];
            }
        }
        return winner;
    }
}
