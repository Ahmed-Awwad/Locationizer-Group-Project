package com.revature.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Blob;

public class Image implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="imageSequence")
	@SequenceGenerator(allocationSize=1,name="imageSequence",sequenceName="SQ_IMAGE_PK")
	@Column(name="I_ID")
	int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="L_ID")
	Location location;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="U_ID")
	Users user;
	
	@Column(name="IMAGE")
	Blob image;
	
	

	public Image() {
		super();
	}

	public Image(Users user, Blob image) {
		super();
		this.user = user;
		this.image = image;
	}

	public Image(Location location, Users user, Blob image) {
		super();
		this.location = location;
		this.user = user;
		this.image = image;
	}

	public Image(int id, Location location, Users user, Blob image) {
		super();
		this.id = id;
		this.location = location;
		this.user = user;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", location=" + location + ", user=" + user + ", image=" + image + "]";
	}

}
