package org.actlab.msat.common.entityes;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class OutgoingServerSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer ID;

    @Column(nullable = false, columnDefinition = "char")
    private String providerName;

    @Column(nullable = false)
    private String host;

    @Column(nullable = false, columnDefinition = "SMALLINT")
    private Integer port;

    @Column(nullable = false)
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
        updatedDate = new Date();
    }

    @PreUpdate
    public void preUpdate(){
        updatedDate = new Date();
    }
}
