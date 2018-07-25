package by.komposter.Services;


public abstract class DaoFactory {
    private static volatile DaoInt daoInt;

    public static DaoInt getItemDAO() {
        if(daoInt == null) {
            synchronized(DaoFactory.class) {
                if(daoInt == null) {
                    daoInt = new ItemDaoImp();
                }
            }
        }
        return daoInt;
    }
}
