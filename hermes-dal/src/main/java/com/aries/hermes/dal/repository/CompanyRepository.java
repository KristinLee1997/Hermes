package com.aries.hermes.dal.repository;

import com.aries.hermes.dal.mapper.CompanyMapper;
import com.aries.hermes.dal.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class CompanyRepository {
    public static boolean addCompany(String database, long id) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            // 获取Mapper
            CompanyMapper companyMapper = session.getMapper(CompanyMapper.class);

            // 输出结果
            System.out.println(companyMapper.selectByPrimaryKey(id).getCompanyName());
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(addCompany("hermes", 1L));
    }
}
