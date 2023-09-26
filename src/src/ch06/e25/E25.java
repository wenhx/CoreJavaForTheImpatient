package ch06.e25;

import ch06.e23.E23;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.concurrent.Callable;

public class E25 {
    public static void run() {
        runCore(() -> E25.class.getDeclaredMethod("genericDeclaration", Method.class));
        runCore(() -> E23.class.getDeclaredMethod("throwAs", Throwable.class));
        runCore(() -> java.util.function.BiFunction.class.getDeclaredMethod("apply", Object.class, Object.class));
    }

    private static void runCore(Callable<Method> call) {
        Method method = null;
        try {
            method = call.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String declaration = genericDeclaration(method);
        System.out.println(declaration);
    }

    public static String genericDeclaration(Method m) {
        StringBuilder declaration = new StringBuilder();

        // Handle generic type parameters
        TypeVariable<Method>[] typeParameters = m.getTypeParameters();
        if (typeParameters.length > 0) {
            declaration.append("<");
            for (int i = 0; i < typeParameters.length; i++) {
                if (i > 0) {
                    declaration.append(", ");
                }
                TypeVariable<Method> typeParameter = typeParameters[i];
                declaration.append(typeParameter.getName());
                Type[] bounds = typeParameter.getBounds();
                if (bounds.length > 0 && !Object.class.equals(bounds[0])) {
                    declaration.append(" extends ").append(getTypeName(bounds[0]));
                }
            }
            declaration.append("> ");
        }

        // Processing method parameter
        declaration.append(m.getReturnType().getSimpleName()).append(" ");
        declaration.append(m.getName()).append("(");
        Class<?>[] parameterTypes = m.getParameterTypes();
        Type[] genericParameterTypes = m.getGenericParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            if (i > 0) {
                declaration.append(", ");
            }
            declaration.append(getTypeName(genericParameterTypes[i]));
            declaration.append(" arg").append(i);
        }
        declaration.append(")");

        return declaration.toString();
    }

    private static String getTypeName(Type type) {
        if (type instanceof Class<?>) {
            return ((Class<?>) type).getSimpleName();
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            Type[] typeArguments = parameterizedType.getActualTypeArguments();
            StringBuilder typeName = new StringBuilder(getTypeName(rawType));
            typeName.append("<");
            for (int i = 0; i < typeArguments.length; i++) {
                if (i > 0) {
                    typeName.append(", ");
                }
                typeName.append(getTypeName(typeArguments[i]));
            }
            typeName.append(">");
            return typeName.toString();
        } else if (type instanceof TypeVariable<?>) {
            TypeVariable<?> typeVariable = (TypeVariable<?>) type;
            return typeVariable.getName();
        } else {
            return type.toString();
        }
    }
}