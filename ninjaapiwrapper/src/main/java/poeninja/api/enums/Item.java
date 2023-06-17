package poeninja.api.enums;

import lombok.Getter;

@Getter
public enum Item {
    Oil("Oil"),
    Incubator("Incubator"),
    Scarab("Scarab"),
    Fossil("Fossil"),
    Resonator("Resonator"),
    Essence("Essence"),
    DivinationCard("DivinationCard"),
    SkillGem("SkillGem"),
    UniqueMap("UniqueMap"),
    Map("Map"),
    UniqueJewel("UniqueJewel"),
    UniqueFlask("UniqueFlask"),
    UniqueWeapon("UniqueWeapon"),
    UniqueArmour("UniqueArmour"),
    Watchstone("Watchstone"),
    UniqueAccessory("UniqueAccessory"),
    DeliriumOrb("DeliriumOrb"),
    Beast("Beast"),
    Vial("Vial"),
    Invitation("Invitation"),
    Artifact("Artifact"),
    BlightedMap("BlightedMap"),
    ClusterJewel("ClusterJewel"),
    BaseType("BaseType"),
    HelmetEnchant("HelmetEnchant");

    private String str;

    private Item(String str) {
        this.str = str;
    }
}
