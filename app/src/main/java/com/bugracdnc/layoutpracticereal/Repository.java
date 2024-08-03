package com.bugracdnc.layoutpracticereal;

import java.util.HashMap;

public class Repository {

    HashMap<String, Character> characters;

    public Repository() {
        characters = new HashMap<>();
        characters.put("stan", new Character("Stanley", "Marsh", "Stan", "Jesus vs. Frosty (1992)", "Trey Parker & Matt Stone", "Trey Parker"));
        characters.put("kyle", new Character("Kyle", "Broflovski", "", "Jesus vs. Frosty (1992)", "Trey Parker & Matt Stone", "Matt Stone"));
        characters.put("eric", new Character("Eric Theodore", "Cartman", "", "Jesus vs. Frosty (1992)", "Trey Parker & Matt Stone", "Trey Parker"));
        characters.put("kenny", new Character("Kenneth", "McCormick", "Kenny", "Jesus vs. Frosty (1992)", "Trey Parker & Matt Stone", "Matt Stone (hooded)"));
    }

}
