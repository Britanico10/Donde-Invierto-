package com.grupo4.inversiones.persistencia;

import java.io.Serializable; 
 
import javax.persistence.Column; import javax.persistence.GeneratedValue; import javax.persistence.GenerationType; import javax.persistence.Id; import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator; 
 
@MappedSuperclass public class Persistible implements Serializable { 
 
    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    @GenericGenerator(name="gen",strategy="increment")
    @GeneratedValue(generator="gen")
    protected Long id;
    protected String name; 
 
    protected Persistible() {
    	
    } 
 
    @Column(name = "id")
    public Long getId() {
    	return id;
    	} 
 
    public void setId(Long id) {
    	this.id = id;
    	} 
 
    @Column(name = "name")
    public String getName() {
    	return name;
    	} 
 
    public void setName(String name) {
    	this.name = name;
    	} 
 
    public String toString() {
    	return getId() + "-" + getName();
    	} 
 
}