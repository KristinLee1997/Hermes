package com.aries.hermes.server.thrift.util;

import com.aries.hermes.idl.dto.CompanyDTO;
import com.aries.hermes.idl.dto.ThriftResponse;
import com.aries.hermes.server.thrift.bean.CompanyBean;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import static com.aries.hermes.server.thrift.constants.HermesResponseEnum.*;


@Getter
public class CompanyHelper {
    private boolean error;
    private CompanyDTO companyDTO;
    private String databaseName;
    private ThriftResponse response;

    public CompanyHelper(CompanyDTO companyDTO) {
        this.companyDTO = companyDTO;
    }

    public CompanyHelper invoke() {
        CompanyBean companyBean = new CompanyBean(companyDTO.getName(), companyDTO.getPassword(), companyDTO.getKeyword());
        databaseName = PartnerBll.getDatabase(companyBean);

        if (StringUtils.isBlank(databaseName)) {
            response = PERMISSION_FAIL.of();
            error = true;
            return this;
        }

        error = false;
        return this;
    }
}