package JavaDocumentation._03_ClassesAndObjects;

public class GarabageCollectors {
    /**
     * The Java platform allows you to create as many objects as you want (limited, of course,
     * by what your system can handle), and you don't have to worry about destroying them. The
     * Java runtime environment deletes objects when it determines that they are no longer being
     * used. This process is called garbage collection
     *
     *
     * An object is eligible for garbage collection when there are no more references to that object.
     * References that are held in a variable are usually dropped when the variable goes out of scope.
     * Or, you can explicitly drop an object reference by setting the variable to the special value null.
     * Remember that a program can have multiple references to the same object; all references to an
     * object must be dropped before the object is eligible for garbage collection.
     *
     * The Java runtime environment has a garbage collector that periodically frees the memory used by objects
     * that are no longer referenced. The garbage collector does its job automatically when it determines that
     * the time is right.
     */
}
