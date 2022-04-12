# 기능 목록

## number

- 1~9 의 숫자만 입력 될 수 있다. -> 아닐 경우 IllegalArgumentException

## numbers

- 3개의 ball을 관리한다.
- String으로 부터 3개의 ball을 생성할 수 있다.
- List<integer>로 부터 3개의 ball을 생성할 수 있다.
- 중복된 수가 있으면 IllegalArgumentException이 발생한다.
- 다른 numbers 와 매칭해서 볼 카운트를 반환한다.
- 다른 numbers 와 매칭해서 스트라이크 카운트를 반환한다.

## matchResult

- ball strike 정보를 가지고 있다.

## numberGenerator

- RandomNumbersGenerator
    - 숫자를 3(룰에 맞게)개 생성한다.
    - 중복되는 숫자가 없이 3개의 Numbers를 생성한다.
- StringNumbersGenerator
    - 문자열로 부터 Numbers를 생성한다

## player

- matchResult 공을 비교해 MatchResult를 반환한다.