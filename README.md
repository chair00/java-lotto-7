# 3주차 우테코 프리코스 : 로또
***
간단한 로또 발매기를 구현한다.
## 구현할 기능 목록
***

### 로또 숫자 뽑기
* 개수 : 6
* 범위 : 1~45 사이 숫자
* 중복되지 않는다.

### 구입할 금액 입력
* 1,000원 단위로 입력한다.
* 예외
    * 1,000으로 나누어 떨어지지 않는 경우
    * 1,000보다 작은 경우(음수 또는 0)
    * 숫자가 아닌 것을 입력할 경우
    * 공백인 경우

### 당첨번호 입력
* 개수 : 6
* 범위 : 1~45
* 중복되지 않는 6개의 수를 입력한다.
* (,)로 구분
* 예외
    * 범위를 벗어날 경우
    * 6개를 넘을 경우
    * 공백이 있거나 공백인 경우
    * 숫자가 아닌 것을 입력할 경우
    * 숫자가 중복될 경우

### 보너스 번호 입력
* 개수 : 1
* 범위 : 1~45
* 당첨번호와 중복되지 않는다.
* 예외
    * 범위를 벗어날 경우
    * 숫자가 아닌 것을 입력할 경우
    * 당첨번호와 숫자가 중복될 경우
    * 공백인 경우

### 발행한 로또 수 및 번호 출력
* 발행한 로또 수 : 구입한 금액 / 1,000
* 개당 한 줄 씩 출력한다.
* 로또 번호는 오름차순으로 정렬하여 보여준다.
  ex.
```
1개를 구매했습니다.
[5, 8, 16, 21, 33, 37]
```

### 당첨 내역 출력
당첨 기준과 수익
```
* 1등: 6개 번호 일치 / 2,000,000,000원
* 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
* 3등: 5개 번호 일치 / 1,500,000원
* 4등: 4개 번호 일치 / 50,000원
* 5등: 3개 번호 일치 / 5,000원
```

ex.
```
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
```

### 수익률 출력
* `수익률` = 순이익/투자비용 * 100 (%)
* 소수점 둘째 자리에서 반올림한다.

### 예외 상황 처리하기
* 예외 발생시 [ERROR] 로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.