package org.actlab.msat.common.entityes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GenerationType;

@Entity
@Setter
@Getter
public class IncomingServerDomains {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(nullable = false)
    private String domain;

    @ManyToOne
    private IncomingServerSetting setting;
}
