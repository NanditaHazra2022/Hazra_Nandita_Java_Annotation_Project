# Hazra_Nandita_Java_Annotation_Project
This is a repository of Java programs to demonstrate usage of annotation.

Annotations, a form of metadata, provide data about a program that is not part of the program itself. Annotations have no direct effect on the operation of the code they annotate.
Annotations have a number of uses, among them:
1.	Information for the compiler — Annotations can be used by the compiler to detect errors or suppress warnings.
2.	Compile-time and deployment-time processing — Software tools can process annotation information to generate code, XML files, and so forth.
3.	Runtime processing — Some annotations are available to be examined at runtime.

In its simplest form, an annotation looks like the following:
@Override
The at sign character (@) indicates to the compiler that what follows is an annotation. 
The annotation can include elements, which can be named or unnamed, and there are values for those elements. If there is just one element named value, then the name can be omitted. If the annotation has no elements, then the parentheses can be omitted.

set of annotation types are predefined in the Java SE API. Some annotation types are used by the Java compiler, and some apply to other annotations.
A.	Following are the predefined annotation types that are used by the Java compiler:
1.	@Deprecated annotation indicates that the marked element is deprecated and should no longer be used. The compiler generates a warning whenever a program uses a method, class, or field with the @Deprecated annotation. When an element is deprecated, it should also be documented using the Javadoc @deprecated tag, as shown in the following example. The use of the at sign (@) in both Javadoc comments and in annotations is not coincidental: they are related conceptually. Also, note that the Javadoc tag starts with a lowercase d and the annotation starts with an uppercase D.
// Javadoc comment follows
/*
* @deprecated
* Explanation of why it was deprecated
*/
@Deprecated
static void deprecatedMethod() { }
}

2.	@Override annotation informs the compiler that the element is meant to override an element declared in a superclass. If a method is annotated with this annotation type compilers are required to generate an error message unless at least one of the following conditions hold:
a.	The method does override or implement a method declared in a supertype.
b.	The method has a signature that is override-equivalent to that of any public method declared in Object.

// mark method as a superclass method
// that has been overridden
@Override 
int overriddenMethod() { }

3.	@SuppressWarnings annotation tells the compiler to suppress compiler warnings in the annotated element (and in all program elements contained in the annotated element). Note that the set of warnings suppressed in a given element is a superset of the warnings suppressed in all containing elements. For example, if you annotate a class to suppress one warning and annotate a method to suppress another, both warnings will be suppressed in the method.
As a matter of style, programmers should always use this annotation on the most deeply nested element where it is effective. If you want to suppress a warning in a particular method, you should annotate that method rather than its class.

In the following example, a deprecated method is used, and the compiler usually generates a warning. In this case, however, the annotation causes the warning to be suppressed.
/*
* Use a deprecated method and 
* tell compiler not to generate a warning.
*/
@SuppressWarnings("deprecation")
void useDeprecatedMethod() {
// deprecation warning suppressed
objectOne.deprecatedMethod();
}
Every compiler warning belongs to a category. The Java Language Specification lists two categories: deprecation and unchecked. The unchecked warning can occur when interfacing with legacy code written before the advent of generics. 
To suppress multiple categories of warnings, use the following syntax:
@SuppressWarnings({"unchecked", "deprecation"})

4.	@SafeVarargs annotation, when applied to a method or constructor, asserts that the code does not perform potentially unsafe operations on its varargs parameter. When this annotation type is used, unchecked warnings relating to varargs usage are suppressed.
Compilers are encouraged to issue warnings when this annotation type is applied to a method or constructor declaration where:
a.	The variable arity parameter has a reifiable element type, which includes primitive types, Object, and String. (The unchecked warnings this annotation type suppresses already do not occur for a reifiable element type.)
b.	The body of the method or constructor declaration performs potentially unsafe operations, such as an assignment to an element of the variable arity parameter's array that generates an unchecked warning. Some unsafe operations do not trigger an unchecked warning. For example, the aliasing in
@SafeVarargs // Not actually safe
static void m(List<String>... stringLists) {
Object[] array = stringLists;
List<Integer> tmpList = Arrays.asList(42);
array[0] = tmpList; // Semantically invalid, but compiles without warnings
String s = stringLists[0].get(0); // ClassCastException at runtime
}

