package cn.edu.pzhu.util;

import java.security.SecureRandom;

import org.apache.commons.mail.SimpleEmail;

import cn.edu.pzhu.pojo.Msg;

public class EmailUtil {
	public static Msg sendemail(String email) {
		
		SimpleEmail simpleEmail = new SimpleEmail();
		simpleEmail.setHostName("smtp.163.com");
		simpleEmail.setSmtpPort(25);
		simpleEmail.setSSLOnConnect(false);
		simpleEmail.setAuthentication("pzhuweb@163.com", "ZPvxWeE9cS3J9D8N");
		String code = "";
		SecureRandom random = new SecureRandom();
		for (int i = 0; i < 6; i++) {
			int n = random.nextInt(10); //0-9之间的数字
			code+=n;
		}
		try {
			simpleEmail.addTo(email);
			simpleEmail.setFrom("pzhuweb@163.com");
			simpleEmail.setSubject("文件分享系统登录验证码");
			simpleEmail.setMsg("你的登录验证码是："+code);
			simpleEmail.send();			
			
		} catch (Exception e) {
			return new Msg(false, "邮件发送异常！");
		}
		return new Msg(true,code);
	}

}
