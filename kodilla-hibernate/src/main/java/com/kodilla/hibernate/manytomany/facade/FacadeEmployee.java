package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacadeEmployee {
    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> retrieveEmployeeByFragmentOfTheName(String letters) throws EmployeeException {
        return employeeDao.retrieveEmployeeByPartOfTheName(letters);
    }
}