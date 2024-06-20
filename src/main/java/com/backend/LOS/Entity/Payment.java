package com.backend.LOS.Entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "payments")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private double amountPaid;
	private Date paymentDate;
	private String method;
	private String transactionId;

	// Relationships
	@ManyToOne
	@JoinColumn(name = "loan_id")
	private Loan loan;
}
