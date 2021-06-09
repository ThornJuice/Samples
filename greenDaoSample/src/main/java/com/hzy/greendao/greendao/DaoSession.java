package com.hzy.greendao.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.hzy.greendao.City;
import com.hzy.greendao.ResultBean;
import com.hzy.greendao.Task;

import com.hzy.greendao.greendao.CityDao;
import com.hzy.greendao.greendao.ResultBeanDao;
import com.hzy.greendao.greendao.TaskDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig cityDaoConfig;
    private final DaoConfig resultBeanDaoConfig;
    private final DaoConfig taskDaoConfig;

    private final CityDao cityDao;
    private final ResultBeanDao resultBeanDao;
    private final TaskDao taskDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        cityDaoConfig = daoConfigMap.get(CityDao.class).clone();
        cityDaoConfig.initIdentityScope(type);

        resultBeanDaoConfig = daoConfigMap.get(ResultBeanDao.class).clone();
        resultBeanDaoConfig.initIdentityScope(type);

        taskDaoConfig = daoConfigMap.get(TaskDao.class).clone();
        taskDaoConfig.initIdentityScope(type);

        cityDao = new CityDao(cityDaoConfig, this);
        resultBeanDao = new ResultBeanDao(resultBeanDaoConfig, this);
        taskDao = new TaskDao(taskDaoConfig, this);

        registerDao(City.class, cityDao);
        registerDao(ResultBean.class, resultBeanDao);
        registerDao(Task.class, taskDao);
    }
    
    public void clear() {
        cityDaoConfig.clearIdentityScope();
        resultBeanDaoConfig.clearIdentityScope();
        taskDaoConfig.clearIdentityScope();
    }

    public CityDao getCityDao() {
        return cityDao;
    }

    public ResultBeanDao getResultBeanDao() {
        return resultBeanDao;
    }

    public TaskDao getTaskDao() {
        return taskDao;
    }

}