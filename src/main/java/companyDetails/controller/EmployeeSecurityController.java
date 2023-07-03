package companyDetails.controller;


import companyDetails.model.EmployeeSecurity;
import companyDetails.service.EmployeeSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeSecurityController {
    @Autowired
  private EmployeeSecurityService employeeSecurityService;


    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("user", "anu");
        System.out.println(request.getSession());
        System.out.println("userName:" + httpSession.getAttribute("user"));
        return "login";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    @GetMapping("/registrationForm")
    public String login(){
        return "registrationForm";
    }

    @GetMapping("/")
    public String welcomePage(){
        return "welcomePage";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }
    @RequestMapping("/accessDenied")
    public String accessDenied(){

        return "accessDenied";
    }

    @RequestMapping("/user")
    public String user(){
        return "user";
    }

    @RequestMapping(value = "/loginError")
    public String loginError() {
        return "loginError";
    }

    @RequestMapping(value = "/logOut")
    public String logOut() {
        return "login";
    }

    @GetMapping("/signUp")
    public String getRegistration() {
        return "registrationForm";
    }

    @PostMapping("/signUpAction")
    public String dataForms(@ModelAttribute EmployeeSecurity employeeSecurity,HttpServletRequest request) {
        String password= employeeSecurityService.encryptPassword(employeeSecurity.getPassword());
        employeeSecurity.setPassword(password);
         employeeSecurityService.role(employeeSecurity);
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("user", employeeSecurity.getUserName());
        return "successful";
    }

    @ModelAttribute("rolesList")
    public List<String> rolesList() {
        List<String> list = new ArrayList<>();
        list.add("ROLE_USER");
        list.add("ROLE_ADMIN");
        return list;
    }
}




