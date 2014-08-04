package com.journaldev.spring.form.model;

import com.journaldev.spring.form.validator.Phone;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Calendar;
import java.util.Date;

public class Boat {
/*
			<tr>
				<td>Hull type:</td>
				<td><springForm:select path="hull">
						<springForm:option value="" label="Select hull type:" />
						<springForm:option value="MONO" label="Monohull" />
						<springForm:option value="MULTI" label="Multihull" />
					</springForm:select></td>
				<td><springForm:errors path="hull" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Cruising or racing?</td>
				<td><springForm:select path="sailstyle">
						<springForm:option value="" label="Select:" />
						<springForm:option value="CRUISING" label="Cruising" />
						<springForm:option value="RACING" label="Racing" />
						<springForm:option value="BOTH" label="Both" />
					</springForm:select></td>
				<td><springForm:errors path="sailstyle" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Describe what you are looking for:</td>
				<td><springForm:input path="desc"/></td>
				<td><springForm:errors path="desc" cssClass="error" /></td>
			</tr>*/
	@Size(min=1, max=30)
    private String manufacturer;

    @Size(min=1, max=30)
    private String model;

    @NotNull @Min(1850) @Max(2014) //TODO make max dynamic
    private Integer year;

    @NotEmpty @Email
    private String email;
     
    @NotNull @Min(18) @Max(100)
    private Integer age;

    @NotNull @Min(3) @Max(999)
    private Integer length; //TODO units

    public enum HullType {
        MONO, MULTI
    }

    @NotNull
    private HullType hullType;

    public enum SailStyle {
        CRUISING, RACING, BOTH //TODO delivery, professional, other - is an enum suitable here?
    }

    @NotNull
    private Gender gender;
     
    @DateTimeFormat(pattern="MM/dd/yyyy")
    @NotNull @Past
    private Date birthday;
    
    @Phone
    private String phone;
    
    public enum Gender {
		MALE, FEMALE
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
