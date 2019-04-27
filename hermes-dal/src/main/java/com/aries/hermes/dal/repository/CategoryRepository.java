package com.aries.hermes.dal.repository;

import com.alibaba.fastjson.JSON;
import com.aries.hermes.dal.exception.BatchQueryException;
import com.aries.hermes.dal.mapper.CategoryMapper;
import com.aries.hermes.dal.po.Category;
import com.aries.hermes.dal.util.SqlSessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import tk.mybatis.mapper.entity.Example;

import java.util.Collections;
import java.util.List;

@Slf4j
public class CategoryRepository {
    /**
     * 新增一个类别
     *
     * @param database     数据库
     * @param categoryName 类别名
     * @return 是否成功
     */
    public static boolean addCategory(String database, String categoryName) {
        if (StringUtils.isBlank(categoryName)) {
            log.warn("参数异常, category:{}", JSON.toJSONString(categoryName));
            return false;
        }
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
            Category category = new Category();
            category.setName(categoryName);
            int effect = categoryMapper.insertSelective(category);
            return effect > 0;
        }
    }

    /**
     * 根据id获取下一个种类信息。
     *
     * @param database 数据库
     * @param id       种类id
     * @return 下一个种类信息。
     */
    public static Category queryNextCategory(String database, long id) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
            Example example = new Example(Category.class);
            example.createCriteria().andEqualTo("id", id);
            example.orderBy("id").asc();

            List<Category> categories = categoryMapper.selectByExampleAndRowBounds(example, new RowBounds(0, 1));
            if (CollectionUtils.isEmpty(categories)) {
                return null;
            }
            return categories.get(0);
        }
    }

    /**
     * 获取所有种类。
     *
     * @param database 数据库
     * @return 所有种类信息。
     */
    public static List<Category> queryAllCategorys(String database) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
            List<Category> categories = categoryMapper.selectAll();
            if (CollectionUtils.isEmpty(categories)) {
                return Collections.emptyList();
            }
            return categories;
        }
    }

    public static List<Category> batchQueryCategorys(String database, int page, int pageSize) throws BatchQueryException {
        if (page < 1 || pageSize > 100) {
            String errorTemplate = "批量查询失败. page需要大于1, 实际:%d. pageSize需要小于等于100, 实际:%d";
            throw new BatchQueryException(String.format(errorTemplate, page, pageSize));
        }

        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);

            // 根据id正序排序
            Example example = new Example(Category.class);
            example.orderBy("id").asc();

            // 计算offset和limit
            int offset = (page - 1) * pageSize;
            int limit = pageSize;

            List<Category> categories = categoryMapper.selectByExampleAndRowBounds(example, new RowBounds(offset, limit));

            // 额外处理没有数据的情况，返回值为集合类型时，不希望传出null
            if (CollectionUtils.isEmpty(categories)) {
                return Collections.emptyList();
            }
            return categories;
        }
    }

    public static boolean updateCategoryNameById(String database, long id, String categoryName) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);

            Category category = new Category();
            category.setId(id);
            category.setName(categoryName);

            int effect = categoryMapper.updateByPrimaryKey(category);

            return effect > 0;
        }
    }
}
