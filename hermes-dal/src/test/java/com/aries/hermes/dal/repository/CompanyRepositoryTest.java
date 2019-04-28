package com.aries.hermes.dal.repository;

import com.aries.hermes.dal.po.Company;
import org.junit.Test;

public class CompanyRepositoryTest {
    /**
     * 新增公司
     */
    @Test
    public void addCompanyTest() {
        Company company = new Company() {{
            setCompanyName("aries_edu");
            setDbName("hermes_aries_edu");
            setPassword("123123");
        }};
        boolean hemers = CompanyRepository.addCompany("hermes", company);
        System.out.println(hemers);
    }

    /**
     * 根据公司名称查询公司信息
     */
    @Test
    public void selectByNameAndPasswordTest() {
        Company company = CompanyRepository.selectByName("hermes", "aries_edu");
        System.out.println(company.getPassword());
    }
}
