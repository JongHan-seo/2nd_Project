# 2차 프로젝트

### 아두이노를 활용한 환경보호참여  프로젝트<br>
**(팀장(고영주) / 팀원(김서정, 김수용, 김진아, 서종한, 차송연 )**
### 역할
서종한 : DB설계 및 MVC 패턴을 이용해 웹 기능 구현 

<a href = "https://youtu.be/q0w8_9IflzE">
  <b>>>시연영상 바로보기 (링크)</b>
</a><br><br>

### 1. 제안 배경 및 필요성
<p>▪ 환경오염으로 인해 지구온난화로 이상기후, 북극곰의 멸종위기에 처한 현실을 상기시키고<br> &ensp;&ensp;그럼으로써 매일같이 환경보호를 위한 노력을 생활화함을 목표<br>
▪ 다양한 환경보호 활동을 권장 </p>

### 2. 제안 내용
<p>▪ 에코백에 RFID칩을 삽입하여 리더기에서 인식.<br>
▪ 분리수거 통에 적외선 감지 센서를 부착하여 분리수거를 권장함 <br>
▪ RFID칩을 삽입한 텀블러가 자판기가 인식하여 기존 종이컵이 나오지 않고, 텀블러에 음료수가 담김(종이컵 절약)<br>
▪ 콘센트에 근접센서를 부착하여 사용하지 않는, 절약한 전력을 알 수 있음.<br>
▪ 위의 행동들을 수행했을 시 포인트가 쌓임<br>
▪ 쌓인 포인트로 녹은 빙하가 회복되고, 헤어진 북극곰 가족들이 만남.
 </p>
 
 ### 3. 프로젝트 결과
<p>▪ 에코백에 RFID칩을 삽입하여 리더기에서 인식하기 성공.<br>
▪ 쓰레기통에 적외선 감지 센서를 부착하여 인식 성공  <br>
▪ RFID칩을 삽입한 텀블러를 자판기가 인식하여 기존 종이컵이 나오지 않고 텀블러에 음료담기 성공<br>
▪ 위의 행동들을 수행했을 시 DB에 정보가 담겨 웹에 나타남<br>
▪ 각 사용자 별로 포인트를 웹에 나타내고 포인트가 올라가고 스토리의 사진이 변화함<br>
▪ 로그인, 회원가입, 사용자의 정보 변경, 공지사항, 게시판 기능 구현
 </p>
 
 ### 4. 유스케이스 , ER 다이어그램
 
 
![ER다이어그램](https://user-images.githubusercontent.com/71308696/104152375-afccfc00-5422-11eb-86d8-422e351de98f.PNG)
![유스케이스1108](https://user-images.githubusercontent.com/71308696/104152377-b196bf80-5422-11eb-97b8-4d32af6b97e4.png)
 
 
 ### 5. 구현

- 시연영상(클릭시 재생)
<a href = "https://youtu.be/q0w8_9IflzE">
  <img src = "https://user-images.githubusercontent.com/71308696/104132094-8d08fc00-53be-11eb-834a-cf67a5492cf8.PNG">
</a>




![쓰레기통](https://user-images.githubusercontent.com/71308696/104153133-e7d53e80-5424-11eb-9f36-070d830362f8.PNG)
![자판기](https://user-images.githubusercontent.com/71308696/104153139-ead02f00-5424-11eb-8deb-5f5a87dd8c9e.PNG)
![에코백](https://user-images.githubusercontent.com/71308696/104153141-eb68c580-5424-11eb-9445-43b62c9c36da.PNG)

![main](https://user-images.githubusercontent.com/71308696/104132094-8d08fc00-53be-11eb-834a-cf67a5492cf8.PNG)
![join_1](https://user-images.githubusercontent.com/71308696/104132089-8bd7cf00-53be-11eb-90a9-09adbafe54f4.PNG)
![join_2](https://user-images.githubusercontent.com/71308696/104132090-8c706580-53be-11eb-82f2-8ba7f6a1f1ee.PNG)
![login](https://user-images.githubusercontent.com/71308696/104132091-8c706580-53be-11eb-9b64-c3c9030cdc1d.PNG)
![userinfo](https://user-images.githubusercontent.com/71308696/104132097-8da19280-53be-11eb-9ce6-37dd0060d41a.PNG)
![Notice](https://user-images.githubusercontent.com/71308696/104132095-8da19280-53be-11eb-8567-9ebfff6728a0.PNG)
![usermain_1](https://user-images.githubusercontent.com/71308696/104132103-8ed2bf80-53be-11eb-882f-b9c9c2e6f905.PNG)
![userinfo_stage4](https://user-images.githubusercontent.com/71308696/104132099-8e3a2900-53be-11eb-8aa6-c6f96044f953.PNG)




