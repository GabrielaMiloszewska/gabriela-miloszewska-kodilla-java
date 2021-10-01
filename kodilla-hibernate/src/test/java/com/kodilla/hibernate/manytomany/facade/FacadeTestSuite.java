package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FacadeTestSuite {
    @Autowired
    private FacadeCompany facadeCompany;
    @Autowired
    private FacadeEmployee facadeEmployee;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private CompanyDao companyDao;

    @Test
    public void testRetrieveEmployeeByPartOfTheName() throws EmployeeException {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaKovalsky);

        //When
        List<Employee> expectedEmployee = facadeEmployee.retrieveEmployeeByFragmentOfTheName("vals");

        //Then
        assertEquals("Kovalsky", expectedEmployee.get(0).getLastname());

        //CleanUp
        employeeDao.deleteAll();
    }

    @Test
    public void testRetrieveCompanyByPartOfTheName() throws CompanyException {
        //Given
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);

        //When
        List<Company> expectedCompany = facadeCompany.retrieveCompanyByFragmentOfTheName("aes");

        //Then
        assertEquals("Data Maesters", expectedCompany.get(0).getName());

        //CleanUp
        employeeDao.deleteAll();
    }

}
