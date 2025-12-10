public class Main {
    public static void main(String[] args) {

        System.out.println("==== 소환사의 협곡에 오신 것을 환영합니다 ====\n");

        Champion kaisa = new KaiSa("카이사");
        Champion leeSin = new LeeSin("리신");
        Champion zeri = new Zeri("제리");
        Champion viego = new Viego("비에고");

        System.out.println("=== 전투 시작 ===\n");

        kaisa.basicAttack(zeri);
        zeri.basicAttack(kaisa);

        leeSin.basicAttack(viego);
        viego.basicAttack(leeSin);

        kaisa.useQ(zeri);
        zeri.useQ(kaisa);
        leeSin.useQ(viego);
        viego.useQ(leeSin);

        kaisa.useW(zeri);
        zeri.useW(kaisa);
        leeSin.useW(viego);
        viego.useW(leeSin);

        kaisa.useE(zeri);
        zeri.useE(kaisa);
        leeSin.useE(viego);
        viego.useE(leeSin);

        kaisa.levelUp();
        leeSin.levelUp();

        kaisa.useR(zeri);
        zeri.useR(kaisa);
        leeSin.useR(viego);
        viego.useR(leeSin);

        ((RangedChampion)kaisa).kite();
        ((RangedChampion)zeri).kite();
        ((MeleeChampion)leeSin).dash(viego);
        ((MeleeChampion)viego).dash(leeSin);
        ((WarriorChampion)viego).strike(leeSin);

        System.out.println("=== 전투 종료 ===\n");
        System.out.println("=== 전투 결과 ===");

        System.out.println(kaisa);
        System.out.println(leeSin);
        System.out.println(zeri);
        System.out.println(viego);
    }
}