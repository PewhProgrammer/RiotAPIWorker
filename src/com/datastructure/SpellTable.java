package com.datastructure;

/**
 * Created by Thinh-Laptop on 05.08.2016.
 */
public enum SpellTable {
    Cleanse(1,"Removes all disables and summoner spell debuffs affecting your champion " +
            "and lowers the duration of incoming disables by 65% for 3 seconds."),
    Clairvoyance(2,"Reveals a small area of the map for your team for 5 seconds."),
    Exhaust(3,"Exhausts target enemy champion, reducing their Movement Speed and Attack Speed " +
            "by 30%, their Armor and Magic Resist by 10, and their damage dealt by 40% for 2.5 seconds."),
    Flash(4,"Teleports your champion a short distance toward your cursor's location."),
    Ghost(6,"Your champion can move through units and has 28-45% (depending on champion level) increased Movement Speed for 10 seconds."),
    Heal(7,"Restores 90-345 Health (depending on champion level) and grants 30% Movement Speed for 1 second to you and " +
            "target allied champion. This healing is halved for units recently affected by Summoner Heal."),
    Smite(11,"Deals 390-1000 true damage (depending on champion level) to target epic or large monster or enemy minion."),
    Teleport(12,"After channeling for 4.5 seconds, teleports your champion to target allied structure, minion, or ward."),
    Clarity(13,"Restores 50% of your champion's maximum Mana. Also restores allies for 25% of their maximum Mana."),
    Ignite(14,"Ignites target enemy champion, dealing 70-410 true damage (depending on champion level) over " +
                   "5 seconds, grants you vision of the target, and reduces healing effects on them for the duration.");

    private final int ID ;
    private final String Description;

    SpellTable(int id,String description){
        ID = id ;
        Description = description;
    }

}
