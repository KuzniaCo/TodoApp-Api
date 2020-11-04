package pl.ug.kuznia.todoappapi.internal.user;

import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class UserDTO {


    @NotNull
    String username;

    @NotNull
    String password;

    public User createUser() {
        return User.builder()
                .username(username)
                .password(password)
                .build();
    }


}
