package com.aries.hermes.client.thrift.vo;

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
}
