package com.bediss.hotel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hotel")
public class Hotel {
	
	@Id
    @Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column (name = "nom", nullable = false, length =100)
	private String nom;
	
	
	@Column (name = "etoiles", nullable = false, length=1)
	private String etoiles;
	
	
	@Column (name = "adresse", nullable = false)
	private String adresse;
	
	@Column (name = "telephone", nullable = false)
	private String telephone;
	
	@Column (name = "email", nullable = false)
	private String email;
	
	@Column (name = "ville", nullable = false)
	private String ville;

	public Hotel(String nom, String etoiles, String adresse, String telephone, String email, String ville) {
		setNom(nom);
		setEtoiles(etoiles);
		setAdresse(adresse);
		setTelephone(telephone);
		setEmail(email);
		setVille(ville);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((etoiles == null) ? 0 : etoiles.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (etoiles == null) {
			if (other.etoiles != null)
				return false;
		} else if (!etoiles.equals(other.etoiles))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", nom=" + nom + ", etoiles=" + etoiles + ", adresse=" + adresse + ", telephone="
				+ telephone + ", email=" + email + ", ville=" + ville + "]";
	}

	public Hotel() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEtoiles() {
		return etoiles;
	}

	public void setEtoiles(String etoiles) {
		this.etoiles = etoiles;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}


	
	
	
	
	
	

}
