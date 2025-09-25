package com.nit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndianFestival {
	private Integer fid;
	private String fname;
	private String season;
	private String reason;
	private String dressCode;

}
