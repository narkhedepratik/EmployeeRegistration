package com.empreg.app.responce;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> 
{
	private Integer statusCode;
	private String massage;
	private T responseData;
	

}
