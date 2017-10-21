package com.matrix.wraper.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.matrix.wraper.base.BaseException;
import com.matrix.wraper.base.ErrorCode;
import com.matrix.wraper.base.ResponseEntity;
import com.matrix.wraper.service.OrganizationService;

/**
 * 组织
 * 
 * @author junqing.song
 *
 */
@RestController
@RequestMapping( "/organization" )
public class OrganizationController
{
    private static Logger logger = LoggerFactory.getLogger( OrganizationController.class );

    @Resource
    private OrganizationService organizationService;

    /**
     * 获取组织下用户id列表
     * 
     * @param nodeCode 组织的nodeCode
     * @return 组织下用户id列表
     */
    @ApiOperation( value = "获取组织下用户id列表", notes = "根据组织的nodeCode，获取组织下用户id列表，包含子组织" )
    @ApiImplicitParam( name = "nodeCode", value = "组织的nodeCode", required = true, paramType = "query", dataType = "String" )
    @RequestMapping( value = "/getOrgUsers", method = RequestMethod.GET, produces = { "application/json; charset=UTF-8" } )
    ResponseEntity<List<Long>> getOrgUsers( @RequestParam( "nodeCode" ) String nodeCode )
    {

        // 接口日志1： request信息
        logger.info( "/organization/getOrgUsers getOrgUsers()" );
        try
        {
            List<Long> userIds = organizationService.getOrgUsers( nodeCode );

            // 接口日志2： response信息
            logger.info( "/organization/getOrgUsers getOrgUsers() return : userIds={}", userIds );
            return new ResponseEntity<List<Long>>( userIds );
        }
        catch ( BaseException e )
        {
            // 异常日志
            logger.error( e.getMessage(), e );
            return new ResponseEntity<List<Long>>( e.getErrorCode(), e.getMessage() );
        }
        catch ( Exception e )
        {
            // 异常日志
            logger.error( e.getMessage(), e );
            return new ResponseEntity<List<Long>>( ErrorCode.ERROR_COMMON_FAILURE );
        }
    }
    
    /**
     * 获取组织下子组织id列表，包含当前组织
     * 
     * @param nodeCode 组织的nodeCode
     * @return 获取组织下子组织id列表，包含当前组织
     */
    @ApiOperation( value = "获取组织下子组织id列表，包含当前组织", notes = "根据组织的nodeCode，获取组织下子组织id列表，包含当前组织" )
    @ApiImplicitParam( name = "nodeCode", value = "组织的nodeCode", required = true, paramType = "query", dataType = "String" )
    @RequestMapping( value = "/getOrgs", method = RequestMethod.GET, produces = { "application/json; charset=UTF-8" } )
    ResponseEntity<List<Long>> getOrgs( @RequestParam( "nodeCode" ) String nodeCode )
    {
        
        // 接口日志1： request信息
        logger.info( "/organization/getOrgs getOrgs()" );
        try
        {
            List<Long> orgIds = organizationService.getOrgs( nodeCode );
            
            // 接口日志2： response信息
            logger.info( "/organization/getOrgUsers getOrgs() return : userIds={}", orgIds );
            return new ResponseEntity<List<Long>>( orgIds );
        }
        catch ( BaseException e )
        {
            // 异常日志
            logger.error( e.getMessage(), e );
            return new ResponseEntity<List<Long>>( e.getErrorCode(), e.getMessage() );
        }
        catch ( Exception e )
        {
            // 异常日志
            logger.error( e.getMessage(), e );
            return new ResponseEntity<List<Long>>( ErrorCode.ERROR_COMMON_FAILURE );
        }
    }
}
