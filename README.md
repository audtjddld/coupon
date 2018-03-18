# coupon

## Description
> Email을 입력받아 Coupon을 발행 시킨다.
> 1. Email은 중복으로 등록될 수 없다.
> 2. Coupon은 중복으로 등록될 수 없다.

## 사용된 기술
```
spring boot 1.5.x
angularjs (ver.1)
h2 (in memory db)
```

## 설치 방법
```
(선행적으로 sts or intellij 등을 설치해 놓는다.)
1. git hub 주소를 clone 받는다.
2. gradle project 변경 후 refresh를 받는다.
```

### 쿠폰 발행 관련 문제 해결
1. 쿠폰번호 생성은 라이브러리 사용없이 직접 구현.
2. 쿠폰번호는 [0-9a-zA-Z]으로 구성.


> 1. 쿠폰 번호가 중복으로 처리되면 안되기 때문에 최대한 중복이 불가능하는 방법을 생각 함.  
> 2. 시간으로 접근하는 것이 좋을 것 같다는 생각에 currentTimeMillis 와 nanoTime 을 생각함.    
> 3. nanoTime은 머신 성능을 타는 것을 알게 됨.  
> 4. nanoTime으로 생성되는 값과 currentTimeMillis으로 생성되는 13자리를 합하여 숫자를 생성. 
> 5. 생성된 숫자들 중 16자리만 가지고 [0-9a-zA-Z] 문자열로 출력하도록 하기 위하여 3등분하여 
> 각 문자열로 변경하는 것으로 방향을 잡음.

```
for (int i = 0; i < 16; i++) {
      int number = Integer.parseInt(strArray[i]);
      if (i > 0 && i % 4 == 0) {
        sb.append("-");
      }
      int mod = number % 3;
      switch (mod) {
        case 0:
          sb.append((char) (97 + number));
          break;
        case 1:
          sb.append(number);
          break;
        case 2:
          sb.append((char) (65 + number));
          break;
        default:
          break;
      }
    }
    
    ------ 결과 ------
    1CI1-FC1d-ja1d-F7I1
    -----------------
```

>전체적인 문자열 범위를 활용 못하는 것이 아쉬움.