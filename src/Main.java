public class Main {
    public static void main(String[] args) {

        System.out.println("=== 소환사의 협곡에 오신 것을 환영합니다 ===\n");

        Champion kaisa = new KaiSa("카이사");
        Champion leesin = new LeeSin("리신");
        Champion zeri = new Zeri("제리");
        Champion viego = new Viego("비에고");

        System.out.println("총 생성된 챔피언 수: " + Champion.getCreatedCount());
        System.out.println("최대 레벨: " + GameConstants.MAX_LEVEL);
        System.out.println("기본 CDR: " + GameConstants.BASE_CDR);
        System.out.println();

        System.out.println("========== 전투 시작 ==========\n");

        System.out.println("--- 평타 ---");
        kaisa.basicAttack(zeri);
        System.out.println();
        zeri.basicAttack(kaisa);
        System.out.println();
        leesin.basicAttack(viego);
        System.out.println();
        viego.basicAttack(leesin);
        System.out.println();

        System.out.println("--- Q스킬 ---");
        kaisa.useQ(zeri);
        System.out.println();
        zeri.useQ(kaisa);
        System.out.println();
        leesin.useQ(viego);
        System.out.println();
        viego.useQ(leesin);
        System.out.println();

        System.out.println("--- W스킬 ---");
        kaisa.useW(zeri);
        System.out.println();
        zeri.useW(kaisa);
        System.out.println();
        leesin.useW(viego);
        System.out.println();
        viego.useW(leesin);
        System.out.println();

        System.out.println("--- E스킬 ---");
        kaisa.useE(zeri);
        System.out.println();
        zeri.useE(kaisa);
        System.out.println();
        leesin.useE(viego);
        System.out.println();
        viego.useE(leesin);
        System.out.println();

        System.out.println("--- 레벨업 ---");
        kaisa.levelUp();
        leesin.levelUp();
        System.out.println();

        System.out.println("--- 궁극기 ---");
        kaisa.useR(zeri);
        System.out.println();
        zeri.useR(kaisa);
        System.out.println();
        leesin.useR(viego);
        System.out.println();
        viego.useR(leesin);
        System.out.println();

        System.out.println("--- 부활 ---");
        kaisa.resurrect();
        System.out.println();
        kaisa.takeDamage(9999);
        System.out.println();
        kaisa.resurrect();
        System.out.println();

        System.out.println("--- 역할군 별 스킬 ---");
        ((RangedChampion)kaisa).kite();
        ((RangedChampion)zeri).kite();
        System.out.println();
        ((MeleeChampion)leesin).dash(viego);
        System.out.println();
        ((MeleeChampion)viego).dash(leesin);
        System.out.println();
        ((WarriorChampion)viego).strike(leesin);
        System.out.println();

        System.out.println("========== 전투 종료 ==========\n");
        System.out.println("=== 전투 결과 ===");

        System.out.println("전투 횟수: " + Champion.getBattleCount());
        System.out.println();

        System.out.println(kaisa);
        System.out.println(leesin);
        System.out.println(zeri);
        System.out.println(viego);
        System.out.println();
        
        Champion winner = BattleUtils.pickHighHp(kaisa, leesin, zeri, viego);
        System.out.println(winner.getName() + " 이(가) 우승했습니다!");
    }
}