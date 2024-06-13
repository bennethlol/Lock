package com.kenneth;

/**
* @author Kenneth Hudson
* 04/03/2024
* A program the represents a lock. The user has the ability to change the lock combo
*/

public class Lock {
	
    // The combination
    private String combination;
    // Number of incorrect attempts
    private int incorrectAttempts;
    // Whether the lock has been unlocked or not
    private boolean unlocked;

    /**
     * Constructs a lock with the default combination "0000", zero incorrect attempts,
     * and locked status.
     */
    public Lock() {
        this.combination = "0000";
        this.incorrectAttempts = 0;
        this.unlocked = false;
    }

    /**
     * Constructs a lock with a custom combination, zero incorrect attempts, and
     * locked status.
     * 
     * @param combination The initial combination for the lock.
     */
    public Lock(String combination) {
        this.combination = combination;
        this.incorrectAttempts = 0;
        this.unlocked = false;
    }

    /**
     * Checks if the lock is currently unlocked.
     * 
     * @return True if the lock is unlocked, otherwise false.
     */
    public boolean isUnlocked() {
        return unlocked;
    }

    /**
     * Attempts to unlock the lock with a given combination.
     * If the combination is correct, the lock is unlocked; otherwise, the
     * number of incorrect attempts is incremented. If the number of incorrect
     * attempts reaches three or more, an alarm message is printed.
     * 
     * @param combo The combination to attempt to unlock the lock.
     */
    public void attemptUnlock(String combo) {
        if (combo.equals(combination)) {
            unlocked = true;
            incorrectAttempts = 0;
            System.out.println("Click.");
        } else {
            incorrectAttempts++;
            if (incorrectAttempts >= 3) {
                System.out.println("Alarm!");
            }
        }
    }

    /**
     * Changes the combination of the lock if it is currently unlocked.
     * 
     * @param newCombo The new combination to set for the lock.
     * @return True if the combination was successfully changed, otherwise false.
     */
    public boolean changeCombo(String newCombo) {
        if (unlocked) {
            combination = newCombo;
            lock(); // Locks the combination after changing it
            return true;
        } else {
            return false;
        }
    }

    /**
     * Locks the lock, making it unable to be opened until unlocked again.
     */
    public void lock() {
        unlocked = false;
    }
}