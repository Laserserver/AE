package activityexample.mex.ae;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * Created by mirramax97@Mail.ru on 10.04.2018.
 */

public class CrimeList {
    private List<Crime> _crimes;

    private static CrimeList _instance;
    private CrimeList(){
        _crimes = new LinkedList<>();
        FillRand();
    }

    private void FillRand(){
        for (int i = 0; i < 20; i++){
            Crime cm = new Crime(UUID.randomUUID().toString());
            cm.set_date(new Date());
            _crimes.add(cm);
        }
    }

    public int GetCount(){
        return _crimes.size();
    }

    public static CrimeList GetInstance(){
        if(_instance == null)
            _instance = new CrimeList();
        return _instance;
    }

    public void InsertCrime(Crime c){
        _crimes.add(c);
    }

    public Crime GetCrime(int pos){
        return _crimes.get(pos);
    }
}
