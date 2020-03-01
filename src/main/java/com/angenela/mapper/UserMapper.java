package com.angenela.mapper;

import com.angenela.dao.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    User getUserByName(@Param("name") String name);

    void updateToken(@Param("id") int id, @Param("token") String token);

    User byToken(@Param("token") String token);
}
