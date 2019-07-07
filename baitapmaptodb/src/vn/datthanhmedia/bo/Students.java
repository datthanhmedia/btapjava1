package vn.datthanhmedia.bo;

public class Students {
	private Integer id;
	private String first_name;
	private String last_name;
	private String gender;
	private Integer age;
	private String telephone;
	private Integer scores;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		if(first_name == null || first_name.equals("")) {
			System.out.println("First Name is not null");
			System.exit(0);
		}
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		if(!gender.equals("Male") && !gender.equals("Female")) {
			System.out.println("Gender of student not true");
			System.exit(0);
		}
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		if(age == null) {
			this.age = 18;
		}else this.age = age;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Integer getScores() {
		return scores;
	}
	public void setScores(Integer scores) {
		if(scores < 0 || scores > 1000) {
			System.out.println("Scores of student not true");
			System.exit(0);
		}
		this.scores = scores;
	}
}
