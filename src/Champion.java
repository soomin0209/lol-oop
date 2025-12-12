import java.util.ArrayList;
import java.util.Random;

public abstract class Champion {

    private Random random = new Random();

    // 상태 (필드 변수)
    private String name;
    private int level;
    private int hp;
    private int attackDamage;
    private int defence;
    private int attackSpeed;
    private int movementSpeed;
    // 챔피언 역할군 Enum
    private ChampionType type;

    // 모든 챔피언이 공유하는 카운트
    private static int createdCount = 0;
    private static int battleCount = 0;
    // private int battleCount = 0; -> 각 챔피언이 공격받은 횟수만 카운트 가능

    public Champion(String name, int hp, int attackDamage, int defence, int movementSpeed, ChampionType type) {
        this.name = name;
        this.level = 1;
        this.hp = hp;
        this.attackDamage = attackDamage;
        this.defence = defence;
        this.attackSpeed = 1;
        this.movementSpeed = movementSpeed;
        this.type = type;

        createdCount++;
    }

    // 기본 공격 메서드
    public void basicAttack(Champion target) {
        // 랜덤 데미지
        int randomDamage = attackDamage;
        // 랜덤 함수 범위를 정하기 위한 최소, 최대값
        int minDamage = (int)(attackDamage * 1.5);  // 1.5배
        int maxDamage = attackDamage * 2;   // 2배
        new Log(name + " → " + target.name + " 기본 공격!");
        // 20%의 확률로 기존 attackDamage의 1.5~2배 사이에서 randomDamage 설정 -> 치명타 발동
        if (random.nextDouble() < GameConstants.CRITICAL_CHANCE) {
            randomDamage = random.nextInt(maxDamage - minDamage + 1) + minDamage;
            new Log("치명타 " + randomDamage + "!");
        }
        target.takeDamage(randomDamage);
    }

    // 피해 메서드 -> 카이사 누적피해량 구하기 위해 int로 변경
    public int takeDamage(int damage) {
        int actualDamage = damage - defence;
        if (actualDamage < 0) actualDamage = 0;

        hp -= actualDamage;

        // hp가 0일 때 사망
        if (hp <= 0) {
            hp = 0;
            new Log(name +  " 이(가) " + actualDamage + " 피해를 입음! (남은 HP: " + hp + ")");
            new Log(name + " 사망!");
        } else {
            new Log(name + " 이(가) " + actualDamage + " 피해를 입음! (남은 HP: " + hp + ")");
        }
        // 전투 후 데미지를 입으면 배틀카운트 +1
        battleCount++;
        return actualDamage;
    }

    // 힐 메서드
    public void healHp(int heal) {
        hp += heal;

        new Log(name + " 이(가) " + heal + " 만큼 회복! (남은 HP: " + hp + ")");
    }

    // 이속, 공속 증가 메서드
    public void increaseSpeed (int mSpeed, int aSpeed) {
        movementSpeed += mSpeed;
        attackSpeed += aSpeed;

        new Log(name + " 이동 속도 " + mSpeed + " 증가!");
        new Log(name + " 공격 속도 " + aSpeed + " 증가!");
    }

    // 레벨업 메서드
    public final void levelUp() {
        if (this.level >= GameConstants.MAX_LEVEL) {
            new Log(name + " 이(가) 이미 최고 레벨입니다!");
        } else {
            level++;
            hp += 120;
            attackDamage += 5;
            defence += 5;
            new Log(name + " 이(가) 레벨업 하였습니다! (현재 레벨: " + level + ")");
        }
    }

    // 부활 메서드
    public final void resurrect() {
        if (hp > 0) {
            new Log(name + " 이(가) 이미 살아있습니다! (현재 HP: " + hp + ")");
        } else if (canResurrect()){
            hp = 10;
            new Log(name + " 이(가) 부활했습니다! (현재 HP: " + hp + ")");
            resurrectBuff();    // 버프 적용
        } else {
            new Log(name + " 이(가) 부활 조건을 만족하지 못했습니다!");
        }
    }

    // Hook 메서드 -> 확장하는 메서드라 protected로 정의
    protected void resurrectBuff() {
        // 기본 - 아무것도 안함
    }

    // 궁극기 사용 메서드
    // 레벨 6 이상 조건 공통 -> final 선언
    // 챔피언 별 궁극기는 useUltimate 추상메서드에 정의
    public final void useR(Champion target) {
        if (level < 6) {
            new Log(name + " 레벨 6 이상부터 궁극기 사용 가능! (현재 레벨: " + level + ")");
            return;
        }
        useUltimate(target);
    }

    // 챔피언 정보 출력 메서드
    @Override
    public String toString() {
        return  name + "{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", hp=" + hp +
                ", attackDamage=" + attackDamage +
                ", defense=" + defence +
                ", attackSpeed=" + attackSpeed +
                ", movementSpeed=" + movementSpeed +
                '}';
    }

    // 중첩 클래스 -> 로그 출력
    public static class Log {
        private static ArrayList<String> logs = new ArrayList<>();
        private final String message;

        public Log(String message) {
            this.message = message;
            logs.add(this.message);
            System.out.println(message);
        }

        // 모든 로그 출력 메서드
        public static void printLog() {
            System.out.println("========== 전투 로그 ==========");
            for (String log : logs) {
                System.out.println("[LOG] " + log);
            }
        }
    }

    // Getter
    public ChampionType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getLevel() {
        return level;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public static int getCreatedCount() {
        return createdCount;
    }

    public static int getBattleCount() {
        return battleCount;
    }

    // 추상 메서드
    public abstract void useQ(Champion target);
    public abstract void useW(Champion target);
    public abstract void useE(Champion target);
    public abstract void useUltimate(Champion target);
    public abstract boolean canResurrect();
}
