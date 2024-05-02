package com.assignment.movie.data.ResData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RegistrationResData {
    private Long id;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;
    private String address;
    private String facebook;
    private List<String> roleNames;
}
