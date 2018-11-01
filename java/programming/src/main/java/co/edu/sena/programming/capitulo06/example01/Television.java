package co.edu.sena.programming.capitulo06.example01;

public class Television extends java.lang.Object implements ElectronicDevice {

    public void turnOn() {
        changeChannel(1);
        initializeScreen();
    }
    public void turnOff() { }
    
    public void changeChannel(int channel) {}
    private void initializeScreen() {}
    
}