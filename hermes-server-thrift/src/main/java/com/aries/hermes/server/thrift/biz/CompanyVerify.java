package com.aries.hermes.server.thrift.biz;

import com.aries.hermes.dal.constants.SystemConstants;
import com.aries.hermes.dal.po.Company;
import com.aries.hermes.dal.repository.CompanyRepository;
import com.aries.hermes.idl.dto.CompanyDTO;

public class CompanyVerify {
    public static String judgePermission(CompanyDTO companyDTO) {
        Company company = CompanyRepository.queryDatabaseByPassword(SystemConstants.SYSTEM_DATABASE_NAME,
                companyDTO.getName(), companyDTO.getPassword());
        return company.getDbName();
    }

    public static boolean judgeParam(CompanyDTO companyDTO) {
        if (companyDTO.getName() == null || companyDTO.getPassword() == null) {
            return false;
        }
        return true;
    }
}
