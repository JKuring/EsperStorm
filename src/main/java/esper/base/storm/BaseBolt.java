package esper.base.storm;

/**
 * Created by linghang.kong on 2016/7/5.
 */
public interface BaseBolt<T> {

    //public T analyzeTuple(String epl);

    public String getEpl();

    public void setEpl(String epl);

    public String getBoltName();

    public void setBoltName(String boltName);

}
