package edu.truman.cs260.hengyili.lab;

public class Farewell {
    // The greeting message
    private final String theFarewell;
    /** Construct and initialize a new object.
     * @param farewell what to say when greeting
     */
    public Farewell (String farewell) {
        this.theFarewell = farewell;
    }
    /** Return the greeting.
     * @return the greeting
     */
    public String getFarewell() {
        return theFarewell;
    }
}
