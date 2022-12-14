# 1.1 TODO 웹 애플리케이션

## 1.1.1 Todo 웹 애플리케이션 기능

- Todo 생성: + 버튼을 클릭해 Todo 아이템을 생성할 수 있다
- Todo 리스트: 생성된 아이템 목록을 화면에서 확인할 수 있다
- Todo 수정: Todo 아이템을 체크하거나 내용을 수정할 수 있다
- Todo 삭제: Todo 아이템을 삭제할 수 있다
- 회원가입: 사용자는 애플리케이션에 회원가입하고 생성된 계정을 이용해 Todo 애플리케이션에 접근할 수 있다
- 로그인: 계정을 생성한 사용자는 계정으로 로그인할 수 있다
- 로그아웃: 로그인한 사용자는 로그아웃할 수 있다.


## 1.1.2 Todo 웹 애플리케이션 아키텍처

![](readmeFile/img.png)

<br/>

## 1.2 배경 지식

### 1.2.1 하이퍼텍스트 트랜스퍼 프로토콜

HTTP 는 애플리케이션 레벨의 네트워크 프로토콜이다. 즉, 다른 문서로 향하는 링크가 있는 텍스트의 통신 규약이다.

![](readmeFile/img_1.png)

그러나 오늘날의 HTTP는 HTML 문서를 주고받던 간단한 프로토콜에서 벗어나 그림 파일, 동영상, 3D 등 다양한 미디어 리소스를 
주고 받는 형태로 발전했다.

![](readmeFile/img_2.png)

사용자는 브라우저라는 클라이언트를 통해 서버에 HTTP 요청을 전송할 수 있으며, 브라우저의 주소창에 URL 을 입력하고 엔터를 누르면
브라우저는 HTTP GET 요청을 해당 URL 서버로 전송하고 그 결과인 HTTP 응답을 브라우저에 렌더링한다.

<br/>

- HTTP 요청

![](readmeFile/img_3.png)

HTTP 요청에는 송신자의 다양한 정보가 담겨있다.
그림에서 송신자는 localhost:8080 으로 GET 요청을 전송하려 하였고, 프로토콜은 HTTP 1.1 버전, 운영체제는 Mac OS X 이며,
요청 전송 시 사파리 브라우저를 사용했다.

주목해야 할 부분은 요청 메서드인데, HTTP 요청에는 GET, POST, PUT, DELETE 와 같은 메서드를 지정할 수 있다.
요청 메서드는 호스트에 지정한 리소스에 어떤 작업을 하고 싶은지 알려주는 역할을 한다.

| 메서드 | 기능            |
|:----|:--------------|
| GET | 리소스를 가져올 때 사용 |
|POST|리소스에 대해 임의의 작업 (생성, 수정)을 할 때 사용|
|PUT|리소스를 대체할 때 사용|
|DELETE|리소스를 삭제할 때 사용|

> 웹에서의 리소스: HTTP 요청 대상을 리소스라고 부름 (문서, 사진, 텍스트, 동영상 어떤 것이든 될 수 있음)

<br/>

- HTTP 응답

![](readmeFile/img_4.png)
![](readmeFile/img_5.png)

HTTP/1.1 옆 200 이라는 숫자는 응답 코드이다. 응답 코드를 통해 사용자의 요청이 어떻게 처리되었는지 알 수 있다.

|응답코드|설명|
|:---|:---|
|200|성공적으로 요청을 처리함|
|404|해당 리소스가 존재하지 않음|
|403|송신자에게 해당 리소스에 접근할 권한이 없음|
|500|서버의 에러로 요청을 처리할 수 없음|

Content-Type 은 응답 미디어 타입을 의미한다. 미디어 타입에는 text/html, text/css, application/json, video/mpeg 등이 있다.
이외에도 Keep-Alive, Cache-Control, Connection 등 통신에 관련된 정보를 확인할 수 있다.

마지막으로 응답 body 가 있다. 서버 애플리케이션은 보통 HTTP 응답 바디에 요청 처리 결과를 보낸다. 예를 들어 www.google.com 에 GET 요청을
보내면 GOOGLE 의 랜딩 페이지 HTML을 넣어 반환한다.


<br/>

### 1.2.2 자바스크립트 오브젝트 노테이션

JSON (JavaScript Object Notation) 은 '오브젝트'를 표현하는 문자열이다.

> - Object란?
> 오브젝트란 메모리상에 존재하는 어떤 자료 구조이다.
> 
> ![](readmeFile/img_6.png)
> ![](readmeFile/img_7.png)
> ![](readmeFile/img_8.png)