leads to a ClassCastException at runtime.
Future versions of the platform may mandate compiler errors for such unsafe operations.

5.	@FunctionalInterface annotation: An informative annotation type used to indicate that an interface type declaration is intended to be a functional interface as defined by the Java Language Specification. Conceptually, a functional interface has exactly one abstract method. Since default methods have an implementation, they are not abstract. If an interface declares an abstract method overriding one of the public methods of java.lang.Object, that also does not count toward the interface's abstract method count since any implementation of the interface will have an implementation from java.lang.Object or elsewhere.
Note that instances of functional interfaces can be created with lambda expressions, method references, or constructor references.
If a type is annotated with this annotation type, compilers are required to generate an error message unless:
a.	The type is an interface type and not an annotation type, enum, or class.
b.	The annotated type satisfies the requirements of a functional interface.
However, the compiler will treat any interface meeting the definition of a functional interface as a functional interface regardless of whether or not a FunctionalInterface annotation is present on the interface declaration.

B.	Following are the Annotations That Apply to Other Annotations: 
Note: Annotations that apply to other annotations are called meta-annotations. There are several meta-annotation types defined in java.lang.annotation.
1.	@Retention annotation specifies how the marked annotation is stored:
RetentionPolicy.SOURCE – The marked annotation is retained only in the source level and is ignored by the compiler.
RetentionPolicy.CLASS – The marked annotation is retained by the compiler at compile time, but is ignored by the Java Virtual Machine (JVM).
RetentionPolicy.RUNTIME – The marked annotation is retained by the JVM so it can be used by the runtime environment.
Indicates how long annotations with the annotated type are to be retained. If no Retention annotation is present on an annotation type declaration, the retention policy defaults to RetentionPolicy.CLASS.
A Retention meta-annotation has effect only if the meta-annotated type is used directly for annotation. It has no effect if the meta-annotated type is used as a member type in another annotation type.

2.	@Documented annotation indicates that whenever the specified annotation is used those elements should be documented using the Javadoc tool. (By default, annotations are not included in Javadoc.) For more information on Javadoc, see the Appendix. This type should be used to annotate the declarations of types whose annotations affect the use of annotated elements by their clients. If a type declaration is annotated with Documented, its annotations become part of the public API of the annotated elements. 

3.	@Target annotation marks another annotation to restrict what kind of Java elements the annotation can be applied to. 

A target annotation specifies one of the following element types as its value:
ElementType.ANNOTATION_TYPE can be applied to an annotation type.
ElementType.CONSTRUCTOR can be applied to a constructor.
ElementType.FIELD can be applied to a field.
ElementType.LOCAL_VARIABLE can be applied to a local variable.
ElementType.METHOD can be applied to a method-level annotation.
ElementType.PACKAGE can be applied to a package declaration.
ElementType.PARAMETER can be applied to the parameters of a method.
ElementType.TYPE can be applied to any element of a class.
Indicates the contexts in which an annotation type is applicable. The declaration contexts and type contexts in which an annotation type may be applicable are specified in JLS 9.6.4.1, and denoted in source code by enum constants of java.lang.annotation.ElementType.
If an @Target meta-annotation is not present on an annotation type T, then an annotation of type T may be written as a modifier for any declaration except a type parameter declaration.
If an @Target meta-annotation is present, the compiler will enforce the usage restrictions indicated byElementType enum constants, in line with JLS 9.7.4.
For example, this @Target meta-annotation indicates that the declared type is itself a meta-annotation type. It can only be used on annotation type declarations:
@Target(ElementType.ANNOTATION_TYPE)
public @interface MetaAnnotationType {

// code

}

This @Target meta-annotation indicates that the declared type is intended solely for use as a member type in complex annotation type declarations. It cannot be used to annotate anything directly:
@Target({})
public @interface MemberType {

// code

}

It is a compile-time error for a single ElementType constant to appear more than once in an @Target annotation. For example, the following @Target meta-annotation is illegal:
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.FIELD})
    public @interface Bogus {
        ...
    }
4.	@Inherited: This annotation indicates that the annotation type can be inherited from the super class. (This is not true by default.) When the user queries the annotation type and the class has no annotation for this type, the class's superclass is queried for the annotation type. This annotation applies only to class declarations.
5.	@Repeatable: This annotation, introduced in Java SE 8, indicates that the marked annotation can be applied more than once to the same declaration or type use.

