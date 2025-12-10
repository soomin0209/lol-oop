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

    public Champion(String name, int hp, int attackDamage, int defence, int movementSpeed) {
        this.name = name;
        this.level = 1;
        this.hp = hp;
        this.attackDamage = attackDamage;
        this.defence = defence;
        this.attackSpeed = 1;
        this.movementSpeed = movementSpeed;
    }

    // 기본 공격 메서드
    public void basicAttack(Champion target) {
        // 랜덤 데미지
        int randomDamage = attackDamage;
        // 랜덤 함수 범위를 정하기 위한 최소, 최대값
        int minDamage = (int)(attackDamage * 1.5);  // 1.5배
        int maxDamage = attackDamage * 2;   // 2배
        System.out.println(name + " → " + target.name + " 기본 공격!");
        // 30%의 확률로 기존 attackDamage의 1.5~2배 사이에서 randomDamage 설정 -> 치명타 발동
        if (random.nextDouble() < 0.3) {
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
            System.out.println(name + " 사망!\n");
        } else {
            System.out.println(name + " 이(가) " + actualDamage + " 피해를 입음! (남은 HP: " + hp + ")\n");
        }
    }

    // 힐 메서드
    public void healHp(int heal) {
        hp += heal;

        System.out.println(name + " 이(가) " + heal + " 만큼 회복! (남은 HP: " + hp + ")\n");
    }

    // 이속, 공속 증가 메서드
    public void increaseSpeed (int mSpeed, int aSpeed) {
        movementSpeed += mSpeed;
        attackSpeed += aSpeed;

        System.out.println(name + " 이동 속도 " + mSpeed + " 증가!");
        System.out.println(name + " 공격 속도 " + aSpeed + " 증가!\n");
    }

    // 레벨업 메서드
    public void levelUp() {;
        level += 1;
        hp += 120;
        attackDamage += 5;
        defence += 5;
        System.out.println(name + " 이(가) 레벨업 하였습니다! (현재 레벨: " + level + ")\n");
    }

    public String getName() {
        return name;
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
