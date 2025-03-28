package com.example;
/**
 * A program to carry on conversations with a human user.
 * This version:
 *<ul><li>
 * 		Uses advanced search for keywords 
 *</li><li>
 * 		Will transform statements as well as react to keywords
 *</li></ul>
 * @author Laurie White
 * @version April 2012
 *
 */
public class Magpie4b
{
    /**
     * Get a default greeting 	
     * @return a greeting
     */	
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }

    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";

        // Activity 4 Code here

        // return stops all

        if (findKeyword(statement, "math", 0) >= 0 || findKeyword(statement, "science", 0) >= 0)
        {
            response = "Is that your favorite class?";
            return response;
        }
        if (findKeyword(statement, "KCD", 0) >= 0)
        {
            response = "KCD is the best school!";
            return response;
        }
        if (findKeyword(statement, "hamburger", 0) >= 0)
        {
            response = "Sounds yummy!";
            return response;
        }
        if (findKeyword(statement, "rollercoaster", 0) >= 0)
        {
            response = "What theme park?";
            return response;
        }
        if (findKeyword(statement, "tired", 0) >= 0)
        {
            response = "Go take a nap.";
            return response;
        }
        if (findKeyword(statement, "dog", 0) >= 0)
        {
            statement = replaceWord(statement, "dog", "cat"); // Replaces all instances of "dog" with "cat"
            response = statement;
            return response;
        }
        else
        {
            response = getRandomResponse();
        }
        
        // Responses which require transformations
        if (findKeyword(statement, "I want to", 0) >= 0)
        {
            response = transformIWantToStatement(statement);
        }

        else if(findKeyword(statement, "I want", 0) >= 0)
        {
            response = transformIWantStatement(statement);
        }

        else if(findKeyword(statement, "I don't like", 0) >= 0)
        {
            response = transformIDontLikeStatement(statement);
        }

        else if(findKeyword(statement, "You don't like", 0) >= 0)
        {
            response = transformYouDontLikeStatement(statement);
        }

        else if(findKeyword(statement, "Would you like to", 0) >= 0)
        {
            response = transformWouldYouLikeStatement(statement);
        }

        else if(findKeyword(statement, "Would you like to", 0) >= 0)
        {
            // Look for a two word (would you like to <something> with me)
            // pattern
            int psn = findKeyword(statement, "Would you like to", 0);

            if (psn >= 0 && findKeyword(statement, "with me", psn) >= 0)
            {
                response = transformWouldYouLikeStatement(statement); // Concatenate a custom response here
            }
            else
            {
                response = getRandomResponse(); // Concatenate a custom response here
            }
        }

        else
        {
            // Look for a two word (you <something> me)
            // pattern
            int psn = findKeyword(statement, "you", 0);

            if (psn >= 0 && findKeyword(statement, "me", psn) >= 0)
            {
                response = transformYouMeStatement(statement);
            }
            else
            {
                response = getRandomResponse();
            }
        }
        return response;
    }
    
    /**
     * Gives a custom response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getCustomResponse(String statement)
    {
        statement = replaceWord(statement, "dog", "cat"); // Replaces all instances of "dog" with "cat"
        String response = "";
        
        // Activity 4 Code here. 
        // Customize the responses to be different than the original
        
        // Responses which require transformations
        if (findKeyword(statement, "I want to", 0) >= 0)
        {
            response = transformIWantToStatement(statement); // Concatenate a custom response here
        }

        else
        {
            // Look for a two word (you <something> me)
            // pattern
            int psn = findKeyword(statement, "you", 0);

            if (psn >= 0 && findKeyword(statement, "me", psn) >= 0)
            {
                response = transformYouMeStatement(statement); // Concatenate a custom response here
            }
            else
            {
                response = getRandomResponse(); // Concatenate a custom response here
            }
        }
        return response;
    }
    
    /**
     * Find and replace all instances of one work with another word
     * @param phrase
     *            the string to search
     * @param oldWord
     *            the string to search for
     * @param newWord
     *            the string to replace with
     * @return the new string with all instances of oldWord replaced with newWord
     */
    private String replaceWord(String phrase, String oldWord, String newWord)
    {
        //  Remove the final period, if there is one
        phrase = phrase.trim();
        String lastChar = phrase.substring(phrase.length() - 1);
        if (lastChar.equals("."))
        {
            phrase = phrase.substring(0, phrase.length() - 1);
        }

        if (findKeyword(phrase, oldWord, 0) >= 0)
        {
            int psnStart = findKeyword(phrase, oldWord, 0);
            String firstPart = phrase.substring(0, psnStart);
            String lastPart = phrase.substring(firstPart.length() + oldWord.length(), phrase.length());
            phrase = firstPart + newWord + lastPart;
        }
        else
        {
            return phrase;
        }
        return phrase; // Modify this statement to return the correct String
    }
    
    /**
     * Take a statement with "I don't like <something>." and transform it into 
     * "You said 'I dislike <something>'? What don't you like about it?"
     * @param statement the user statement, assumed to contain "I don't like"
     * @return the transformed statement
     */
    private String transformIDontLikeStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }

        statement = replaceWord(statement, "don't like", "dislike");

        return "You said '" + statement + "'? What don't you like about it?";
    }

    private String transformYouDontLikeStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }

        statement = replaceWord(statement, "don't like", "dislike");
        statement = replaceWord(statement, "You", "I");

        return "You said that " + statement + "? Why do you think that?";
    }

    /**
     * Take a statement with "I want <something>." and transform it into 
     * "I would like <something> too!"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    private String transformIWantStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }

        int psnOfIWant = findKeyword (statement, "I want", 0);

        String restOfStatement = statement.substring(psnOfIWant + 7).trim();
        return "I would like " + restOfStatement + " too!";
    }
    
    /**
     * Take a statement with "Would you like to <something> with me?" and transform it into 
     * "When would you like me to <something> with you?"
     * @param statement the user statement, assumed to contain "Would you like to" and "with me"
     * @return the transformed statement
     */
    private String transformWouldYouLikeStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }

        int psnOfWouldYouLikeTo = findKeyword(statement, "Would you like to", 0);
        int psnOfWithMe = findKeyword(statement, "with me", 0);

        String restOfStatement = statement.substring(psnOfWouldYouLikeTo + 18, psnOfWithMe).trim();
        return "When would you like me to " + restOfStatement + " with you?";
    }
    
    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    private String transformIWantToStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
        int psn = findKeyword (statement, "I want to", 0);
        String restOfStatement = statement.substring(psn + 9).trim();
        return "What would it mean to " + restOfStatement + "?";
    }

    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    private String transformYouMeStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }

        int psnOfYou = findKeyword (statement, "you", 0);
        int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);

        String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
        return "What makes you think that I " + restOfStatement + " you?";
    }

    /**
     * Search for one word in phrase. The search is not case
     * sensitive. This method will check that the given goal
     * is not a substring of a longer string (so, for
     * example, "I know" does not contain "no").
     *
     * @param statement
     *            the string to search
     * @param goal
     *            the string to search for
     * @param startPos
     *            the character of the string to begin the
     *            search at
     * @return the index of the first occurrence of goal in
     *         statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal, int startPos)
    {
        String phrase = statement.trim().toLowerCase();
        goal = goal.toLowerCase();

        // The only change to incorporate the startPos is in
        // the line below
        int psn = phrase.indexOf(goal, startPos);

        // Refinement--make sure the goal isn't part of a
        // word
        while (psn >= 0)
        {
            // Find the string of length 1 before and after
            // the word
            String before = " ", after = " ";
            if (psn > 0)
            {
                before = phrase.substring(psn - 1, psn);
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(psn + goal.length(), psn + goal.length() + 1);
            }

            // If before and after aren't letters, we've
            // found the word
            if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0)) // before is not a letter
                    && ((after.compareTo("a") < 0) || (after.compareTo("z") > 0)))
            {
                return psn;
            }

            // The last position didn't work, so let's find
            // the next, if there is one.
            psn = phrase.indexOf(goal, psn + 1);
        }
        return -1;
    }

    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 4;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";

        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }

        return response;
    }
}
