package lvr.system;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public abstract class SystemCapability {
    private String name;
    private List<LinkedList<SystemAction>> flows;
}