![](readmeFile/img_9.png)

그림처림 애플리케이션 1은 애플리케이션 2에 인터넷을 통해 TodoItem 을 전송하려 한다. 애플리케이션 1과 애플리케이션 2는 서로
언어도 다르고 아키텍처도 다르다고 가정하면, 이 오브젝트를 전송하기 위해선 애플리케이션 1과 애플리케이션 2 둘 다 이해할 수 있는 형태로
오프벡트를 변환해야 한다. 이렇게 저장 또는 전송을 위해 메모리상의 오브젝트를 다른 형태로 변환하는 작업을 직렬화 (Serialization) 라고 하고
그 반대 작업을 역직렬화 (Deserialization) 라고 한다.

그러면 어떤 형태로 오브젝트를 직렬화할 것인가에 대한 질문이 남는데 JSON 이다.

JSON은 키-값 (Key-value)의 형태로 오브젝트를 표현한 문자열이다.

![](readmeFile/img_10.png)

그림은 TodoItem 오브젝트를 JSON 으로 변환한 예인데, 자바 인스턴스 변수의 이름은 key 가 되고 변수에 들어간 값은 value 가 되는 것을 확인할 수 있다.

![](readmeFile/img_11.png)

![](readmeFile/img_12.png)

위에서 확인할 수 있듯 JSON (Javascript Object Notaion)은 형식이 자바스크립트에서 오브젝트를 생성하는 형식과 같아서 JSON 이라고 
부른다.

![](readmeFile/img_13.png)

<br/>

다시 애플리케이션 1과 애플리케이션 2의 상황으로 돌아가서 애플리케이션 1과 애플리케이션 2는 JSON 을 이용해 통신하기로 약속했다고 가정하자

![](readmeFile/img_14.png)

그림처럼 오브젝트를 JSON 형태의 문자열로 변환한 후 HTTP 요청의 바디 부분에 변환한 JSON 을 넣어 요청을 전송한다.
요청을 받은 애플리케이션 2는 HTTP 요청의 바디 부분에서 JSON 을 꺼내 TodoItem 으로 변환해 사용할 수 있다.

![](readmeFile/img_15.png)

정리해보면 브라우저상에서 실행될 리액트 애플리케이션은 JSON 을 요청 바디에 넣어 보낸다. 그러면 자바 백엔드 애플리케이션은 이 JSON 을
바디에서 꺼내 TodoItem 으로 변환한다. 물론 이러한 변환 과정은 라이브러리와 프레임워크가 대신 해주므로 크게 신경 쓸 일은 없다.

<br/>

### 1.2.3 서버란?

서버란 프로그램인데 특정 포트, 예를 들어 8080 포트에 소켓을 열고 클라이언트가 연결할 때까지 무한 대기하며 기다린다. 긜고 클라이언트가 연결하면
해당 클라이언트 소켓에서 요청을 받아와 수행하고 응답을 작성해 전달한다.


- 아주 간단한 서버 예

```java
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    public static void main(String[] args) {
        new WebServer().run();
    }

    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (true) {
                try {
                    Socket client = serverSocket.accept();
                    new Thread(() -> handleClient(client)).start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void handleClient(Socket client) {
        // (1) 클라이언트의 요청 읽어오기
        // (2) 클라이언트의 요청에 맞는 작업 수행하기
        // (3) 클라이언트에게 응답 작성하기
        // (4) 소켓 닫기
    }
}
```

예시처럼 아주 간단한 서버에서 클라이언트에게 요청을 읽어올 때 또는 응답을 작성할 때 FTP (File Transfer Protocol) 을 사용한다면 FTP 서버가 되는 것이고,
하이퍼텍스트 트랜스퍼 프로토콜을 사용한다면 HTTP 서버가 되는 것이다. 어찌되었건 서버는 네트워크 오퍼레이션을 수행하는 프로그램이다.

<br/>

### 1.2.4 정적 웹 서버

정적 웹 서버 (Static Web Server) 란 HTTP 서버 중에서도 리소스 파일을 리턴하는 서버를 의미한다.

![](readmeFile/img_16.png)

예를 들어 서버 호스트는 8080 에서 실행되고 있는 로컬 호스트라고 가정하면 localhost:8080/file.html HTTP 요청을 서버로 보내면 정적 웹 서버인 이 서버는
지정된 디렉토리 경로에서 file.html 을 찾아 그 내용을 HTTP 응답 바디에 넣어 전송한다. 이때 서버는 해당 html 파일에 아무 작업도 하지 않고 파일 있는 그대로를 리턴하기 때문에
정적 (Static) 웹 서버라고 한다. 정적 웹 서버의 예로는 아파치나 Nginx 등이 있다. 아파치나 Nginx 를 설치하고 지정된 경로에 원하는 리소스 파일을 저장하면 자동으로 해당 리소스는 웹 서버를 통해 접근할 수 있게 된다.
따라서 서버를 설치하고 설정하고 원하는 리소스를 경로에 지정하는 것 말고는 개발자가 할 일은 없다.

