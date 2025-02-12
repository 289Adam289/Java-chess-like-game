package com.io.service.game;

import com.io.core.board.BoardMoveChange;
import com.io.core.board.SpecialCell;
import com.io.core.character.Character;
import com.io.core.moves.MoveDTO;

import java.util.List;
import java.util.Map;

public interface BoardInterface {
    BoardMoveChange tryMakeMove(MoveDTO move);

    PlayerInterface getPlayer();

    Map<Integer, Integer> getTeamCount();

    List<SpecialCell> getSpecialCells();

    int getBoardWidth();

    int getBoardHeight();

}
