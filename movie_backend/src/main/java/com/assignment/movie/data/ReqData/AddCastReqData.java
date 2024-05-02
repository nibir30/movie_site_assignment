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
public class AddCastReqData {
    private String fullName;
    private String imagePath;
    private LocalDateTime dob;
}
