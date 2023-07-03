package companyDetails.rest.impl;


import companyDetails.model.EmployeeDetails;
import companyDetails.rest.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RestServiceImpl implements RestService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public int saveDataInServer(EmployeeDetails employeeDetails) {
        System.out.println(employeeDetails);

        int r = restTemplate.postForObject("http://localhost:8082/CompanyRecords_war_exploded/saveDataFromClient", employeeDetails, Integer.class);
        System.out.println(r);
        return r;
    }

    @Override
    public List<EmployeeDetails> getEmployeeDetailsFromServer() {
        List<EmployeeDetails> employeeInfo =  restTemplate.getForObject("http://localhost:8082/CompanyRecords_war_exploded/employeeDetailsInJson" ,List.class);
        return employeeInfo ;
    }

    @Override
    public EmployeeDetails getEmpByIdFromServer(int employeeId) {
        return  restTemplate.getForObject("http://localhost:8082/CompanyRecords_war_exploded/getByIdInJson/"+ employeeId,EmployeeDetails.class);
    }

    @Override
    public int deleteEmployeeById(int employeeId) {
        try{
            restTemplate.delete("http://localhost:8082/CompanyRecords_war_exploded/delete/"+employeeId);
            return 1;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateEmployeeById(EmployeeDetails employeeDetails) {
        try{
            restTemplate.put("http://localhost:8082/CompanyRecords_war_exploded//Update",employeeDetails);
            return 1;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
