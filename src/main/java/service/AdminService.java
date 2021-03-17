package service;

import com.atguigu.dao.AdminDao;

public class AdminService {
    AdminDao adminDao;

    public AdminDao getAdminDao() {
        return adminDao;
    }

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public String toString() {
        return "AdminService{" +
                "adminDao=" + adminDao +
                '}';
    }
}
