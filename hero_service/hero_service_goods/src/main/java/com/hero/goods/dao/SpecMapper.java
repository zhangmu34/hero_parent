package com.hero.goods.dao;

import com.hero.goods.pojo.Spec;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SpecMapper extends Mapper<Spec> {
    @Select("SELECT name,options FROM tb_spec WHERE template_id IN ( SELECT template_id FROM tb_category WHERE NAME=#{categoryName}) order by seq")
    List<Map> findListByCategoryName(@Param("categoryName") String categoryName);
}
