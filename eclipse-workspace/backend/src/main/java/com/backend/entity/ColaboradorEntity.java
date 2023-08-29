package com.backend.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "COLABORADOR")
public class ColaboradorEntity {
	@Id
	@GeneratedValue
	@Column(name="ID")
	Integer id;
	
	@Column(name="NOME")
	String nome;
	
	@Column(name="SENHA")
	String senha;
	
	@Column(name="SCORE_STRING")
	String stringScore;
		
	@Column(name="SCORE")
	int score;
	
	@ManyToOne
	@JoinColumn(name="ID_CHEFE")
	ColaboradorEntity chefe;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getStringScore() {
		return stringScore;
	}

	public void setStringScore(String stringScore) {
		this.stringScore = stringScore;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer i) {
		this.score = i;
	}

	public ColaboradorEntity getChefe() {
		return chefe;
	}

	public void setChefe(ColaboradorEntity chefe) {
		this.chefe = chefe;
	}

}