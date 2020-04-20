package co.edu.ff.orders.user.domain;

import com.google.common.base.Preconditions;
import lombok.Value;

@Value(staticConstructor = "from")
public class UserAuthRequest {
    Username username;
    String password;

    public UserAuthRequest(Username username, String password) {
        Preconditions.checkNotNull(username);
        Preconditions.checkNotNull(password);
        this.username = username;
        this.password = password;
    }
}
