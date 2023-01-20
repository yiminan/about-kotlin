package _class

/**
 * - In same class
 */
private class PrivateClass {
}

private open class Example {
    /**
     * - In same class
     * - With inheritance, in same module
     * - With inheritance, in other module
     */
    protected class ProtectedClass {
    }
}

/**
 * - In same class
 * - In same module
 */
internal class InternalClass {
}

/**
 * - In same class
 * - In same module
 * - In other module
 * - from everywhere
 */
public class PublicClass {
}

/**
 * Same as public class
 */
class DefaultClass {
}
