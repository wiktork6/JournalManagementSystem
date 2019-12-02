package app.controllers.roles;

import java.util.List;

public interface Role {
    String getName();
    List<String> getAvailableActions();
}
