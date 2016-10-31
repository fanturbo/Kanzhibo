package pub.kanzhibo.app.model.event;

import com.hwangjr.rxbus.annotation.Produce;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.thread.EventThread;

/**
 * Created by turbo on 2016/10/31.
 */

public class SearchEvent {
    private String searchKey;

    public SearchEvent(String searchKey) {
        this.searchKey = searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    @Produce
    public String getSearchKey() {
        return this.searchKey;
    }
}
