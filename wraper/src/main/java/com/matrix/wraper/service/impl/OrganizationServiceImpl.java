package com.matrix.wraper.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrix.wraper.dao.OrgMapper;
import com.matrix.wraper.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService
{

    @Autowired
    private OrgMapper orgMapper;

    @Override
    public List<Long> getOrgUsers( String nodeCode )
    {
        return orgMapper.getOrgUsers( nodeCode );
    }

    @Override
    public List<Long> getOrgs( String nodeCode )
    {
        return orgMapper.getOrgs( nodeCode );
    }

}
