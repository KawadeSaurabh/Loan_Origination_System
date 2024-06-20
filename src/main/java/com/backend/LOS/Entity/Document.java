package com.backend.LOS.Entity;

import java.sql.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "documents")
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String fileLocation;

	// Relationships
	@ManyToOne
	@JoinColumn(name = "loan_application_id")
	private LoanApplication loanApplication;
}
