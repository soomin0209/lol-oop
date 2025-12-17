import java.util.ArrayList;
import java.util.List;

public class TeamWithWrongGeneric<T> {
    // 잘못된 제네릭 설계 사례 예시

    private String name;
    private List<T> members = new ArrayList<>();

    public TeamWithWrongGeneric(String name) {
        this.name = name;
    }

    public void addMember(T champion) {
        members.add(champion);
        System.out.println(champion.getName() + " 이(가) " + name + "팀에 합류!");
    } // T가 Champion이라는 보장이 없어 getName() 메서드가 없을수도 있기 때문에 컴파일 에러

    public int getTotalHp() {
        return members.stream()
                .mapToInt(Champion::getHp)
                .sum();
    } // T가 Champion이라는 보장이 없어 getHp() 메서드가 없을수도 있기 때문에 컴파일 에러

    public List<T> getMembers() {
        return members;
    }

    // 제네릭 와일드카드 적용
    public static void printTeamMembers(List<? extends Champion> team) {
        for(Champion c : team) {
            System.out.println(c.getName());
        }
    }
}
