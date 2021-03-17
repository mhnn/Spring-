package factory;

import org.springframework.beans.factory.FactoryBean;
import pojo.Book;

import java.util.UUID;

/**
 * 实现了FactoryBean接口的类是Spring可以认识的工厂类
 * spring会自动地调用工厂方法创建实例
 *
 * 1、编写一个FactoryBean的实现类
 * 2、在spring配置文件中注册
 * 3、FactoryBean的实现类无论单多实例，在容器启动时都不会创建实现的对象
 */
public class MyFactoryBeanImple implements FactoryBean<Book> {
    /**
     * 是单例吗
     * @return
     */
    @Override
    public boolean isSingleton() {
        return false;
    }

    /**
     * 工厂方法
     * Spring自动调用
     * 返回创建的对象
     * @return
     * @throws Exception
     */
    @Override
    public Book getObject() throws Exception {
        System.out.println("myFactoryBean为你创建对象...");
        Book book = new Book();
        book.setId(202103);
        return book;
    }

    /**
     * 返回创建对象的类型
     * spring自动调用来确认创建的对象是什么类型
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }
}
