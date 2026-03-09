package se21.modules;

/**
 * EXAM TOPIC: Packaging and Deploying Java Code — Java Platform Module System (JPMS)
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~8% of exam
 *
 * Covers:
 * - module-info.java: defines a module; must be in the root of the source directory
 * - requires: declares a dependency on another module
 * - exports: makes a package accessible to other modules
 * - opens: allows reflective access (needed for frameworks like Spring)
 * - provides / uses: service provider mechanism
 * - Module types: named module, automatic module, unnamed module
 * - jdeps: tool for analyzing module dependencies
 * - jar --create --main-class --module-version: modular jar creation
 * - --module-path / -p: specifies where to find modules (replaces classpath for modules)
 * - --add-modules: adds modules to the resolution process
 *
 * Key module-info.java syntax:
 * <pre>
 * module com.example.myapp {
 *     requires java.sql;                 // depends on java.sql module
 *     requires transitive java.logging;  // transitive: dependents also get this
 *     exports com.example.api;           // visible to all modules
 *     exports com.example.internal to com.example.plugin; // restricted export
 *     opens com.example.model;           // allows reflection on this package
 *     uses com.example.spi.MyService;    // declares a service consumer
 *     provides com.example.spi.MyService with com.example.impl.MyServiceImpl; // declares a service provider
 * }
 * </pre>
 *
 * TODO: Add runnable examples as you study this topic.
 *       Key things to understand for the exam:
 *       - Difference between exports and opens
 *       - Transitive requires
 *       - Unnamed vs automatic vs named modules
 *       - How to compile and run a modular application
 */
public class Modules {

	public static void main(String[] args) {
		// Print the module of this class
		Module module = Modules.class.getModule();
		System.out.println("Module: " + module.getName()); // EXAM: named module returns module name; unnamed returns null

		// Print module of a JDK class
		Module javaBase = String.class.getModule();
		System.out.println("java.base module: " + javaBase.getName()); // java.base — the foundational module
	}
}
