package com.mikemopo.workbook.model;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Data @Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@Builder
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


	public User(User user) {

	}
}
