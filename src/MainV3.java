public class MainV3 {

    public static void main(String[] args) {

        // 챔피언 생성
        Champion kaisa = new KaiSa("카이사");
        Champion leesin = new LeeSin("리신");
        Champion zeri = new Zeri("제리");
        Champion viego = new Viego("비에고");

        // 챔피언 Pool 구성
        ChampionPool pool = new ChampionPool();
        pool.addChampion(kaisa);
        pool.addChampion(leesin);
        pool.addChampion(zeri);
        pool.addChampion(viego);

        // 팀 생성
        Team<Champion> blue = new Team<>("블루");
        Team<Champion> red = new Team<>("레드");

        // 팀 배치
        blue.addMember(pool.get("카이사"));
        blue.addMember(pool.get("리신"));

        red.addMember(pool.get("제리"));
        red.addMember(pool.get("비에고"));
        System.out.println();

        System.out.println("블루팀 전체 체력: " + blue.getTotalHp());
        System.out.println("레드팀 전체 체력: " + red.getTotalHp());
        System.out.println();

        // 1대 1 전투 시작
        Battle.onVsone(blue, red);
        System.out.println();

        System.out.println(kaisa);
        System.out.println(leesin);
        System.out.println(zeri);
        System.out.println(viego);
    }
}
