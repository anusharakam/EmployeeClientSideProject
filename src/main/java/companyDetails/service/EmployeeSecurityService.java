package companyDetails.service;

import companyDetails.model.EmployeeSecurity;

import java.security.Principal;

public interface EmployeeSecurityService {
     int role(EmployeeSecurity employeeSecurity);
     String encryptPassword(String password);
    EmployeeSecurity getUserdetailsbyid(Principal id);
}
