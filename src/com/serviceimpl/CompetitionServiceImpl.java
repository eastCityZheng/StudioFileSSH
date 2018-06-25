package com.serviceimpl;

import com.dao.CompetitionDao;
import com.entity.CompetitionEntity;
import com.service.CompetitionService;

import java.util.List;

public class CompetitionServiceImpl implements CompetitionService {

    private  CompetitionDao competitionDao;

    public void setCompetitionDao(CompetitionDao competitionDao) {
        this.competitionDao = competitionDao;
    }

    @Override
    public void add(CompetitionEntity competitionEntity) {
        competitionDao.add(competitionEntity);
    }

    @Override
    public List<CompetitionEntity> list(int w_id) {

        return competitionDao.findAll(w_id);
    }

    @Override
    public CompetitionEntity findOne(int i) {
        return competitionDao.findOne(i);
    }

    @Override
    public void del(CompetitionEntity ct) {
        competitionDao.del(ct);
    }

    @Override
    public void update(CompetitionEntity competitionEntity) {
        competitionDao.update(competitionEntity);
    }
}
