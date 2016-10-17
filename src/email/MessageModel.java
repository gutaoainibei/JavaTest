package email;

import javax.mail.Session;

public class MessageModel {
	/**
	 * 邮件会话
	 */
	private Session session;
	/**
	 * 邮件主题
	 */
	private String subject;
	/**
	 * 邮件内容
	 */
	private String content;
	/**
	 * 发送人
	 */
	private String sendPerson;
	/**
	 * 接收人
	 */
	private String[] receivePerson;
	/**
	 * 抄送人
	 */
	private String[] copyreceivePerson;
	/**
	 * 秘密发送
	 */
	private String[] bccreceivePerson;
	/**
	 * 附件路径
	 */
	private String pathFile;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSendPerson() {
		return sendPerson;
	}

	public void setSendPerson(String sendPerson) {
		this.sendPerson = sendPerson;
	}

	public String[] getReceivePerson() {
		return receivePerson;
	}

	public void setReceivePerson(String[] receivePerson) {
		this.receivePerson = receivePerson;
	}

	public String[] getCopyreceivePerson() {
		return copyreceivePerson;
	}

	public void setCopyreceivePerson(String[] copyreceivePerson) {
		this.copyreceivePerson = copyreceivePerson;
	}

	public String[] getBccreceivePerson() {
		return bccreceivePerson;
	}

	public void setBccreceivePerson(String[] bccreceivePerson) {
		this.bccreceivePerson = bccreceivePerson;
	}

	public String getPathFile() {
		return pathFile;
	}

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

}
