/*
 * Andrew Terenzi
 * Main class -- run this --
 */
package DictionaryThesaurus;

public class Main {

    public static void main(String[] args) {

        //Test simple word adding and definitions
        System.out.println("Test simple definitions:");
        runDefinitions();
        System.out.println();
        
        //Test commutative property
        System.out.println("Test commutative property:");
        runCommutative();
        System.out.println();
        
        //Test transitive property
        System.out.println("Test transitive property:");
        runTransitive();
        System.out.println();
        
        //Test "Both the synonym and the word should already
        //be present in the dictionary."
        System.out.println("Test add synonym:");
        runAdd();
        System.out.println();
        
        //Test for a more random case"
        System.out.println("Test random:");
        runRandom();
    }

    public static void runDefinitions() {
        //Instantiate a library object
        Library library = new Library();

        //Add definitions
        library.addWord("big", "takes a lot of space");
        library.addWord("large", "bigger than medium");
        library.addWord("enormous", "really large");
        library.addWord("ginormous", "super large");
        library.addWord("tasty", "fun to eat!");
        library.addWord("cool", "not uncool");

        //Retrieve definitions
        library.getDefinition("big");
        library.getDefinition("large");
        library.getDefinition("cool");
        //Salty hasn't been added!
        library.getDefinition("salty");
    }
    
    public static void runCommutative() {
        //Instantiate a library object
        Library library = new Library();
        library.addWord("big", "takes a lot of space");
        library.addWord("large", "bigger than medium");
        
        //Test commutative property
        library.addSynonym("big", "large");
        library.getSynonyms("big");
        library.getSynonyms("large");
        
        //Test reverse = same
        Library library2 = new Library();
        library2.addWord("big", "takes a lot of space");
        library2.addWord("large", "bigger than medium");
        
        library2.addSynonym("large", "big");
        library2.getSynonyms("big");
        library2.getSynonyms("large");
    }
    
    public static void runTransitive()
    {
        //Instantiate a library object
        Library library = new Library();
        library.addWord("gorgeous", "10/10");
        library.addWord("beautiful", "aesthetically pleasing");
        library.addWord("lovely", "pretty to look at");
        
        //Gorgeous will also have lovely as a synonym
        //(And thus lovely should have gorgeous)
        library.addSynonym("gorgeous", "beautiful");
        library.addSynonym("beautiful", "lovely");
        
        library.getSynonyms("gorgeous");
        library.getSynonyms("beautiful");
        library.getSynonyms("lovely");
    }
    
    public static void runAdd()
    {
        //Instantiate a library object
        Library library = new Library();
        library.addWord("gorgeous", "10/10");
        library.addWord("beautiful", "aesthetically pleasing");
        library.addWord("lovely", "pretty to look at");
        
        //The word isn't in, doesn't work
        library.addSynonym("pretty", "gorgeous");
        //The synonym isn't in, doesn't work
        library.addSynonym("gorgeous", "pretty");
        //Neither word is in!
        library.addSynonym("tasty", "delicious");
    }
    
    public static void runRandom()
    {
        //Instantiate a library object
        Library library = new Library();
        library.addWord("gorgeous", "10/10");
        library.addWord("beautiful", "aesthetically pleasing");
        library.addWord("lovely", "pretty to look at");
        library.addWord("pretty", "nice to look at");
        library.addWord("cool", "not uncool");
        library.addWord("sweet", "lots of sugar");
        
        library.addSynonym("pretty", "beautiful");
        library.addSynonym("gorgeous", "lovely");
        library.addSynonym("pretty", "lovely");
        
        library.getSynonyms("gorgeous");
        library.getSynonyms("beautiful");
        library.getSynonyms("lovely");
        library.getSynonyms("pretty");
    }
}
