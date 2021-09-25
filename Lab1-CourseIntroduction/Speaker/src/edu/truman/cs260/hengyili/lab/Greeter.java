package edu.truman.cs260.hengyili.lab;

/**
 * @author Turing
 *
 * A class to store and return a greeting.
 */
public class Greeter {
    // The greeting message
    private final String greeting;
    /** Construct and initialize a new object.
     * @param greeting what to say when greeting
     */
    public Greeter (String greeting) {
        this.greeting = greeting;
    }
    /** Return the greeting.
     * @return the greeting
     */
    public String getGreeting() {
        return greeting;
    }
}
