public class Viego extends Champion implements MeleeChampion, FighterChampion {

    // 궁 사용 여부 확인
    private static boolean usedUseR = false;

    public Viego(String name) {
        super(name, GameConstants.VIEGO_HP, GameConstants.VIEGO_AD, GameConstants.VIEGO_DF, GameConstants.VIEGO_MS, ChampionType.FIGHTER);
    }

    @Override
    public void dash(Champion target) {
        System.out.println(getName() + " 돌진!");
        target.takeDamage(50);
    }

    @Override
    public void strike(Champion target) {
        System.out.println(getName() + " 강력한 일격!");
        target.takeDamage(70);
    }

    @Override
    public void useQ(Champion target) {
        System.out.println(getName() + "의 몰락한 왕의 검(Q)!");
        target.takeDamage(50);
    }

    @Override
    public void useW(Champion target) {
        System.out.println(getName() + "의 망령의 나락(W)!");
        target.takeDamage(40);
    }

    @Override
    public void useE(Champion target) {
        System.out.println(getName() + "의 안개의 길(E)!");
        increaseSpeed(80, 1);
    }

    @Override
    public void useUltimate(Champion target) {
        System.out.println(getName() + "의 심장 파괴자(R)!");
        target.takeDamage(120);
        usedUseR = true;
    }

    // 궁극기 한번이라도 사용했으면 true
    @Override
    public boolean canResurrect() {
        return usedUseR;
    }

    // resurrectBuff 오버라이딩 X
    // 부활 시 버프 효과 없음
}
