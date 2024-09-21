package com.io.service;

import com.io.core.character.CharacterEnum;
import com.io.db.DatabaseEngine;
import com.io.db.entity.CellEntity;
import com.io.db.entity.CharacterEntity;
import com.io.db.entity.LevelEntity;
import com.io.db.entity.SnapshotEntity;

import java.sql.SQLException;
import java.util.List;

public class LevelService {
    private final DatabaseEngine dbEngine;

    public LevelService(DatabaseEngine dbEngine) {
        this.dbEngine = dbEngine;
    }

    public List<Long> getLevels() {
        var levelDAO = dbEngine.getDAO(LevelEntity.class);
        try {
            return levelDAO.queryForAll().stream().map(LevelEntity::getId).toList();
        } catch (SQLException ignored) {
        }
        return List.of();
    }

    private void createLevel(
        LevelEntity levelEntity,
        SnapshotEntity snapshotEntity,
        List<CharacterEntity> characterEntityList,
        List<CellEntity> cellEntityList
    ) {
        var snapshotDAO = dbEngine.getDAO(SnapshotEntity.class);
        var levelDAO = dbEngine.getDAO(LevelEntity.class);
        var characterDAO = dbEngine.getDAO(CharacterEntity.class);
        var cellDAO = dbEngine.getDAO(CellEntity.class);

        try {
            snapshotDAO.create(snapshotEntity);
            var snapshotId = snapshotEntity.getId();

            levelEntity.setStartingSnapshot(snapshotId);
            levelDAO.create(levelEntity);

            characterEntityList.forEach(entity -> entity.setSnapshotId(snapshotId));
            for (var entity : characterEntityList) characterDAO.create(entity);

            cellEntityList.forEach(entity -> entity.setSnapshotId(snapshotId));
            for (var entity : cellEntityList) cellDAO.create(entity);
        } catch (SQLException ignored) {
        }
    }

    public void loadLevels() {
        dbEngine.clear();

        {
            // LEVEL 1
            SnapshotEntity snapshotEntity = new SnapshotEntity(5, 5);
            LevelEntity levelEntity = new LevelEntity();
            List<CharacterEntity> characterEntityList = List.of(
                new CharacterEntity(0, 0, CharacterEnum.Player, 0),
                new CharacterEntity(2, 4, CharacterEnum.MeleeEnemy, 1),
                new CharacterEntity(3, 4, CharacterEnum.MeleeEnemy, 1),
                new CharacterEntity(4, 3, CharacterEnum.MeleeEnemy, 1)
            );
            List<CellEntity> cellEntityList = List.of();
            createLevel(levelEntity, snapshotEntity, characterEntityList, cellEntityList);
        }
        {
            // LEVEL 2
            SnapshotEntity snapshotEntity = new SnapshotEntity(5, 5);
            LevelEntity levelEntity = new LevelEntity();
            List<CharacterEntity> characterEntityList = List.of(
                new CharacterEntity(0, 0, CharacterEnum.Player, 0),
                new CharacterEntity(1, 4, CharacterEnum.MeleeEnemy, 1),
                new CharacterEntity(2, 4, CharacterEnum.MeleeEnemy, 1),
                new CharacterEntity(3, 4, CharacterEnum.MeleeEnemy, 1),
                new CharacterEntity(4, 4, CharacterEnum.MeleeEnemy, 1)
            );
            List<CellEntity> cellEntityList = List.of(
                new CellEntity(0, 3, true),
                new CellEntity(1, 3, true),
                new CellEntity(2, 3, true),
                new CellEntity(3, 3, true),
                new CellEntity(4, 3, true)
            );
            createLevel(levelEntity, snapshotEntity, characterEntityList, cellEntityList);
        }
    }
}
