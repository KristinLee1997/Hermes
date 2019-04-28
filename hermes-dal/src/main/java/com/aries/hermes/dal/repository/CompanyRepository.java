package com.aries.hermes.dal.repository;

import com.aries.hermes.dal.mapper.CompanyMapper;
import com.aries.hermes.dal.po.Company;
import com.aries.hermes.dal.po.CompanyExample;
import com.aries.hermes.dal.util.SqlSessionUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Collections;
import java.util.List;

public class CompanyRepository {
    /**
     * 新增公司
     *
     * @param database
     * @param company
     * @return
     */
    public static boolean addCompany(String database, Company company) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            CompanyMapper companyMapper = session.getMapper(CompanyMapper.class);
            int i = companyMapper.insertSelective(company);
            return i > 0;
        }
    }

    /**
     * 通过公司名或者密码查询公司
     *
     * @param database
     * @param companyName
     * @return
     */
    public static Company queryDatabaseByPassword(String database, String companyName, String password) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            CompanyMapper companyMapper = session.getMapper(CompanyMapper.class);
            CompanyExample example = new CompanyExample();
            example.createCriteria().andCompanyNameEqualTo(companyName).andPasswordEqualTo(password);
            List<Company> companyList = companyMapper.selectByExample(example);
            if (CollectionUtils.isEmpty(companyList)) {
                return null;
            } else {
                return companyList.get(0);
            }
        }
    }
}