<br/>

### 1.2.5 동적 웹 서버

동적 웹 서버 (Dynamic Web Server)는 파일을 있는 그대로 리턴하지 않는다. 동적 웹 서버는 요청을 처리한 후 결과에 따라 응답 바디를 재구성하거나 HTML 템플릿 파일에 결과를 대체해 보낸다.

![](readmeFile/img_17.png)

클라이언트는 요청에 요청 매개 변수를 보낼 수 있다. 예시에선 name=Engineer 라는 매개변수와 값을 보낸다. 이를 확인한 서버는 요청과 매개변수에 맞는 작업을 수행한 후 그 자리에서 
html 파일을 구성하거나 템플릿 html 파일에서 적절한 값을 대체하는 방식으로 html을 구성해 리턴한다. 따라서 동적 웹 서버는 클라이언트가 누군지, 어떤 매개변수를 보내는지에 따라 같은 요청이라도 다른 응답을 받을 수 있다.
이를 위해선 백엔드 개발자들은 소켓 프로그래밍, HTTP 파싱, 스레드 풀 관리 등의 작업을 하여야 하는데 다행히 자바 프로그램 중 서블릿 엔진을 사용하면 동적 웹 서버를 구현할 수 있다.
아파치 톰캣이 서블릿 엔진에 해당한다.


<br/>

### 1.2.6 자바 서블릿 컨테이너/엔진

서블릿 컨테이너 또는 서블릿 엔진은 서버 프로그램이다. 개발자들은 서블릿 엔진을 설치한 후 서블릿 엔진에게 자기가 개발한 비즈니스 로직, 즉 클래스 파일과 해당 클래스 파일 어느 요청에서 실행해야 하는지 알려줘야 한다.
이때 우리는 서블릿 엔진이 이해할 수 있는 형태로 클래스 파일을 작성해야 한다.

![](readmeFile/img_18.png)

서블릿 엔진이 이해할 수 있는 클래스란 javax.servlet.http.HttpServlet 을 상속받는 서브 클래스를 의미한다. 우리는 HttpServlet 을 상속받는 클래스를 작성해 특정 형식에 맞춰 압축해 전달하며,
이를 통해 개발자는 서버를 처음부터 구현하지 않고도 각기 다른 비즈니스 로직을 구현하고 배포할 수 있다.

사용하게될 스프링 부트도 내부적으론 서블릿 엔진의 사용을 위해 서블릿을 상속 및 구현한다. 


---

<br/>
<br/>
<br/>

# 2장 백엔드 개발

### 2.1.3 스프링 프레임워크와 의존성 주입

- 스프링이란?
스프링이란 오픈 소스의 경량 프레임워크이다. 보통 경량 프레임워크라 함은 해당 프레임워크 사용 시 메모리나 CPU 자원이 많이 들지 않거나 사용이 쉽고 간편한 경우를 경량 프레임워크라고 부른다.
프레임워크는 개발자들이 확장해서 사용할 수 있는 코드이다. 여기서 확장이란 프레임워크가 제공하는 클래스나 라이브러리를 사용하거나 프레임워크가 제공하는 클래스나 인터페이스를 상속 및 구현해 프레임워크의 일부로 실행하는 것을 의미한다.
스프링 프레임워크에는 여러 가지 컴포넌트가 존재하는데 의존성 주입 외에도 스프링 AOP (Aspect Oriented PRogramming), 스프링 ORM, 스프링 웹 등 여러 방면에서 개발을 돕는 프레임워크를 제공한다.
우리가 사용할 컴포넌트는 스프링 부트이다.

<br/>
<br/>

### 2.1.7 빌드 자동화 툴: Gradle과 라이브러리

- build.gradle

```groovy
plugins {
    id 'org.springframework.boot' version '2.7.3'
    id 'io.spring.dependency-management' version '1.0.13.RELEASE'
    id 'java'
    id 'war'
}

group = 'com.example'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '17'

configurations {
    compileOnly {
        extendsFrom annotationProcessor
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    compileOnly 'org.projectlombok:lombok'
    developmentOnly 'org.springframework.boot:spring-boot-devtools'
    annotationProcessor 'org.projectlombok:lombok'
    providedRuntime 'org.springframework.boot:spring-boot-starter-tomcat'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

tasks.named('test') {
    useJUnitPlatform()
}
```

