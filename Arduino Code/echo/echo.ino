#include <SoftwareSerial.h>
#include <SPI.h>
#include <MFRC522.h>
#include <Wire.h>
#include <LiquidCrystal_I2C.h>

LiquidCrystal_I2C lcd(0x27,20,4); 
#define SS_PIN 10
#define RST_PIN 9
MFRC522 rfid(SS_PIN, RST_PIN); // Instance of the class
MFRC522::MIFARE_Key key; 
byte nuidPICC[4];


const String SSID = "cha";
const String PASSWORD = "12345678";
const String SERVER_IP = "192.168.0.53";
const String SERVER_PORT = "8081";


String cmd = "";
String sendData = "";
boolean FAIL_8266 = false;
String readData = "";
// TX, RX
SoftwareSerial esp(3, 2);


void setup() {
  lcd.init();
  lcd.backlight();
  Serial.begin(9600);
  Serial.println("Start module connection");
  //lcd
  lcd.begin(16, 2);
  lcd.print("Adugen_Mart");
  lcd.setCursor(6, 1);
  lcd.print("Welcome_S2");
  
  SPI.begin(); // Init SPI bus
  rfid.PCD_Init(); // Init MFRC522 
  
  for (byte i = 0; i < 6; i++) {
    key.keyByte[i] = 0xFF;
  }
  
  Serial.println(F("This code scan the MIFARE Classsic NUID."));
  Serial.print(F("Using the following key:"));
  printHex(key.keyByte, MFRC522::MF_KEY_SIZE);
  delay(1000);

  lcd.setCursor(0, 1);
  lcd.print("Wifi Connect....");
  
  delay(500);
  lcd.clear();
  lcd.setCursor(0, 0);
  lcd.print("Wifi Connect....");
  
  
  //
  do {
    Serial.println("dowhile");
    esp.begin(9600);
    // ESP8266 모듈 재시작
    esp.println("AT+RST");
    delay(1000);
    // 만약 재시작되었다면
    if (esp.find("ready")) {
      Serial.println("Module ready");
      // ESP8266 모듈의 모드를 듀얼모드로 설정 (클라이언트)
      esp.println("AT+CWMODE=1");
      delay(2000);
      // AP에 접속되면
      if (cwJoinAP()) {
        Serial.println("AP successful");
        
        
        FAIL_8266 = false;
        delay(5000);
        Serial.println("Start buffer initialization");
        while (esp.available() > 0) {
          char a = esp.read();
          Serial.write(a);
        }
        Serial.println();
        Serial.println("Buffer initialization terminated");
        
      } else {
        Serial.println("AP connection failure");
        delay(500);
        FAIL_8266 = true;
      }
    } else {
      Serial.println("Module connection failure");
      delay(500);
      FAIL_8266 = true;
    }
  } while (FAIL_8266);
  Serial.println("Module connection complete");
  
}

boolean a = true;
String message = "";
int count_data = 0;
int login=0;
int forloginone=0;

void loop() {
    //Sensor
    
    
    
 
    //lcd
    if(login==0){
    lcd.clear();
    lcd.setCursor(0, 0);
    lcd.print("Echobag Ready^_^");
    //lcd.setCursor(0, 1);
    //lcd.print(millis() / 1000);
    rfidstart();
    }else if(login==1){

      if(forloginone==0){
        lcd.clear();
        forloginone=1;
      }
      
      lcd.setCursor(0, 0);
      lcd.print(readData); 
      readData="";


           
      lcd.setCursor(0, 1);
      lcd.print("Coupon Create!");
      delay(5000);
      login=0;
      forloginone=0;
      
      
      
    }



   

  //wifi
  if(message!=""){
  sendDataToServer(message);
  message="";
  }
 

}

int readon = 0;
boolean check = false;



