import java.util.List;
import java.util.Random;

public class Battle {

    private static Random random = new Random();

    public static void onVsone(Team<Champion> t1, Team<Champion> t2) {

        Champion c1 = randomPick(t1.getMembers());
        Champion c2 = randomPick(t2.getMembers());

        System.out.println("===== 1:1 전투 시작 =====");
        System.out.println("** " + c1.getName() + " vs " + c2.getName() + " **");
        System.out.println();

        c1.basicAttack(c2);
        System.out.println();
        c2.basicAttack(c1);
        System.out.println();

        c1.useQ(c2);
        System.out.println();
        c2.useQ(c1);
        System.out.println();
    }

    private static Champion randomPick(List<Champion> list) {
        return list.get(random.nextInt(list.size()));
    }
}
