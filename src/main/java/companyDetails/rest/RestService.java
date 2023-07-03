package companyDetails.rest;

import companyDetails.model.EmployeeDetails;
import companyDetails.model.EmployeeSecurity;

import java.util.List;

public interface RestService {

     int saveDataInServer(EmployeeDetails employeeDetails);
     List<EmployeeDetails> getEmployeeDetailsFromServer();
        EmployeeDetails getEmpByIdFromServer(int employeeId);
     int deleteEmployeeById(int employeeId);
     int updateEmployeeById(EmployeeDetails employeeDetails);
    }

