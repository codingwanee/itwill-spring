package site.itwill10.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

//ÀÔ·Â°ªÀÌ ÀúÀåµÇ´Â ÇÊµå¿¡ ¾î³ëÅ×ÀÌ¼ÇÀ» ¼±¾ğÇÏ¿© À¯È¿¼º °Ë»ç  
public class Hewon {
	//@NotEmpty : ÀÔ·Â°ªÀÇ À¯¹«¸¦ °Ë»çÇÏ±â À§ÇÑ ¾î³ëÅ×ÀÌ¼Ç
	// => ¿¡·¯ ¸Ş¼¼Áö´Â ¾î³ëÅ×ÀÌ¼Ç¿¡¼­ Á¦°øÇÏ´Â ±âº» ¸Ş¼¼Áö »ç¿ë
	// => ¾î³ëÅ×ÀÌ¼ÇÀÇ message ¼Ó¼ºÀÇ ¼Ó¼º°ªÀ¸·Î »ç¿ëÇÒ ¸Ş¼¼Áö ¼³Á¤
	@NotEmpty(message = "¾ÆÀÌµğ¸¦ ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.")
	//@Size : ÀÔ·Â°ªÀÇ ±æÀÌ¸¦ °Ë»çÇÏ±â À§ÇÑ ¾î³ëÅ×ÀÌ¼Ç
	// => ¾î³ëÅ×ÀÌ¼ÇÀÇ min ¼Ó¼º ¶Ç´Â max ¼Ó¼º¿¡ Á¤¼ö°ªÀ» ÀÌ¿ëÇÏ¿© ±æÀÌ¸¦ ¼Ó¼º°ªÀ¸·Î ¼³Á¤
	//@Size(min = 6, max = 20, message = "¾ÆÀÌµğ´Â ÃÖ¼Ò 6ÀÚ ÀÌ»ó ÃÖ´ë 20ÀÚ ÀÌÇÏ·Î¸¸ ÀÔ·Â °¡´ÉÇÕ´Ï´Ù.")
	//@Pattern : ÀÔ·Â°ªÀ» Á¤±ÔÇ¥Çö½ÄÀ¸·Î °Ë»çÇÏ±â À§ÇÑ ¾î³ëÅ×ÀÌ¼Ç
	// => ¾î³ëÅ×ÀÌ¼Ç¿¡ regexp ¼Ó¼º¿¡ Á¤±ÔÇ¥Çö½ÄÀ» ¼Ó¼º°ªÀ¸·Î ¼³Á¤
	@Pattern(regexp = "^[a-zA-Z]\\w{5,19}$",message = "¾ÆÀÌµğ¸¦ Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.")
	private String id;
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{6,20}$",message = "ºñ¹Ğ¹øÈ£¸¦ Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.")
	private String passwd;
	@Pattern(regexp = "^[°¡-ÆR]{2,10}$",message = "ÀÌ¸§À» Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.")
	private String name;
	@NotEmpty(message = "ÀÌ¸ŞÀÏÀ» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.")
	//@Pattern(regexp = "^([a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+(\\.[-a-zA-Z0-9]+)+)*$",message = "ÀÌ¸ŞÀÏÀ» Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.")
	@Email(message = "ÀÌ¸ŞÀÏÀ» Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.")
	private String email;
	@NotEmpty(message = "¼ºº°À» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.")
	private String gender;
	
	public Hewon() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