<br/>

- 프로젝트 메타데이터

```groovy
group = 'com.example'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '17'
```

| 키워드     | 설명                                                                   |
|:--------|:---------------------------------------------------------------------|
| group   | artifact(애플리케이션)를 배포하는 데 사용                                          |
| version | 이 프로젝트의 버전. 일반적으로 프로덕션 배포마다 버전이 올라감. 그리고 버전을 어떻게 올리는지는 개개의 프로젝트마다 다름 |
|sourceCompatibility| sourceCompatibility에 자바 버전을 명시                                       |


<br/>

- Lombok

```groovy
configurations {
    compileOnly {
        extendsFrom annotationProcessor
    }
}

dependencies {
    annotationProcessor 'org.projectlombok:lombok'
}
```

|키워드| 설명                                            |
|:---|:----------------------------------------------|
|configurations| annotationProcessor를 컴파일시 사용하라고 그래이들에게 알려줌    |
|annotationProcessor| annotationProcessor를 통해 lomok을 사용하도록 디펜던시에 명시 |


<br/>

- repositories

```groovy
repositories {
    mavenCentral()
}
```

|키워드| 설명 |
|:---|:--|
|mavenCentral| 그레이들이 라이브러리를 다운 받는 곳 |

<br/>

- Dependency

```groovy
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    compileOnly 'org.projectlombok:lombok'
    developmentOnly 'org.springframework.boot:spring-boot-devtools'
    annotationProcessor 'org.projectlombok:lombok'
    providedRuntime 'org.springframework.boot:spring-boot-starter-tomcat'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}
```

|키워드| 설명 |
|:---|:--|
|dependencies| 디펜던시 부분에 명시된 라이브러리들은 그레이들이 리포지터리에서 다운 및 설치함 |

<br/>

- Test


```groovy
tasks.named('test') {
    useJUnitPlatform()
}
```

|키워드| 설명                                |
|:---|:----------------------------------|
|test| JUnitPlatform을 사용해 유닛 테스트를 하도록 명시 |


<br/>
<br/>

### 2.1.8 디펜던시 라이브러리 추가
구글 구아바 라이브러리를 추가해보자!

![](readmeFile/img_19.png)

![](readmeFile/img_20.png)

![](readmeFile/img_21.png)

- 그래들 스니펫 디펜던시 섹션에 추가
```groovy
dependencies {
    implementation 'com.google.guava:guava:31.1-jre'
}
```

<br/>
<br/>

### 2.1.9 롬복
롬복을 사용하면 getter, setter, builder, constructor 작성이 간편해짐.
롬복이 제공하는 어노테이션 프로세서 annotationProcessor가 getter, setter .. 를 프롲게트 컴파일시 자동 작성해줌.


<br/>

- 롬복 테스팅

```java
package com.example.react_springboot_server;

import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public class DemoModel {

    @NonNull
    private String id;
}
```

<br/>
<br/>

### 2.1.10 포스트맨 API 테스트
REST API는 URI(Unified Resource Identifier), HTTP 메서드, 요청 매개변수, 요청 바디로 구분됨.
이를 테스팅하기 위해선 브라우저 환경, cURL (커맨드라인 툴), 포스트맨 (GUI 환경) 등이 있음.

![](readmeFile/img_22.png)

<br/>
<br/>

### 2.2 백엔드 서비스 아키텍처
레이어드 아키텍처 패턴은 스프링 프로젝트 내부에서 어떻게 코드를 적절히 분리하고 관리할 것이냐에 대한 내용임. <br/>
REST 아키텍처 스타일은 클라이언트가 우리 서비스를 이용하려면 어떤 형식으로 요청을 보내고 응답을 받는지에 대한 내용이고, REST 아키텍처 스타일을 따라 설계 및 구현된 서비스를 RESTful 서비스라고 함.

<br/>
<br/>

### 2.2.1 레이어드 아키텍처

![](readmeFile/img_23.png)

레이어드 아키텍처 패턴은 애플리케이션을 구성하는 요소들을 수평으로 나누어 관리하는 것을 말함.

<br/>
<br/>

### 2.2.2 모델, 엔티티, DTO

![](readmeFile/img_24.png)

모델, 엔티티, DTO는 아무 기능 없이 데이터베이스에서 반환된 비즈니스 데이터를 담기 위한 클래스들임.

<br/>

