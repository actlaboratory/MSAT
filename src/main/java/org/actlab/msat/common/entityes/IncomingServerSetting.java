package org.actlab.msat.common.entityes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Null;

import org.actlab.msat.common.IncomingServerTypes;

import lombok.Data;

import javax.persistence.GenerationType;


@Data
@Entity
public class IncomingServerSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer ID;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "char")
    private IncomingServerTypes serverType;

    @Column(nullable = false, columnDefinition = "char")
    private String providerName;

    @Column(nullable = false)
    private String host;

    @Column(nullable = false, columnDefinition = "SMALLINT")
    private Integer port;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(nullable = false)
    private Boolean ssl;

    @Column(columnDefinition = "text")
    private String description;

    private String helpUrl;

    @Column(nullable = false, columnDefinition = "char")
    private String source;

    @Column(columnDefinition = "char")
    private String sourceUrl;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date updatedDate;

    @PrePersist
    public void prePersist(){
        if(updatedDate == null){
            updatedDate = new Date();
        }
    }

    @PreUpdate
    public void preUpdate(){
        if(updatedDate == null){
            updatedDate = new Date();
        }
    }
}
