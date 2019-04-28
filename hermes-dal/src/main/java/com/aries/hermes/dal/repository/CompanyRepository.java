package com.aries.hermes.dal.repository;

import com.aries.hermes.dal.mapper.CompanyMapper;
import com.aries.hermes.dal.po.Company;
import com.aries.hermes.dal.po.CompanyExample;
import com.aries.hermes.dal.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CompanyRepository {
    public static boolean addCompany(Company company) {
        try (SqlSession session = SqlSessionUtil.openSession(company.getCompanyName())) {
            CompanyMapper companyMapper = session.getMapper(CompanyMapper.class);
            int i = companyMapper.insertSelective(company);
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static Company selectByNameAndPassword(Company company) {
        try (SqlSession session = SqlSessionUtil.openSession(company.getCompanyName())) {
            CompanyMapper companyMapper = session.getMapper(CompanyMapper.class);
            CompanyExample example = new CompanyExample();
            example.createCriteria().andCompanyNameEqualTo(company.getCompanyName()).andPasswordEqualTo(company.getPassword());
            List<Company> companyList = companyMapper.selectByExample(example);
            if (companyList != null && companyList.size() > 0) {
                return companyList.get(0);
            } else {
                return null;
            }
        }
    }
}
