package com.app.DTO;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Apiresponse {
	private String msg;
	private LocalDate date;

	public Apiresponse(String msg) {
		this.msg = msg;
		this.date = LocalDate.now();
	}
}
