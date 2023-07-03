

package companyDetails.controller;

import companyDetails.model.EmployeeDetails;
import companyDetails.model.EmployeeSecurity;
import companyDetails.rest.impl.RestServiceImpl;
import companyDetails.service.EmployeeSecurityService;
import companyDetails.service.impl.EmployeeSecurityServiceImpl;
import companyDetails.validation.impl.EmployeeDetailsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.security.Principal;
import java.util.List;


@Controller
public class EmployeeDetailsController {
    @Autowired
    private RestServiceImpl restService;
     @Autowired
     private EmployeeDetailsValidator employeeDetailsValidator;
     @Autowired
     private EmployeeSecurityServiceImpl employeeSecurityService;


    @GetMapping(value = "/register")
    public String employeeApplicationForm(@ModelAttribute("employeeForm") EmployeeDetails employeeDetails, HttpServletRequest request) {
      Cookie[] cookies=request.getCookies();
      for(Cookie cookie:cookies){
          if("name".equals(cookie.getName())){
               String name=cookie.getValue();
              employeeDetails.setName(name);
            }
      }
        return "applicationForm";
    }
    @PostMapping("/insertData")
    public String employeeNewEntry(@Valid @ModelAttribute("employeeForm") EmployeeDetails employeeDetails,  BindingResult result ,HttpServletRequest request, HttpServletResponse response, Model model) {
        System.out.println(employeeDetails);
        employeeDetailsValidator.validate(employeeDetails, result);
        //create the cookie
        Cookie cookie=new Cookie("name",employeeDetails.getName());
        //add the cookie
        response.addCookie(cookie);

        if (result.hasErrors()) {
            return "applicationForm";
        } else {
             int count = restService.saveDataInServer(employeeDetails);
            System.out.println(count);
            if (count > 0) {
                model.addAttribute("save", "application form registered successfully ");
            } else {
                model.addAttribute("save", "Error-check the console log");
            }
            return "successful";
        }
    }

    @RequestMapping("/viewAll")
    public ModelAndView getCompanyDetails(ModelAndView m, Principal principal) {
        Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
        List<EmployeeDetails> list = restService.getEmployeeDetailsFromServer();
        m.addObject("list", list);
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            EmployeeSecurity str = employeeSecurityService.getUserdetailsbyid(principal);
            String c = str.getRole();
            if (c.contains("ROLE_USER")) {
                m.setViewName("viewEmployeesListForUser");
            } else {
                m.setViewName("viewEmployeeListForAdmin");
            }
        }
            return m;
        }


    @RequestMapping(value = "/getById/{employeeId}", method = RequestMethod.GET)
    public String getUserById(@PathVariable int employeeId, Model model) {
        EmployeeDetails employee = restService.getEmpByIdFromServer(employeeId);
        model.addAttribute("employee", employee);
        return "employeeData";
    }

    @GetMapping(value = "/editEmployee/{employeeId}")
    public String updateCompany(@PathVariable int employeeId, Model model) {
        EmployeeDetails employee = restService.getEmpByIdFromServer(employeeId);
        model.addAttribute("Employee",employee );
        return "update";
    }

    @PostMapping("/editEmployee/UpdateEmployee")
    public String createCompanyEntry( @ModelAttribute EmployeeDetails employeeDetails,Model model)
    {
        int counter = restService.updateEmployeeById(employeeDetails);
        System.out.println(counter);
        if (counter > 0) {
            model.addAttribute("msg", " updation done successfully");
        } else {
            model.addAttribute("msg", "not updated successfully");
        }
        return "updateSuccess";
    }
    @RequestMapping(value = "/deleteEmployee/{employeeId}", method = RequestMethod.GET)
    public ModelAndView deleteCompany(@PathVariable int employeeId, ModelAndView modelAndView) {
        System.out.println(employeeId);
        int employee= restService.deleteEmployeeById(employeeId);
        modelAndView.addObject("msg",employee);
        modelAndView.setViewName("deleteSuccess");
        return modelAndView;
    }
}





