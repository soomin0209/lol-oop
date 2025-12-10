public class LeeSin extends Champion implements MeleeChampion {

    public LeeSin(String name) {
        super(name, 645, 66, 36, 345);
    }

    @Override
    public void dash(Champion target) {
        System.out.println(getName() + " 돌진!");
        target.takeDamage(50);
    }

    @Override
    public void useQ(Champion target) {
        System.out.println(getName() + "의 음파/공명의 일격(Q)!");
        target.takeDamage(60);
    }

    @Override
    public void useW(Champion target) {
        System.out.println(getName() + "의 방호/강철의 의지(W)!");
        healHp(10);
    }

    @Override
    public void useE(Champion target) {
        System.out.println(getName() + "의 폭풍/무력화(E)!");
        target.takeDamage(55);
    }

    @Override
    public void useR(Champion target) {
        System.out.println(getName() + "의 용의 분노(R)!");
        target.takeDamage(100);
    }
}