- 모델과 엔티티
큰 애플리케이션의 경우 모델과 엔티티를 따로 구현하지만 규모가 작은 경우 합쳐서 구현함.

```java
package com.example.react_springboot_server.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoEntity {
    private String id; // 이 오브젝트의 아이디
    private String userId; // 이 오브젝트를 생성한 사용자의 아이디
    private String title; // Todo 타이틀 (예: 운동하기)
    private boolean done; // true - todo를 완료한 경우 (checked)
}

```

<br/>

- 어노테이션

> ##### @Builder
> @Builder 어노테이션을 사용하면 Builder 클래스를 따로 개발하지 않고도 Builder 패턴을 사용해 오브젝트를 생성할 수 있다.
>- 롬복이 생성하는 Builder 메서드 사용법
>```
>TodoEntity todo = TodoEntity.builder().id("t-123123").userId("developer").title("Implement Model").build();
>```

> ##### @NoArgsConstructor
> 매개변수가 없는 생성자를 구현해줌


> ##### @AllArgsConstructor
> 모든 멤버 변수를 매개변수로 받는 생성자를 구현해줌


> ##### @Data
> Getter/Setter 메서드를 구현해줌


<br/>

- DTO

서비스가 요청을 처리하고 클라이언트로 반환할 때 모델 자체를 그대로 리턴하는 경우는 별로 없음. <br/>
DTO를 사용함으로서 비즈니스 로직을 캡슐화하고, 외부 사용자에게 서비스 내부의 로직과 데이터베이스 구조를 숨김 <br/>
또한 클라이언트가 필요한 정보를 모델이 전부 포함하지 않는 경우가 많음. 예를 들어 서비스 실행 중 사용자에게 에러가 발생하면
DTO에 에러 메시지 필드를 선언하고 DTO에 포함함 (모델은 서비스 로직과 관련 없음)

<br/>

- TodoDTO (Todo 아이템을 생성, 수정, 삭제)
```java
import com.example.react_springboot_server.model.TodoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoDTO {
    private String id;
    private String title;
    private boolean done;

    public TodoDTO(final TodoEntity entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.done = entity.isDone();
    }

}
```

> 사용자가 자기 아이디를 넘겨주지 않아도 인증이 가능함. userId는 애플리케이션과 데이터베이스에서 사용자를 구별하는 고유 식별자로 사용하기 때문에 숨길 수 있다면 숨김

<br/>

- ResponseDTO (HTTP 응답으로 사용할 예정)

```java
package com.example.react_springboot_server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseDTO<T> {
    private String error;
    private List<T> data;
}

```

> 다른 모델의 DTO도 ResponseDTO를 이용해 리턴할 수 있도록 Generic 타입 활용


<br/>
<br/>

### 2.2.3 REST API
REST (Representational State Transfer)는 아키텍처 스타일임.  <br/>
아키텍처 패턴은 어떤 반복되는 문제 상황을 해결하는 도구이고, 아키텍처 스타일은 반복되는 아키텍처 디자인을 의미한다.

REST 아키텍처 스타일은 6가지 제약조건으로 구성되며 이 가이드라인을 따르는 API를 RESTful API라고 한다.

> REST 제약조건
> - 클라이언트-서버
> - 상태가 없는 (Stateless)
> - 캐시되는 데이터 (Cacheable)
> - 일관적인 인터페이스
> - 레이어 시스템
> - 코드-온-디맨드

<br/>

- 상태가 없는

클라이언트가 서버에 요청을 보낼 때 이전 요청의 영향을 받지 않음을 의미함. 예를 들어 /login으로 로그인 요청을 보내고 로그인이 돼 다음 페이지인 /page로 넘어갔다고 가정하면, /page로 리소스를 불러올 때 이전 요청에서 login한 사실을 서버가 알고 있어야 한다면 상태가 있는 아키텍처이다. 따라서 stateless 상태가 되기 위해 클라이언트는 서버에 요청을 할 때마다 요청에 리소스를 받기 위한 모든 정보를 포함해야 한다. 예를 들어 로그인의 경우 클라이언트는 요청을 보낼때마다 로그인 정보를 함께 보내야 한다. 리소스를 수정한 후 수정 상태를 유지해야 하는 경우 서버가 아닌 데이터베이스 같은 퍼시스턴스에 상태를 저장햐야 한다.

<br/>

- 캐시되는 데이터

서버에서 리소스를 리턴할 때 캐시가 가능한지 아닌지 명시할 수 있어야 한다. HTTP에선 cache-control 이라는 헤더에 리소스의 캐시 여부를 명시할 수 있다.

