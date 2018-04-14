package activityexample.mex.ae;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class CrimeList {
    private List<Crime> _crimes;
    private static CrimeList _instance;
    private CrimeList(){
        _crimes = new LinkedList<>();
        TestInsert();
    }

    private void TestInsert(){
        for(int i = 0; i < 10; i++){
            Crime crime = new Crime(UUID.randomUUID().toString());
            crime.set_date(new Date());
            _crimes.add(crime);
        }
    }

    public static CrimeList GetInstance(){
        if(_instance == null)
            _instance = new CrimeList();
        return _instance;
    }

    public int GetCount(){
        return _crimes.size();
    }

    public Crime GetCrime(int pos){
        return _crimes.get(pos);
    }


}
