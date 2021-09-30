package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FacadeCompany {
    @Autowired
    CompanyDao companyDao;

    public List<Company> retrieveCompanyByFragmentOfTheName(String letters) throws CompanyException {
        return companyDao.retrieveCompanyByPartOfTheName();
    }

}
