# modu_practice

현재 설계 구조 <br>
------------
![ex_screenshot](./modu_MSA_architecture.drawio.png) <br>

1. 클라이언트 서버가 인가서버와 통신하며 로그인 성공하여 인가서버로부터 JWT 토큰을 가지고 옴.
2. 이 토큰을 가지고 API 자원 서버에 자원을 요청함.
3. API 서버는 클라이언트 서버가 제시한 토큰이 올바른지 확인하기 위하여 인가서버에 /oauth2/jwks 요청을 함으로써 jwk (Json Web Key) 를 받아오고, 이것을 토대로 JWT를 검증함.
4. 토큰이 검증에 성공할 경우 API 서버에서 시큐리티를 통과하고 MVC 로 가서 자원을 response 해줌.
