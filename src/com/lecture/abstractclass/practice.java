package com.lecture.abstractclass;

abstract class Device{
    int deviceId;

    abstract void deviceInfo();
    abstract void connect();
    abstract void disconnect();
    abstract void send();
    abstract void receive();

}

class UsbProt1 extends Device{
    UsbProt1(int id){
        this.deviceId= id;
    }
    void deviceInfo(){
        System.out.println("deviceId"+ deviceId);
    }
    void connect(){
        System.out.println("연결 하였습니다.");
    }
    void disconnect(){
        System.out.println("연결이 해제되었습니다.");
    }

    void send() {
        System.out.println("데이터를 전송합니다.");
    }

    void receive() {
        System.out.println("데이터를 수신합니다.");
    }
}

class Wifi extends Device{
    public Wifi(int id){
        this.deviceId=id;
    }

    @Override
    void deviceInfo() {

    }

    @Override
    void connect() {

    }

    @Override
    void disconnect() {

    }

    @Override
    void send() {

    }

    @Override
    void receive() {

    }
}
public class practice {
    public static void main(String[] args){

        UsbProt1 usb1 = new UsbProt1(1);
    }
}
