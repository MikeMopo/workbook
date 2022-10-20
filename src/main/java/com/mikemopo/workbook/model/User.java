package com.mikemopo.workbook.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Data @Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "USER_TBL")
public class User {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Id Long id;
	private String title;
	private String firstname;
	private String surname;
	private String dob;
	private String jobtitle;

	

}
