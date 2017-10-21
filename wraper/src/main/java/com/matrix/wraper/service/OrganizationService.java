package com.matrix.wraper.service;

import java.util.List;

public interface OrganizationService
{

    List<Long> getOrgUsers( String nodeCode );

    List<Long> getOrgs( String nodeCode );
}
