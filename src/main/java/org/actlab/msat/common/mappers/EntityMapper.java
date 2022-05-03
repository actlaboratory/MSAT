package org.actlab.msat.common.mappers;

import org.actlab.msat.common.IncomingServerTypes;
import org.actlab.msat.common.entityes.IncomingServerDomain;
import org.actlab.msat.common.entityes.IncomingServerSetting;
import org.actlab.msat.common.entityes.OutgoingServerDomain;
import org.actlab.msat.common.entityes.OutgoingServerSetting;
import org.actlab.msat.common.settingInfo.ImapInfo;
import org.actlab.msat.common.settingInfo.PopInfo;
import org.actlab.msat.common.settingInfo.SmtpInfo;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public abstract class EntityMapper {
    abstract public SmtpInfo outGoingServerSettingEntityToSmtpInfo(OutgoingServerSetting entity);

    public SmtpInfo outgoingServerDomainEntityToSmtpInfo(OutgoingServerDomain entity){
        if(entity == null){ return null; }
        return outGoingServerSettingEntityToSmtpInfo(entity.getSetting());
    }

    abstract protected ImapInfo internalEntityToImapInfo(IncomingServerSetting entity);

    public ImapInfo incomingServerSettingEntityToImapInfo(IncomingServerSetting entity){
        if(!(entity == null)){
            if(entity.getServerType() != IncomingServerTypes.IMAP){ throw new IllegalArgumentException("can't mapping imapInfo from not imap incomingServerEntity"); }
        }
        return internalEntityToImapInfo(entity);
    }

    public ImapInfo incomingServerDomainEntityToImapInfo(IncomingServerDomain entity){
        if(entity == null){ return null; }
        return incomingServerSettingEntityToImapInfo(entity.getSetting());
    }

    abstract protected PopInfo internalEntityToPopInfo(IncomingServerSetting entity);

    public PopInfo incomingSettingEntityToPopInfo(IncomingServerSetting entity){
        if(!(entity == null)){
            if(entity.getServerType() != IncomingServerTypes.POP){ throw new IllegalArgumentException("can't mapping PopInfo from not pop incomingServerEntity"); }
        }
        return internalEntityToPopInfo(entity);
    }

    public PopInfo incomingServerDomainEntityToPopInfo(IncomingServerDomain entity){
        if(entity == null){ return null; }
        return incomingServerSettingEntityToPopInfo(entity.getSetting());
    }

}