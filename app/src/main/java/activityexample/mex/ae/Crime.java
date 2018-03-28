package activityexample.mex.ae;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Mex on 28.03.2018.
 */

public class Crime {
    private UUID _id;
    private String _text;
    private boolean _solved;
    private Date _date;

    public Crime(String text, Date date){
        this._text = text;
        this._date = date;
        _id = UUID.randomUUID();
        _solved = false;
    }


    public String get_text() {
        return _text;
    }

    public void set_text(String _text) {
        this._text = _text;
    }

    public UUID get_id() {
        return _id;
    }

    public void set_id(UUID _id) {
        this._id = _id;
    }

    public Date get_date() {
        return _date;
    }

    public void set_date(Date _date) {
        this._date = _date;
    }

    public boolean is_solved() {
        return _solved;
    }

    public void set_solved(boolean _solved) {
        this._solved = _solved;
    }
}
