package Week6.Polymorphism2;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Layer {
    private List<Shape> shapes = new ArrayList<>();

    /**
     * Add newShape.
     *
     * @param newShape shape
     */
    public void addShape(Shape newShape) {
        if (newShape != null) {
            shapes.add(newShape);
        }
    }

    /**
     * Remove all Circle.
     */
    public void removeCircles() {
//        for (int i = 0; i < shapes.size(); ) {
//            if (shapes.get(i) instanceof Circle) {
//                shapes.remove(shapes.get(i));
//            } else {
//                i++;
//            }
//        }
        shapes.removeIf(i -> i instanceof Circle);
    }

    /**
     * get Info of all Shape in shapes in order of insertion.
     *
     * @return String res
     */
    public String getInfo() {
        StringBuilder ans = new StringBuilder();
        ans.append("Layer of crazy shapes: ").append('\n');
        shapes.forEach((i) -> {
            ans.append(i.toString());
            ans.append('\n');
        });
        return ans.toString();
    }

    /**
     * Remove duplicates.
     */
    public void removeDuplicates() {
        shapes = shapes.stream().distinct().collect(Collectors.toList());
        // shapes = new LinkedHashSet<Shape>(shapes).stream().toList();
        // shapes = new ArrayList<>(new LinkedHashSet<>(shapes));
        // or iteration with contains...
    }
}
