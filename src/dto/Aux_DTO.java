package dto;

public class Aux_DTO {
	private String name;
	private int id;
	
	public Aux_DTO(int id,String name){
		setId(id);
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
