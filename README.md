<h1>Smart Kiosk Using AWS Rekognition</h1>
<p>This system consists of an Android app and a Spring Boot server.</p>
<li>The Android app captures a user's photo using the camera module.</li>
<li>The photo is then sent to the Spring Boot server and deleted from the device and server.</li>
<li>The server analyzes the user's age and gender based on the image and sends a personalized menu list to the app.</li>

##사용 기술

- 백엔드 서버: Spring Boot, MySQL

- 프론트엔드 / 클라이언트: 안드로이드 앱 (Retrofit 기반 HTTP 통신), 카메라 모듈

- 하드웨어 / 통합 테스트 환경: 안드로이드 기반 키오스크

##핵심 기능

- 안드로이드 키오스크에서 사용자 이미지 수집 및 서버 전송

- AWS Rekognition API를 활용한 성별·연령 분석

- 분석 결과 기반 맞춤형 메뉴 추천
    
![Image](https://github.com/user-attachments/assets/fb672935-6b6e-4b3f-9d30-913c062cf070)
