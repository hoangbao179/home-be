package com.local.home.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
public class CommonEntity {

    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    @Column(name = "user_create")
    private String userCreate;

    @Column(name = "date_create")
    private Date dateCreate;

    @Column(name = "user_update")
    private String userUpdate;

    @Column(name = "date_update")
    private Date dateUpdate;
}
