import java.util.ArrayList;
import java.util.List;

public class Team<T extends Champion> {

    private String name;
    private List<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addMember(T champion) {
        members.add(champion);
        System.out.println(champion.getName() + " 이(가) " + name + "팀에 합류!");
    }

    public int getTotalHp() {
        return members.stream()
                .mapToInt(Champion::getHp)
                .sum();
    }

    public List<T> getMembers() {
        return members;
    }
}
