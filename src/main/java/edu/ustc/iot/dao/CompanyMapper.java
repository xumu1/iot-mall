package edu.ustc.iot.dao;

import edu.ustc.iot.pojo.Company;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface CompanyMapper {

    //根据主键id查找
    Company selectByPrimaryKey(Integer id);
}