<br/>

- 일관적인 인터페이스

시스템 또는 애플리케이션의 리소스에 접근할 때 인터페이스가 일관적이어야 한다. 그리고 이 인터페이스에는 URI, JSON 형식의 리소스 반환 등이 있다.

<br/>

- 레이어 시스템

클라이언트가 서버에 요청을 할 때 여러 개의 레이어로 된 서버를 거칠 수 있다. 예를 들어 서버가 인증 서버, 캐싱 서버, 로드 밸런서를 거쳐 최종적으로 애플리케이션에 도착한다고 가정했을 때, 이 사이의 레이어들은 요청과 응답에 영향을 미치지 않으며 클라이언트는 서버의 레이어 존재 유무를 알지 못한다.


<br/>

- 코드-온-디맨드

이는 선택사항이다. 분산 컴퓨팅에서 주문형 코드는 클라이언트 소프트웨어의 요청에 따라 서버 컴퓨터에서 클라이언트 컴퓨터로 실행 가능한 소프트웨어 코드를 보내는 것을 말한다.

<br/>
<br/>

### 2.2.4 컨트롤러 레이어: 스프링 REST API 컨트롤러

<br/>

- HTTP 요청

```http request
GET /test HTTP/1.1
HOST: localhost:8080
Content-Type: application/json
Content-Length: 17
{
"id": 123
}
```

> localhost:8080에 http GET 메서드를 이용해 test라는 리소스를 요청해라! <br/>
> 서버는 자기 주소를 제외한 /{리소스} 부분을 이해하고 이 요청이 어떤 HTTP 메서드를 이용했는지 알아야 함 <br/>
> -> 이를 spring-boot-starter-web의 어노테이션이 쉽게 도와줌


- 스프링 부트 스타터 build.gradle
```groovy
implementation 'org.springframework.boot:spring-boot-starter-web'
```


<br/>

- TestController

```java
package com.example.react_springboot_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test") // 리소스
public class TestController {

    @GetMapping
    public String testController() {
        return "Hello World!";
    }
}
```

| 키워드             | 설명                                 |
|:----------------|:-----------------------------------|
| @RestController | 이 컨트롤러가 RestController임을 명시        |
| @GetMapping | 이 메서드의 리소스와 HTTP 메서드를 지정.          |

![](readmeFile/img_25.png)

<br/>

- 결과

![](readmeFile/img_26.png)

![](readmeFile/img_27.png)



| 어노테이션          | HTTP 메서드 |
|:---------------|:---------|
| @GetMapping    | GET      |
| @PostMapping   | POST     |
| @PutMapping    | PUT      |
| @DeleteMapping | DELETE   |



> 위 어노테이션은 스프링 4.3부터 지원되기 시작했으며 그 이전에는, <br/>
> @RequestMapping(value="/path", method=RequestMethod.GET) <br/> 
> 처럼 하나의 어노테이션에 HTTP 메서드를 매겨변수로 주는 형태로 컨트롤러 메서드를 연결했다.



<br/>

- 매개변수를 넘겨받는 방법

/test가 아닌 /test/{id}로 PathVariable이나 /test?id=123처럼 요청 매개변수를 받아야 한다면 어떻게 해야 할지 알아보자 !

<br/>

| 종류                    | 어노테이션            |
|:----------------------|:-----------------|
| /test/{id}            | @PathVariable 이용 |
| /test?id=123          | @RequestParam 이용 |
| /test/path(JSON)      | @RequestBody 이용  |
| /test/... return JSON | @ResponseBody 이용 |
| /test/... status 조작   | @ResponseEntity 이용 |


<br/>
<br/>

- PathVariable을 이용한 매개변수 전달

![](readmeFile/img_28.png)

```java
package com.example.react_springboot_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test") // 리소스
public class TestController {

    @GetMapping("/{id}")
    public String testControllerWithPathVariable(@PathVariable(required = false) int id) {
        return "Hello World! ID"+id;
    }

}
```

<br/>

- 결과

![](readmeFile/img_30.png)

> required = false는 이 매개변수가 꼭 필요한 것은 아니라는 뜻


<br/>
<br/>

- RequestParam을 이용한 매개변수 전달

![](readmeFile/img_29.png)

<br/>

- 결과

![](readmeFile/img_31.png)


<br/>
<br/>

- RequestBody을 이용한 JSON 전달

반환하고자 하는 리소스가 복잡할 때. (오브젝트 등)

![](readmeFile/img_32.png)


```java
package com.example.react_springboot_server.dto;

import lombok.Data;

@Data
public class TestRequestDTO {
    private int id;
    private String message;
}
```


