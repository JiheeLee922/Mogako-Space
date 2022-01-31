package com.mogako.mogakospace.member.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.mogako.mogakospace.member.domain.entity.MemberEntity;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {

	
	private Long id;
	
	@NotBlank(message="�г����� �ʼ� �Է� ���Դϴ�.")
	private String nickname;
	
	@NotBlank(message = "�̸����� �ʼ� �Է� ���Դϴ�.")
	@Email(message = "�̸��� ���Ŀ� ���� �ʽ��ϴ�.")
	private String email;
	
	@NotBlank(message =  "��й�ȣ�� �ʼ� �Է� ���Դϴ�.")
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
			message = "��й�ȣ�� ���� ��,�ҹ��ڿ� ����, Ư����ȣ�� ��� 1�� �̻� ���Ե� 8��~20���� ��й�ȣ���� �մϴ�.")
	private String password;
	//(?=.*[0-9]) ���� ��� �ϳ�, (?=.*[a-zA-Z])���� ��� �ϳ� , (?=.*\\W) Ư�� ��� �ϳ�, (?=\\S+$) ��������
	
	private LocalDateTime createdDate;
	
	private LocalDateTime modifiedDate;
	
	public MemberEntity toEntity() {
		return MemberEntity.builder()
				.id(id)
				.email(email)
				.password(password)
				.nickname(nickname)
				.build();
	}
	
	@Builder
	public MemberDto(Long id, String email, String password, String nickname) {
		this.id = id;
		this.nickname = nickname;
		this.email = email;
		this.password = password;
	}
	
	
}
