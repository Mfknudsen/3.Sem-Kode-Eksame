package interfaces;

import java.util.List;

public interface Idto<dto, entity> {
    static <dto, entity> List<dto> getDTOs(List<entity> list) {
        return null;
    }
}
