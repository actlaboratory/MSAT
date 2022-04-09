package org.actlab.msat.repository;

import org.actlab.msat.common.entityes.OutgoingServerSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutgoingServerSettingRepository extends JpaRepository<OutgoingServerSetting, Long>{
}