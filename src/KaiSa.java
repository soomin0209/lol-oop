public class KaiSa extends Champion implements RangedChampion {

    // 카이사 누적 피해량 계산할 static 변수
    private static int totalDamage = 0;

    public static int getTotalDamage() {
        return totalDamage;
    }

    public KaiSa(String name) {
        super(name, GameConstants.KAISA_HP, GameConstants.KAISA_AD, GameConstants.KAISA_DF, GameConstants.KAISA_MS, ChampionType.MARKSMAN);
    }

    @Override
    public void kite() {
        System.out.println(getName() + " 카이팅!");
    }

    @Override
    public void useQ(Champion target) {
        System.out.println(getName() + "의 이케시아 폭우(Q)!");
        int actualDamage = target.takeDamage(90);
        totalDamage += actualDamage;
    }

    @Override
    public void useW(Champion target) {
        System.out.println(getName() + "의 공허추적자(W)!");
        int actualDamage = target.takeDamage(80);
        totalDamage += actualDamage;
    }

    @Override
    public void useE(Champion target) {
        System.out.println(getName() + "의 고속 충전(E)!");
        increaseSpeed(100, 1);
    }

    @Override
    public void useUltimate(Champion target) {
        System.out.println(getName() + "의 사냥 본능(R)!");
        increaseSpeed(50, 0);
        healHp(10);
    }

    // 스킬 누적 딜량이 100 이상이어야 true
    @Override
    public boolean canResurrect() {
        return totalDamage >= 100;
    }

    @Override
    protected void resurrectBuff() {
        new Log(getName() + " 부활 버프: 공격 속도 1 증가!");
        increaseSpeed(0, 1);
    }
}

