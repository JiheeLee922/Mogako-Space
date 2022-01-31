package com.mogako.mogakospace.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;


/**
 * �α��� ���� �� �ڵ鷯
 * @author JiheeLee
 * @since 2021.11.03
 * @version 1.0
 * @see <pre>
 *  == �����̷�(Modification Information) ==
 *   
 *   ������      	  ������       			   ��������
 *  -------      --------    ---------------------------
 *   2021.11.03  JiheeLee       	  ���� ����
 * 
 * </pre>
 */
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

	public CustomLoginSuccessHandler(String defaultTargetUrl) {
		setDefaultTargetUrl(defaultTargetUrl);
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session != null) 
		{
			String redirectUrl = (String) session.getAttribute("prevPage");
			if(redirectUrl != null) 
			{
				session.removeAttribute("prevPage");
				getRedirectStrategy().sendRedirect(request, response, redirectUrl); 
			} 
			else
			{
				super.onAuthenticationSuccess(request, response, authentication);
			}
		}
	}
	
	
}
