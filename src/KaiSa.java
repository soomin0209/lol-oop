public class KaiSa extends Champion {

    public KaiSa(String name) {
        super(name, 640, 59, 25);
    }

    @Override
    public void useQ(Champion target) {
        System.out.println(getName() + "의 이케시아 폭우(Q)!");
        target.takeDamage(90);
    }
}
