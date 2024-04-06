package in.ashokit.util;

import java.io.File;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;
@Component
public class EmailUtils {
	@Autowired
	private JavaMailSender sender;
	public String sendEmail(String msg,String toEmail,File f) throws Exception{
		MimeMessage message=sender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message, true);
		helper.setCc(toEmail);
		helper.setSubject("first email");
		helper.setSentDate(new Date());
		helper.setText(msg, true);
		helper.addAttachment("ravixls", f);
		sender.send(message);
		return "message sent";
		
	}
}
