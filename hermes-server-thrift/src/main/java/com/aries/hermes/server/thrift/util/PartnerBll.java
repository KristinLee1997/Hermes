package com.aries.hermes.server.thrift.util;

import com.aries.hermes.dal.repository.CompanyRepository;
import com.aries.hermes.server.thrift.bean.CompanyBean;

public class PartnerBll {
    public static String getDatabase(CompanyBean company) {
        return CompanyRepository.queryDatabaseByPassword("",company.getName(),company.getPassword());
    }

}
