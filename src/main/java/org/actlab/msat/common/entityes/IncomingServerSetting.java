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

import org.actlab.msat.common.IncomingServerTypes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GenerationType;


@Entity
@Setter
@Getter
public class IncomingServerSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long ID;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IncomingServerTypes serverType;

    @Column(nullable = false)
    private String providerName;

    @Column(nullable = false)
    private String host;

    @Column(nullable = false)
    private Integer port;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(nullable = false)
    private Boolean ssl;

    private String description;

    private String helpUrl;

    @Column(nullable = false)
    private String source;

    private String sourceUrl;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date updatedDate;

    @PrePersist
    public void prePersist(){
        updatedDate = new Date();
    }

    @PreUpdate
    public void preUpdate(){
        updatedDate = new Date();
    }
}
