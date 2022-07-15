package academy.pocu.comp2500.assignment1.registry;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * DO NOT MODIFY. YOU DON'T HAVE TO!
 */
public class Registry {
    public static final String ASSIGNMENT1_PACKAGE_NAME = "academy.pocu.comp2500.assignment1";
    protected static final int TOTAL_INTERFACES_COUNT = 21;

    protected HashMap<InterfaceKey, Interface> interfaces = new HashMap<>();

    public final HashMap<InterfaceKey, Interface> getInterfaces() {
        return this.interfaces;
    }

    public final void registerBlogCreator(final String className) {
        this.interfaces.put(InterfaceKey.BLOG_CREATOR, new Interface(className));
    }

    public void registerTagFilterSetter(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.TAG_FILTER_SETTER, new Interface(className, methodName));
    }

    public final void registerAuthorFilterSetter(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.AUTHOR_FILTER_SETTER, new Interface(className, methodName));
    }

    public final void registerPostOrderSetter(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.POST_ORDER_SETTER, new Interface(className, methodName));
    }

    public final void registerPostListGetter(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.POST_LIST_GETTER, new Interface(className, methodName));
    }

    public final void registerPostAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.POST_ADDER, new Interface(className, methodName));
    }

    public final void registerPostTitleUpdater(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.POST_TITLE_UPDATER, new Interface(className, methodName));
    }

    public final void registerPostBodyUpdater(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.POST_BODY_UPDATER, new Interface(className, methodName));
    }

    public final void registerPostTagAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.POST_TAG_ADDER, new Interface(className, methodName));
    }

    public final void registerCommentAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.COMMENT_ADDER, new Interface(className, methodName));
    }

    public final void registerSubcommentAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.SUBCOMMENT_ADDER, new Interface(className, methodName));
    }

    public final void registerCommentUpdater(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.COMMENT_UPDATER, new Interface(className, methodName));
    }

    public final void registerSubcommentUpdater(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.SUBCOMMENT_UPDATER, new Interface(className, methodName));
    }

    public final void registerReactionAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.REACTION_ADDER, new Interface(className, methodName));
    }

    public final void registerReactionRemover(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.REACTION_REMOVER, new Interface(className, methodName));
    }

    public final void registerCommentUpvoter(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.COMMENT_UPVOTER, new Interface(className, methodName));
    }

    public final void registerCommentDownvoter(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.COMMENT_DOWNVOTER, new Interface(className, methodName));
    }

    public final void registerCommentListGetter(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.COMMENT_LIST_GETTER, new Interface(className, methodName));
    }

    public final void registerSubcommentListGetter(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.SUBCOMMENT_LIST_GETTER, new Interface(className, methodName));
    }

    public final void registerSubcommentUpvoter(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.SUBCOMMENT_UPVOTER, new Interface(className, methodName));
    }

    public final void registerSubcommentDownvoter(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.SUBCOMMENT_DOWNVOTER, new Interface(className, methodName));
    }

    public void validate() {
        assertTrue(this.interfaces.size() >= TOTAL_INTERFACES_COUNT,
                "%d unregistered method(s)",
                TOTAL_INTERFACES_COUNT - this.interfaces.size());

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
            String fullClassName = String.format("%s.%s", ASSIGNMENT1_PACKAGE_NAME, name);
            return Class.forName(fullClassName);
        } catch (ClassNotFoundException e) {
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
