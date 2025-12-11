public class Viego extends Champion implements MeleeChampion, WarriorChampion {

    public Viego(String name) {
        super(name, GameConstants.VIEGO_HP, GameConstants.VIEGO_AD, GameConstants.VIEGO_DF, GameConstants.VIEGO_MS);
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
    public void useR(Champion target) {
        System.out.println(getName() + "의 심장 파괴자(R)!");
        target.takeDamage(120);
    }
}
