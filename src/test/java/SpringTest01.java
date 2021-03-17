import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Admin;
import pojo.AdminInfo;
import service.AdminService;

import javax.sql.DataSource;
import java.sql.SQLException;

public class SpringTest01 {
//    ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//    ApplicationContext ac = new ClassPathXmlApplicationContext("beans02.xml");
//    ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext03.xml");

    /**
     * 测试Spring的IOC
     */
    @Test
    public void testIoc(){
        //通过Spring获取Admin类的实例
        //方法一：通过id值
        Admin admin = (Admin)ac.getBean("admin");
        System.out.println(admin);
        //方法二：通过bean的字节码对象
        Admin admin1 = ac.getBean(Admin.class);
        System.out.println(admin1);
    }

    /**
     * spring中默认都是单实例的
     * 单实例：加载完beans.xml后，立即创建所有单实例的对象
     *          会存到beanPool中（底层是Map）
     *          key就是id，value就是实例对象
     *          在Spring容器销毁时跟着销毁（服务器关闭时，Spring容器会销毁）
     * 多实例：容器去获取实例对象时才会创建
     *          不会存到bean池
     *          多实例的bean销毁不归Spring容器管
     *          在一个方法结束后，其内的局部变量将变为游离/不可达对象
     *          在jvm的垃圾回收机制中，扫描到这个对象时，就会对其进行回收
     * 多实例开启方式：
     *  在要实现多实例的bean上加入scope="prototype"，即可变成多实例，
     *  默认单实例
     */
    /**
     * 如果一个对象使用的频次特别高，建议使用单实例
     * 反之，使用多实例
     * 多线程问题。。。
     */
    @Test
    public void testScope(){
        Admin admin = ac.getBean(Admin.class);
        Admin admin1 = ac.getBean(Admin.class);
        if (admin == admin1){
            System.out.println("Admin类是单实例");
        }else {
            System.out.println("Admin是多实例");
        }
    }
    /**
     * 测试DI
     */
    /**
     * bean中是property
     * 如果是基本数据类型，就是set方法注入
     * 如果是引用类型，就是构造方法注入/赋值
     *bean中是constructor-arg
     * 找寻合适的构造方法进行注入
     */
    @Test
    public void testDI(){
        Admin admin = ac.getBean(Admin.class);
        System.out.println(admin);

        AdminService adminService = ac.getBean(AdminService.class);
        System.out.println(adminService);//service获取成功，但其中dao变量还是null

    }
    @Test
    public void testAdmin2(){
        Admin admin2 =(Admin) ac.getBean("admin2");
        AdminInfo adminInfo = (AdminInfo)ac.getBean("adminInfo");
        System.out.println("adminInfo默认值："+adminInfo);//会被修改
        System.out.println(admin2);//会被修改
        /**
         * 因为在beans中是引用的adminInfo
         */
    }

    /**
     * 测试bean的重用
     */
    @Test
     public void testParent(){
        Admin admin =(Admin) ac.getBean("admin");
        Admin admin3 =(Admin) ac.getBean("admin3");
        System.out.println(admin);
        System.out.println(admin3);
    }

    /**
     * 所谓bean的依赖其实就是bean的创建顺序
     */
    @Test
    public void testBeanDep(){
        /**
         * 和bean中先后顺序一样
         * 按照bean的顺序创建
         */
        /**
         * 可以改变bean的创建顺序
         */
    }

    /**
     * 测试bean工厂
     */
    @Test
    public void testBeanFactory() {
//        Object airPlane = ac.getBean("airPlane");
//        System.out.println(airPlane.getClass());    //AirPlane
//        System.out.println(airPlane);   //AirPlane{fdj='太行', yc='198.98m', personNumber=300, jzName='张三', fjsName='lfy'}
        Object airPlane2 = ac.getBean("airPlane2");

        System.out.println("容器启动完成..."+airPlane2);

    }
    @Test
    public void testFactoryBean() {
        Object factoryBeanImple = ac.getBean("myFactoryBeanImple");
        System.out.println(factoryBeanImple);
    }
    @Test
    public void testComboPool() throws SQLException {
        //1、从容器中拿到连接池
//        DataSource dataSource = (DataSource)ac.getBean("dataSource");
        //2、按类型获取组件，可以获取到这个类型下所有子类的实现等等..
        DataSource dataSource1 = ac.getBean(DataSource.class);

        System.out.println(dataSource1.getConnection());
    }

    /**
     * 测试自动装配（xml）
     */
    @Test
    public void testAutoWiredByXml(){
        Admin admin = ac.getBean(Admin.class);
        System.out.println(admin);
    }

}
