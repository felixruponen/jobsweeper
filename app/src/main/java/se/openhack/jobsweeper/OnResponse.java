package se.openhack.jobsweeper;

/**
 * Created by victoraxelsson on 2016-12-02.
 */

public interface OnResponse<T> {
    void onResponse(T res);
}
