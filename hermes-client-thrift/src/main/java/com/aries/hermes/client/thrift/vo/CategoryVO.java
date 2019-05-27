package com.aries.hermes.client.thrift.vo;

import com.aries.hermes.idl.dto.CategoryDTO;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryVO {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static final class CategoryVOBuilder {
        private String name;

        private CategoryVOBuilder() {
        }

        public static CategoryVOBuilder aCategoryVO() {
            return new CategoryVOBuilder();
        }

        public CategoryVOBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CategoryVO build() {
            CategoryVO categoryVO = new CategoryVO();
            categoryVO.name = this.name;
            return categoryVO;
        }
    }

    public static CategoryDTO toDTO(CategoryVO categoryVO) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.name = categoryVO.name;
        return categoryDTO;
    }

    public static CategoryVO buildFromDTO(CategoryDTO categoryDTO) {
        CategoryVO categoryVO = new CategoryVO();
        categoryDTO.id = categoryVO.id;
        categoryDTO.name = categoryVO.name;
        return categoryVO;
    }

    public static List<CategoryVO> buildFromDTO(List<CategoryDTO> categoryDTOList) {
        if (CollectionUtils.isEmpty(categoryDTOList)) {
            return Collections.emptyList();
        }
        return categoryDTOList.stream().map(CategoryVO::buildFromDTO).collect(Collectors.toList());
    }
}
