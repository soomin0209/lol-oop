public class LeeSin extends Champion {

    public LeeSin(String name) {
        super(name, 645, 66, 36);
    }

    @Override
    public void useQ(Champion target) {
        System.out.println(getName() + "의 음파/공명의 일격(Q)!");
        target.takeDamage(60);
    }
}