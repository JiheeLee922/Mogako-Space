package com.mogako.mogakospace.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.mogako.mogakospace.member.service.MemberSerivce;

import lombok.AllArgsConstructor;


@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	private MemberSerivce memberService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/*	spring security ���� ��� ������ AuthenticationManager�� ���� �̷���.
		 *  AuthenticationManager �����Ϸ��� AuthenticationManagerBuilder ���.
		 *  ������ ���� UserDetailService�� ���� �ʿ��� ���� ���� ���µ� ���⼱ memberService���� ó��*/
		
		auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		
		/*	WebSecurity�� FilterChainProxy��(security���� ����ϴ� filter����) �����ϴ� ���� 
		 * �Ʒ� ����� ���ϵ��� Spring Security�� ������ �� �ֵ��� ����. ������ resources/static */
		
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/*	HttpSecurity�� ���� HTTP��û�� ���� ����� ������ �����Ѵ�. 
		 * authorizeRequests -> HttpServletRequests�� ���� ���� ����. antMatchers �޼���� Ư�� ��� ������ ���ҿ� ���� ���� ���� ����ش�
		 * formLogin -> form ������� �����ϵ�����. �α��� ������ �⺻������ HttpSession �̿�*/
		
		http.authorizeRequests()
				//������ ���� ����
				.antMatchers("/admin/**").hasRole("ADMIN")		//�ش� ��δ� ADMIN ���� ���� ����ڸ� ���� ����
				.antMatchers("/user/myinfo").hasRole("MEMBER")
				.antMatchers("/board/**").hasRole("MEMBER")
				.antMatchers("/chat/**").hasRole("MEMBER")
				.antMatchers("/**").permitAll()		//	<-> .anyRequest().authenticated() ��� ����� ���ٰ���
			.and()	//�α��� ����
				.formLogin()
				.loginPage("/user/login")		// �⺻ �����Ǵ� form ���� Ŀ���� �α��� form �� ���� ���� �� 
				.defaultSuccessUrl("/user/login/result")	//�α��� �������� �� �̵� ������
				.successHandler(successHandler())
				//.usernameParameter("mbrId")  �α��� form���� name�� username�� ���̵�� �ν��ϴµ� �ٸ��ɷ� �ϰ� ���� ��
				.permitAll()
			.and()	//�α׾ƿ� ����
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))	//�α׾ƿ��� �⺻ url ���� Ŀ�����ϰ� ���� ��
				.logoutSuccessUrl("/user/logout/result")
				.invalidateHttpSession(true)	//HTTP ���� �ʱ�ȭ
				//.deleteCookies("Ű��")  �α׾ƿ� �� Ư�� ��Ű �����ϰ� ���� �� 
			.and()	//403 ����ó�� �ڵ鸵
				.exceptionHandling().accessDeniedPage("/user/denied");
		
	}
	
	
	public AuthenticationSuccessHandler successHandler() {
		return new CustomLoginSuccessHandler("/user/login/result");
	}
	
}
