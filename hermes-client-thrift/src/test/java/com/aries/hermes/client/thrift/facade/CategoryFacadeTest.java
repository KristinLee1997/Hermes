package com.aries.hermes.client.thrift.facade;

import com.alibaba.fastjson.JSON;
import com.aries.hera.client.thrift.exception.ServiceNotFoundException;
import org.apache.thrift.transport.TTransportException;
import org.junit.Test;

public class CategoryFacadeTest {

    @Test
    public void addCategory() throws ServiceNotFoundException, TTransportException {
        CategoryFacade.addCategory("标题120");
    }


    @Test
    public void queryNextCategory() throws ServiceNotFoundException, TTransportException {
        System.out.println(CategoryFacade.queryNextCategory(1));
    }

    @Test
    public void queryAllCategorys() throws ServiceNotFoundException, TTransportException {
        System.out.println(JSON.toJSONString(CategoryFacade.queryAllCategorys()));
    }

    @Test
    public void batchQueryCategorys() throws ServiceNotFoundException, TTransportException {
        System.out.println(JSON.toJSONString(CategoryFacade.batchQueryCategorys(1, 10)));
    }

    @Test
    public void updateCategoryNameById() throws ServiceNotFoundException, TTransportException {
        System.out.println(JSON.toJSONString(CategoryFacade.updateCategoryNameById(1, "标题001")));
    }
}
