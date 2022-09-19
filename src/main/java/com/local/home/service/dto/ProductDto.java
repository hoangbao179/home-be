package com.local.home.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.local.home.entity.CommonEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto extends CommonEntity {

    public Long id;

    public String name;

    public String description;

    public Long price;
}
