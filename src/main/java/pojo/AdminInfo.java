package pojo;

public class AdminInfo {
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public AdminInfo(String info) {
        this.info = info;
    }

    public AdminInfo() {
        System.out.println("adminInfo被创建了。。。");
    }

    @Override
    public String toString() {
        return "AdminInfo{" +
                "info='" + info + '\'' +
                '}';
    }
}
