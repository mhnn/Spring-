package factory;

import pojo.AirPlane;

/**
 * 静态工厂
 */
public class AirPlaneStaticFactory {
    //静态工厂
    //AirPlaneStaticFactory.getAirPlane
    public static AirPlane getAirPlane(String jzName){
        System.out.println("AirPlaneStaticFactory正在为你造飞机....");
        AirPlane airPlane = new AirPlane();
        airPlane.setFdj("太行");
        airPlane.setFjsName("lfy");
        airPlane.setJzName(jzName);
        airPlane.setPersonNumber(300);
        airPlane.setYc("198.98m");
        return airPlane;
    }
}
