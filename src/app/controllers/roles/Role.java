package app.controllers.roles;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

public interface Role {
    String getName();
    HashMap<String, ActionListener> getAvailableActions(JFrame frame);
}
