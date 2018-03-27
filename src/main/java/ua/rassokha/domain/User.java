package ua.rassokha.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    @NonNull
    private String username;
    @NonNull
    private String password;
}
