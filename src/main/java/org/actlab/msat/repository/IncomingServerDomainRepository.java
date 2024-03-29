package org.actlab.msat.repository;

import org.actlab.msat.common.entityes.IncomingServerDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomingServerDomainRepository extends JpaRepository<IncomingServerDomain, Integer>{
}