package by.skopinau.rescue.hr.service.impl;

import by.skopinau.rescue.hr.service.RankService;
import by.skopinau.rescue.hr.dao.RankDao;
import by.skopinau.rescue.hr.dao.jpa.RankDaoJpa;
import by.skopinau.rescue.hr.model.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RankServiceImpl extends BaseServiceImpl<Rank> implements RankService {
    private final RankDao rankDao;

    @Autowired
    public RankServiceImpl(RankDaoJpa rankDao) {
        super(rankDao);
        this.rankDao = rankDao;
    }

    public Rank findByTitle(String rankTitle) {
        return rankDao.findByTitle(rankTitle);
    }
}