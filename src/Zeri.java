public class Zeri extends Champion implements RangedChampion {

    public Zeri(String name) {
        super(name, GameConstants.ZERI_HP, GameConstants.ZERI_AD, GameConstants.ZERI_DF, GameConstants.ZERI_MS, ChampionType.MARKSMAN);
    }

    @Override
    public void kite() {
        System.out.println(getName() + " 카이팅!");
    }

    @Override
    public void useQ(Champion target) {
        System.out.println(getName() + "의 집중 사격(Q)!");
        target.takeDamage(50);
    }

    @Override
    public void useW(Champion target) {
        System.out.println(getName() + "의 초강력 레이저(W)!");
        target.takeDamage(70);
    }

    @Override
    public void useE(Champion target) {
        System.out.println(getName() + "의 스파크 돌진(E)!");
        increaseSpeed(100, 0);
    }

    @Override
    public void useUltimate(Champion target) {
        System.out.println(getName() + "의 번개 방출(R)!");
        target.takeDamage(100);
    }

    // 이속 400 이상이어야 true
    @Override
    public boolean canResurrect() {
        return getMovementSpeed() >= 400;
    }

    @Override
    protected void resurrectBuff() {
        new Log(getName() + " 부활 버프: 이동 속도 50 증가!");
        increaseSpeed(50, 0);
    }
}
