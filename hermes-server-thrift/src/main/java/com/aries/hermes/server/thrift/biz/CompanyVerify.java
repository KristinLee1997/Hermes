package com.aries.hermes.server.thrift.biz;

import com.aries.hermes.dal.constants.SystemConstants;
import com.aries.hermes.dal.po.Company;
import com.aries.hermes.dal.repository.CompanyRepository;
import com.aries.hermes.idl.dto.CompanyDTO;

public class CompanyVerify {
    public static boolean judge(CompanyDTO companyDTO) {
        Company company = CompanyRepository.selectByNameAndPassword(SystemConstants.SYSTEM_DATABASE_NAME,
                companyDTO.getName(), companyDTO.getPassword());
        return company != null;
    }
}
