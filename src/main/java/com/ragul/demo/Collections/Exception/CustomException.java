package com.ragul.demo.Collections.Exception;

public class CustomException {
    //Custom Checked Exception
    class InvalidAgeException extends Exception {
        public InvalidAgeException(String message) {
            super(message);
        }
    }

    //Custom Unchecked Exception
    class InvalidInputException extends RuntimeException {
        public InvalidInputException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        CustomException customException = new CustomException();
        try {
            customException.vote(16, null);
        } catch (InvalidAgeException e) {
            System.out.println("Caught InvalidAgeException: " + e.getMessage());
        } catch (InvalidInputException e) {
            System.out.println("Caught InvalidInputException: " + e.getMessage());
        }
    }

    public void vote(int age, Object input) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above to vote");
        }

        if (input == null) {
            throw new InvalidInputException("Input cannot be null");
        }
    }


}
