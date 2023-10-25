package com.user.pojo;

public class Pojo {
	private int Id;
	private String Name;
	private String Email;
	private String Contact;
	public Pojo() {}
	@Override
	public String toString() {
		return "Pojo [Id=" + Id + ", Name=" + Name + ", Email=" + Email + ", Contact=" + Contact + "]";
	}
	public Pojo(int id, String name, String email, String contact) {
		Id = id;
		Name = name;
		Email = email;
		Contact = contact;
	}
	public Pojo(String name, String email, String contact) {
		Name = name;
		Email = email;
		Contact = contact;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getContact() {
		return Contact;
	}
	public void setContact(String contact) {
		Contact = contact;
	}
	
}
