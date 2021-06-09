package com.zeedlabs.crud.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="utilityRecord")
public class UtilityBeneficiary {
			
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@JsonIgnore
		@Column
		private Long id;
		
		@Column
		private String fullName;

		@Column
		private String refNumber;

		@Column
		private String userId;
		
		@Column
		private String billerId;
		
		@Column
		private String packageId;
		
		@Column
		private String amount;
			
		@Column
		private String bankCode;
		
		@Column
		@Temporal(TemporalType.TIMESTAMP)
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Date paymentDate;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public String getRefNumber() {
			return refNumber;
		}

		public void setRefNumber(String refNumber) {
			this.refNumber = refNumber;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getBillerId() {
			return billerId;
		}

		public void setBillerId(String billerId) {
			this.billerId = billerId;
		}

		public String getPackageId() {
			return packageId;
		}

		public void setPackageId(String packageId) {
			this.packageId = packageId;
		}

		public String getAmount() {
			return amount;
		}

		public void setAmount(String amount) {
			this.amount = amount;
		}

		public String getBankCode() {
			return bankCode;
		}

		public void setBankCode(String bankCode) {
			this.bankCode = bankCode;
		}

		public Date getPaymentDate() {
			return paymentDate;
		}

		public void setPaymentDate(Date paymentDate) {
			this.paymentDate = paymentDate;
		}
}
