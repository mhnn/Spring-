package pojo;

import java.io.Serializable;

public class Admin implements Serializable {
    private Integer aId;
    private String aName;
    private String aPassword;
    private AdminInfo adminInfo;

    public Admin() {
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

    @Override
    public String toString() {
        return "Admin{" +
                "aId=" + aId +
                ", aName='" + aName + '\'' +
                ", aPassword='" + aPassword + '\'' +
                ", adminInfo=" + adminInfo +
                '}';
    }
}
