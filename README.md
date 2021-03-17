# 声明式事务

> 项目结构：
>
> Dao：进行sql语句的执行
>
> Service：进行Dao层的调用并打印结果
>
> resources-applicationContext.xml：启用包扫描，引入外部配置文件，配置数据库连接池，配置JdbcTemplate
>
> test-java-JdbcTemplateTest：测试

声明式事务：

​		以前通过复杂的编程来编写一个事务，替换为只需要告诉Spring哪个方法是事务方法即可；

​		Spring自动进行事务控制；

编程式事务：

* 弊端：需要自己拦截那些需要进行事务控制的方法

```java
TransactionFilter{

	try{

		//获取连接

		//设置非自动提交

		chain.doFilter();

		//提交

	}catch(Exception e){

		//回滚

	}finally{

		//关闭连接释放资源

}

}
```

---

AOP：环绕通知可以去做；

```java
	//获取连接
	//设置非自动提交
	目标代码执行
    //正常提交
    //异常回滚
    //最终关闭
```

最终效果：

```java
//我们只需要在需要进行事务控制的方法上添加一行注解
BookService{
    @this is a txmethod(Transactional)
    public void checkout(){
        //xxxx
    }
}
```

**事务管理代码的<u>固定模式</u>作为一种<u>横切关注点</u>，可以通过AOP方法模块化，进而借助<u>Spring AOP框架</u>实现声明式事务管理。**

自己要写切面还是很麻烦；在多线程下每个人拿的Connection都不一样，所以需要保证线程同步，还要感知到每个线程的异常，决定哪些回滚哪些不要回滚；

故这个切面已经有了；（事务切面===事务管理器）；

`DataSourceTransactionManager`这个事务管理器就可以在目标方法运行前后进行事务控制（事务切面）；

我们目前都使用这个类；即可；spring也提供了其他数据源对应的类入jpa等

---

快速地位某个方法添加事务：

1. 配置出这个事务管理器，让他工作；