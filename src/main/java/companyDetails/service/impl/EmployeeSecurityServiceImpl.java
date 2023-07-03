package companyDetails.service.impl;
import companyDetails.dao.EmployeeSecurityDao;
import companyDetails.model.EmployeeSecurity;
import companyDetails.service.EmployeeSecurityService;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EmployeeSecurityServiceImpl implements EmployeeSecurityService {
    private EmployeeSecurityDao employeeSecurityDao;

    @Override
    public int role(EmployeeSecurity employeeSecurity) {
        return employeeSecurityDao.role(employeeSecurity);
    }

    public String encryptPassword(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String hashcode = bCryptPasswordEncoder.encode(password);
        return hashcode;
    }

    @Override
    public EmployeeSecurity getUserdetailsbyid(Principal id)
    {
        return employeeSecurityDao.getRegistredDetailsbyid(id);
    }

    public EmployeeSecurityDao getEmployeeSecurityDao() {
        return employeeSecurityDao;
    }
    public void setEmployeeSecurityDao(EmployeeSecurityDao employeeSecurityDao) {
        this.employeeSecurityDao = employeeSecurityDao;
    }
}



