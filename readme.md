# 자바 심화 과정

- 리스트 직접 구현
- 초기 값은 생성자를 통해서 값을 설정해준다.
- [x] add 구현하기
  - add 는 항상 true를 리턴해야한다.
  - add 시에 배열의 크기보다 커졌을 경우
    - MakenewDataIfNotEnough() 를통해서 초과하는지 체크
      - 초과하는 경우 makeNewData를 통해서 새로 생성하고 주입해준다.
- [x] remove 구현하기
- [x] get 구현하기
  - 배열을 통해서 저장시키기
- [x] size 구현하기
- [x] contains 구현
- [x] indexOf 구현
- [x] clear 구현
  - size를 0으로 바꿔주고 data 배열을 0으로 초기화한다.