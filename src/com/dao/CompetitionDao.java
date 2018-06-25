package com.dao;

import com.entity.CompetitionEntity;

import java.util.List;

public interface CompetitionDao {

    void add(CompetitionEntity competitionEntity);

    List<CompetitionEntity> findAll(int w_id);

    CompetitionEntity findOne(int i);

    void del(CompetitionEntity ct);

    void update(CompetitionEntity competitionEntity);
}
