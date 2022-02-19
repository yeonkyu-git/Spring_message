## 스프링 메시지 및 국제화 

### 설명 
1. 스프링에는 메시지 및 국제화 기능이 지원된다.
2. 스프링부트는 Http Request에 Accept-langauge 를 보고 값을 셋팅한다.
3. 해당 플젝은 CookieLocaleResolver 를 통해 쿠키 값으로 언어를 셋팅한다.
4. 사용자가 한국어 또는 영어를 선택할 수 있다.
5. 만약 사용자가 언어를 변경하면, 인터셉터에서 LocaleChangeInterceptor가 default언어를 재 셋팅한다. 
6. 메시지는 셋팅된 언어를 바탕으로 보여준다. 
7. LocaleChangeInterceptor는 HandlerInterceptor를 상속받아 스프링에서 구현해놓았다.
8. Locale 변경시에 Interceptor의 preHandler가 동작하는데, 매번 언어 값을 셋팅하는 것이 아니라 Cookie (lang)이 변경될 때만 언어셋을 바꾼다.
    - LocaleChangeInterceptor 에서 그렇게 구현해놓았다. 
    - 다만 Interceptor의 prehandler는 무조건 들어간다. 