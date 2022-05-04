package com.example.seckilldemo.exception;

import com.example.seckilldemo.vo.RespBeanEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlobalException  extends  Exception{
    private RespBeanEnum respBeanEnum;
}