```java
package com.example.react_springboot_server.controller;

import com.example.react_springboot_server.dto.TestRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test") // 리소스
public class TestController {


    /*....*/
    
    @GetMapping("/testRequestBody")
    public String testControllerRequestBody(@RequestBody TestRequestDTO testRequestDTO) {
        return "Hello World! ID " + testRequestDTO.getId() + "Message : " + testRequestDTO.getMessage();
    }

}
```

<br/>

|키워드| 설명                                                                                                              |
|:---|:----------------------------------------------------------------------------------------------------------------|
|@RequestBody TestRequestDTO testRequestDTO| ✏ RequestBody로 보내는 JSON을 TestRequestBodyDTO 오브젝트로 변환해 가져오라 <br/> ✏ JSON의 내부 구조는 의미적으로 TestRequestBodyDTO와 같아야 함 |

> 예를 들어 JSON을 { id: 실수 } 이렇게 넘겨주면 에러가 발생함.


<br/>

- 테스트

![](readmeFile/img_33.png)


<br/>
<br/>

- ResponseBody 이용한 오브젝트 반환 (JSON 반환)

@RestController의 내부는 다음과 같음

```java
@Controller
@ResponseBody
public @interface RestController {
    // ...
}
```

<br/>

| 키워드         | 설명                                                                                                        |
|:------------|:----------------------------------------------------------------------------------------------------------|
| @Controller | @Component로 스프링이 이 클래스의 오브젝트를 알아서 생성하고 다른 오브젝트들과의 의존성을 연결한다                                               |
| @ResponseBody          | 이 클래스의 메서드가 리턴하는 것은 웹 서비스의 ResponseBody이다. -> 메서드가 리턴할 때 스프링은 리턴된 오브젝트를 JSON 형태로 바꾸고 HttpResponse에 담아 반환함 |


<br/>

- ResponseDTO를 반환하는 컨트롤러 메서드

```java
package com.example.react_springboot_server.controller;

import com.example.react_springboot_server.dto.ResponseDTO;
import com.example.react_springboot_server.dto.TestRequestDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test") // 리소스
public class TestController {


    // ...
    
    @GetMapping("/testResponseBody")
    public ResponseDTO<String> testControllerResponseBody() {
        List<String> list = new ArrayList<>();
        list.add("Hello Wolrd! I'm ResponseDTO");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return response;
    }

}
```

<br/>

- ResponseDTO를 반환하는 컨트롤러 메서드 - 결과

![](readmeFile/img_34.png)

<br/>
<br/>

- ResponseEntity를 이용한 HTTP 응답 바디, 매개변수 조작

```java
package com.example.react_springboot_server.controller;

import com.example.react_springboot_server.dto.ResponseDTO;
import com.example.react_springboot_server.dto.TestRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test") // 리소스
public class TestController {

    // ...
    
    @GetMapping("/testReponseEntity")
    public ResponseEntity<?> testControllerResponseEntity() {
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm Response Entity. And you got 400!");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        // http status를 400으로 설정
        return ResponseEntity.badRequest().body(response);
    }

}

```

<br/>

- 결과

![](readmeFile/img_35.png)


<br/>
<br/>

- ResponseEntity를 이용한 HTTP 응답 바디, 매개변수 조작 - OK 

```java
package com.example.react_springboot_server.controller;

import com.example.react_springboot_server.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("todo")
public class TodoController {

    @GetMapping("/testTodo")
    public ResponseEntity<?> testTodo() {
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm Response Entity. And you got 200!");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        // http status를 200으로 설정
        return ResponseEntity.ok().body(response);
    }

}
```

<br/>

- 결과

![](readmeFile/img_36.png)


<br/>
<br/>
<br/>

### 2.2.5 서비스 레이어 : 비즈니스 로직

서비스 레이어는 컨트롤러와 퍼시스턴스 사이에서 비즈니스 로직을 수행하는 역할을 함.

<br/>

- TodoService

```java
package com.example.react_springboot_server.service;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    public String testService() {
        return "Test Service";
    }
    
}
```

|키워드| 설명                                                                              |
|:---|:--------------------------------------------------------------------------------|
|@Service| @Service는 내부에 @Componenet를 갖고 있으며, @Service는 기능적으로로 비즈니스 로직을 수행하는 서비스 레이어임을 알려줌 |

<br/>

- TodoService

