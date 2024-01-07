package entity.services;

import base.entity.BaseEntity;

import javax.persistence.Column;


public class Service extends BaseEntity<Long> {
    @Column(nullable = false)
    private String aboutService;

    @Column(nullable = false)
    private Double basePrice;



}
