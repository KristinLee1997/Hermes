package com.aries.hermes.server.thrift.impl;

import com.alibaba.fastjson.JSON;
import com.aries.hermes.dal.po.Category;
import com.aries.hermes.dal.repository.CategoryRepository;
import com.aries.hermes.idl.dto.CategoryDTO;
import com.aries.hermes.idl.dto.CompanyDTO;
import com.aries.hermes.idl.dto.ThriftResponse;
import com.aries.hermes.idl.service.CategoryServer;
import com.aries.hermes.server.thrift.util.CompanyHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.thrift.TException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.aries.hermes.server.thrift.constants.HermesResponseEnum.*;

@Slf4j
public class CategoryServerImpl implements CategoryServer.Iface {
    @Override
    public String ping() throws TException {
        log.debug("pong, category server");
        return "pong,this is category server";
    }

    @Override
    public ThriftResponse addCategory(CompanyDTO companyDTO, String categoryName) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            log.warn("addCategory 没有权限,companyDTO:{}, categoryName:{}", JSON.toJSONString(companyDTO), categoryName);
            return companyHelper.getResponse();
        }
        try {
            boolean effect = CategoryRepository.addCategory(companyHelper.getDatabaseName(), categoryName);
            return effect ? SUCCESS.of() : NOT_CHANGED.of();
        } catch (Exception e) {
            log.error("addCategory error:{}", e.getMessage(), e);
            return SYSTEM_ERROR.of();
        }
    }

    @Override
    public CategoryDTO queryNextCategory(CompanyDTO companyDTO, long id) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            log.warn("queryNextCategory 没有权限,companyDTO:{}, id:{}", JSON.toJSONString(companyDTO), id);
            return null;
        }
        try {
            Category category = CategoryRepository.queryNextCategory(companyHelper.getDatabaseName(), id);
            return convert2CategoryDTO(category);
        } catch (Exception e) {
            log.error("queryNextCategory error:{}", e.getMessage(), e);
            return null;
        }
    }


    @Override
    public List<CategoryDTO> queryAllCategorys(CompanyDTO companyDTO) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            log.warn("queryAllCategorys 没有权限,companyDTO:{}", JSON.toJSONString(companyDTO));
            return Collections.emptyList();
        }

        try {
            List<Category> categories = CategoryRepository.queryAllCategorys(companyHelper.getDatabaseName());
            return convert2CategoryDTO(categories);
        } catch (Exception e) {
            log.error("queryAllCategorys error:{}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public List<CategoryDTO> batchQueryCategorys(CompanyDTO companyDTO, int page, int pageSize) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            log.warn("batchQueryCategorys 没有权限,companyDTO:{}, page:{}, pageSize:{}", JSON.toJSONString(companyDTO), page, pageSize);
            return Collections.emptyList();
        }
        try {
            List<Category> categories = CategoryRepository.batchQueryCategorys(companyHelper.getDatabaseName(), page, pageSize);
            return convert2CategoryDTO(categories);
        } catch (Exception e) {
            log.error("batchQueryCategorys error:{}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public ThriftResponse updateCategoryNameById(CompanyDTO companyDTO, long id, String categoryName) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            log.warn("updateCategoryNameById 没有权限,companyDTO:{}, id:{}, categoryName:{}", JSON.toJSONString(companyDTO), id, categoryName);
            return companyHelper.getResponse();
        }

        try {
            boolean effect = CategoryRepository.updateCategoryNameById(companyHelper.getDatabaseName(), id, categoryName);
            return effect ? SUCCESS.of() : NOT_CHANGED.of();
        } catch (Exception e) {
            log.error("updateCategoryNameById error:{}", e.getMessage(), e);
            return SYSTEM_ERROR.of();
        }
    }

    private static CategoryDTO convert2CategoryDTO(Category category) {
        if (category == null) {
            return null;
        }
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }

    private static List<CategoryDTO> convert2CategoryDTO(List<Category> categorys) {
        if (CollectionUtils.isEmpty(categorys)) {
            return Collections.emptyList();
        }

        return categorys.stream().map(CategoryServerImpl::convert2CategoryDTO).collect(Collectors.toList());
    }
}