void rfidstart(){

    

  //rfid
  // Reset the loop if no new card present on the sensor/reader. This saves the entire process when idle.
  if ( ! rfid.PICC_IsNewCardPresent())
    return;

  // Verify if the NUID has been readed
  if ( ! rfid.PICC_ReadCardSerial())
    return;

  Serial.print(F("PICC type: "));
  MFRC522::PICC_Type piccType = rfid.PICC_GetType(rfid.uid.sak);
  Serial.println(rfid.PICC_GetTypeName(piccType));

  // Check is the PICC of Classic MIFARE type
  if (piccType != MFRC522::PICC_TYPE_MIFARE_MINI &&  
    piccType != MFRC522::PICC_TYPE_MIFARE_1K &&
    piccType != MFRC522::PICC_TYPE_MIFARE_4K) {
    Serial.println(F("Your tag is not of type MIFARE Classic."));
    return;
  }

 
    Serial.println(F("Card Reading"));
    //lcd
    lcd.clear();
    lcd.setCursor(0, 0);
    lcd.print("Card Reading...");
    // Store NUID into nuidPICC array
    for (byte i = 0; i < 4; i++) {
      nuidPICC[i] = rfid.uid.uidByte[i];
      message+=rfid.uid.uidByte[i];
    }
   
    //Serial.println(F("The NUID tag is:"));
    //Serial.print(F("In hex: "));
    //printHex(rfid.uid.uidByte, rfid.uid.size);
    Serial.println();
    Serial.print(F("In dec: "));
    printDec(rfid.uid.uidByte, rfid.uid.size);
    Serial.println();
 

  // Halt PICC
  rfid.PICC_HaltA();

  // Stop encryption on PCD
  rfid.PCD_StopCrypto1();

  Serial.println(message);
  
  
  
  }



void sendDataToServer(String data) {
  Serial.println("Start the data transfer part");
  cmd = "AT+CIPSTART=\"TCP\",\"" + SERVER_IP + "\"," + SERVER_PORT + "\r\n";
  Serial.println("Attempt to connect to server");
  esp.println(cmd);
  // 웹 서버에 접속되면
  if (esp.find("OK")) {
    Serial.println("Server connection successful");
  } else {
    Serial.println("Server connection failed");
  }

  // 서버로 GET 메시지 전송
  cmd = "GET /Northbears/echo.do?echo=";
  cmd += data;
  //cmd = "GET /wifi/wifi";
  cmd += "\r\nConnection: close\r\n\r\n";

  Serial.println(cmd);
  esp.print("AT+CIPSEND=");
  esp.println(cmd.length());
  if (esp.find("OK")) {
    Serial.println("Ready to send to server");
  } else {
    Serial.println("Failed to prepare to send to server");
  }
  esp.println(cmd);

  //데이터 전송이 완료되면
  if (esp.find("OK")) {
    Serial.println("Data transfer successful");
    Serial.println();
    delay(5000);
    Serial.println("Attempt to receive data");
    Serial.println();
    Serial.println();
    
    while (esp.available()) {
      char c = esp.read();
      //Serial.write(c);
      if (c == '/') {
        check = !check;
      } else if (check) {
        readData += c;
      }
    }
    


    
    Serial.println();
    Serial.println("End Receiving Data");
      //lcd
    //lcd.clear();
    //lcd.setCursor(0, 0);
    //lcd.print(readData);
    //lcd.setCursor(0, 1);
    //lcd.print("Plz put trash");
    //delay(2000);
    login=1;
  } else {
    Serial.println("Data transfer failed");
    sendDataToServer(data);
  }
  delay(1000);
}

boolean cwJoinAP() {
  String cmd = "AT+CWJAP=\"" + SSID + "\",\"" + PASSWORD + "\"";
  esp.println(cmd);
  if (esp.find("OK")) {
    return true;
  } else {
    return false;
  }
}




void printHex(byte *buffer, byte bufferSize) {
  for (byte i = 0; i < bufferSize; i++) {
    Serial.print(buffer[i] < 0x10 ? " 0" : " ");
    Serial.print(buffer[i], HEX);
  }
}




void printDec(byte *buffer, byte bufferSize) {
  for (byte i = 0; i < bufferSize; i++) {
    Serial.print(buffer[i] < 0x10 ? " 0" : " ");
    Serial.print(buffer[i], DEC);
  }
}
