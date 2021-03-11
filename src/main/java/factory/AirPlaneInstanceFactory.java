package factory;

import pojo.AirPlane;

/**
 * 实例工厂
 */
public class AirPlaneInstanceFactory {
    //new AirPlaneInstanceFactory.getAirPlane()
    public  AirPlane getAirPlane(String jzName){
        System.out.println("AirPlaneInstanceFactory正在造飞机...");
        AirPlane airPlane = new AirPlane();
        airPlane.setFdj("太行");
        airPlane.setFjsName("lfy");
        airPlane.setJzName(jzName);
        airPlane.setPersonNumber(300);
        airPlane.setYc("198.98m");
        return airPlane;
    }
}
