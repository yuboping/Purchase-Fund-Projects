package com.qiandai.util.sms;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <p>
 * Title:MailUtils
 * </p>
 * <p>
 * Description:邮件发送工具类
 * </p>
 * <p>
 * Company:北京钱袋宝公司南京分公司
 * </p>
 * 
 * @author wanghaitao01@new4g.cn
 * @date 2016年5月5日下午6:08:38
 */
public class MailUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(MailUtils.class);

	private MimeMessage mimeMsg; // MIME邮件对象
	private Session session; // 邮件会话对象
	private Properties props; // 系统属性
	//private boolean needAuth = false; // smtp是否需要认证
	// smtp认证用户名和密码
	private String username;
	private String password;
	private Multipart mp; // Multipart对象,邮件内容,标题,附件等内容均添加到其中后再生成MimeMessage对象

	/** 
     * Constructor 
     * @param smtp 邮件发送服务器 
     */  
    public MailUtils(String smtp) {
        setSmtpHost(smtp);   
        createMimeMessage();   
    }

	/**
	 * 设置邮件发送服务器
	 * 
	 * @param hostName
	 *            String
	 */
	public void setSmtpHost(String hostName) {
		if (props == null)
			props = System.getProperties(); // 获得系统属性对象
		props.put("mail.smtp.host", hostName); // 设置SMTP主机
	}

	/**
	 * 创建MIME邮件对象
	 * 
	 * @return
	 */
	public boolean createMimeMessage() {
		try {
			session = Session.getDefaultInstance(props, null); // 获得邮件会话对象
		} catch (Exception e) {
			logger.info("获取邮件会话对象时发生错误:"+e);
			return false;
		}

		try {
			mimeMsg = new MimeMessage(session); // 创建MIME邮件对象
			mp = new MimeMultipart();
			return true;
		} catch (Exception e) {
			logger.info("创建MIME邮件对象失败:"+e);
			return false;
		}
	}

	/**
	 * 设置SMTP是否需要验证
	 * 
	 * @param need
	 */
	public void setNeedAuth(boolean need) {
		if (props == null)
			props = System.getProperties();
		if (need) {
			props.put("mail.smtp.auth", "true");
		} else {
			props.put("mail.smtp.auth", "false");
		}
	}

	/**
	 * 设置用户名和密码
	 * 
	 * @param name
	 * @param pass
	 */
	public void setNamePass(String name, String pass) {
		username = name;
		password = pass;
	}

	/**
	 * 设置邮件主题
	 * 
	 * @param mailSubject
	 * @return
	 */
	public boolean setSubject(String mailSubject) {
		try {
			mimeMsg.setSubject(mailSubject);
			return true;
		} catch (Exception e) {
			logger.error("设置邮件主题发生错误:"+e);
			return false;
		}
	}

	/**
	 * 设置邮件正文
	 * 
	 * @param mailBody
	 *            String
	 */
	public boolean setBody(String mailBody) {
		try {
			BodyPart bp = new MimeBodyPart();
			bp.setContent("" + mailBody, "text/html;charset=GBK");
			mp.addBodyPart(bp);
			return true;
		} catch (Exception e) {
			logger.error("设置邮件正文时发生错误:"+e);
			return false;
		}
	}

	/**
	 * 添加附件
	 * 
	 * @param filename
	 *            String
	 */
	public boolean addFileAffix(String filename) {
		try {
			BodyPart bp = new MimeBodyPart();
			FileDataSource fileds = new FileDataSource(filename);
			bp.setDataHandler(new DataHandler(fileds));
			bp.setFileName(fileds.getName());
			mp.addBodyPart(bp);
			return true;
		} catch (Exception e) {
			logger.error("增加邮件附件：" + filename + "发生错误:" + e);
			return false;
		}
	}

	/**
	 * 设置发信人
	 * 
	 * @param from
	 *            String
	 */
	public boolean setFrom(String from) {
		try {
			mimeMsg.setFrom(new InternetAddress(from)); // 设置发信人
			return true;
		} catch (Exception e) {
			logger.error("设置发信人错误"+e);
			return false;
		}
	}

	/**
	 * 设置收信人
	 * 
	 * @param to
	 *            String
	 */
	public boolean setTo(String to) {
		if (to == null)
			return false;
		try {
			mimeMsg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 设置抄送人
	 * 
	 * @param copyto
	 *            String
	 */
	public boolean setCopyTo(String copyto) {
		if (copyto == null)
			return false;
		try {
			mimeMsg.setRecipients(Message.RecipientType.CC, (Address[]) InternetAddress.parse(copyto));
			return true;
		} catch (Exception e) {
			logger.error("设置抄送人错误："+e);
			return false;
		}
	}

	/**
	 * 发送邮件
	 */
	public boolean sendOut(boolean isCopyto) {
		try {
			mimeMsg.setContent(mp);
			mimeMsg.saveChanges();
			System.out.println("正在发送邮件....");

			Session mailSession = Session.getInstance(props, null);
			Transport transport = mailSession.getTransport("smtp");
			transport.connect((String) props.get("mail.smtp.host"), username, password);
			transport.sendMessage(mimeMsg, mimeMsg.getRecipients(Message.RecipientType.TO));
			if (isCopyto) {
				transport.sendMessage(mimeMsg, mimeMsg.getRecipients(Message.RecipientType.CC));
			}
			
			// transport.send(mimeMsg);

			System.out.println("发送邮件成功！");
			transport.close();
			return true;
		} catch (Exception e) {
			logger.error("邮件发送失败:"+e);
			return false;
		}
	}

	
	/**
	 * 
	 * <p>Description:完成邮件发送</p>
	 * @author wanghaitao01@new4g.cn
	 * @date 2016年5月6日上午10:40:19
	 * @param smtp
	 * @param from
	 * @param to
	 * @param subject
	 * @param content
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean send(String smtp, String from, String to, String subject, String content, String username,
			String password) {
		MailUtils theMail = new MailUtils(smtp);
		theMail.setNeedAuth(true); // 需要验证

		if (!theMail.setSubject(subject)){
			return false;
		}
			
		if (!theMail.setBody(content)) {
			return false;
		}
			
		if (!theMail.setTo(to)){
			return false;
		}
			
		if (!theMail.setFrom(from)) {
			return false;
		}
			
		theMail.setNamePass(username, password);

		if (!theMail.sendOut(false)){
			return false;
		}
			
		return true;
	}

	
	/**
	 * 
	 * <p>Description:完成邮件发送,带抄送</p>
	 * @author wanghaitao01@new4g.cn
	 * @date 2016年5月6日上午10:19:50
	 * @param smtp
	 * @param from
	 * @param to
	 * @param copyto
	 * @param subject
	 * @param content
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean sendAndC(String smtp, String from, String to, String copyto, String subject, String content,
			String username, String password) {
		MailUtils theMail = new MailUtils(smtp);
		theMail.setNeedAuth(true); // 需要验证

		if (!theMail.setSubject(subject)){
			return false;
		}
			
		if (!theMail.setBody(content)) {
			return false;
		}
			
		if (!theMail.setTo(to)){
			return false;
		}
			
		if (!theMail.setCopyTo(copyto)){
			return false;
		}
			
		if (!theMail.setFrom(from)){
			return false;
		}
			
		theMail.setNamePass(username, password);

		if (!theMail.sendOut(true))
			return false;
		return true;
	}

	
	/**
	 * 
	 * <p>Description:完成邮件发送,带附件</p>
	 * @author wanghaitao01@new4g.cn
	 * @date 2016年5月6日上午10:41:58
	 * @param smtp
	 * @param from
	 * @param to
	 * @param subject
	 * @param content
	 * @param username
	 * @param password
	 * @param filename
	 * @return
	 */
	public static boolean send(String smtp, String from, String to, String subject, String content, String username,
			String password, String filename) {
		MailUtils theMail = new MailUtils(smtp);
		theMail.setNeedAuth(true); // 需要验证

		if (!theMail.setSubject(subject)) {
			return false;
		}
			
		if (!theMail.setBody(content)) {
			return false;
		}
			
		if (!theMail.addFileAffix(filename)) {
			return false;
		}
			
		if (!theMail.setTo(to)) {
			return false;
		}
			
		if (!theMail.setFrom(from)) {
			return false;
		}
			
		theMail.setNamePass(username, password);

		if (!theMail.sendOut(false))
			return false;
		return true;
	}

	
	/**
	 * 
	 * <p>Description:完成邮件发送,带附件和抄送</p>
	 * @author wanghaitao01@new4g.cn
	 * @date 2016年5月6日上午10:17:44
	 * @param smtp
	 * @param from
	 * @param to
	 * @param copyto
	 * @param subject
	 * @param content
	 * @param username
	 * @param password
	 * @param filename
	 * @return
	 */
	public static boolean sendAndC(String smtp, String from, String to, String copyto, String subject, String content,
			String username, String password, String filename) {
		MailUtils theMail = new MailUtils(smtp);
		theMail.setNeedAuth(true); // 需要验证

		if (!theMail.setSubject(subject)) {
			return false;
		}
			
		if (!theMail.setBody(content)) {
			return false;
		}
			
		if (!theMail.addFileAffix(filename)) {
			return false;
		}
			
		if (!theMail.setTo(to)) {
			return false;
		}
			
		if (!theMail.setCopyTo(copyto)) {
			return false;
		}
			
		if (!theMail.setFrom(from)) {
			return false;
		}
			
		theMail.setNamePass(username, password);

		if (!theMail.sendOut(true)) {
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * <p>Description:完成邮件发送</p>
	 * @author wanghaitao01@new4g.cn
	 * @date 2016年5月6日上午10:42:42
	 * @param smtp
	 * @param from
	 * @param to
	 * @param subject
	 * @param content
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean sendAndC(String smtp, String from, String to, String subject, String content,
			String username, String password) {
		MailUtils theMail = new MailUtils(smtp);
		theMail.setNeedAuth(true); // 需要验证
		

		if (!theMail.setSubject(subject)) {
			return false;
		}
			
		if (!theMail.setBody(content)) {
			return false;
		}
			
		if (!theMail.setTo(to)) {
			return false;
		}
	
		if (!theMail.setFrom(from)) {
			return false;
		}
			
		theMail.setNamePass(username, password);

		if (!theMail.sendOut(false)) {
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * <p>Description:发送邮件,带抄送</p>
	 * @author wanghaitao01@new4g.cn
	 * @date 2016年5月6日上午10:22:56
	 * @param to
	 * @param copyto
	 * @param subject
	 * @param content
	 * @return
	 */
	public static boolean sendToc(String to,String copyto,String subject,String content) {
		 String smtp = "smtp.exmail.qq.com";  //SMTP服务器
		 String from = "wanghaitao01@new4g.cn";  
		 String username="wanghaitao01@new4g.cn";  
		 String password="Wht6495913";  
		return sendAndC(smtp, from, to, copyto, subject, content, username, password);
	}
	
	/**
	 * 
	 * <p>Description:发送邮件,带抄送,带附件</p>
	 * @author wanghaitao01@new4g.cn
	 * @date 2016年5月6日上午10:23:21
	 * @param to
	 * @param copyto
	 * @param subject
	 * @param content
	 * @param fileName
	 * @return
	 */
	public static boolean sendToc(String to,String copyto,String subject,String content,String fileName){
		 String smtp = "smtp.exmail.qq.com";  //SMTP服务器
		 String from = "wanghaitao01@new4g.cn";  
		 String username="wanghaitao01@new4g.cn";  
		 String password="Wht6495913";  
		return sendAndC(smtp, from, to, copyto, subject, content, username, password,fileName);
	}
	
	/**
	 * 
	 * <p>Description:发送邮件</p>
	 * @author wanghaitao01@new4g.cn
	 * @date 2016年5月6日上午10:23:51
	 * @param to
	 * @param subject
	 * @param content
	 * @return
	 */
	public static boolean sendToc(String to,String subject,String content){
		 String smtp = "smtp.exmail.qq.com";  //SMTP服务器
		 String from = "wanghaitao01@new4g.cn";  
		 String username="wanghaitao01@new4g.cn";  
		 String password="Wht6495913";  
		return sendAndC(smtp, from, to, subject, content, username, password);
	}
	
}
