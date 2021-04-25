package com.employee.Employee.entity;

import java.util.Date;
import java.time.LocalDate;
import java.util.List;

import javax.management.relation.Role;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "nvemply")
public class User 


{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private long userId;
	
	@Column(name = "createDate")
	private Date createDate;
	
	@Column(name = "modifiedDate")
	private Date modifiedDate;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "reminderQueryQuestion")
	private String reminderQueryQuestion;
	
	@Column(name = "reminderQueryAnswer")
	private String reminderQueryAnswer;
	
	@Column(name = "emailAdress")
	private String emailAdress;
	
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "middleName")
	private String middleName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "jobTitle")
	private String jobTitle;
	
	@Column(name = "loginDate")
	private Date loginDate;
	
	@Column(name = "agreeToTermsOfUse")
	private boolean agreeToTermsOfUse;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "emailAdressverified")
	private boolean emailAdressverified;
	
	@OneToMany(targetEntity = Roles.class, cascade = CascadeType.ALL)
	private List<Roles> roles;
	
	public User(long userId, Date date, Date date2, String password, String reminderQueryQuestion,
			String reminderQueryAnswer, String emailAdress, String firstName, String middleName, String lastName,
			String jobTitle, Date date3, boolean agreeToTermsOfUse, int status, boolean emailAdressverified,List<Roles> roles2) {
		super();
		this.userId = userId;
		this.createDate =  date;
		this.modifiedDate =  date2;
		this.password = password;
		this.reminderQueryQuestion = reminderQueryQuestion;
		this.reminderQueryAnswer = reminderQueryAnswer;
		this.emailAdress = emailAdress;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.jobTitle = jobTitle;
		this.loginDate =  date3;
		this.agreeToTermsOfUse = agreeToTermsOfUse;
		this.status = status;
		this.emailAdressverified = emailAdressverified;
		this.roles=roles2;
	}
	public List<Roles> getRoles() {
		return roles;
	}
	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
	public User()
	{
		
	}

	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getReminderQueryQuestion() {
		return reminderQueryQuestion;
	}
	public void setReminderQueryQuestion(String reminderQueryQuestion) {
		this.reminderQueryQuestion = reminderQueryQuestion;
	}
	public String getReminderQueryAnswer() {
		return reminderQueryAnswer;
	}
	public void setReminderQueryAnswer(String reminderQueryAnswer) {
		this.reminderQueryAnswer = reminderQueryAnswer;
	}
	public String getEmailAdress() {
		return emailAdress;
	}
	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	public boolean isAgreeToTermsOfUse() {
		return agreeToTermsOfUse;
	}
	public void setAgreeToTermsOfUse(boolean agreeToTermsOfUse) {
		this.agreeToTermsOfUse = agreeToTermsOfUse;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public boolean isEmailAdressverified() {
		return emailAdressverified;
	}
	public void setEmailAdressverified(boolean emailAdressverified) {
		this.emailAdressverified = emailAdressverified;
	}
	@Override
	public String toString() {
		return "Emply [userId=" + userId + ", createDate=" + createDate + ", modifiedDate=" + modifiedDate
				+ ", password=" + password + ", reminderQueryQuestion=" + reminderQueryQuestion
				+ ", reminderQueryAnswer=" + reminderQueryAnswer + ", emailAdress=" + emailAdress + ", firstName="
				+ firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", jobTitle=" + jobTitle
				+ ", loginDate=" + loginDate + ", agreeToTermsOfUse=" + agreeToTermsOfUse + ", status=" + status
				+ ", emailAdressverified=" + emailAdressverified + "]";
	}
	
}
