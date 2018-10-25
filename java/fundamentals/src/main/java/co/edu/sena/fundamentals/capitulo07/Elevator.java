package co.edu.sena.fundamentals.capitulo07;

public class Elevator {

  public boolean doorOpen=false; // Doors are closed by default
  public int currentFloor = 1; // All elevators start on first floor
  public final int TOP_FLOOR = 10;
  public final int MIN_FLOORS = 1;
  
  public void openDoor() {
      System.out.println(this.currentFloor==this.MIN_FLOORS ? "No se puede bajar":"si se puede bajar");
    if(this.doorOpen==false && this.currentFloor>this.MIN_FLOORS) {
      System.out.println("Opening door.");
      doorOpen = true;
      System.out.println("Door is open.");
    }else{
      System.out.println("no se puede abrir la puerta por que ya esta abierta");
    }
  }
  
  public void closeDoor() {
    System.out.println("Closing door.");
    doorOpen = false;
    System.out.println("Door is closed.");
  }

  public void goUp() {
      System.out.println(this.currentFloor==this.TOP_FLOOR ? "No se puede subir":"si se puede subir");
    if(this.doorOpen==false && this.currentFloor<this.TOP_FLOOR){
    System.out.println("Going up one floor.");
    currentFloor++;
    System.out.println("Floor: " + currentFloor);
    }else{
      System.out.println("no puedo subir la puerta esta abierta");
    }
  }

  public void goDown() {
    if(this.doorOpen==false) {
      System.out.println("Going down one floor.");
      currentFloor--;
      System.out.println("Floor: " + currentFloor);
    }else{
      System.out.println("no puedo subir la puerta esta abierta");
    }
  }


}
