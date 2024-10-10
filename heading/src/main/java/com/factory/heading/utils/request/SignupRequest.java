package com.factory.heading.utils.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
    private String sku;
    private String username;
    private String password;
    private String fullname;
    private Boolean activated;
    private Long roleId;
}
