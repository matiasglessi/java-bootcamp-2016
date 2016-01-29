package spring.ws.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "User", description = "Complete data of an user.")
public class User {
	@ApiModelProperty(value = "The id of the User", required = false)
	private Long id;
	@ApiModelProperty(value = "The name of the user", required = true)
	private String name;
	@ApiModelProperty(value = "The nickname of the user", required = true)
	private String nickname;
	@ApiModelProperty(value = "The password of the user", required = true)
	private String pass;
	
	public User(){
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
}
