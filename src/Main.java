public class Main {
    public static void main(String[] args) {

        System.out.println("==== 소환사의 협곡에 오신 것을 환영합니다 ====");

        Champion kaisa = new KaiSa("카이사");
        Champion leeSin = new LeeSin("리신");

        System.out.println("=== 전투 시작 ===");

        kaisa.basicAttack(leeSin);
        leeSin.basicAttack(kaisa);

        kaisa.useQ(leeSin);
        leeSin.useQ(kaisa);

        System.out.println("=== 전투 종료 ===");
        System.out.println("=== 전투 결과 ===");

        System.out.println(kaisa);
        System.out.println(leeSin);
    }
}