package se21;

/**
 * EXAM TOPIC: Java Object-Oriented Approach / Nested Classes + Polymorphism
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - All four nested class types in one file: static nested, inner (non-static), local, anonymous
 * - Nested interface: implicitly static; used here as the polymorphic base type
 * - Nested abstract class: can be static; concrete subclasses must implement abstract methods
 * - Nested record (Java 16+): implicitly static; immutable; can implement interfaces
 * - Static nested class access rules: can access outer static members but NOT outer instance members
 * - Inner class access rules: can access all outer members (static and instance, including private)
 * - Local class access rules: can access effectively final variables from the enclosing method scope
 * - Anonymous class: one-time-use class defined inline; no class name; implements interface or extends class
 * - Polymorphism: all nested types implement the same interface and are treated uniformly via a reference type
 * - Instantiation syntax: 'new Outer().new Inner()' is required for non-static inner classes from outside
 */
public class Outer {
    private String outerField = "Outer Instance Field";
    private static String outerStaticField = "Outer Static Field";

    // EXAM: nested interface is implicitly static — does not require an outer instance to use
    public interface Behavior {
        String act();  // Abstract method for polymorphism
    }

    // EXAM: static nested class — declared with 'static'; can be instantiated without an Outer instance
    public static class StaticNested implements Behavior {
        @Override
        public String act() {
            return "Static Nested: Accesses " + outerStaticField;  // EXAM: static nested can access outer static fields directly
            // Cannot access outerField directly (needs new Outer().outerField)
        }
    }

    // EXAM: inner class (non-static nested) — holds implicit Outer.this reference; requires outer instance to instantiate
    public class Inner implements Behavior {
        @Override
        public String act() {
            return "Inner: Accesses " + outerField + " and " + outerStaticField;  // EXAM: inner class can access all outer members including private instance fields
        }
    }

    // EXAM: abstract class can be nested and static; subclasses must implement abstract methods
    public static abstract class AbstractNested implements Behavior {
        public abstract String extraInfo(); // EXAM: abstract method forces concrete subclasses (including anonymous ones) to provide an implementation

        @Override
        public String act() {
            return "Abstract Nested: Base act() + " + extraInfo();
        }
    }

    // EXAM: nested records are implicitly static (Java 16+); can implement interfaces; provide polymorphic behavior
    public static record RecordNested(String name) implements Behavior {
        @Override
        public String act() {
            return "Record Nested: Name is " + name + ", Accesses " + outerStaticField;
        }
    }

    public void demonstrateNested() {
        // EXAM: local class — scoped to this method; can access effectively final locals and outer instance members
        class Local implements Behavior {
            @Override
            public String act() {
                return "Local: Accesses " + outerField + " and " + outerStaticField;
            }
        }
        Behavior local = new Local();  // Instantiate locally

        // EXAM: anonymous class — nameless, defined and instantiated in one expression; used for one-off implementations
        Behavior anonymous = new Behavior() {
            @Override
            public String act() {
                return "Anonymous: Accesses " + outerField + " and " + outerStaticField;
            }
        };

        // EXAM: polymorphism — all nested types are referenced via the Behavior interface; act() dispatched at runtime
        java.util.List<Behavior> behaviors = java.util.Arrays.asList(
            new StaticNested(),                // EXAM: static nested — no outer instance needed; use ClassName directly
            new Outer().new Inner(),           // EXAM: inner class — must use 'outerInstance.new Inner()' syntax
            new AbstractNested() {             // EXAM: anonymous subclass of abstract nested class; must implement all abstract methods
                @Override
                public String extraInfo() {
                    return "Overridden extraInfo";
                }
            },
            new RecordNested("MyRecord"),      // EXAM: nested record instantiated like a normal class via canonical constructor
            local,                             // Local instance
            anonymous                          // Anonymous instance
        );

        // EXAM: polymorphic invocation — same method call on different runtime types; determined by actual object type
        for (Behavior b : behaviors) {
            System.out.println(b.act());
        }
    }

    public static void main(String[] args) {
        new Outer().demonstrateNested();
    }
}