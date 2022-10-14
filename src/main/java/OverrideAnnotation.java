/* Java program to demonstrate
 * @Override annotation, which informs
 * the compiler that the element
 * is meant to override an element
 * declared in a superclass. */

// Super class.
class Shape
{

    // Method that will be overridden by subclass.
    public void printNameOfShape(String shape)
    {

        System.out.println
                (
                        "The shape is "
                                + shape
                );

    }

}

// Subclass
class Square
        extends Shape
{

    // Overriding method of super class.
    @Override   // Override annotation.
    public void printNameOfShape (String shape)
    {

        System.out.println
                (
                        "The shape is "
                                + shape
                );

    }

}

// Main class.
public class OverrideAnnotation
{   // Start of main class.

    //  Starting point of execution.
    public static void main(String[] args)
    {   // Start of execution thread.

        //  Creation of subclass's object.
        Square s
                = new Square();

        // Calling overridden method of subclass.
        s.printNameOfShape("square");

    }   // End of execution thread.

}   // End of main class.