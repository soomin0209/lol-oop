public abstract class Champion {

    // 상태 (필드 변수)
    private String name;
    private int level;
    private int hp;
    private int attackDamage;
    private int defence;

    public Champion(String name, int hp, int attackDamage, int defence) {
        this.name = name;
        this.level = 1;
        this.hp = hp;
        this.attackDamage = attackDamage;
        this.defence = defence;
    }

    // 기본 공격 메서드
    public void basicAttack(Champion target) {
        System.out.println(name + " → " + target.name + " 기본 공격!");
        target.takeDamage(attackDamage);
    }

    // 피해 메서드
    public void takeDamage(int damage) {
        int actualDamage = damage - defence;
        if (actualDamage < 0) actualDamage = 0;

        hp -= actualDamage;

        System.out.println(name + " 이(가) " + actualDamage + " 피해를 입음! (남은 HP: " + hp + ")");
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getDefence() {
        return defence;
    }

    public int getAttackDamage() {
        return attackDamage;
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

    // Q 스킬 메서드
    public abstract void useQ(Champion target);
}