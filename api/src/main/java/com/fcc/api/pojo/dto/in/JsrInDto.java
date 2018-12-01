package com.fcc.api.pojo.dto.in;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 20:30 2018/11/30
 */
@Data
public class JsrInDto {
    public interface Add{}
    public interface Update{}
    @NotNull(groups={Update.class})
    private Long id;
}
