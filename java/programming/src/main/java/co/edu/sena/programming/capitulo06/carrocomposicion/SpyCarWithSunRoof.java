package co.edu.sena.programming.capitulo06.carrocomposicion;


public class SpyCarWithSunRoof {  
    private BasicCar car = new BasicCar();
    private SpyCarAddon spyAddon = new SpyCarAddon();
    private SunRoofAddon roofAddon = new SunRoofAddon();

    public void start() {
        car.start();
    }

    public void openSunRoof() {
        roofAddon.openSunRoof();
    }

    
}