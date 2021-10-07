package co.micol.dbPrj;

import co.micol.dbPrj.db.DevServicelmpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//DataSource dao = new DataSource();
    	DevServicelmpl dao = new DevServicelmpl();
    	dao.selectList();
    }
}
