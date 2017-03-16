package greenden;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by luweicheng on 2017/3/15 0015.
 */
@Entity
public class Father {
    @Id
    private long id;
    @Property(nameInDb = "NAME")
    private String name;
    @Property(nameInDb = "GENDER")
    private String gender;
    @Generated(hash = 1903949690)
    public Father(long id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }
    @Generated(hash = 383274692)
    public Father() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
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


}
