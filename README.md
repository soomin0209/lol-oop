# LoL로 객체지향 파밍하기
## 🐰 달리기반 과제

<details>
<summary><strong> 1회차 과제</strong></summary>

### [필수미션]
- 카이사 / 리신 등 챔피언을 기반으로한 클래스 2개 생성 후 상태(필드변수) / 행위(메서드) 지정하기 (캡슐화)
- 유사한 성격을 가진 메서드를 모아 추상 클래스로 묶어보기(추상화)
- 기존 클래스에 상속 후 코드 수정하기(상속)
- 다형성을 활용하여 메서드 설정 및 main함수에서 모의 전투 롤플레잉 (다형성)

### [추가미션]
- 카이사에게 “레벨업(levelUp)” 메서드를 만들어 체력·공격력 증가하게 해보기
- takeDamage 후 체력이 0 이하가 되면 “카이사 사망!” 메시지 출력
- attackDamage 값을 난수(랜덤)로 만들어 “치명타 개념” 추가해보기
- Zeri, Viego 등 챔피언 2명 더 만들기
- 인터페이스를 2개 이상 조합한 챔피언 만들기(예: 근거리 + 전사)
- Q/W/E/R 스킬을 모두 추상 메서드로 확장해보기
- “치명타 확률” 같은 고유 패시브를 메서드로 추가해보기

#### 챔피언 클래스: KaiSa, LeeSin, Zeri, Viego  
#### 인터페이스: MeleeChampion, RangedChampion, WarriorChampion  
#### 인터페이스 2개 이상 조합된 챔피언: Viego (Melee + Warrior)

</details>

<details>
<summary><strong> 2회차 과제</strong></summary>

### [필수미션]
- 챔피언의 기본 스탯을 GameConstants로 분리하기
- 전투 횟수(static) 카운팅 기능 추가
- 고정된 부활(resurrect) 규칙을 final 메서드로 만들기

### [선택미션]
- 공통되지 않는 ‘부활 조건’은 어떻게 분리할까?
- 전투 로그를 static 중첩 클래스로 만들어보기
- static을 남용했을 때 생기는 문제를 직접 재현해보기
- 상수 그룹을 Enum으로 표현해보기
- 부활(resurrect) 메서드를 템플릿 메서드 패턴으로 확장해보기

</details>