```java
package com.example.react_springboot_server.controller;

import com.example.react_springboot_server.dto.ResponseDTO;
import com.example.react_springboot_server.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("todo")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping("/test")
    public ResponseEntity<?> testTodo() {
        String str = service.testService(); // 테스트 서비스 사용
        List<String> list = new ArrayList<>();
        list.add(str);
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return ResponseEntity.ok().body(response);
    }

}

```

|키워드| 설명                                                 |
|:---|:---------------------------------------------------|
|@Autowired| @Autowired이 알아서 빈을 찾은 다음 그 빈을 이 인스턴스 멤버 변수에 연결하라 ! |

<br/>

- 테스팅

![](readmeFile/img_37.png)


<br/>
<br/>
<br/>

### 2.2.6 퍼시스턴스 레이어 : 스프링 데이터 JPA

<br/>

- 데이터베이스와 스프링 데이터 JPA 설정

<br/>

- build.gradle h2 디펜던시 추가
 
```groovy
dependencies {
    /*...*/
    runtimeOnly 'com.h2database:h2'
}
```

H2는 In-Memory 데이터베이스로 로컬 환경에서 메모리상에 데이터베이스를 구축해줌. 

<br/>

- spring-boot-starter-data-jpa 디펜던시 추가

```groovy
dependencies {
    // ...
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
}
```

<br/>


- h2 데이터베이스가 잘 추가되었는지 확인

```shell
2022-10-03 18:06:19.570  INFO 12576 --- [  restartedMain] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2022-10-03 18:06:19.602  INFO 12576 --- [  restartedMain] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 5.6.10.Final
2022-10-03 18:06:19.714  INFO 12576 --- [  restartedMain] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
2022-10-03 18:06:19.799  INFO 12576 --- [  restartedMain] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.H2Dialect
2022-10-03 18:06:19.928  INFO 12576 --- [  restartedMain] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal
```

> JPA Provider로 Hibernate ORM을 사용하는 것과 데이터베이스로 h2를 사용한다는 것을 확인할 수 있음.


<br/>

- 엔티티 클래스

하나의 엔티티 인스턴스는 데이터베이스 테이블의 한 행에 해당함

![](readmeFile/img_38.png)

엔티티 클래스는 그 자체가 테이블을 정의해야 하며, 테이블 스키마 관련 정보는 JPA 관련 어노테이션을 이용해 정의해야 함.



<br/>

- TodoEntity

```java
package com.example.react_springboot_server.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Todo")
public class TodoEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id; // 이 오브젝트의 아이디
    private String userId; // 이 오브젝트를 생성한 사용자의 아이디
    private String title; // Todo 타이틀 (예: 운동하기)
    private boolean done; // true - todo를 완료한 경우 (checked)
}
```

| 키워드                                                        | 설명                                                           |
|:-----------------------------------------------------------|:-------------------------------------------------------------|
| @Entity("~~~")                                             | 엔티티 이름 지정 가능                                                 |
|@Id| pk 지정                                                        |
|@Table(name = "Todo")| 테이블 이름 Todo로 지정, 지정 안하면 보통 클래스 이름 따라감 (db마다 규칙이 다른데 그거 준수해서) |
| @GeneratedValue(generator = "system-uuid")                 | ID 자동 생성                                                     |
| @GenericGenerator(name = "system-uuid", strategy = "uuid") | ID 생성 방식 지정 (uuid)                                           |


> 기본 Generator로는 INCREMENTAL, SEQUENCE, IDENTITY 등이 있는데 문자열 형태의 UUID 사용을 위해 커스텀 generator를 만듦

<br/>

- TodoRepository

```java
package com.example.react_springboot_server.persistance;

import com.example.react_springboot_server.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {
}
```

| 키워드                                       | 설명                                        |
|:------------------------------------------|:------------------------------------------|
|@Repository| 얘 또한 @Component의 특별 케이스임                  |
| JpaRepository<TodoEntity, String> | JpaRepository<매핑될 엔티티 클래스, 매핑될 엔티티 pk 타입> |

<br/>

- TodoService에서 TodoRepository 사용


```java
package com.example.react_springboot_server.service;

import com.example.react_springboot_server.model.TodoEntity;
import com.example.react_springboot_server.persistance.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public String testService() {
        // TodoEntity 생성
        TodoEntity entity = TodoEntity.builder().title("My first todo item").build();
        // TodoEntity 저장
        repository.save(entity);
        // TodoEntity 검색
        TodoEntity savedEntity = repository.findById(entity.getId()).get();
        return savedEntity.getTitle();
    }

}
```

<br/>

- TodoService에서 TodoRepository 테스트

![](readmeFile/img_39.png)




































<br/>

|키워드| 설명  |
|:---|:----|
|||
































