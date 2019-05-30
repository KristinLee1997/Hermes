package com.aries.hermes.client.thrift.facade;

import com.aries.hera.client.thrift.ThriftHelper;
import com.aries.hera.client.thrift.exception.ServiceNotFoundException;
import com.aries.hera.core.utils.PropertiesProxy;
import com.aries.hermes.idl.dto.CategoryDTO;
import com.aries.hermes.idl.dto.CompanyDTO;
import com.aries.hermes.idl.dto.ThriftResponse;
import com.aries.hermes.idl.service.CategoryServer;
import org.apache.thrift.transport.TTransportException;

import java.util.List;

public class CategoryFacade {
    private static final CompanyDTO companyDTO;

    static {
        PropertiesProxy propertiesProxy = new PropertiesProxy("hermes-pass.properties");
        String company = propertiesProxy.readProperty("company");
        String password = propertiesProxy.readProperty("password");
        companyDTO = new CompanyDTO(company, password, "");
    }

    public static ThriftResponse addCategory(String categoryName) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Hermes", CategoryServer.Client.class, client -> client.addCategory(companyDTO, categoryName));
    }

    public static CategoryDTO queryNextCategory(long id) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Hermes", CategoryServer.Client.class, client -> client.queryNextCategory(companyDTO, id));
    }

    public static List<CategoryDTO> queryAllCategorys() throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Hermes", CategoryServer.Client.class, client -> client.queryAllCategorys(companyDTO));
    }

    public static List<CategoryDTO> batchQueryCategorys(int page, int pageSize) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Hermes", CategoryServer.Client.class, client -> client.batchQueryCategorys(companyDTO, page, pageSize));
    }

    public static ThriftResponse updateCategoryNameById(long id, String categoryName) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Hermes", CategoryServer.Client.class, client -> client.updateCategoryNameById(companyDTO, id, categoryName));
    }


}
