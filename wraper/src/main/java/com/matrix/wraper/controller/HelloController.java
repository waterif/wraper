package com.matrix.wraper.controller;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.matrix.wraper.dao.OrgMapper;
import com.matrix.wraper.entity.Organization;

/**
 * 测试
 * @author junqing.song
 *
 */
@RestController
@RequestMapping( "/demo" )
@EnableAutoConfiguration
public class HelloController
{
    @Resource
    private OrgMapper orgMapper;

    /**
     * 获取组织信息
     * @param id 组织id
     * @return 组织信息
     */
    @RequestMapping( value = "/findOrg", method = RequestMethod.GET, produces = { "application/json; charset=UTF-8" } )
    Organization findOrg( @RequestParam( "id" ) Long id )
    {
        return orgMapper.getOrg( id );
    }
}
