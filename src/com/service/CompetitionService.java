package com.service;

import com.entity.CompetitionEntity;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface CompetitionService {
    //添加比赛文件
    void add(CompetitionEntity competitionEntity);
    //获取比赛文件列表
    List<CompetitionEntity> list(int w_id);
    //获取一个比赛文件
    CompetitionEntity findOne(int i);
    //删除比赛文件
    void del(CompetitionEntity ct);
    //更新比赛文件
    void update(CompetitionEntity competitionEntity);
}
