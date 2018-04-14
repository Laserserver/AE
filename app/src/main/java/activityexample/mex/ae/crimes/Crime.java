package activityexample.mex.ae.crimes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Mex on 28.03.2018.
 */

public class Crime {
    private UUID _id;
    private String _text;
    private String _title;
    private boolean _solved;
    private Date _date;

    Crime(String title, String text){
        this._text = text;
        _solved = false;
        this._title = title;

        this._date = new Date();
        _id = UUID.randomUUID();
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

    public String get_date() {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(_date);
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

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }
}
