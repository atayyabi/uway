package com.uway.server.model.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user_orders")
public class UserOrder {
	
	@Id
	@GeneratedValue
	private long id;
	private String orderNumber;
	private String orderTrackingUrl;
	private String encodedLabel;
	private String carrierName;
	private String carrierService;
	private String shipFrom;
	private String shipTo;
	private String emailAddress;
	private Double totalCharge;
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id", referencedColumnName="user_id")
	private User user;

}
