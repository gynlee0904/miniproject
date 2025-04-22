package miniproject;

import java.security.MessageDigest;

import org.springframework.stereotype.Repository;

@Repository("m_encry")
public class m_encry {
	public String md5_make(String pw) {
		StringBuilder sb = new StringBuilder();
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			md.update(pw.getBytes());
			for(byte b : md.digest()) {
				sb.append(String.format("%x",b));
			}
		} catch (Exception e) {
			System.out.println("e : "+e);
			e.getStackTrace();
		}
		return sb.toString();
	}
}
