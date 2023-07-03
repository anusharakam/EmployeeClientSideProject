package companyDetails.dao.impl;

import companyDetails.dao.EmployeeSecurityDao;
import companyDetails.model.EmployeeSecurity;

import java.security.Principal;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeSecurityDaoImpl implements EmployeeSecurityDao {
    private JdbcTemplate jdbcTemplate;

    @Override
    public int role(EmployeeSecurity employeeSecurity) {
        String query = "insert into security(username , password , role) values(?,?,?)";
        return jdbcTemplate.update(query, employeeSecurity.getUserName(), employeeSecurity.getPassword(), employeeSecurity.getRole());
    }

    @Override
    public EmployeeSecurity getRegistredDetailsbyid(Principal principal) {
        String QUERY1="select * from security where username='"+principal.getName()+"'";
        EmployeeSecurity employeeSecurity = (EmployeeSecurity) jdbcTemplate.queryForObject(QUERY1, new BeanPropertyRowMapper(EmployeeSecurity.class));
        return employeeSecurity;
    }
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}