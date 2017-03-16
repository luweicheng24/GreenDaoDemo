package greenden;

import com.dao.DaoSession;
import com.dao.FatherDao;
import com.dao.SonDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;

/**
 * Created by luweicheng on 2017/3/15 0015.
 */
@Entity
public class Son {
    @Override
    public String toString() {
        return "Son{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", fatherId=" + fatherId +
                ", father=" + father +
                ", daoSession=" + daoSession +
                ", myDao=" + myDao +
                ", father__resolvedKey=" + father__resolvedKey +
                '}';
    }

    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "NAME")
    private String name;
    @Property(nameInDb = "GENDER")
    private String gender;
    private long fatherId;
    @ToOne(joinProperty = "fatherId")
    private Father father;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1926509084)
    private transient SonDao myDao;
    @Generated(hash = 712561333)
    public Son(Long id, String name, String gender, long fatherId) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.fatherId = fatherId;
    }
    @Generated(hash = 1259336981)
    public Son() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return this.gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public long getFatherId() {
        return this.fatherId;
    }
    public void setFatherId(long fatherId) {
        this.fatherId = fatherId;
    }
    @Generated(hash = 2100996716)
    private transient Long father__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 614506380)
    public Father getFather() {
        long __key = this.fatherId;
        if (father__resolvedKey == null || !father__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FatherDao targetDao = daoSession.getFatherDao();
            Father fatherNew = targetDao.load(__key);
            synchronized (this) {
                father = fatherNew;
                father__resolvedKey = __key;
            }
        }
        return father;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1018445113)
    public void setFather(@NotNull Father father) {
        if (father == null) {
            throw new DaoException(
                    "To-one property 'fatherId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.father = father;
            fatherId = father.getId();
            father__resolvedKey = fatherId;
        }
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 838735897)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getSonDao() : null;
    }

}