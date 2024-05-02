package com.assignment.movie.data.ReqData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddUserReqData {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDateTime dob;
}
