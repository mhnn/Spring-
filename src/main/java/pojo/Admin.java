package pojo;

import java.io.Serializable;
import java.util.List;

public class Admin implements Serializable {
    private Integer aId;
    private String aName;
    private String aPassword;
    private AdminInfo adminInfo;
    private List<Book> books;
    private Car car;

    public Admin(Car car) {
        System.out.println("调用了可以为car赋值的有参构造器。。。");
        this.car = car;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aId=" + aId +
                ", aName='" + aName + '\'' +
                ", aPassword='" + aPassword + '\'' +
                ", adminInfo=" + adminInfo +
                ", books=" + books +
                ", car=" + car +
                '}';
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Admin() {
        System.out.println("admin被创建了。。。");
    }

    public Admin(String aName, String aPassword, AdminInfo adminInfo) {
        this.aName = aName;
        this.aPassword = aPassword;
        this.adminInfo = adminInfo;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword;
    }

    public AdminInfo getAdminInfo() {
        return adminInfo;
    }

    public void setAdminInfo(AdminInfo adminInfo) {
        this.adminInfo = adminInfo;
    }

}
