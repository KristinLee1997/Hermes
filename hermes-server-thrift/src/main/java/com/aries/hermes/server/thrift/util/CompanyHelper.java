package com.aries.hermes.server.thrift.util;

import com.aries.hermes.idl.dto.CompanyDTO;
import com.aries.hermes.idl.dto.ThriftResponse;
import com.aries.hermes.server.thrift.bean.CompanyBean;
import com.aries.hermes.server.thrift.biz.CompanyBiz;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import static com.aries.hermes.server.thrift.constants.HermesResponseEnum.*;


@Getter
@Slf4j
public class CompanyHelper {
    private boolean error;
    private CompanyDTO companyDTO;
    private String databaseName;
    private ThriftResponse response;

    public CompanyHelper(CompanyDTO companyDTO) {
        this.companyDTO = companyDTO;
    }

    public CompanyHelper check() {
        if (StringUtils.isBlank(companyDTO.getName()) || StringUtils.isBlank(companyDTO.getPassword())) {
            log.warn("公司账号或密码为空, name:{}, password:{}", companyDTO.getName(), companyDTO.getPassword());
            response = PARAM_NULL.of();
            error = true;
            return this;
        }
        CompanyBean companyBean = new CompanyBean(companyDTO.getName(), companyDTO.getPassword(), companyDTO.getKeyword());
        databaseName = CompanyBiz.getDatabase(companyBean);

        if (StringUtils.isBlank(databaseName)) {
            log.warn("公司没有操作权限, name:{}, password:{}", companyDTO.getName(), companyDTO.getPassword());
            response = PERMISSION_FAIL.of();
            error = true;
            return this;
        }

        error = false;
        return this;
    }
}