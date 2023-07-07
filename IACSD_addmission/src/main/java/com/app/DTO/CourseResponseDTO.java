package com.app.DTO;
// course title(unique) , start date , end date , fees , min score

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.app.entities.CourseEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CourseResponseDTO {
	private Long id;
	private String cname;
	private LocalDate start_date;
	private LocalDate end_date;
	@NotNull(message = "Fee Must Be Filled")
	private double fee;
	@NotNull(message = "Fee Must Be Filled")
	private double score;
}
