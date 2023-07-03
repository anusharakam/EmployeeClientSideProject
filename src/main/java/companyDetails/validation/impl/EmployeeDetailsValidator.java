package companyDetails.validation.impl;

import companyDetails.model.EmployeeDetails;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class EmployeeDetailsValidator implements Validator {
    @Override
        public boolean supports(Class<?> clazz) {
            return EmployeeDetails.class.isAssignableFrom(clazz);
         //   here we are assigning company class
        }
    @Override
    public void validate(Object companyForm, Errors error) {
        ValidationUtils.rejectIfEmpty( error, "Name", "employeeDetails.Name.empty","name should not be empty");
        ValidationUtils.rejectIfEmpty( error, "phoneNumber", "employeeDetails.phoneNumber.empty");
        ValidationUtils.rejectIfEmpty( error, "address", "employeeDetails.address.empty");

/*        EmployeeDetails employeeDetails = (EmployeeDetails) companyForm;
        System.out.println(  employeeDetails.getName());
        if (employeeDetails.getName()!= null && employeeDetails.getName().length() >= 3){
           error.rejectValue("employeeName", "employeeDetails.employeeName.empty");
        }*/
    }
}

