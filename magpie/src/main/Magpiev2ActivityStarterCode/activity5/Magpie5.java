import java.util.Random;

/**
 * A program to carry on conversations with a human user.
 * This version:
 *<ul><li>
 * 		Uses advanced search for keywords 
 *</li><li>
 * 		Will transform statements as well as react to keywords
 *</li></ul>
 * This version uses an array to hold the default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie5
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
        statement = replaceWord(statement, "dog", "cat"); // Replaces all instances of "dog" with "cat"
        String response = "";
        
        // Activity 4/4b Code here

        // Responses which require transformations
        if (findKeyword(statement, "I want to", 0) >= 0)
        {
            response = transformIWantToStatement(statement);
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
                
        // Activity 4/4b Code here. 
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
        // Activity 4b Code here
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
        // Activity 4b Code here
        
        return ""; // Modify this statement to return the correct String
    }
    
    
    /**
     * Take a statement with "I want <something>." and transform it into 
     * "I would like <something> too!"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    private String transformIWantStatement(String statement)
    {
        // Activity 4 Code here
        
        return transformIWantToStatement(statement); // Modify this statement to return the correct String
    }
    
    /**
     * Take a statement with "Would you like to <something> with me?" and transform it into 
     * "When would you like me to <something> with you?"
     * @param statement the user statement, assumed to contain "Would you like to" and "with me"
     * @return the transformed statement
     */
    private String transformWouldYouLikeStatement(String statement)
    {
        // Activity 4 Code here
        
        return ""; // Modify this statement to return the correct String
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
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
     * @param statement the string to search
     * @param goal the string to search for
     * @return the index of the first occurrence of goal in statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal)
    {
        return findKeyword (statement, goal, 0);
    }

    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse ()
    {
        Random r = new Random ();
        return randomResponses [r.nextInt(randomResponses.length)];
    }

    // private class attribute
    private String [] randomResponses = {"Interesting, tell me more",
        "Hmmm.",
        "Do you really think so?",
        "You don't say." // Your code goes here
    };

}
