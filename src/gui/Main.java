package gui;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import persistence.dao.BirthDao;
import persistence.dao.DaoFactory;
import persistence.dao.DeathDao;
import persistence.entity.BirthRecord;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        DaoFactory daoFactory = new DaoFactory();
        BirthDao birthDao = (BirthDao) daoFactory.getDao("BirthDao");
        DeathDao deathDao = (DeathDao) daoFactory.getDao("DeathDao");
        List<BirthRecord> birthRecords = birthDao.queryForAll();
        for (BirthRecord birthRecord : birthRecords) {
            System.out.println(birthRecord.getPeriod() + " " + birthRecord.getRegion() + " " +
                               birthRecord.getBirth_count());
        }
    }
}
