package Week8.Interface;

import java.util.List;

public class ShapeUtil {
    /**
     * Print Week8.Interface.Circle, Week8.Interface.Triangle.
     *
     * @param list list.
     * @return String
     */
    public String printInfo(List<GeometricObject> list) {
        StringBuilder ans = new StringBuilder("Week8.Interface.Circle:\n");
        for (GeometricObject g : list) {
            if (g instanceof Circle) {
                ans.append(g.getInfo()).append('\n');
            }
        }
        ans.append("Week8.Interface.Triangle:\n");
        for (GeometricObject g : list) {
            if (g instanceof Triangle) {
                ans.append(g.getInfo()).append('\n');
            }
        }
        return ans.toString();
    }
}
