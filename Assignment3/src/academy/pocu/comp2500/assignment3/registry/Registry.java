package academy.pocu.comp2500.assignment3.registry;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * DO NOT MODIFY. YOU DON'T HAVE TO!
 */
public class Registry {
    public static final String ASSIGNMENT3_PACKAGE_NAME = "academy.pocu.comp2500.assignment3";
    protected static final int TOTAL_INTERFACES_COUNT = 7;

    protected HashMap<InterfaceKey, Interface> interfaces = new HashMap<>();

    public final HashMap<InterfaceKey, Interface> getInterfaces() {
        return this.interfaces;
    }

    public final void registerMarineCreator(final String className) {
        this.interfaces.put(InterfaceKey.MARINE, new Interface(className));
    }

    public final void registerMarineCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.MARINE, new Interface(className, methodName));
    }

    public final void registerTankCreator(final String className) {
        this.interfaces.put(InterfaceKey.TANK, new Interface(className));
    }

    public final void registerTankCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.TANK, new Interface(className, methodName));
    }

    public final void registerWraithCreator(final String className) {
        this.interfaces.put(InterfaceKey.WRAITH, new Interface(className));
    }

    public final void registerWraithCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.WRAITH, new Interface(className, methodName));
    }

    public final void registerTurretCreator(final String className) {
        this.interfaces.put(InterfaceKey.TURRET, new Interface(className));
    }

    public final void registerTurretCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.TURRET, new Interface(className, methodName));
    }

    public final void registerMineCreator(final String className) {
        this.interfaces.put(InterfaceKey.MINE, new Interface(className));
    }

    public final void registerMineCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.MINE, new Interface(className, methodName));
    }

    public final void registerSmartMineCreator(final String className) {
        this.interfaces.put(InterfaceKey.SMART_MINE, new Interface(className));
    }

    public final void registerSmartMineCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.SMART_MINE, new Interface(className, methodName));
    }

    public final void registerDestroyerCreator(final String className) {
        this.interfaces.put(InterfaceKey.DESTROYER, new Interface(className));
    }

    public final void registerDestroyerCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.DESTROYER, new Interface(className, methodName));
    }

    public void validate() {
        assertTrue(this.interfaces.size() >= TOTAL_INTERFACES_COUNT,
                "%d unregistered method(s)",
                TOTAL_INTERFACES_COUNT - this.interfaces.size());

        HashSet<String> visited = new HashSet<>();
        for (Map.Entry<InterfaceKey, Interface> entry : this.interfaces.entrySet()) {
            Interface aInterface = entry.getValue();
            String className = aInterface.getClassName();

            Class<?> aClass = getClassByNameOrNull(className);

            assertTrue(aClass != null, "not found: %s", className);

            String methodName = aInterface.getMethodName();

            if (methodName != null) {
                ArrayList<Method> methods = getMethodsByName(aClass, methodName);

                assertTrue(methods.size() > 0, "not found: %s.%s()", className, methodName);
            }
        }
    }

    protected void assertTrue(boolean condition, String format, Object... args) {
        assert condition : String.format(format, args);
    }

    private final Class<?> getClassByNameOrNull(final String name) {
        try {
            String fullClassName = String.format("%s.%s", ASSIGNMENT3_PACKAGE_NAME, name);
            return Class.forName(fullClassName);
        } catch (ClassNotFoundException e) {
            return null;
        } catch (NoClassDefFoundError e) {
            return null;
        }
    }

    private final ArrayList<Method> getMethodsByName(final Class<?> aClass, final String methodName) {
        Method[] declaredMethods = aClass.getDeclaredMethods();
        ArrayList<Method> methods = new ArrayList<>();

        for (int i = 0; i < declaredMethods.length; ++i) {
            if (declaredMethods[i].getName().equals(methodName)) {
                methods.add(declaredMethods[i]);
            }
        }

        return methods;
    }
}
