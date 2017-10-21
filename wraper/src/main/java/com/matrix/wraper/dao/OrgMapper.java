package com.matrix.wraper.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.matrix.wraper.entity.Organization;

@Mapper
public interface OrgMapper
{

    @Select( "select * from tang_ums_organization where id = #{id}" )
    Organization getOrg( @Param( "id" ) long id );
    
    @Select( "select user_id from tang_ums_user_organization where organization_id in (select id from tang_ums_organization where node_code like concat(#{nodeCode,jdbcType=VARCHAR} ,'%') )")
    List<Long> getOrgUsers(@Param( "nodeCode" ) String nodeCode);
   
    @Select( "select id from tang_ums_organization where node_code like concat(#{nodeCode,jdbcType=VARCHAR} ,'%') ")
    List<Long> getOrgs(@Param( "nodeCode" ) String nodeCode);
}
