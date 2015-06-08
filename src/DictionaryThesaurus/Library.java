package DictionaryThesaurus;

import java.util.*;

/**
 * Provides functionality for a data structure that
 * will act as a thesaurus and a dictionary.
 */
public class Library {

    //The main library will be a hashmap that has a string key
    //as the actual word, and the value will be a "WordInfo" object.
    //This object will contain information about the definition
    //and the synonyms of a word in the library.
    HashMap<String, WordInfo> dictionary;

    //Constructor method
    public Library() {
        //Starts empty, user adds entries.
        dictionary = new HashMap<>();
    }

    /**
     * Adds a word to the dictionary. Note that only a definition
     * is added, not a synonym.
     *
     * @param word, the word to be added
     * @param definition, the definition of the given word
     */
    public void addWord(String word, String definition) {
        //Instantiate a new WordInfo object.
        WordInfo wordInfo = new WordInfo(definition);
        //Add the entry to the HashMap
        dictionary.put(word, wordInfo);
    }

    /**
     * Adds a synonym to word in the dictionary. Also handles commutative and
     * transitive properties.
     *
     * @param word, the root word to get a new synonym
     * @param newSynonym, a word which is the new synonym being added
     */
    public void addSynonym(String word, String newSynonym) {
        //First, make sure both words are already members of the dictionary.
        if (dictionary.containsKey(word) && dictionary.containsKey(newSynonym)) {

            //Retrieve the WordInfo value from the HashMap
            WordInfo thisWord = dictionary.get(word);
            WordInfo newWord = dictionary.get(newSynonym);

            //Note: More information regarding the set implementation
            //can be found in the WordInfo class    
            
            //If neither word has an initialized synonym set,
            if (thisWord.isSynEmpty() && newWord.isSynEmpty()) {
                //Let the current word have one (and add itself)
                thisWord.makeSyn(word);
                //And then add the new synonym to it.
                thisWord.addSynonym(newSynonym);
                
                //Then, make the new synonym's set of synonyms
                //to be the same as the first word.
                //(Commutitive and Transitive properties make this okay)
                newWord.setSynonym(thisWord);
                
            //If the current word doesn't have an initialized synonym set
            } else if (thisWord.isSynEmpty()) {
                //Then add the word to the new synonym's set
                newWord.addSynonym(word);
                //And then let the current set equal that set (commutitive)
                thisWord.setSynonym(newWord);
                
            //If the current word does have an initialized synonym set
            } else if (newWord.isSynEmpty()) {
                //Do the reverse!
                thisWord.addSynonym(newSynonym);
                newWord.setSynonym(thisWord);
                
            //If the two words already have their own sets, join them.
            } else { 
                //Iterate through one set to combine them
                for (String element : newWord.synonyms)
                {
                    //Join the two sets
                    thisWord.getSynonyms().add(element);
                    //Make sure everything in the old synonym set
                    //Now points to the new set!
                    dictionary.get(element).setSynonym(thisWord);
                }
            }
        } else { //If the two words aren't already in the dictionary...
            System.out.println("Those two words are not in the dictionary.");
        }
    }

    /**
     * Prints out the definitions of a given word
     *
     * @param word, the word key that will be looked up
     */
    public void getDefinition(String word) {
        WordInfo thisWordInfo = dictionary.get(word);
        if (thisWordInfo == null) {
            System.out.println("This word isn't in the dictionary.");
        } else {
            System.out.print("The definition for " + word + ": ");
            thisWordInfo.printDefinition();
        }
    }

    /**
     * Prints out the synonyms of a given word
     *
     * @param word, the word key that will be looked up
     */
    public void getSynonyms(String word) {
        dictionary.get(word).printSynonyms(word);
    }
}
