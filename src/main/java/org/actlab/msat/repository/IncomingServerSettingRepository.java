package org.actlab.msat.repository;

import org.actlab.msat.common.entityes.IncomingServerSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomingServerSettingRepository extends JpaRepository<IncomingServerSetting, Integer> {
}