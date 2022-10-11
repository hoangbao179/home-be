package com.local.home.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;

    private String name;

    private String description;

    private Long price;

    private boolean isDeleted = false;

    private String userCreate;

    private Date dateCreate;

    private String userUpdate;

    private Date dateUpdate;
}
