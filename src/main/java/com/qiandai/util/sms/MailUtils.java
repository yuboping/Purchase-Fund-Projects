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
 * Description:�ʼ����͹�����
 * </p>
 * <p>
 * Company:����Ǯ������˾�Ͼ��ֹ�˾
 * </p>
 * 
 * @author wanghaitao01@new4g.cn
 * @date 2016��5��5������6:08:38
 */
public class MailUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(MailUtils.class);

	private MimeMessage mimeMsg; // MIME�ʼ�����
	private Session session; // �ʼ��Ự����
	private Properties props; // ϵͳ����
	//private boolean needAuth = false; // smtp�Ƿ���Ҫ��֤
	// smtp��֤�û���������
	private String username;
	private String password;
	private Multipart mp; // Multipart����,�ʼ�����,����,���������ݾ���ӵ����к�������MimeMessage����

	/** 
     * Constructor 
     * @param smtp �ʼ����ͷ����� 
     */  
    public MailUtils(String smtp) {
        setSmtpHost(smtp);   
        createMimeMessage();   
    }

	/**
	 * �����ʼ����ͷ�����
	 * 
	 * @param hostName
	 *            String
	 */
	public void setSmtpHost(String hostName) {
		if (props == null)
			props = System.getProperties(); // ���ϵͳ���Զ���
		props.put("mail.smtp.host", hostName); // ����SMTP����
	}

	/**
	 * ����MIME�ʼ�����
	 * 
	 * @return
	 */
	public boolean createMimeMessage() {
		try {
			session = Session.getDefaultInstance(props, null); // ����ʼ��Ự����
		} catch (Exception e) {
			logger.info("��ȡ�ʼ��Ự����ʱ��������:"+e);
			return false;
		}

		try {
			mimeMsg = new MimeMessage(session); // ����MIME�ʼ�����
			mp = new MimeMultipart();
			return true;
		} catch (Exception e) {
			logger.info("����MIME�ʼ�����ʧ��:"+e);
			return false;
		}
	}

	/**
	 * ����SMTP�Ƿ���Ҫ��֤
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
	 * �����û���������
	 * 
	 * @param name
	 * @param pass
	 */
	public void setNamePass(String name, String pass) {
		username = name;
		password = pass;
	}

	/**
	 * �����ʼ�����
	 * 
	 * @param mailSubject
	 * @return
	 */
	public boolean setSubject(String mailSubject) {
		try {
			mimeMsg.setSubject(mailSubject);
			return true;
		} catch (Exception e) {
			logger.error("�����ʼ����ⷢ������:"+e);
			return false;
		}
	}

	/**
	 * �����ʼ�����
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
			logger.error("�����ʼ�����ʱ��������:"+e);
			return false;
		}
	}

	/**
	 * ��Ӹ���
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
			logger.error("�����ʼ�������" + filename + "��������:" + e);
			return false;
		}
	}

	/**
	 * ���÷�����
	 * 
	 * @param from
	 *            String
	 */
	public boolean setFrom(String from) {
		try {
			mimeMsg.setFrom(new InternetAddress(from)); // ���÷�����
			return true;
		} catch (Exception e) {
			logger.error("���÷����˴���"+e);
			return false;
		}
	}

	/**
	 * ����������
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
	 * ���ó�����
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
			logger.error("���ó����˴���"+e);
			return false;
		}
	}

	/**
	 * �����ʼ�
	 */
	public boolean sendOut(boolean isCopyto) {
		try {
			mimeMsg.setContent(mp);
			mimeMsg.saveChanges();
			System.out.println("���ڷ����ʼ�....");

			Session mailSession = Session.getInstance(props, null);
			Transport transport = mailSession.getTransport("smtp");
			transport.connect((String) props.get("mail.smtp.host"), username, password);
			transport.sendMessage(mimeMsg, mimeMsg.getRecipients(Message.RecipientType.TO));
			if (isCopyto) {
				transport.sendMessage(mimeMsg, mimeMsg.getRecipients(Message.RecipientType.CC));
			}
			
			// transport.send(mimeMsg);

			System.out.println("�����ʼ��ɹ���");
			transport.close();
			return true;
		} catch (Exception e) {
			logger.error("�ʼ�����ʧ��:"+e);
			return false;
		}
	}

	
	/**
	 * 
	 * <p>Description:����ʼ�����</p>
	 * @author wanghaitao01@new4g.cn
	 * @date 2016��5��6������10:40:19
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
		theMail.setNeedAuth(true); // ��Ҫ��֤

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
	 * <p>Description:����ʼ�����,������</p>
	 * @author wanghaitao01@new4g.cn
	 * @date 2016��5��6������10:19:50
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
		theMail.setNeedAuth(true); // ��Ҫ��֤

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
	 * <p>Description:����ʼ�����,������</p>
	 * @author wanghaitao01@new4g.cn
	 * @date 2016��5��6������10:41:58
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
		theMail.setNeedAuth(true); // ��Ҫ��֤

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
	 * <p>Description:����ʼ�����,�������ͳ���</p>
	 * @author wanghaitao01@new4g.cn
	 * @date 2016��5��6������10:17:44
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
		theMail.setNeedAuth(true); // ��Ҫ��֤

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
	 * <p>Description:����ʼ�����</p>
	 * @author wanghaitao01@new4g.cn
	 * @date 2016��5��6������10:42:42
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
		theMail.setNeedAuth(true); // ��Ҫ��֤
		

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
	 * <p>Description:�����ʼ�,������</p>
	 * @author wanghaitao01@new4g.cn
	 * @date 2016��5��6������10:22:56
	 * @param to
	 * @param copyto
	 * @param subject
	 * @param content
	 * @return
	 */
	public static boolean sendToc(String to,String copyto,String subject,String content) {
		 String smtp = "smtp.exmail.qq.com";  //SMTP������
		 String from = "wanghaitao01@new4g.cn";  
		 String username="wanghaitao01@new4g.cn";  
		 String password="Wht6495913";  
		return sendAndC(smtp, from, to, copyto, subject, content, username, password);
	}
	
	/**
	 * 
	 * <p>Description:�����ʼ�,������,������</p>
	 * @author wanghaitao01@new4g.cn
	 * @date 2016��5��6������10:23:21
	 * @param to
	 * @param copyto
	 * @param subject
	 * @param content
	 * @param fileName
	 * @return
	 */
	public static boolean sendToc(String to,String copyto,String subject,String content,String fileName){
		 String smtp = "smtp.exmail.qq.com";  //SMTP������
		 String from = "wanghaitao01@new4g.cn";  
		 String username="wanghaitao01@new4g.cn";  
		 String password="Wht6495913";  
		return sendAndC(smtp, from, to, copyto, subject, content, username, password,fileName);
	}
	
	/**
	 * 
	 * <p>Description:�����ʼ�</p>
	 * @author wanghaitao01@new4g.cn
	 * @date 2016��5��6������10:23:51
	 * @param to
	 * @param subject
	 * @param content
	 * @return
	 */
	public static boolean sendToc(String to,String subject,String content){
		 String smtp = "smtp.exmail.qq.com";  //SMTP������
		 String from = "wanghaitao01@new4g.cn";  
		 String username="wanghaitao01@new4g.cn";  
		 String password="Wht6495913";  
		return sendAndC(smtp, from, to, subject, content, username, password);
	}
	
}
