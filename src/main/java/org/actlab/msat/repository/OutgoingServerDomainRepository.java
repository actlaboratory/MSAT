package org.actlab.msat.repository;

import org.actlab.msat.common.entityes.OutgoingServerDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutgoingServerDomainRepository extends JpaRepository<OutgoingServerDomain, Long> {
}