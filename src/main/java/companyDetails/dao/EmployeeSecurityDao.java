package companyDetails.dao;

import companyDetails.model.EmployeeSecurity;

import java.security.Principal;

public interface EmployeeSecurityDao {
     int role(EmployeeSecurity employeeSecurity);
    EmployeeSecurity getRegistredDetailsbyid(Principal principal);
}
