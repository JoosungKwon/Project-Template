package com.prgrms.demotemplate.domain.user.model;

import static com.prgrms.demotemplate.global.utils.ValidateUtil.*;
import static lombok.AccessLevel.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE users SET deleted = true where id=?")
@Table(name = "users")
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Size(max = 100)
	String name;

	@Builder
	public User(String name) {
		this.name = validateName(name);
	}

	private String validateName(String nickName) {
		checkText(nickName, "유효하지 않은 이름");
		checkOverLength(nickName, 100, "최대 글자수를 초과했습니다.");
		return nickName;
	}
}
