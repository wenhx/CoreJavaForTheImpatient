package ch04.e09;

import java.lang.reflect.Field;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;

public class E09 {
    public static void run() {
        Node node = new Node();
        node.add("For Test");
        System.out.println(toString(node));
    }

    public static String toString(Object obj) {
        Objects.requireNonNull(obj);
        return toString(obj, 1, new IdentityHashMap<>());
    }

    public static String toString(Object obj, int depth, Map<Object, Object> exists) {
        if (depth > 5)
            return "(Max depth reached)";

        Class<?> objClass = obj.getClass();
        if (objClass.isPrimitive() || objClass.getCanonicalName() == "java.lang.String")
            return obj.toString();

        Field[] fields = objClass.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for (Field field : fields) {
            Object fieldValue = null;
            try {
                field.setAccessible(true);
                sb.append(field.getName());
                sb.append(" = ");
                fieldValue = field.get(obj);
            } catch (Exception e) {
                fieldValue = "(Not accessible)";
            }
            if (exists.containsKey(fieldValue)) {
                sb.append(fieldValue.toString());
            } else {
                exists.put(obj, obj);
                sb.append(toString(fieldValue, depth + 1, exists));
            }
            sb.append(", ");
        }
        if (sb.length() > 2) {
            sb.setLength(sb.length() - 2);
        }
        sb.append(" }");
        return sb.toString();
    }
}
