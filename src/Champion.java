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

    // 모든 챔피언이 공유하는 카운트
    private static int createdCount = 0;
    private static int battleCount = 0;

    public Champion(String name, int hp, int attackDamage, int defence, int movementSpeed) {
        this.name = name;
        this.level = 1;
        this.hp = hp;
        this.attackDamage = attackDamage;
        this.defence = defence;
        this.attackSpeed = 1;
        this.movementSpeed = movementSpeed;

        createdCount++;
    }

    public static int getCreatedCount() {
        return createdCount;
    }

    public static int getBattleCount() {
        return battleCount;
    }

    // 기본 공격 메서드
    public void basicAttack(Champion target) {
        // 랜덤 데미지
        int randomDamage = attackDamage;
        // 랜덤 함수 범위를 정하기 위한 최소, 최대값
        int minDamage = (int)(attackDamage * 1.5);  // 1.5배
        int maxDamage = attackDamage * 2;   // 2배
        System.out.println(name + " → " + target.name + " 기본 공격!");
        // 20%의 확률로 기존 attackDamage의 1.5~2배 사이에서 randomDamage 설정 -> 치명타 발동
        if (random.nextDouble() < GameConstants.CRITICAL_CHANCE) {
            randomDamage = random.nextInt(maxDamage - minDamage + 1) + minDamage;
            System.out.println("치명타 " + randomDamage + "!");
        }
        target.takeDamage(randomDamage);
    }

    // 피해 메서드
    public void takeDamage(int damage) {
        int actualDamage = damage - defence;
        if (actualDamage < 0) actualDamage = 0;

        hp -= actualDamage;

        // hp가 0일 때 사망
        if (hp <= 0) {
            hp = 0;
            System.out.println(name +  " 이(가) " + actualDamage + " 피해를 입음! (남은 HP: " + hp + ")");
            System.out.println(name + " 사망!");
        } else {
            System.out.println(name + " 이(가) " + actualDamage + " 피해를 입음! (남은 HP: " + hp + ")");
        }
        // 전투 후 데미지를 입으면 배틀카운트 +1
        battleCount++;
    }

    // 힐 메서드
    public void healHp(int heal) {
        hp += heal;

        System.out.println(name + " 이(가) " + heal + " 만큼 회복! (남은 HP: " + hp + ")");
    }

    // 이속, 공속 증가 메서드
    public void increaseSpeed (int mSpeed, int aSpeed) {
        movementSpeed += mSpeed;
        attackSpeed += aSpeed;

        System.out.println(name + " 이동 속도 " + mSpeed + " 증가!");
        System.out.println(name + " 공격 속도 " + aSpeed + " 증가!");
    }

    // 레벨업 메서드
    public final void levelUp() {
        if (this.level >= GameConstants.MAX_LEVEL) {
            System.out.println(name + " 이(가) 이미 최고 레벨입니다!");
        } else {
            level++;
            hp += 120;
            attackDamage += 5;
            defence += 5;
            System.out.println(name + " 이(가) 레벨업 하였습니다! (현재 레벨: " + level + ")");
        }
    }

    public final void resurrect() {
        if (hp > 0) {
            System.out.println(name + " 이(가) 이미 살아있습니다! (현재 HP: " + hp + ")");
        } else {
            hp = 10;
            System.out.println(name + " 이(가) 부활했습니다! (현재 HP: " + hp + ")");
        }
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
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
                '}';
    }

    // 스킬 메서드
    public abstract void useQ(Champion target);
    public abstract void useW(Champion target);
    public abstract void useE(Champion target);
    public abstract void useR(Champion target);
}
