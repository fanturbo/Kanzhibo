package pub.kanzhibo.app.register;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;

import pub.kanzhibo.app.model.Login;

/**
 * Created by turbo on 2016/11/2.
 * mvpView 就是说界面上需要的所有动作的定义
 * mvpPresenter 界面上所有的逻辑操作  这儿有个mvpPresenter和mvpBasePresenter 这两个其实差不多，但是继承mvpBasePresenter的话
 * 不但继承了attachView 和detachView两个方法，还创建了一个软引用的view（即fragment)，即不需要自己再去维护presenter和view的联系了
 * mvpFragment 有两个用处：
 * 1、在合适的地方（比如进入fragment加载数据，或者button的点击事件）调用present的方法
 * 2.实现所有动作的定义 implements mvpView，在合适的地方展示view（比如说加载数据时候的loading,加载完成之后的数据显示）
 * <p>
 * LCE模块的话就是对loading-content-error这个部分做了进一步封装，使用起来方便些。
 * 当然，比如说login这样的模块或者只是简单的一个网络请求或者逻辑，是不需要继承lce模块的类和接口的
 */

public interface RegisterView extends MvpView {

    public void showError(String errMessage);

    public void showProgress();

    public void registerSuccessful();
}
