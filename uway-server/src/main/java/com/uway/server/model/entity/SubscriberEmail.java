package com.uway.server.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class SubscriberEmail implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    private String email;


}
