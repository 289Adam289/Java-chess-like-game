package com.io.service.utils;

import com.io.core.character.CharacterEnum;
import com.io.view.game.characters.CharacterViewType;

import java.util.EnumMap;
import java.util.Map;

public abstract class CharacterTypesMapper {
    private static final Map<CharacterEnum, CharacterViewType> map = new EnumMap<>(CharacterEnum.class);

    static {
        map.put(CharacterEnum.Player, CharacterViewType.KOALA);
        map.put(CharacterEnum.MeleeEnemy, CharacterViewType.LINUX);
        map.put(CharacterEnum.RangeEnemy, CharacterViewType.MINIX);
        map.put(CharacterEnum.GoodEnemy, CharacterViewType.FIREFOX);
    }

    public static CharacterViewType getPresenterType(CharacterEnum type) {
        return map.get(type);
    }
}
