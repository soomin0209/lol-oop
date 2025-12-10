public class KaiSa extends Champion implements RangedChampion {

    public KaiSa(String name) {
        super(name, 640, 59, 25, 335);
    }

    @Override
    public void kite() {
        System.out.println(getName() + " 카이팅!\n");
    }

    @Override
    public void useQ(Champion target) {
        System.out.println(getName() + "의 이케시아 폭우(Q)!");
        target.takeDamage(90);
    }

    @Override
    public void useW(Champion target) {
        System.out.println(getName() + "의 공허추적자(W)!");
        target.takeDamage(80);
    }

    @Override
    public void useE(Champion target) {
        System.out.println(getName() + "의 고속 충전(E)!");
        increaseSpeed(100, 1);
    }

    @Override
    public void useR(Champion target) {
        System.out.println(getName() + "의 사냥 본능(R)!");
        increaseSpeed(50, 0);
        healHp(10);
    }
}

