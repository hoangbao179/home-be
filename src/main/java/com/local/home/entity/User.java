package com.local.home.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends CommonEntity{

    @Id
    private Long id;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;
}
