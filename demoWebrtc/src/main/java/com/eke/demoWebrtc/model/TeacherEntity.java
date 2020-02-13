/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eke.demoWebrtc.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
/**
 *
 * @author eke
 */
@Entity
@Table(name = "teachers")
public class TeacherEntity extends AuditModel{
    @Id
    @Column(name = "teacher_id", unique = true, nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "teacher_name", nullable=false)
    private String name;
    
    @Column(name = "teacher_surename", nullable=false)
    private String surename;
    
    @Column(name = "teacher_access_key", unique = true, nullable=false)
    private String access_key;
    
    @Column(name = "teacher_passwd", nullable=false)
    private String passwd;
    
    @Column(name = "teacher_email", unique = true, nullable=false)
    private String email;
    
    @Column(name = "teacher_phone", unique = true, nullable=false)
    private String phone;
    
    @Column(name = "teacher_image")
    private String image;
    
    @Column(name = "teacher_birthday", nullable=false)
    private String birthday;
    
    @Column(name = "teacher_registration_date")
    private String registration_date;

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

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public String getAccess_key() {
        return access_key;
    }

    public void setAccess_key(String access_key) {
        this.access_key = access_key;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }
    
    
}
