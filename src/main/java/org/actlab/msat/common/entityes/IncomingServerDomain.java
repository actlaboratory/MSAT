package org.actlab.msat.common.entityes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;



@Entity
@Data
public class IncomingServerDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false, columnDefinition = "char")
    private String domain;

    @ManyToOne
    private IncomingServerSetting setting;

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
