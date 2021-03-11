import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Admin;
import service.AdminService;

public class SpringTest01 {
    ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
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
}
